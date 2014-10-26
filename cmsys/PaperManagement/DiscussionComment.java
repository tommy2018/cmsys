package cmsys.PaperManagement;

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
}
