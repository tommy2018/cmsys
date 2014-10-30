package test;

import static org.junit.Assert.*;

import org.junit.Test;

import cmsys.Common.CmsysException;
import cmsys.Common.Encryption;
import cmsys.Common.Settings;

public class CommonTest {

	@Test
	public void testExcryption() {
		assertEquals(Encryption.sha256("admin"), "8C6976E5B5410415BDE908BD4DEE15DFB167A9C873FC4BB8A81F6F2AB448A918");
	}
	
	public void testSettings() throws CmsysException {
		Settings settings = Settings.getInstance();
		assertNotEquals(settings, null);
		assertEquals(Settings.getSettingFromDB("status"), "3");
	}

}
