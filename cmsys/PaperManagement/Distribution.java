package cmsys.PaperManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import cmsys.Common.CmsysException;
import cmsys.Common.Settings;

public class Distribution {
	private int pid, uid, status;
	private long deadline;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getDeadline() {
		return deadline;
	}
	public void setDeadline(long deadline) {
		this.deadline = deadline;
	}
	
	static public HashMap<Integer, ArrayList<Integer>> getDistributionList() throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM tempDistribution");
		) {
			HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
			ResultSet result = null;

			result = statement.executeQuery();
			
			while (result.next()) {
				if (map.get(result.getInt("pid")) == null) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					
					temp.add(result.getInt("uid"));
					map.put(result.getInt("pid"), temp);
				} else {
					ArrayList<Integer> temp = map.get(result.getInt("pid"));
					temp.add(result.getInt("uid"));
				}
			}
			return map;
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
}
