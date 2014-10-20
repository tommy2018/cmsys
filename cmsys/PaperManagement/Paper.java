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
	
	static public ArrayList<Integer> getPaperListByUID(int uid) throws CmsysException {
		 Settings settings = Settings.getInstance();
		 
		 try (
				Connection conn = DriverManager.getConnection(settings.getSetting("dbURL"), settings.getSetting("dbUsername"), settings.getSetting("dbPassword"));
				PreparedStatement statement = conn.prepareStatement("SELECT * FROM paper WHERE uid = ?");
			) {
			 	ArrayList<Integer> list = new ArrayList<Integer>();
			 	
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
					//getKeywordList(pid)
					paper = new Paper(uid, pid, status, keywords, authors, title, paperAbstract, docFilenameWH, docFilenameWOH, hashWH, hashWOH);
				}

				result.close();
				return paper;
			} catch (SQLException e) {
				throw new CmsysException(24);
			}
	}
	
	static private ArrayList<String> getAuthorList(int pid) {
		try (
				Connection conn = DriverManager.getConnection(settings.getSetting("dbURL"), settings.getSetting("dbUsername"), settings.getSetting("dbPassword"));
				PreparedStatement statement = conn.prepareStatement("SELECT * FROM paper WHERE pid = ?");
			)
		{
			ArrayList<String> list = null;
		
			return list;
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
}
