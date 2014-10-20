package cmsys.Common;

import java.util.*;
import java.io.*;

public class Settings {
	private static Settings settings = null;
	private Map<String, String> programSettings;

	private Settings(String filename) throws CmsysException {
		try {
			programSettings = new HashMap<String, String>();
			Properties settings = new Properties();	
			FileInputStream file = new FileInputStream(filename);
	
			settings.load(file);
			programSettings.put("programName", settings.getProperty("programName"));
			programSettings.put("programVersion", settings.getProperty("programVersion"));
			programSettings.put("dbDrivers", settings.getProperty("dbDrivers"));
			programSettings.put("dbURL", settings.getProperty("dbURL"));
			programSettings.put("dbUsername", settings.getProperty("dbUsername"));
			programSettings.put("dbPassword", settings.getProperty("dbPassword"));
	
			for (String key : programSettings.keySet()) {
				if (programSettings.get(key) == null)
					throw new CmsysException(0);
			}

			System.setProperty("jdbc.drivers", programSettings.get("dbDrivers"));
			file.close();
		} catch (FileNotFoundException e) {
			throw new CmsysException(1);
		} catch (IOException e) {
			throw new CmsysException(2);
		}
	}

	public static Settings getInstance() throws CmsysException { 
		if (settings == null)
			settings = new Settings("settings.ini");

		return settings;
	}

	public String getSetting(String settingName) {
		return programSettings.get(settingName);
	}
}