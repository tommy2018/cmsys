package cmsys.PaperManagement;

public class Status {
	static public String toString(int status, int role) {
		//if (role == 1 || role == 2) {
			switch (status) {
				case 0:
					return "Submitted";
				case 1:
					return "Awaiting response";
				case 2:
					return "Accepted - Awaiting final version submittion";
				case 3:
					return "Accepted";
				case 4:
					return "Rejected";
				default:
					return "---";
			}
		/*} else {
			return "---";
		}*/
	}
	
	static public int toInt(String status) {
		if (status.equals("Submitted"))
			return 0;
		else if (status.equals("Awaiting response"))
			return 1;
		else if (status.equals("Accepted - Awaiting final version submittion"))
			return 2;
		else if (status.equals("Accepted"))
			return 3;
		else if (status.equals("Rejected"))
			return 4;
		else
			return -1;
		
	}
}
