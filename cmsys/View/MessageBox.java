package cmsys.View;

import java.awt.Component;
import javax.swing.JOptionPane;

public class MessageBox {
	static public void information(String message, Component parent) {
		JOptionPane.showMessageDialog(parent, message);
	}
	
	static public void warning(String message, Component parent) {
		JOptionPane.showMessageDialog(parent, message, "Warning", JOptionPane.WARNING_MESSAGE);
	}
	
	static public void error(String message, Component parent) {
		JOptionPane.showMessageDialog(parent, message, "Warning", JOptionPane.ERROR_MESSAGE);
	}
}
