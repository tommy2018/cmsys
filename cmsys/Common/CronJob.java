package cmsys.Common;

import java.util.ArrayList;

import cmsys.PaperManagement.Check;
import cmsys.PaperManagement.Distribution;
import cmsys.PaperManagement.Paper;
import cmsys.PaperManagement.Preference;
import cmsys.UserManagement.User;

public class CronJob {
	static public void updateSystemStatus() {
		try {
			if (Integer.parseInt(Settings.getSettingFromDB("status")) == 0) {
				if (Time.timestamp() > Long.parseLong(Settings.getSettingFromDB("submissionDeadline"))) {
					changeSystemStatusToCloseSubmission();
				}
			} else if (Integer.parseInt(Settings.getSettingFromDB("status")) == 1) {
				if (Time.timestamp() > Long.parseLong(Settings.getSettingFromDB("preferenceDeadline"))) {
					changeSystemStatusToDistribution();
				}
			} else if (Integer.parseInt(Settings.getSettingFromDB("status")) == 3) {
				checkReviewStatus();
			}
		} catch (NumberFormatException e) {
		} catch (CmsysException e) {
		}
	}
	
	static public void changeSystemStatusToCloseSubmission() {
		try {
			Long submissionDeadline = Long.parseLong(Settings.getSettingFromDB("submissionDeadline"));
			Long preferenceDeadline = submissionDeadline + 432000000;
			
			if (submissionDeadline > Time.timestamp()) {
				Long now = Time.timestamp();
				Settings.updateSetting("preferenceDeadline", now.toString());
			}
			Settings.updateSetting("status", "1");
			Settings.updateSetting("preferenceDeadline", preferenceDeadline.toString());
		} catch (CmsysException e) {
		}
	}
	
	static public void changeSystemStatusToDistribution() {
		try {
			//Check if PC Members have made their preferences
			ArrayList<Paper> paperList = Paper.getPaperList();
			ArrayList<User> pmList = User.getPcMemberList();
			
			for (Paper paper : paperList) {
				for (User user : pmList) {
					if (Preference.getPreference(user.getUID(), paper.getPid()) == null) {
						if (Check.isCOI(paper, user))
							Preference.setPreference(user.getUID(), paper.getPid(), 3);
						else
							Preference.setPreference(user.getUID(), paper.getPid(), 0);
					}
				}
			}
			
			//Distribute
			int baseline = 4;
			
			for (Paper paper : paperList) {
				int marker = 0;
				for (User user : pmList) {
					int mark = 0;
					int p = Preference.getPreference(user.getUID(), paper.getPid());
					if (p != 3) {
						ArrayList<String> list = paper.getKeywords();
						String keyword = user.getRA();
						int total = 1;
						
						for (String s : list) {
							if (s.equals(keyword))
								total++;
						}
						
						mark += p * total;
						
						if (mark >= baseline) {
							Distribution.tempDistribute(paper.getPid(), user.getUID());
							marker++;
						}
					}
				}
				
				if (marker < 2) {
					for (User user : pmList) {
						int baseline1 = 1;
						int mark = 0;
						int p = Preference.getPreference(user.getUID(), paper.getPid());
						if (p != 3) {
							ArrayList<String> list = paper.getKeywords();
							String keyword = user.getRA();
							int total = 1;
							
							for (String s : list) {
								if (s.equals(keyword))
									total++;
							}
							
							mark += p * total;
							
							if (mark >= baseline1) {
								Distribution.tempDistribute(paper.getPid(), user.getUID());
								marker++;
							}
						}
					}
				}
				
				if (marker < 2) {
					for (User user : pmList) {
						int p = Preference.getPreference(user.getUID(), paper.getPid());
						if (p != 3) {
							Distribution.tempDistribute(paper.getPid(), user.getUID());
						}
						
						if (marker >= 2)
							break;
					}
				}
			}
			
			Settings.updateSetting("status", "2");
		} catch (CmsysException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	static public void changeSystemStatusToRevewing() {
		try {			
			Settings.updateSetting("status", "3");
		} catch (CmsysException e) {
		}
	}
	
	static public void checkReviewStatus() {
		try {	
			ArrayList<Integer> paperList = Paper.getReviewPaperList();
			
			for (Integer paper : paperList) {
				if (Paper.allReviewed(paper)) {
					Paper.setToReviewed(paper);
				}
			}
		} catch (CmsysException e) {
		}
	}
}
