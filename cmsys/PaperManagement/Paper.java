package cmsys.PaperManagement;

import java.sql.*;
import cmsys.Common.*;
import java.util.*;

public class Paper {
	private int uid;
	private int pid;
	private int status;
	private ArrayList<String> keywords;
	private ArrayList<String> authors;
	private String title;
	private String paperAbstract;
	private String docFilenameWH;
	private String docFilenameWOH;
	private String hashWH;
	private String hashWOH;
	
	public Paper(int uid, int pid, int status, ArrayList<String> keywords, ArrayList<String> authors, String title, String paperAbstract, String docFilenameWH, String docFilenameWOH, String hashWH, String hashWOH) {
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
	
	public ArrayList<String> getAuthors() {
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
	
	static public ArrayList<Paper> getPaperListByUID(int uid) throws CmsysException {
		 Settings settings = Settings.getInstance();
		 
		 try (
				Connection conn = DriverManager.getConnection(settings.getSetting("dbURL"), settings.getSetting("dbUsername"), settings.getSetting("dbPassword"));
				PreparedStatement statement = conn.prepareStatement("SELECT pid FROM paper WHERE uid = ?");
			) {
			 	ArrayList<Paper> list = new ArrayList<Paper>();
			 	ResultSet result = null;
				
				statement.setInt(1, uid);
				result = statement.executeQuery();
				
				while (result.next()) {
					list.add(getPaperByPID(result.getInt("pid")));
				}
			 	
			 	return list;
		 } catch (SQLException e) {
			 throw new CmsysException(24);
		 }
	}
	
	static public Paper getPaperByPID(int pid) throws CmsysException {
		Settings settings = Settings.getInstance();
		
		try (
				Connection conn = DriverManager.getConnection(settings.getSetting("dbURL"), settings.getSetting("dbUsername"), settings.getSetting("dbPassword"));
				PreparedStatement statement = conn.prepareStatement("SELECT * FROM paper WHERE pid = ?");
			) {
				Paper paper = null;
				ResultSet result = null;

				statement.setInt(1, pid);
				result = statement.executeQuery();
				
				if (result.next()) {
					int uid, status; 
					String title, paperAbstract, docFilenameWH, docFilenameWOH, hashWH, hashWOH;
					ArrayList<String> keywords, authors;
					
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
	
	static private ArrayList<String> getAuthorList(int pid) throws CmsysException {
		Settings settings = Settings.getInstance();
		
		try (
				Connection conn = DriverManager.getConnection(settings.getSetting("dbURL"), settings.getSetting("dbUsername"), settings.getSetting("dbPassword"));
				PreparedStatement statement = conn.prepareStatement("SELECT firstName, lastName FROM paperAuthor WHERE pid = ?");
			)
		{
			ArrayList<String> list = new ArrayList<String>();
			ResultSet result = null;
			
			statement.setInt(1, pid);
			result = statement.executeQuery();
			
			while (result.next()) {
				list.add(result.getString("firstName") + result.getString("lastName"));
			}
			
			return list;
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
	
	static private ArrayList<String> getKeywordList(int pid) throws CmsysException {
		Settings settings = Settings.getInstance();
		
		try (
				Connection conn = DriverManager.getConnection(settings.getSetting("dbURL"), settings.getSetting("dbUsername"), settings.getSetting("dbPassword"));
				PreparedStatement statement = conn.prepareStatement("SELECT keyword FROM paperKeyword WHERE pid = ?");
			)
		{
			ArrayList<String> list = new ArrayList<String>();
			ResultSet result = null;
			
			statement.setInt(1, pid);
			result = statement.executeQuery();
			
			while (result.next()) {
				list.add(result.getString("keyword"));
			}
			
			return list;
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
}
