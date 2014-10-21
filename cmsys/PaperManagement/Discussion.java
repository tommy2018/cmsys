package cmsys.PaperManagement;

import java.sql.*;
import java.util.*;

import cmsys.Common.*;

public class Discussion {
	private ArrayList<DiscussionComment> commentList;
	
	public Discussion() {
		commentList = new ArrayList<DiscussionComment>();
	}
	
	public ArrayList<DiscussionComment> getCommentList() {
		return commentList;
	}
	
	static public Discussion getDiscussionByPid(int pid) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM discussion WHERE pid = ? ORDER BY timestamp ASC");
		) {
			Discussion discussion = new Discussion();
			ResultSet result = null;

			statement.setInt(1, pid);
			result = statement.executeQuery();
			
			while (result.next()) {
				DiscussionComment comment = new DiscussionComment();
				
				comment.uid = result.getInt("uid");
				comment.timestamp = result.getInt("timestamp");
				comment.content = result.getString("content");
				
				discussion.getCommentList().add(comment);
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
			PreparedStatement statement = conn.prepareStatement("INSERT INTO discussion(pid, uid, timestamp, content) VALUES (?, ?, ?)");
		) {
			statement.setInt(1, pid);
			statement.setInt(2, comment.uid);
			statement.setInt(3, comment.timestamp);
			statement.setString(4, comment.content);

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
}
