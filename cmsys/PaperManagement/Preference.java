package cmsys.PaperManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cmsys.Common.CmsysException;
import cmsys.Common.Settings;

public class Preference {
	private int uid, pid, preference;
	
	public Preference() {
		uid = 0;
		pid = 0;
		preference = 0;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getPreference() {
		return preference;
	}

	public void setPreference(int preference) {
		this.preference = preference;
	}
	
	static public void setPreference(int uid, int pid, int preference) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
			PreparedStatement statement = conn.prepareStatement("INSERT INTO reviewerPreference(uid, pid, preference) VALUES (?, ?, ?)");
		) {
			
				statement.setInt(1, uid);
				statement.setInt(2, pid);
				statement.setInt(3, preference);
				statement.executeUpdate();
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
	
	static public Integer getPreference(int uid, int pid) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
			PreparedStatement statement = conn.prepareStatement("SELECT preference FROM reviewerPreference WHERE uid = ? AND pid = ?");
		) {
				ResultSet result = null;
				Integer temp = null;
				
				statement.setInt(1, uid);
				statement.setInt(2, pid);
				result = statement.executeQuery();
				
				if (result.next())  {
					temp = result.getInt("preference");
				}
				
				return temp;
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
	
	static public void setPreference(ArrayList<Preference> preferenceList) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
			PreparedStatement statement = conn.prepareStatement("INSERT INTO reviewerPreference(uid, pid, preference) VALUES (?, ?, ?)");
		) {
			
			for (Preference p : preferenceList) {
				statement.setInt(1, p.getUid());
				statement.setInt(2, p.getPid());
				statement.setInt(3, p.getPreference());
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
	
	static public boolean hasMadePreference(int uid) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
			PreparedStatement statement = conn.prepareStatement("SELECT COUNT(*) FROM reviewerPreference WHERE uid = ?");
		) {
			ResultSet result = null;
			statement.setInt(1, uid);
			
			result = statement.executeQuery();
			
			if (result.next()) {
				int count = result.getInt(1);
				
				if (count > 0)
					return true;
				else
					return false;	
			} else
				throw new CmsysException(21);
			
		} catch (SQLException e) {
			System.err.println(e);
			throw new CmsysException(24);
		}
	}
}
