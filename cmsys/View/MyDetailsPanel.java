package cmsys.View;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import cmsys.Common.CmsysException;
import cmsys.Common.UserDefault;
import cmsys.UserManagement.*;

public class MyDetailsPanel extends javax.swing.JPanel {

	private static final long serialVersionUID = -4579181238230251010L;
	public MyDetailsPanel() {
    	UserDefault userDefault = UserDefault.getInstance();
    	
    	user = (User)userDefault.getObj("user");
        initComponents();
    }

    private void initComponents() {

        basicDetailsPanel = new javax.swing.JPanel();
        roleDesLabel = new javax.swing.JLabel();
        uidDesLabel = new javax.swing.JLabel();
        usernameDesLabel = new javax.swing.JLabel();
        firstNameDesLabel = new javax.swing.JLabel();
        lastNameDesLabel = new javax.swing.JLabel();
        emailDesLabel = new javax.swing.JLabel();
        uidLabel = new javax.swing.JLabel();
        roleLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        jSeparatorButtom = new javax.swing.JSeparator();
        newPasswordDesLabel = new javax.swing.JLabel();
        newPasswordTextField = new javax.swing.JPasswordField();
        confirmNewPasswordDesLabel = new javax.swing.JLabel();
        confirmNewPasswordTextField = new javax.swing.JPasswordField();
        changeButton = new javax.swing.JButton();

        basicDetailsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Basic details"));

        roleDesLabel.setText("Role:");
        roleLabel.setText(Role.toString(user.getRole()));

        uidDesLabel.setText("UID:");
        uidLabel.setText(Integer.toString(user.getUID()));

        usernameDesLabel.setText("Username:");
        usernameLabel.setText(user.getUsername());

        firstNameDesLabel.setText("First name:");
        firstNameLabel.setText(user.getFirstName());

        lastNameDesLabel.setText("Last name:");
        lastNameLabel.setText(user.getLastName());

        emailDesLabel.setText("Email:");
        emailLabel.setText(user.getEmail());

        javax.swing.GroupLayout basicDetailsPanelLayout = new javax.swing.GroupLayout(basicDetailsPanel);
        basicDetailsPanel.setLayout(basicDetailsPanelLayout);
        basicDetailsPanelLayout.setHorizontalGroup(
            basicDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(basicDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(emailDesLabel)
                    .addComponent(lastNameDesLabel)
                    .addComponent(firstNameDesLabel)
                    .addComponent(usernameDesLabel)
                    .addComponent(uidDesLabel)
                    .addComponent(roleDesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(basicDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(uidLabel)
                    .addComponent(roleLabel)
                    .addComponent(usernameLabel)
                    .addComponent(firstNameLabel)
                    .addComponent(lastNameLabel)
                    .addComponent(emailLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        basicDetailsPanelLayout.setVerticalGroup(
            basicDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(basicDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uidDesLabel)
                    .addComponent(uidLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(basicDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roleDesLabel)
                    .addComponent(roleLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(basicDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameDesLabel)
                    .addComponent(usernameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(basicDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameDesLabel)
                    .addComponent(firstNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(basicDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameDesLabel)
                    .addComponent(lastNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(basicDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailDesLabel)
                    .addComponent(emailLabel))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        newPasswordDesLabel.setText("New password:");

        confirmNewPasswordDesLabel.setText("Confirm new password:");

        changeButton.setText("Change");
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparatorButtom)
                    .addComponent(newPasswordTextField)
                    .addComponent(confirmNewPasswordTextField)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(changeButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newPasswordDesLabel)
                            .addComponent(confirmNewPasswordDesLabel))
                        .addGap(220, 220, 220))
                    .addComponent(basicDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(basicDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparatorButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(newPasswordDesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(confirmNewPasswordDesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmNewPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(changeButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	changeButtonActionPerformed();
            }
        });
    }
    
    private void changeButtonActionPerformed() {
    	JPanel self = this;
    	
    	changeButton.setEnabled(false);
    	
    	new Thread() {
    		public void run() {
    			SwingUtilities.invokeLater(new Runnable() {
    				public void run() {
    					try {
    						String password = new String(newPasswordTextField.getPassword());
    						String confirmPassword = new String(confirmNewPasswordTextField.getPassword());
    						
    						if (confirmPassword.equals(password)) {
    							if (confirmPassword.length() < 8)
    								JOptionPane.showMessageDialog(self, "The password must contains at least 8 characters.", "Error", JOptionPane.ERROR_MESSAGE);
    							else {
    								user.changePassword(confirmPassword);
    								newPasswordTextField.setText("");
    								confirmNewPasswordTextField.setText("");
    								JOptionPane.showMessageDialog(self, "Password has been changed successfully.");
    							}
    						} else {
    							JOptionPane.showMessageDialog(self, "Both passwords have to be matched.", "Error", JOptionPane.ERROR_MESSAGE);
    						}
    						
    						changeButton.setEnabled(true);
    					} catch (CmsysException e) {
    						JOptionPane.showMessageDialog(self, "Unable to change the password (" + e.getMessage() + ")", "Error", JOptionPane.ERROR_MESSAGE);
    					}
    				}
    			});
    		}
    	}.start();
    }

    private javax.swing.JPanel basicDetailsPanel;
    private javax.swing.JButton changeButton;
    private javax.swing.JLabel confirmNewPasswordDesLabel;
    private javax.swing.JPasswordField confirmNewPasswordTextField;
    private javax.swing.JLabel emailDesLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel firstNameDesLabel;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JSeparator jSeparatorButtom;
    private javax.swing.JLabel lastNameDesLabel;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JLabel newPasswordDesLabel;
    private javax.swing.JPasswordField newPasswordTextField;
    private javax.swing.JLabel roleDesLabel;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JLabel uidDesLabel;
    private javax.swing.JLabel uidLabel;
    private javax.swing.JLabel usernameDesLabel;
    private javax.swing.JLabel usernameLabel;
    private User user;
}
