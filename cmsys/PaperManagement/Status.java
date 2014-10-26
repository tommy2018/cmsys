package cmsys.PaperManagement;

public class Status {
	static public String toString(int status, int role) {
		switch (status) {
			case 0:
				return "Submitted";
			case 1:
				return "Awaiting response";
			case 2:
				return "Awaiting final version submission";
			case 3:
				return "Accepted";
			case 4:
				return "Rejected";
			case 5:
				return "Revewing";
			case 6:
				return "Reviewed";
			case 7:
				return "Awaiting allocation";
			default:
				return "---";
		}
	}
	
	static public int toInt(String status) {
		if (status.equals("Submitted"))
			return 0;
		else if (status.equals("Awaiting response"))
			return 1;
		else if (status.equals("Awaiting final version submission"))
			return 2;
		else if (status.equals("Accepted"))
			return 3;
		else if (status.equals("Rejected"))
			return 4;
		else if (status.equals("Revewing"))
			return 5;
		else if (status.equals("Reviewed"))
			return 6;
		else
			return -1;
		
	}
}
