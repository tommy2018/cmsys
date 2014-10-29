package cmsys.View;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.ListSelectionModel;
import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;

import cmsys.Common.CmsysException;
import cmsys.Common.CronJob;
import cmsys.Common.Settings;
import cmsys.Common.Time;
import cmsys.Common.UserDefault;
import cmsys.PaperManagement.Check;
import cmsys.PaperManagement.Paper;
import cmsys.PaperManagement.Preference;
import cmsys.UserManagement.User;

public class PcMemberReviewPreferencePanel extends javax.swing.JPanel {

	private static final long serialVersionUID = -3580560729592360167L;
	public PcMemberReviewPreferencePanel() {
    	UserDefault userDefault = UserDefault.getInstance();
    	
    	user = (User)userDefault.getObj("user");
        initComponents();
    }

    private void initComponents() {

        papersScrollPane = new javax.swing.JScrollPane();
        papersTable = new javax.swing.JTable();
        showDetailsButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        descriptionLabel = new javax.swing.JLabel();
        deadlineLabel = new javax.swing.JLabel();
        jSeparatorTop = new javax.swing.JSeparator();
        
        papersScrollPane.setViewportView(papersTable);

        showDetailsButton.setText("Show details of the selected paper");
        showDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	showDetailsButtonActionPerformed(evt);
            }
        });

        submitButton.setText("Submit all decisions");
        submitButton.setToolTipText("");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	submitButtonActionPerformed(evt);
            }
        });

        descriptionLabel.setText("<html>Please make your decision for each paper.<br><b>Caution: You only have one chance!</b></html>");

        deadlineLabel.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        deadlineLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deadlineLabel.setText("Deadline:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deadlineLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(papersScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                    .addComponent(jSeparatorTop)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(submitButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showDetailsButton))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(deadlineLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparatorTop, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showDetailsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(papersScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(submitButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        showDetailsButton.setEnabled(false);
        
        try {
			updateTable();
		} catch (CmsysException e) {}
        
        papersTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        papersTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {
				if (papersTable.getSelectedRow() == -1) {
					showDetailsButton.setEnabled(false);
			        return;
				}
				
				showDetailsButton.setEnabled(true);
			}
        });
    }
    
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	try {
    		boolean made = Preference.hasMadePreference(user.getUID());
    		
    		if (made) {
    			MessageBox.error("You have already made your decision.", this);
    			submitButton.setEnabled(false);
    			updateTable();
    			return;
    		}
    		
    		CronJob.updateSystemStatus();
    		
    		if (Integer.parseInt(Settings.getSettingFromDB("status")) != 1) {
    			MessageBox.error("Submission date expired", this);
    			submitButton.setEnabled(false);
    			updateTable();
    			return;
        	}
		} catch (Exception e) {}
    	
    	Component me = this;
        Dialog dialog = new Dialog(this, "Applying changes...");
        
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			protected Void doInBackground() {
				try {
					ArrayList<Preference> preferenceList = new ArrayList<Preference>();
					
					for(int i = 0; i < papersTable.getRowCount(); i++) {
						String temp = (String)(papersTable.getValueAt(i, 2));
						Preference preference = new Preference();
						
						preference.setPid((int)(papersTable.getValueAt(i, 0)));
						preference.setUid(user.getUID());
						
						if (temp.equals("Maybe"))
							preference.setPreference(0);
						else if (temp.equals("Yes"))
							preference.setPreference(2);
						else if (temp.equals("Confit of interest"))
							preference.setPreference(3);
						else
							preference.setPreference(1);
						
						preferenceList.add(preference);
					}
					
					Preference.setPreference(preferenceList);
					updateTable();
					dialog.close();
					submitButton.setEnabled(false);
					MessageBox.information("Done.", me);
					
				} catch (CmsysException e) {
					dialog.close();
					MessageBox.error("Unable to apply the changes.", me);
				}
				return null;
			}
    	};
    	
    	worker.execute();
    	dialog.show();
    }
    
    private void showDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	int selectedRow = papersTable.convertRowIndexToModel(papersTable.getSelectedRow());
        int pid = (int)(papersTable.getModel().getValueAt(selectedRow, 0));
        Component me = this;
        Dialog dialog = new Dialog(this, "Getting information...");
        
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			private Paper paper = null;
			
			protected Void doInBackground() {
				try {
					paper = Paper.getPaperByPid(pid);
					dialog.close();
					
				} catch (CmsysException e) {
					dialog.close();
					MessageBox.error("Unable to get the information needed.", me);
				}
				return null;
			}
			
			protected void done() {
				if (paper != null) {
					Dialog dialog = new Dialog(me, new ShowPaperDetailsPanel(paper), "View paper", 0);
					dialog.show();
				}
			}
    	};
    	
    	worker.execute();
    	dialog.show();
    }
    
    private void updateTable() throws CmsysException {
    	CronJob.updateSystemStatus();
    	int status = Integer.parseInt(Settings.getSettingFromDB("status"));
    	
    	if (status != 1) {
    		deadlineLabel.setText("Submission date has already passed");
    		deadlineLabel.setForeground(Color.red);
    		submitButton.setEnabled(false);
    		MessageBox.warning("System status changed, restart required", this);
    		System.exit(0);
    	} else {
    		submitButton.setEnabled(true);
    		deadlineLabel.setForeground(Color.black);
    		deadlineLabel.setText("Submission deadline: " + Time.toDate(Long.parseLong(Settings.getSettingFromDB("preferenceDeadline"))));
    	}
    	
    	
    	ArrayList<Paper> paperList = Paper.getPaperList();
    	Object[][] paperObj = new Object[paperList.size()][3];
    	
    	for (int i = 0; i < paperList.size(); i++) {
    		paperObj[i][0] = paperList.get(i).getPid();
    		paperObj[i][1] = paperList.get(i).getTitle();
    		if (Check.isCOI(paperList.get(i), user))
    			paperObj[i][2] = "Confit of interest";
    		else
    			paperObj[i][2] = "Maybe";
    	}
    	
    	model = (new javax.swing.table.DefaultTableModel(paperObj, new String [] {"PID", "Title", "Preference"}) {
					private static final long serialVersionUID = -7209182869872950827L;
					public boolean isCellEditable(int row, int column) {
						if (column == 2 && !((String)paperObj[row][column]).equals("Confit of interest"))
							return true;
						else
							return false;
					}
				});
    	
    	papersTable.setModel(model);
    	
    	javax.swing.JComboBox<String> decisionComboBox = new javax.swing.JComboBox<String>();
    	decisionComboBox.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "Yes", "No", "Maybe" }));
    	TableColumn preferenceColumn = papersTable.getColumnModel().getColumn(2);
    	preferenceColumn.setCellEditor(new DefaultCellEditor(decisionComboBox));
    	
    	if (status != 1 || Preference.hasMadePreference(user.getUID())) {
    		papersTable.removeColumn(preferenceColumn);
    		papersTable.setEnabled(false);
    	}
    }

    private javax.swing.JLabel deadlineLabel;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JSeparator jSeparatorTop;
    private javax.swing.JScrollPane papersScrollPane;
    private javax.swing.JTable papersTable;
    private javax.swing.JButton showDetailsButton;
    private javax.swing.JButton submitButton;
    private javax.swing.table.DefaultTableModel model;
    private User user;
}
