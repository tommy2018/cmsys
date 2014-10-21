import cmsys.Common.*;
import cmsys.UserManagement.*;
import cmsys.PaperManagement.*;

import java.sql.SQLException;
import java.util.*;

public class MainController {
	static public void main(String[] args) {
		Settings settings = null;
		try {
			try (Scanner reader = new Scanner(System.in)) {
				settings = Settings.getInstance();
				System.out.println((int) (Math.random() * 90000) + "");

				while (true) {
					System.out
							.println("enter 1 for log in function \n enter 2 for register function \n enter 3 dor test Encryption \n 4 for Paper testing \n 5 for get File testing \n 6 for save file testing");
					String command = reader.nextLine();
					if (command.equals("1")) {
						User user = null;

						System.out.println("enter Username");
						String userName = reader.nextLine();
						System.out.println("enter PassWord");
						String password = reader.nextLine();

						user = Login.login(userName, password);

						if (user == null) {
							System.out.println("INCORRECT INPUT");
						} else {
							System.out.println("Email: " + user.getEmail());
							System.out.println("First name: "
									+ user.getFirstName());
							System.out.println("Last name: "
									+ user.getLastName());
							System.out.println("Username: "
									+ user.getUsername());
							System.out.println("UID: " + user.getUID());
							System.out.println("Role: " + user.getRole());
						}

					} else if (command.equals("2")) {
						System.out.println("enter new Username");
						String newUsername = reader.nextLine();
						System.out.println("enter password");
						String newPassword = reader.nextLine();
						System.out.println("enter your email");
						String newEmail = reader.nextLine();
						System.out.println("enter your first Name");
						String newFname = reader.nextLine();
						System.out.println("enter your Last Name");
						String newLname = reader.nextLine();

						Register.newUser(newUsername, newPassword, newEmail,
								newFname, newLname);
					} else if (command.equals("3")) {
						System.out.println(Encryption.sha256("huicheng"));
					} else if (command.equals("4")) {
						System.out.println("Enter UID: ");
						int uid = reader.nextInt();

						ArrayList<Paper> paperList = Paper
								.getPaperListByUid(uid);

						for (Paper paper : paperList) {
							System.out.println("UID: " + paper.getUid());
							System.out.println("PID: " + paper.getPid());
							System.out.println("Key words: "
									+ paper.getKeywords());
							System.out.println(" Authors: "
									+ paper.getAuthors());
							System.out.println("Tile: " + paper.getTitle());
							System.out.println("Paper Abstract: "
									+ paper.getPaperAbstract());
						}

					} else if (command.equals("5")) {
						System.out.println("ENTER FILE NAME: ");
						String fileName = reader.nextLine();
						System.out.println("ENTER DESTNATION: ");
						String dest = reader.nextLine();
						FileManager.getFile(fileName, dest);
					} else if (command.equals("6")) {
						System.out.println("ENTER FILE PATH: ");
						String filePath = reader.nextLine();
						System.out.println("ENTER filename: ");
						String fileName = reader.nextLine();
						FileManager.saveFile(filePath, fileName);
					} else if (command.equals("exit")) {
						break;
					}
				}

			} catch (CmsysException e) {
				System.err.println(e.getMessage());
			}
		} finally {
			if (settings != null)
				try {
					settings.getDBConnection().close();
				} catch (Exception e) {
				}
		}
	}
}
