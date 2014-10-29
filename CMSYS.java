import cmsys.Common.*;
import cmsys.View.*;

import javax.swing.*;

public class CMSYS {	
	static public void main(String[] args) {
		@SuppressWarnings("unused")
		Settings settings = null;
		
		try {
			settings = Settings.getInstance();
			
			if (Settings.getSettingFromDB("status") == null) {
				JFrame loginFrame = new JFrame("Setup");

				loginFrame.add(new SetupForm());
				loginFrame.pack();
				loginFrame.setLocationRelativeTo(null);
				loginFrame.setVisible(true);
			} else {
				JFrame loginFrame = new JFrame("Login");

				loginFrame.add(new LoginPanel(loginFrame));
				loginFrame.pack();
				loginFrame.setLocationRelativeTo(null);
				loginFrame.setVisible(true);
			}
			
		} catch (CmsysException e) {
			MessageBox.error(e.getMessage(), null);
		}
	}
}
