package cmsys.PaperManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cmsys.Common.CmsysException;
import cmsys.Common.Settings;

public class FinalPaper {
	static public String getFinalPaperFileByPid(int pid) throws CmsysException {
		Settings settings = Settings.getInstance();
		Connection conn = settings.getDBConnection();
		
		try (
			PreparedStatement statement = conn.prepareStatement("SELECT hashFinalPaperFilename FROM finalPaper WHERE pid = ?");
		) {
			String filePath = null;
			ResultSet result = null;

			statement.setInt(1, pid);
			result = statement.executeQuery();
					
			if (result.next()) {
				return result.getString("hashFinalPaperFilename");
			}

			return filePath;
		} catch (SQLException e) {
			throw new CmsysException(24);
		}
	}
}
