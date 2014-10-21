package cmsys.PaperManagement;

import java.sql.*;
import java.util.*;

import cmsys.Common.*;

public class Discussion {	
	static public ArrayList<DiscussionComment> getDiscussionByPid(int pid) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM discussion WHERE pid = ? ORDER BY timestamp ASC");
		) {
			ArrayList<DiscussionComment> discussion = new ArrayList<DiscussionComment>();
			ResultSet result = null;

			statement.setInt(1, pid);
			result = statement.executeQuery();
			
			while (result.next()) {
				DiscussionComment comment = new DiscussionComment();
				
				comment.uid = result.getInt("uid");
				comment.timestamp = result.getLong("timestamp");
				comment.content = result.getString("content");
				
				discussion.add(comment);
			}
			
			return discussion;
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
	
	static public void addComment(int pid, DiscussionComment comment) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
			PreparedStatement statement = conn.prepareStatement("INSERT INTO discussion(pid, uid, timestamp, content) VALUES (?, ?, ?, ?)");
		) {
			statement.setInt(1, pid);
			statement.setInt(2, comment.uid);
			statement.setLong(3, comment.timestamp);
			statement.setString(4, comment.content);

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
}
