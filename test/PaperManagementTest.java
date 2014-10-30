package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import cmsys.Common.CmsysException;
import cmsys.PaperManagement.Paper;
import cmsys.PaperManagement.Status;

public class PaperManagementTest {
	@Test
	public void testStatus() {
		assertEquals(Status.toString(0, 0), "Submitted");
	}
	@Test
	public void testPaper() throws CmsysException {
		ArrayList<Paper> paperList = Paper.getPaperList();
		assertNotEquals(paperList, null);
		
		Paper paper1 = paperList.get(0);
		Paper paper2 = Paper.getPaperByPid(paper1.getPid());
		
		assertEquals(paper1.getHashWH(), paper2.getHashWH());
	}
	
	
}
