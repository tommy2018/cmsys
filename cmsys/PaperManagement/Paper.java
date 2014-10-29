package cmsys.PaperManagement;

import java.sql.*;

import cmsys.Common.*;

import java.util.*;

public class Paper {
	private int uid;
	private int pid;
	private int status;
	private ArrayList<String> keywords;
	private ArrayList<Author> authors;
	private String title;
	private String paperAbstract;
	private String docFilenameWH;
	private String docFilenameWOH;
	private String hashWH;
	private String hashWOH;
	
	public Paper(int uid, int pid, int status, ArrayList<String> keywords, ArrayList<Author> authors, String title, String paperAbstract, String docFilenameWH, String docFilenameWOH, String hashWH, String hashWOH) {
		this.uid = uid;
		this.pid = pid;
		this.status = status;
		this.keywords = keywords;
		this.authors = authors;
		this.title = title;
		this.paperAbstract = paperAbstract;
		this.docFilenameWH = docFilenameWH;
		this.docFilenameWOH = docFilenameWOH;
		this.hashWH = hashWH;
		this.hashWOH = hashWOH;
	}
	
	public int getUid() {
		return uid;
	}
	
	public int getPid() {
		return pid;
	}
	
	public int getStatus() {
		return status;
	}
	
	public ArrayList<String> getKeywords() {
		return keywords;
	}
	
	public ArrayList<Author> getAuthors() {
		return authors;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getPaperAbstract() {
		return paperAbstract;
	}
	
	public String getDocFilenameWH() {
		return docFilenameWH;
	}
	
	public String getDocFilenameWOH() {
		return docFilenameWOH;
	}
	
	public String getHashWH() {
		return hashWH;
	}
	
	public String getHashWOH() {
		return hashWOH;
	}
	
	static public void startToReview(int pid) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		try (
			PreparedStatement statement = conn.prepareStatement("UPDATE paper SET status = 5 WHERE pid = ?");
		) {
			statement.setInt(1, pid);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
	
	static public void setToReviewed(int pid) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		try (
			PreparedStatement statement = conn.prepareStatement("UPDATE paper SET status = 6 WHERE pid = ?");
		) {
			statement.setInt(1, pid);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
	
	static public void accept(int pid) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		try (
			PreparedStatement statement = conn.prepareStatement("UPDATE paper SET status = 2 WHERE pid = ?");
		) {
			statement.setInt(1, pid);
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			throw new CmsysException(24);
		}
	}
	
	static public void decline(int pid) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
			PreparedStatement statement = conn.prepareStatement("UPDATE paper SET status = 4 WHERE pid = ?");
		) {
			statement.setInt(1, pid);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
	
	static public ArrayList<Paper> getPaperListByUid(int uid) throws CmsysException {
		 Settings settings = Settings.getInstance();
		 Connection conn = settings.getDBConnection();
		 try (
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM paper WHERE uid = ?");
		 ) {
				ArrayList<Paper> paperList = new ArrayList<Paper>();
				ResultSet result = null;

				statement.setInt(1, uid);
				result = statement.executeQuery();
					
				while (result.next()) {
					Paper paper;
					
					int pid, status; 
					String title, paperAbstract, docFilenameWH, docFilenameWOH, hashWH, hashWOH;
					ArrayList<String> keywords;
					ArrayList<Author> authors;
						
					pid = result.getInt("pid");
					status = result.getInt("status");
					title = result.getString("title");
					paperAbstract = result.getString("abstract");
					docFilenameWH = result.getString("filenameWH");
					docFilenameWOH = result.getString("filenameWOH");
					hashWH = result.getString("hashFilenameWH");
					hashWOH = result.getString("hashFilenameWOH");
					authors = getAuthorList(pid);
					keywords = getKeywordList(pid);
					
					paper = new Paper(uid, pid, status, keywords, authors, title, paperAbstract, docFilenameWH, docFilenameWOH, hashWH, hashWOH);
					paperList.add(paper);
				}

				result.close();
				return paperList;
			} catch (SQLException e) {
				throw new CmsysException(24);
			}
	}
	
	static public int getStatus(int pid) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
			PreparedStatement statement = conn.prepareStatement("SELECT status FROM paper WHERE pid = ?");
		) {
			statement.setInt(1, pid);
			ResultSet result = null;
			result = statement.executeQuery();
			
			if (result.next())
				return result.getInt("status");
			else
				return 0;
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
	
	static public ArrayList<Paper> getPaperList() throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM paper");
		) {
			ArrayList<Paper> paperList = new ArrayList<Paper>();
			ResultSet result = null;
				result = statement.executeQuery();
				
			while (result.next()) {
				Paper paper;
				
				int uid, pid, status; 
				String title, paperAbstract, docFilenameWH, docFilenameWOH, hashWH, hashWOH;
				ArrayList<String> keywords;
				ArrayList<Author> authors;
					
				pid = result.getInt("pid");
				uid = result.getInt("uid");
				status = result.getInt("status");
				title = result.getString("title");
				paperAbstract = result.getString("abstract");
				docFilenameWH = result.getString("filenameWH");
				docFilenameWOH = result.getString("filenameWOH");
				hashWH = result.getString("hashFilenameWH");
				hashWOH = result.getString("hashFilenameWOH");
				authors = getAuthorList(pid);
				keywords = getKeywordList(pid);
					
				paper = new Paper(uid, pid, status, keywords, authors, title, paperAbstract, docFilenameWH, docFilenameWOH, hashWH, hashWOH);
				paperList.add(paper);
			}

			result.close();
			return paperList;
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
	
	static public ArrayList<Paper> getReviewPaperListByUid(int uid) throws CmsysException {
		 Settings settings = Settings.getInstance();
		 Connection conn = settings.getDBConnection();
		 try (
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM paper JOIN distribution USING(pid) WHERE distribution.uid = ? AND paper.status = 5 AND distribution.status = 0");
		 ) {
				ArrayList<Paper> paperList = new ArrayList<Paper>();
				ResultSet result = null;

				statement.setInt(1, uid);
				result = statement.executeQuery();
					
				while (result.next()) {
					Paper paper;
					
					int pid, status; 
					String title, paperAbstract, docFilenameWH, docFilenameWOH, hashWH, hashWOH;
					ArrayList<String> keywords;
					ArrayList<Author> authors;
						
					pid = result.getInt("pid");
					status = result.getInt("status");
					title = result.getString("title");
					paperAbstract = result.getString("abstract");
					docFilenameWH = result.getString("filenameWH");
					docFilenameWOH = result.getString("filenameWOH");
					hashWH = result.getString("hashFilenameWH");
					hashWOH = result.getString("hashFilenameWOH");
					authors = getAuthorList(pid);
					keywords = getKeywordList(pid);
					
					paper = new Paper(uid, pid, status, keywords, authors, title, paperAbstract, docFilenameWH, docFilenameWOH, hashWH, hashWOH);
					paperList.add(paper);
				}

				result.close();
				return paperList;
			} catch (SQLException e) {
				throw new CmsysException(24);
			}
	}
	
	static public ArrayList<Integer> getReviewPaperList() throws CmsysException {
		 Settings settings = Settings.getInstance();
		 Connection conn = settings.getDBConnection();
		 try (
			PreparedStatement statement = conn.prepareStatement("SELECT DISTINCT(pid) c FROM distribution");
		 ) {
				ArrayList<Integer> paperList = new ArrayList<Integer>();
				ResultSet result = null;

				result = statement.executeQuery();
					
				while (result.next()) {
					int temp = result.getInt("c");
					paperList.add(temp);
				}

				result.close();
				return paperList;
			} catch (SQLException e) {
				System.out.println(e);
				throw new CmsysException(24);
			}
	}
	
	static public Paper getPaperByPid(int pid) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
				PreparedStatement statement = conn.prepareStatement("SELECT * FROM paper WHERE pid = ?");
		) {
				Paper paper = null;
				ResultSet result = null;

				statement.setInt(1, pid);
				result = statement.executeQuery();
				
				if (result.next()) {
					int uid, status; 
					String title, paperAbstract, docFilenameWH, docFilenameWOH, hashWH, hashWOH;
					ArrayList<String> keywords;
					ArrayList<Author> authors;
					
					uid = result.getInt("uid");
					status = result.getInt("status");
					title = result.getString("title");
					paperAbstract = result.getString("abstract");
					docFilenameWH = result.getString("filenameWH");
					docFilenameWOH = result.getString("filenameWOH");
					hashWH = result.getString("hashFilenameWH");
					hashWOH = result.getString("hashFilenameWOH");
					authors = getAuthorList(pid);
					keywords = getKeywordList(pid);
					
					paper = new Paper(uid, pid, status, keywords, authors, title, paperAbstract, docFilenameWH, docFilenameWOH, hashWH, hashWOH);
				}

				result.close();
				return paper;
			} catch (SQLException e) {
				throw new CmsysException(24);
			}
	}
	
	static public boolean allReviewed(int pid) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
				PreparedStatement statement = conn.prepareStatement("SELECT * FROM paper JOIN distribution USING(pid) WHERE pid = ? HAVING COUNT(DISTINCT(distribution.status)) = 1 AND distribution.status = 1 AND paper.status = 5");
		) {
				ResultSet result = null;

				statement.setInt(1, pid);
				result = statement.executeQuery();
				
				if (result.next()) {
					return true;
				}
				
				return false;
			} catch (SQLException e) {
				throw new CmsysException(24);
			}
	}
	
	static private ArrayList<Author> getAuthorList(int pid) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
				PreparedStatement statement = conn.prepareStatement("SELECT firstName, lastName FROM paperAuthor WHERE pid = ?");
		) {
			
			ArrayList<Author> list = new ArrayList<Author>();
			ResultSet result = null;
			
			statement.setInt(1, pid);
			result = statement.executeQuery();
			
			while (result.next()) {
				list.add(new Author(result.getString("firstName"), result.getString("lastName")));
			}
			
			result.close();
			return list;
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
	
	static private ArrayList<String> getKeywordList(int pid) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
				PreparedStatement statement = conn.prepareStatement("SELECT keyword FROM paperKeyword WHERE pid = ?");
		) {
			
			ArrayList<String> list = new ArrayList<String>();
			ResultSet result = null;
			
			statement.setInt(1, pid);
			result = statement.executeQuery();
			
			while (result.next()) {
				list.add(result.getString("keyword"));
			}
			
			result.close();
			return list;
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
}
