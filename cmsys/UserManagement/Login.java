package cmsys.UserManagement;

import java.sql.*;

import cmsys.Common.*;

public class Login {
	public static User login(String username, String password) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
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
						result.getString("lastName"), result.getString("email"), result.getInt("role"), result.getString("research"));
			}

			return user;
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
}
