package cmsys.PaperManagement;

import java.sql.*;
import cmsys.Common.*;
import java.util.*;

public class Paper {
	private int uid;
	private int pid;
	private int status;
	private String title;
	private ArrayList<String> keywords;
	private String[] docFileName;
	
	public void changeStatus(int status) {
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
					paper = new Paper();
				}

				result.close();
				return paper;
			} catch (SQLException e) {
				throw new CmsysException(24);
			}
	}
}
