package cmsys.UserManagement;

import java.sql.*;
import cmsys.Common.*;

public class Register {
	public static void newUser(String username, String password, String email, String firstName, String lastName, String ra) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		int role = 1;
		
		try (
			PreparedStatement statement = conn.prepareStatement("INSERT INTO user(username, password, firstName, lastName, email, role, research) VALUES (?, ?, ?, ?, ?, ?, ?)");
		) {
			password = Encryption.sha256(password);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, firstName);
			statement.setString(4, lastName);
			statement.setString(5, email);
			statement.setInt(6, role);
			statement.setString(7, ra);

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
}

