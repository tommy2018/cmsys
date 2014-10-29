package cmsys.UserManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cmsys.Common.CmsysException;
import cmsys.Common.Encryption;
import cmsys.Common.Settings;

public class User {
	private int uid;
	private int role;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private ArrayList<String> researchAreas;

	public User(int uid, String username, String firstName, String lastName, String email, int role) {
		this.uid = uid;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUsername() {
		return username;
	}

	public int getUID() {
		return uid;
	}

	public int getRole() {
		return role;
	}
	
	public ArrayList<String> getResearchAreas() {
		return researchAreas;
	}
	
	public void changePassword(String password) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
			PreparedStatement statement = conn.prepareStatement("UPDATE user SET password = ? WHERE uid = ?");
		) {
			password = Encryption.sha256(password);
			statement.setString(1, password);
			statement.setInt(2, uid);

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
	
	public void changeRole(int role) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
			PreparedStatement statement = conn.prepareStatement("UPDATE user SET role = ? WHERE uid = ?");
		) {
			statement.setInt(1, role);
			statement.setInt(2, uid);

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
	
	static public User getUserByUid(int uid) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM user WHERE uid = ?");	
		) {
			User user = null;
		 	ResultSet result = null;
		 	
		 	statement.setInt(1, uid);
			result = statement.executeQuery();
		 	
			while (result.next()) {
				user = new User(result.getInt("uid"), result.getString("username"), result.getString("firstName"),
						result.getString("lastName"), result.getString("email"), result.getInt("role"));
			}
			
		 	return user;
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
	
	static public ArrayList<User> getPcMemberList() throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM user WHERE role = 3");	
		) {
			ArrayList<User> list = new ArrayList<User>();
		 	ResultSet result = null;
		 	
			result = statement.executeQuery();
		 	
			while (result.next()) {
				User user = new User(result.getInt("uid"), result.getString("username"), result.getString("firstName"),
						result.getString("lastName"), result.getString("email"), result.getInt("role"));
				list.add(user);
			}
			
		 	return list;
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
	
	static public ArrayList<User> searchUserByUsername(String keywords) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM user WHERE username LIKE ? LIMIT 30");	
		) {
			ArrayList<User> list = new ArrayList<User>();
		 	ResultSet result = null;
		 	
		 	keywords = '%' + keywords.trim() + '%';
		 	
		 	statement.setString(1, keywords);
			result = statement.executeQuery();
		 	
			while (result.next()) {
				User user = new User(result.getInt("uid"), result.getString("username"), result.getString("firstName"),
						result.getString("lastName"), result.getString("email"), result.getInt("role"));
				list.add(user);
			}
			
		 	return list;
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
	
	static public ArrayList<User> searchUserByName(String keywords) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM user WHERE firstName LIKE ? OR lastName LIKE ? LIMIT 30");	
		) {
			ArrayList<User> list = new ArrayList<User>();
		 	ResultSet result = null;
		 	
		 	keywords = '%' + keywords.trim() + '%';
		 	
		 	statement.setString(1, keywords);
		 	statement.setString(2, keywords);
			result = statement.executeQuery();
		 	
			while (result.next()) {
				User user = new User(result.getInt("uid"), result.getString("username"), result.getString("firstName"),
						result.getString("lastName"), result.getString("email"), result.getInt("role"));
				list.add(user);
			}
			
		 	return list;
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
}
