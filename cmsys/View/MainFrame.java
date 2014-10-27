package cmsys.View;

import java.awt.*;

import cmsys.Common.UserDefault;
import cmsys.UserManagement.*;

public class MainFrame extends javax.swing.JFrame {
	
	private static final long serialVersionUID = -4701337077433129909L;
	public MainFrame() {
    	UserDefault userDefault = UserDefault.getInstance();
    	
    	user = (User)userDefault.getObj("user");
        initComponents();
    }

    private void initComponents() {

        loginAsDesLabel = new javax.swing.JLabel();
        jSeparatorTop = new javax.swing.JSeparator();
        mainPanel = new javax.swing.JPanel(new BorderLayout());
        loginAsLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        logoutMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        manualMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loginAsDesLabel.setText("Login as: ");
        
        if (user.getRole() == 1 || user.getRole() == 2)
        	mainPanel.add(new NormalUserMainPanel(),BorderLayout.LINE_START);
        else if (user.getRole() == 3 )
        	mainPanel.add(new PcMemberMainPanel(),BorderLayout.LINE_START);
        else if (user.getRole() == 4)
        	mainPanel.add(new PcChairMainPanel(),BorderLayout.LINE_START);
        else if (user.getRole() == 0)
        	mainPanel.add(new AdminMainPanel(),BorderLayout.LINE_START);

        loginAsLabel.setText(user.getUsername());

        fileMenu.setText("File");

        logoutMenuItem.setText("Logout");
        fileMenu.add(logoutMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText("Help");

        manualMenuItem.setText("Manual");
        manualMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manualMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(manualMenuItem);

        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparatorTop, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(loginAsDesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginAsLabel)
                        .addGap(0, 450, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginAsDesLabel)
                    .addComponent(loginAsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparatorTop, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    private void manualMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
    }


    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JSeparator jSeparatorTop;
    private javax.swing.JLabel loginAsDesLabel;
    private javax.swing.JLabel loginAsLabel;
    private javax.swing.JMenuItem logoutMenuItem;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuItem manualMenuItem;
    private javax.swing.JMenuBar menuBar;
    private User user;
}
