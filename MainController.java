import cmsys.Common.*;
import cmsys.View.*;

import javax.swing.*;

public class MainController {	
	static public void main(String[] args) {
		@SuppressWarnings("unused")
		Settings settings = null;
		
		try {
			settings = Settings.getInstance();
			
			JFrame loginFrame = new JFrame("Login");

			loginFrame.add(new LoginPanel(loginFrame));
			loginFrame.pack();
			loginFrame.setLocationRelativeTo(null);
			loginFrame.setVisible(true);
			
		} catch (CmsysException e) {
			MessageBox.error(e.getMessage(), null);
		}
	}
}
