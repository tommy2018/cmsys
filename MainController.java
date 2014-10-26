import cmsys.Common.*;
import cmsys.UserManagement.*;
import cmsys.PaperManagement.*;
import cmsys.View.*;

import javax.swing.*;

import java.util.*;
import java.io.*;

public class MainController {
	static public void main(String[] args) {
		Settings settings = null;
		
		try {
			UserDefault userDefault = UserDefault.getInstance();
			User user = null;
			
			settings = Settings.getInstance();
			user = User.getUserByUid(1);
			userDefault.putObj("user", user);
			
			//Login frame
			
			//Main frame
			JFrame frame = new MainFrame();
					
			frame.pack();
			frame.setVisible(true);
		} catch (CmsysException e) {
			System.err.println(e.getMessage());
		}
	}
}
