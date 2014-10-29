package cmsys.PaperManagement;

import java.sql.*;
import java.util.ArrayList;
import java.io.*;

import cmsys.Common.*;
import cmsys.UserManagement.User;

public class Submission {
	static public void submitPaper(int uid, String title, String paperAbstract, ArrayList<Author>authors, ArrayList<String>keywords, File fileWH, File fileWOH) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		int pid = 0;
		
		try (
			PreparedStatement statement = conn.prepareStatement("INSERT INTO paper(uid, status, title, abstract, filenameWH, filenameWOH, hashFilenameWH, hashFilenameWOH, timestamp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		) {

			long timestamp = cmsys.Common.Time.timestamp();
			String hashFilenameWOH = Encryption.sha256((int)(Math.random() * 999999) + fileWOH.getName() + uid + timestamp);
			String hashFilenameWH = Encryption.sha256((int)(Math.random() * 999999) + fileWH.getName() + uid + timestamp);
			FileManager.saveFile(fileWH.getAbsolutePath(), hashFilenameWH);
			FileManager.saveFile(fileWOH.getAbsolutePath(), hashFilenameWOH);
			
			statement.setInt(1, uid);
			statement.setInt(2, 0);;
			statement.setString(3, title);
			statement.setString(4, paperAbstract);
			statement.setString(5, fileWH.getName());
			statement.setString(6, fileWOH.getName());
			statement.setString(7, hashFilenameWH);
			statement.setString(8, hashFilenameWOH);
			statement.setLong(9, timestamp);
			
			statement.executeUpdate();
			
			ResultSet keys = statement.getGeneratedKeys();
			keys.next();
			pid = keys.getInt(1);
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
		
		addAuthors(pid, authors);
		addKeywords(pid, keywords);
		
		User user = User.getUserByUid(uid);
		
		if (user.getRole() == 1)
			user.changeRole(2);
	}
	
	static public void submitFinalPaper(int pid, File file) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
			PreparedStatement statement = conn.prepareStatement("INSERT INTO finalPaper(pid, finalPaperFilename, hashFinalPaperFilename) VALUES (?, ?, ?)");
		) {

			long timestamp = cmsys.Common.Time.timestamp();
			String hashFilename = Encryption.sha256((int)(Math.random() * 999999) + file.getName() + timestamp);
			FileManager.saveFile(file.getAbsolutePath(), hashFilename);
			
			statement.setInt(1, pid);
			statement.setString(2, file.getName());
			statement.setString(3, hashFilename);
			
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
		
		try (
				PreparedStatement statement = conn.prepareStatement("UPDATE paper SET status = 3 WHERE pid = ?");
			) {
				statement.setInt(1, pid);
				statement.executeUpdate();
		} catch (SQLException e) {
				throw new CmsysException(24);
		}
		
	}
	
	static private void addAuthors(int pid, ArrayList<Author> authors) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
			PreparedStatement statement = conn.prepareStatement("INSERT INTO paperAuthor(pid, firstName, lastName) VALUES(?, ?, ?)");
		) {
			
			for (Author author: authors) {
				statement.setInt(1, pid);
				statement.setString(2, author.getFirstName());
				statement.setString(3, author.getLastName());
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			System.err.println(e);
			throw new CmsysException(24);
		}
	}
	
	static private void addKeywords(int pid, ArrayList<String> keywords) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
			PreparedStatement statement = conn.prepareStatement("INSERT INTO paperKeyword(pid, keyword) VALUES(?, ?)");
		) {
			
			for (String keyword: keywords) {
				statement.setInt(1, pid);
				statement.setString(2, keyword);
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			System.err.println(e);
			throw new CmsysException(24);
		}
	}
}
