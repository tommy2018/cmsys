package cmsys.UserManagement;

public class Role {
	static public String toString(int role) {
		switch (role) {
			case 0:
				return "Administrator";
			case 1:
				return "Normal user";
			case 2:
				return "Author";
			case 3:
				return "PC Member";
			case 4:
				return "PC Chair";
			default:
				return "---";
		}
	}
}
