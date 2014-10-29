package cmsys.View;
import javax.swing.JFrame;

import cmsys.Common.CmsysException;
import cmsys.Common.CronJob;
import cmsys.Common.UserDefault;
import cmsys.UserManagement.*;

@SuppressWarnings("serial")
public class LoginPanel extends javax.swing.JPanel {

    public LoginPanel(JFrame me) {
    	this.me = me;
        initComponents();
    }

    private void initComponents() {

        signUpButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        usernameDesLabel = new javax.swing.JLabel();
        passwordDesLabel = new javax.swing.JLabel();
        usernameTextBox = new javax.swing.JTextField();
        passwordTextBox = new javax.swing.JPasswordField();
        CMSDesLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        newUserDesLabel = new javax.swing.JLabel();

        signUpButton.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        signUpButton.setText("Sign up");
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	CronJob.changeSystemStatusToDistribution();
            }
        });
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        usernameDesLabel.setText("Username: ");

        passwordDesLabel.setText("Password:");

        usernameTextBox.setToolTipText("");

        CMSDesLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        CMSDesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CMSDesLabel.setText("Conference Management System");

        newUserDesLabel.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        newUserDesLabel.setText("New user?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passwordDesLabel)
                                    .addComponent(usernameDesLabel))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(CMSDesLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addComponent(passwordTextBox)
                            .addComponent(usernameTextBox, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(newUserDesLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signUpButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(CMSDesLabel)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameDesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordDesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(signUpButton)
                        .addComponent(newUserDesLabel))
                    .addComponent(loginButton))
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String username = usernameTextBox.getText().trim();
        char[] input = passwordTextBox.getPassword();
        String password = String.copyValueOf(input);
        
        if (username == null || username.length() == 0 || input == null || input.length == 0) {
        	MessageBox.error("Please enter your username or password", this);
        } else {
        	User user = null;
        	boolean success = false;
        	
			try {
				user = Login.login(username, password);
				success = true;
			} catch (CmsysException e) {
				System.out.println(e.getMessage());
				MessageBox.error("Unable to preform this action at the moment.", this);
			}
        	
			if (success) {
				if (user == null ) {
					MessageBox.error("Incorrect login information!", this);
				} else {
					UserDefault userDefault = UserDefault.getInstance();
					userDefault.putObj("user", user);
					me.dispose();
        		
					//Main frame
					JFrame frame = new MainFrame();
					
					frame.pack();
					frame.setVisible(true);
				}
        	}
        }
        
    }
    
    private javax.swing.JLabel CMSDesLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel newUserDesLabel;
    private javax.swing.JLabel passwordDesLabel;
    private javax.swing.JPasswordField passwordTextBox;
    private javax.swing.JButton signUpButton;
    private javax.swing.JLabel usernameDesLabel;
    private javax.swing.JTextField usernameTextBox;
    private JFrame me;
}
