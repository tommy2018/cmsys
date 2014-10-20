package cmsys.PaperManagement;

import java.io.*;

import cmsys.Common.*;

public class FileManager {
	static public void getFile(String filename, String dest) throws CmsysException {	
		Settings settings = Settings.getInstance();
		
		filename = settings.getSetting("docDir") + filename;
		
		try (
				InputStream in = new BufferedInputStream(new FileInputStream(filename));
				FileOutputStream out = new FileOutputStream(dest);
			)
		{
			int bytesRead = 0;
			byte[] buffer = new byte[1024];
			
			while ((bytesRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, bytesRead);
			}
		} catch (IOException e) {
			throw new CmsysException(31);
		}
	}
	
	static public void saveFile(String filePath, String filename) throws CmsysException {
		Settings settings = Settings.getInstance();
		
		try (
				InputStream in = new BufferedInputStream(new FileInputStream(filePath));
				FileOutputStream out = new FileOutputStream(settings.getSetting("docDir") + filename);
			)
		{
			int bytesRead = 0;
			byte[] buffer = new byte[1024];
			
			while ((bytesRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, bytesRead);
			}
		} catch (IOException e) {
			throw new CmsysException(32);
		}
		
	}
}
