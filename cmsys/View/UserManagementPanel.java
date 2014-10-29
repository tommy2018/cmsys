package cmsys.View;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import cmsys.Common.CmsysException;
import cmsys.UserManagement.Role;
import cmsys.UserManagement.User;

public class UserManagementPanel extends javax.swing.JPanel {

	private static final long serialVersionUID = 2834497746512482681L;

	public UserManagementPanel() {
		initComponents();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initComponents() {

		searchPanel = new javax.swing.JPanel();
		keywordDesLabel = new javax.swing.JLabel();
		keywordTextField = new javax.swing.JTextField();
		searchButton = new javax.swing.JButton();
		resultPanel = new javax.swing.JPanel();
		usersScrollPane = new javax.swing.JScrollPane();
		usersTable = new javax.swing.JTable();
		jSeparatorMid = new javax.swing.JSeparator();
		optionsTabbedPane = new javax.swing.JTabbedPane();
		userDetailsPanel = new javax.swing.JPanel();
		uidDesLabel = new javax.swing.JLabel();
		roleDesLabel = new javax.swing.JLabel();
		usernameDesLabel = new javax.swing.JLabel();
		firstNameDesLabel = new javax.swing.JLabel();
		lastNameDesLabel = new javax.swing.JLabel();
		emailDesLabel = new javax.swing.JLabel();
		uidLabel = new javax.swing.JLabel();
		roleLabel = new javax.swing.JLabel();
		usernameLabel = new javax.swing.JLabel();
		firstnameLabel = new javax.swing.JLabel();
		lastNameLabel = new javax.swing.JLabel();
		emailLabel = new javax.swing.JLabel();
		changePasswordPanel = new javax.swing.JPanel();
		changePasswordButton = new javax.swing.JButton();
		newPasswordDesLabel = new javax.swing.JLabel();
		confirmPasswordDesLabel = new javax.swing.JLabel();
		newPasswordTextField = new javax.swing.JPasswordField();
		confirmNewPasswordTextField = new javax.swing.JPasswordField();
		jPanel5 = new javax.swing.JPanel();
		currentRoleDesLabel = new javax.swing.JLabel();
		changeToDesLabel = new javax.swing.JLabel();
		changeToComboBox = new javax.swing.JComboBox();
		changePermissionButton = new javax.swing.JButton();
		currentRoleLabel = new javax.swing.JLabel();

		searchPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder("Search"));
		searchPanel.setName(""); // NOI18N

		keywordDesLabel.setText("Keyword:");

		searchButton.setText("Search");
		searchButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				searchButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(
				searchPanel);
		searchPanel.setLayout(searchPanelLayout);
		searchPanelLayout
				.setHorizontalGroup(searchPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								searchPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												searchPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																searchPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				keywordDesLabel)
																		.addContainerGap(
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
														.addGroup(
																searchPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				keywordTextField)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				searchButton,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				89,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))));
		searchPanelLayout
				.setVerticalGroup(searchPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								searchPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(keywordDesLabel)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												searchPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																keywordTextField,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																searchButton))
										.addContainerGap(13, Short.MAX_VALUE)));

		resultPanel.setBorder(javax.swing.BorderFactory
				.createTitledBorder("Result"));

		usersTable.setModel(new javax.swing.table.DefaultTableModel(null,
				new String[] { "UID", "Username", "Email" }));
		usersScrollPane.setViewportView(usersTable);

		uidDesLabel.setText("UID:");

		roleDesLabel.setText("Role:");

		usernameDesLabel.setText("Username:");

		firstNameDesLabel.setText("Firstname:");

		lastNameDesLabel.setText("Lastname:");

		emailDesLabel.setText("Email:");

		uidLabel.setText("---");

		roleLabel.setText("---");

		usernameLabel.setText("---");

		firstnameLabel.setText("---");

		lastNameLabel.setText("---");

		emailLabel.setText("---");

		javax.swing.GroupLayout userDetailsPanelLayout = new javax.swing.GroupLayout(
				userDetailsPanel);
		userDetailsPanel.setLayout(userDetailsPanelLayout);
		userDetailsPanelLayout
				.setHorizontalGroup(userDetailsPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								userDetailsPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												userDetailsPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																emailDesLabel)
														.addGroup(
																userDetailsPanelLayout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(
																				usernameDesLabel)
																		.addGroup(
																				userDetailsPanelLayout
																						.createSequentialGroup()
																						.addGap(39,
																								39,
																								39)
																						.addGroup(
																								userDetailsPanelLayout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING)
																										.addComponent(
																												roleDesLabel)
																										.addComponent(
																												uidDesLabel)))
																		.addComponent(
																				firstNameDesLabel,
																				javax.swing.GroupLayout.Alignment.TRAILING)
																		.addComponent(
																				lastNameDesLabel,
																				javax.swing.GroupLayout.Alignment.TRAILING)))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												userDetailsPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(uidLabel)
														.addComponent(roleLabel)
														.addComponent(
																usernameLabel)
														.addComponent(
																firstnameLabel)
														.addComponent(
																lastNameLabel)
														.addComponent(
																emailLabel))
										.addContainerGap(286, Short.MAX_VALUE)));
		userDetailsPanelLayout
				.setVerticalGroup(userDetailsPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								userDetailsPanelLayout
										.createSequentialGroup()
										.addGap(41, 41, 41)
										.addGroup(
												userDetailsPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																uidDesLabel)
														.addComponent(uidLabel))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												userDetailsPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																roleDesLabel)
														.addComponent(roleLabel))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												userDetailsPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																usernameDesLabel)
														.addComponent(
																usernameLabel))
										.addGap(12, 12, 12)
										.addGroup(
												userDetailsPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																firstNameDesLabel)
														.addComponent(
																firstnameLabel))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												userDetailsPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																lastNameDesLabel)
														.addComponent(
																lastNameLabel))
										.addGap(12, 12, 12)
										.addGroup(
												userDetailsPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																emailDesLabel)
														.addComponent(
																emailLabel))
										.addContainerGap(20, Short.MAX_VALUE)));

		optionsTabbedPane.addTab("User details", userDetailsPanel);

		changePasswordButton.setText("Change");
		changePasswordButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						changePasswordButtonActionPerformed(evt);
					}
				});

		newPasswordDesLabel.setText("New password:");

		confirmPasswordDesLabel.setText("Confirm password:");

		javax.swing.GroupLayout changePasswordPanelLayout = new javax.swing.GroupLayout(
				changePasswordPanel);
		changePasswordPanel.setLayout(changePasswordPanelLayout);
		changePasswordPanelLayout
				.setHorizontalGroup(changePasswordPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								changePasswordPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												changePasswordPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																confirmPasswordDesLabel)
														.addComponent(
																newPasswordDesLabel))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												changePasswordPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																newPasswordTextField)
														.addComponent(
																confirmNewPasswordTextField,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																218,
																Short.MAX_VALUE))
										.addContainerGap(43, Short.MAX_VALUE))
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								changePasswordPanelLayout
										.createSequentialGroup()
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(
												changePasswordButton,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												82,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));
		changePasswordPanelLayout
				.setVerticalGroup(changePasswordPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								changePasswordPanelLayout
										.createSequentialGroup()
										.addGap(69, 69, 69)
										.addGroup(
												changePasswordPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																newPasswordDesLabel)
														.addComponent(
																newPasswordTextField,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												changePasswordPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																confirmPasswordDesLabel)
														.addComponent(
																confirmNewPasswordTextField,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(changePasswordButton)
										.addContainerGap(33, Short.MAX_VALUE)));

		optionsTabbedPane.addTab("Change password", changePasswordPanel);

		currentRoleDesLabel.setText("Current role:");

		changeToDesLabel.setText("Change to:");

		changeToComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "Administrator", "Normal user", "Author",
						"PC member", "PC chair" }));

		changePermissionButton.setText("Change");
		changePermissionButton
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						changePermissionButtonActionPerformed(evt);
					}
				});

		currentRoleLabel.setText("---");

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
				jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout
				.setHorizontalGroup(jPanel5Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel5Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel5Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel5Layout
																		.createSequentialGroup()
																		.addComponent(
																				currentRoleDesLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				currentRoleLabel)
																		.addGap(0,
																				0,
																				Short.MAX_VALUE))
														.addGroup(
																jPanel5Layout
																		.createSequentialGroup()
																		.addComponent(
																				changeToDesLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				changeToComboBox,
																				0,
																				306,
																				Short.MAX_VALUE))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel5Layout
																		.createSequentialGroup()
																		.addGap(0,
																				0,
																				Short.MAX_VALUE)
																		.addComponent(
																				changePermissionButton)))
										.addContainerGap()));
		jPanel5Layout
				.setVerticalGroup(jPanel5Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel5Layout
										.createSequentialGroup()
										.addGap(57, 57, 57)
										.addGroup(
												jPanel5Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																currentRoleDesLabel)
														.addComponent(
																currentRoleLabel,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																16,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel5Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																changeToDesLabel)
														.addComponent(
																changeToComboBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(changePermissionButton)
										.addContainerGap(58, Short.MAX_VALUE)));

		optionsTabbedPane.addTab("Edit permission", jPanel5);

		javax.swing.GroupLayout resultPanelLayout = new javax.swing.GroupLayout(
				resultPanel);
		resultPanel.setLayout(resultPanelLayout);
		resultPanelLayout
				.setHorizontalGroup(resultPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								resultPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												resultPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																optionsTabbedPane)
														.addComponent(
																usersScrollPane,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																0,
																Short.MAX_VALUE)
														.addComponent(
																jSeparatorMid,
																javax.swing.GroupLayout.Alignment.LEADING))
										.addContainerGap()));
		resultPanelLayout
				.setVerticalGroup(resultPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								resultPanelLayout
										.createSequentialGroup()
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(
												usersScrollPane,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												166,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												jSeparatorMid,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												10,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												optionsTabbedPane,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												263,
												javax.swing.GroupLayout.PREFERRED_SIZE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														searchPanel,
														javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														resultPanel,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
								.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(searchPanel,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(33, 33, 33)
						.addComponent(resultPanel,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		usersTable.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent evt) {
						tableAction();
					}
				});
	}// </editor-fold>//GEN-END:initComponents

	private void tableAction() {
		if (usersTable.getSelectedRow() == -1) {
			return;
		}
		int selectedRow = usersTable.convertRowIndexToModel(usersTable
				.getSelectedRow());
		int uid = (int) (usersTable.getModel().getValueAt(selectedRow, 0));
		Component me = this;
		Dialog dialog = new Dialog(this, "Getting information...");

		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			protected Void doInBackground() {
				try {
					User user = User.getUserByUid(uid);
					uidLabel.setText(user.getUID() + "");
					roleLabel.setText(Role.toString((user.getRole())));
					usernameLabel.setText(user.getUsername());
					firstnameLabel.setText(user.getFirstName());
					lastNameLabel.setText(user.getLastName());
					emailLabel.setText(user.getEmail());
					currentRoleLabel.setText(Role.toString((user.getRole())));
					dialog.close();

				} catch (CmsysException e) {
					dialog.close();
					MessageBox.error("Unable to get the information needed.",
							me);
				}
				return null;
			}
		};

		worker.execute();
		dialog.show();
	}

	private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
		String searchString = keywordTextField.getText();
		Dialog dialog = new Dialog(this, "Searching...");

		Component me = this;

		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			protected Void doInBackground() {
				try {
					ArrayList<User> userList = User
							.searchUserByUsername(searchString);
					Object[][] userObj = new Object[userList.size()][3];

					for (int i = 0; i < userList.size(); i++) {
						userObj[i][0] = userList.get(i).getUID();
						userObj[i][1] = userList.get(i).getUsername();
						userObj[i][2] = userList.get(i).getEmail();
					}

					model = (new javax.swing.table.DefaultTableModel(userObj,
							new String[] { "UID", "Username", "Email" }) {
						private static final long serialVersionUID = -7209111222272950827L;

						public boolean isCellEditable(int row, int column) {
							return false;
						}
					});

					usersTable.setModel(model);

					dialog.close();
				} catch (CmsysException e) {
					dialog.close();
					MessageBox.error(
							"Unable to preform the action at the moment.", me);
				}
				return null;
			}
		};

		worker.execute();
		dialog.show();
	}

	private void changePasswordButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		int selectedRow = usersTable.convertRowIndexToModel(usersTable
				.getSelectedRow());
		int uid = (int) (usersTable.getModel().getValueAt(selectedRow, 0));
		JPanel self = this;

		try {
			User user;

			user = User.getUserByUid(uid);

			changePasswordButton.setEnabled(false);

			new Thread() {
				public void run() {
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							try {
								String password = new String(
										newPasswordTextField.getPassword());
								String confirmPassword = new String(
										confirmNewPasswordTextField
												.getPassword());

								if (confirmPassword.equals(password)) {
									if (confirmPassword.length() < 8)
										JOptionPane
												.showMessageDialog(
														self,
														"The password must contains at least 8 characters.",
														"Error",
														JOptionPane.ERROR_MESSAGE);
									else {
										user.changePassword(confirmPassword);
										newPasswordTextField.setText("");
										confirmNewPasswordTextField.setText("");
										JOptionPane
												.showMessageDialog(self,
														"Password has been changed successfully.");
									}
								} else {
									JOptionPane
											.showMessageDialog(
													self,
													"Both passwords have to be matched.",
													"Error",
													JOptionPane.ERROR_MESSAGE);
								}

								changePasswordButton.setEnabled(true);
							} catch (CmsysException e) {
								JOptionPane.showMessageDialog(
										self,
										"Unable to change the password ("
												+ e.getMessage() + ")",
										"Error", JOptionPane.ERROR_MESSAGE);
							}
						}
					});
				}
			}.start();
		} catch (CmsysException e1) {
			e1.printStackTrace();
		}
	}

	private void changePermissionButtonActionPerformed(
			java.awt.event.ActionEvent evt) {
		int selectedRow = usersTable.convertRowIndexToModel(usersTable
				.getSelectedRow());
		int uid = (int) (usersTable.getModel().getValueAt(selectedRow, 0));

		try {
			User user = User.getUserByUid(uid);
			user.changeRole(changeToComboBox.getSelectedIndex());
			user = User.getUserByUid(uid);
			currentRoleLabel.setText(Role.toString((user.getRole())));
			uidLabel.setText(user.getUID() + "");
			roleLabel.setText(Role.toString((user.getRole())));
			usernameLabel.setText(user.getUsername());
			firstnameLabel.setText(user.getFirstName());
			lastNameLabel.setText(user.getLastName());
			emailLabel.setText(user.getEmail());
			currentRoleLabel.setText(Role.toString((user.getRole())));
			MessageBox.error("Changed.", this);
		} catch (CmsysException e) {
			MessageBox.error("Unable to preform the action at the moment.",
					this);
		}
	}

	private javax.swing.table.DefaultTableModel model;

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton changePasswordButton;
	private javax.swing.JPanel changePasswordPanel;
	private javax.swing.JButton changePermissionButton;
	@SuppressWarnings("rawtypes")
	private javax.swing.JComboBox changeToComboBox;
	private javax.swing.JLabel changeToDesLabel;
	private javax.swing.JPasswordField confirmNewPasswordTextField;
	private javax.swing.JLabel confirmPasswordDesLabel;
	private javax.swing.JLabel currentRoleDesLabel;
	private javax.swing.JLabel currentRoleLabel;
	private javax.swing.JLabel emailDesLabel;
	private javax.swing.JLabel emailLabel;
	private javax.swing.JLabel firstNameDesLabel;
	private javax.swing.JLabel firstnameLabel;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JSeparator jSeparatorMid;
	private javax.swing.JLabel keywordDesLabel;
	private javax.swing.JTextField keywordTextField;
	private javax.swing.JLabel lastNameDesLabel;
	private javax.swing.JLabel lastNameLabel;
	private javax.swing.JLabel newPasswordDesLabel;
	private javax.swing.JPasswordField newPasswordTextField;
	private javax.swing.JTabbedPane optionsTabbedPane;
	private javax.swing.JPanel resultPanel;
	private javax.swing.JLabel roleDesLabel;
	private javax.swing.JLabel roleLabel;
	private javax.swing.JButton searchButton;
	private javax.swing.JPanel searchPanel;
	private javax.swing.JLabel uidDesLabel;
	private javax.swing.JLabel uidLabel;
	private javax.swing.JPanel userDetailsPanel;
	private javax.swing.JLabel usernameDesLabel;
	private javax.swing.JLabel usernameLabel;
	private javax.swing.JScrollPane usersScrollPane;
	private javax.swing.JTable usersTable;
	// End of variables declaration//GEN-END:variables
}
