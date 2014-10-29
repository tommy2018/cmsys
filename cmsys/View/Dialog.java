package cmsys.View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Dialog {
	private JDialog dialog;
	
	public Dialog(Component parent, String message) {
		dialog = new JDialog();
		dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		dialog.setResizable(false);
		dialog.setModalityType(ModalityType.APPLICATION_MODAL);
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel(message);
		
		label.setHorizontalAlignment(JLabel.CENTER);
		
		panel.setLayout(new BorderLayout());
		panel.setPreferredSize(new Dimension(400, 80));
		panel.add(label, BorderLayout.CENTER);
		
		dialog.add(panel);
		dialog.pack();
		dialog.setLocationRelativeTo(parent);
	}
	
	public Dialog(Component parent, JPanel panel, String title) {
		dialog = new JDialog();
		dialog.setTitle(title);
		dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		dialog.setResizable(false);
		dialog.setModalityType(ModalityType.APPLICATION_MODAL);
		dialog.add(panel);
		dialog.pack();
		dialog.setLocationRelativeTo(parent);
	}
	
	public Dialog(Component parent, JPanel panel, String title, int n) {
		dialog = new JDialog();
		dialog.setTitle(title);
		dialog.setResizable(false);
		if (n != 100)
			dialog.setModalityType(ModalityType.APPLICATION_MODAL);
		dialog.add(panel);
		dialog.pack();
		dialog.setLocationRelativeTo(parent);
	}
	
	public void show() {
    	dialog.setVisible(true);
	}
	
	public void close() {
		dialog.dispose();
	}
}
