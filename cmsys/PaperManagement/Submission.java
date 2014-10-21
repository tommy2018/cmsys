package cmsys.PaperManagement;

import java.sql.*;
import java.io.*;

import cmsys.Common.*;

public class Submission {
	static public void submitPaper(int uid, File fileWH, File fileWOH) throws CmsysException {
		Settings settings = Settings.getInstance();
		
		try (
			Connection conn = DriverManager.getConnection(settings.getSetting("dbURL"), settings.getSetting("dbUsername"), settings.getSetting("dbPassword"));
			PreparedStatement statement = conn.prepareStatement("INSERT INTO paper() VALUES ()");
		) {
			String filenameWH = Encryption.sha256((int)(Math.random() * 999999) + fileWH.getName());
			String filenameWHO = Encryption.sha256((int)(Math.random() * 999999) + fileWOH.getName());
			
			FileManager.saveFile(fileWH.getAbsolutePath(), filenameWH);
			FileManager.saveFile(fileWOH.getAbsolutePath(), filenameWHO);
			
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
	
	static public void submitFinalPaper() {
		
	}
}
