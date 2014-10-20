package cmsys.UserManagement;

import java.sql.*;
import cmsys.Common.*;

public class Register {
	public static int newUser(String username, String password, String email, String firstName, String lastName) throws CmsysException {
		Settings settings = Settings.getInstance();
		int role = 1;
		
		try (
			Connection conn = DriverManager.getConnection(settings.getSetting("dbURL"), settings.getSetting("dbUsername"), settings.getSetting("dbPassword"));
			PreparedStatement statement = conn.prepareStatement("INSERT INTO user(username, password, firstName, lastName, email, role) VALUES (?, ?, ?, ?, ?, ?)");
		) {
			password = Encryption.sha256(password);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, firstName);
			statement.setString(4, lastName);
			statement.setString(5, email);
			statement.setInt(6, role);

			statement.executeUpdate();
			return 0;
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
}

