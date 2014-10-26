package cmsys.PaperManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
