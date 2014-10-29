package cmsys.Common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Log {
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	static public ArrayList<Log> getLogByUid(int uid) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
				PreparedStatement statement = conn.prepareStatement("SELECT * FROM log WHERE uid = ?");
			) {
				ArrayList<Log> list = new ArrayList<Log> ();
				ResultSet result = null;
				
				statement.setInt(1, uid);
				
				result = statement.executeQuery();
				
				while (result.next()) {
					Log log = new Log();
					log.setMessage(result.getString("message"));
					list.add(log);
				}

				statement.execute();
				return list;
			} catch (SQLException e) {
				throw new CmsysException(24);
			}
	}
	
	static public void newLog(int uid, String message) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
			PreparedStatement statement = conn.prepareStatement("INSERT INTO log(uid, message) VALUES(? ,?)");
		) {
			statement.setInt(1, uid);
			statement.setString(2, message);
			

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
}
