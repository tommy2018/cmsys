package cmsys.UserManagement;

import java.sql.*;
import cmsys.Common.*;

public class Login {
	private static Settings settings = null;

	public static User login(String username, String password) throws CmsysException {
		settings = Settings.getInstance();
		
		try (
			Connection conn = DriverManager.getConnection(settings.getSetting("dbURL"), settings.getSetting("dbUsername"), settings.getSetting("dbPassword"));
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");
		) {
			ResultSet result = null;
			User user = null;

			password = Encryption.sha256(password);
			statement.setString(1, username);
			statement.setString(2, password);
			result = statement.executeQuery();
			
			if (result.next()) {
				user = new User(result.getInt("uid"), result.getString("username"), result.getString("firstName"),
						result.getString("lastName"), result.getString("email"), result.getInt("role"));
			}

			result.close();
			return user;
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
}
