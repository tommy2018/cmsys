package cmsys.PaperManagement;

import java.sql.*;

import cmsys.Common.*;

public class Submission {
	static public void submitPaper(int uid, String filePath) throws CmsysException {
		Settings settings = Settings.getInstance();
		int role = 1;
		
		try (
			Connection conn = DriverManager.getConnection(settings.getSetting("dbURL"), settings.getSetting("dbUsername"), settings.getSetting("dbPassword"));
			PreparedStatement statement = conn.prepareStatement("INSERT INTO user(username, password, firstName, lastName, email, role) VALUES (?, ?, ?, ?, ?, ?)");
		) {
			
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
}
