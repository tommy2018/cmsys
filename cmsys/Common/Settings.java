package cmsys.Common;

import java.sql.*;
import java.util.*;
import java.io.*;

public class Settings {
	private static Settings settings = null;
	private Map<String, String> programSettings;
	private Map<Long, Connection> threadRecord;

	private Settings(String filename) throws CmsysException {
		try (FileInputStream file = new FileInputStream(filename);) {

			programSettings = new HashMap<String, String>();
			Properties settings = new Properties();

			settings.load(file);
			programSettings.put("dbDrivers", settings.getProperty("dbDrivers"));
			programSettings.put("dbURL", settings.getProperty("dbURL"));
			programSettings.put("dbUsername",
					settings.getProperty("dbUsername"));
			programSettings.put("dbPassword",
					settings.getProperty("dbPassword"));
			programSettings.put("docDir", settings.getProperty("docDir"));

			for (String key : programSettings.keySet()) {
				if (programSettings.get(key) == null)
					throw new CmsysException(0);
			}

			System.setProperty("jdbc.drivers", programSettings.get("dbDrivers"));
			file.close();
			threadRecord = new HashMap<Long, Connection>();
		} catch (FileNotFoundException e) {
			throw new CmsysException(1);
		} catch (IOException e) {
			throw new CmsysException(2);
		}
	}

	public synchronized Connection getDBConnection() throws CmsysException {
		try {
			System.err.println("Thread: " + Thread.currentThread().getId());
			Connection conn = threadRecord.get(Thread.currentThread().getId());

			if (conn == null) {
				conn = DriverManager.getConnection(getSetting("dbURL"),
						getSetting("dbUsername"), getSetting("dbPassword"));
				threadRecord.put(Thread.currentThread().getId(), conn);
			} else if (conn.isClosed()) {
				conn = DriverManager.getConnection(getSetting("dbURL"),
						getSetting("dbUsername"), getSetting("dbPassword"));
				threadRecord.put(Thread.currentThread().getId(), conn);
			}

			return conn;
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}

	public static synchronized Settings getInstance() throws CmsysException {
		if (settings == null)
			settings = new Settings("settings.ini");

		return settings;
	}

	public String getSetting(String settingName) {
		return programSettings.get(settingName);
	}

	static public String getSettingFromDB(String key) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();

		try (
				PreparedStatement statement = conn.prepareStatement("SELECT value FROM setting WHERE item = ?");
		) {
			ResultSet result = null;
			String value = null;

			statement.setString(1, key);
			result = statement.executeQuery();

			if (result.next())
				value = result.getString("value");
			
			return value;
		} catch (SQLException e) {
			throw new CmsysException(24);
		}

	}
	
	static public void updateSetting(String key, String value) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();

		try (
				PreparedStatement statement = conn.prepareStatement("UPDATE setting SET value = ? WHERE item = ?");
		) {
			statement.setString(1, value);
			statement.setString(2, key);
			statement.executeUpdate();
			
		} catch (SQLException e) {
			throw new CmsysException(24);
		}

	}
	
	static public void newSetting(String item, String value) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();

		try (
				PreparedStatement statement = conn.prepareStatement("INSERT INTO setting(value, item) VALUES(?, ?)");
		) {
			statement.setString(1, value);
			statement.setString(2, item);
			statement.executeUpdate();
			
		} catch (SQLException e) {
			throw new CmsysException(24);
		}

	}
}