package cmsys.PaperManagement;

import cmsys.Common.CmsysException;
import cmsys.Common.Time;
import cmsys.UserManagement.User;

public class DiscussionComment {
	private int uid;
	private String content;
	private long timestamp;
	
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	public int getUid() {
		return uid;
	}
	
	public String getContent() {
		return content;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	
	public String toString() {
		String string;
		
		string = Time.toDate(timestamp) + "\n";
		
		try {
			string += User.getUserByUid(uid).getUsername() + ":\n";
		} catch (CmsysException e) {}
		
		string += "--------------------\n";
		string += content + "\n";
		string += "--------------------\n\n";
		
		return string;
	}
}
