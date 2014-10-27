package cmsys.View;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import cmsys.Common.CmsysException;
import cmsys.Common.Settings;
import cmsys.Common.Time;
import cmsys.Common.UserDefault;
import cmsys.PaperManagement.Paper;
import cmsys.PaperManagement.Status;
import cmsys.UserManagement.User;

public class MyPapersPanel extends javax.swing.JPanel {

	private static final long serialVersionUID = 3698906451461146631L;
	
    public MyPapersPanel() {
    	UserDefault userDefault = UserDefault.getInstance();
    	
    	user = (User)userDefault.getObj("user");
        initComponents();
    }

    private void initComponents() {

        submissionDeadlineLabel = new javax.swing.JLabel();
        jSeparatorTop = new javax.swing.JSeparator();
        filterDesLabel = new javax.swing.JLabel();
        filterComboBox = new javax.swing.JComboBox();
        jSeparatorMid = new javax.swing.JSeparator();
        submitButton = new javax.swing.JButton();
        papersScrollPane = new javax.swing.JScrollPane();
        papersTable = new javax.swing.JTable();
        responseButton = new javax.swing.JButton();
        submitFinalVersionButton = new javax.swing.JButton();
        viewPaperDetailsButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();

        submissionDeadlineLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        submissionDeadlineLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        submissionDeadlineLabel.setText("");

        filterDesLabel.setText("Filter:");

        filterComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Submitted", "Revewing", "Reviewed", "Awaiting response", "Awaiting final version submission", "Accepted", "Rejected" }));
        
        submitButton.setText("+ Paper");
        submitButton.setToolTipText("");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        
        papersTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        
        papersScrollPane.setViewportView(papersTable);

        responseButton.setText("Response to the reviews");
        responseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                responseButtonActionPerformed(evt);
            }
        });

        submitFinalVersionButton.setText("Submit final version");
        submitFinalVersionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitFinalVersionButtonActionPerformed(evt);
            }
        });

        viewPaperDetailsButton.setText("View paper details");
        viewPaperDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPaperDetailsButtonActionPerformed(evt);
            }
        });

        refreshButton.setText("Refresh");
        refreshButton.setToolTipText("");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(filterDesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(papersScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jSeparatorMid)
                            .addComponent(submissionDeadlineLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparatorTop))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(responseButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submitFinalVersionButton)
                        .addContainerGap(65, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(submitButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(refreshButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(viewPaperDetailsButton)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(submissionDeadlineLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparatorTop, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterDesLabel)
                    .addComponent(filterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparatorMid, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(refreshButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(papersScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viewPaperDetailsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(responseButton)
                    .addComponent(submitFinalVersionButton))
                .addGap(24, 24, 24))
        );
        
        try {
			updateTable();
		} catch (CmsysException e) {}
        
        submitFinalVersionButton.setEnabled(false);
        viewPaperDetailsButton.setEnabled(false);
        responseButton.setEnabled(false);
        
        filterComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	RowFilter<Object, Object> filter = new RowFilter<Object, Object>() {
            			public boolean include(Entry entry) {
            				String status = (String)entry.getValue(2);
            				if (((String)(filterComboBox.getSelectedItem())).equals("All"))
            					return true;
            				return ((String)(filterComboBox.getSelectedItem())).equals(status);
            			}
            	};
            	
            	TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
            	sorter.setRowFilter(filter);
            	papersTable.setRowSorter(sorter);
            }
        });
        
        papersTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {
				if (papersTable.getSelectedRow() == -1) {
	            	submitFinalVersionButton.setEnabled(false);
			        viewPaperDetailsButton.setEnabled(false);
			        responseButton.setEnabled(false);
			        return;
				}
				
				submitFinalVersionButton.setEnabled(false);
		        viewPaperDetailsButton.setEnabled(false);
		        responseButton.setEnabled(false);
		        
		        int selectedRow = papersTable.convertRowIndexToModel(papersTable.getSelectedRow());
		        int status = Status.toInt((String)(papersTable.getModel().getValueAt(selectedRow, 2)));
		        switch (status) {
					case 1:
						responseButton.setEnabled(true);
						break;
					case 2:
						submitFinalVersionButton.setEnabled(true);
						break;
				}
				
				viewPaperDetailsButton.setEnabled(true);
			}
        });
    }

    private void viewPaperDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {
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
					Dialog dialog = new Dialog(me, new ShowPaperDetailsAuthorPanel(paper), "View paper", 0);
					dialog.show();
				}
			}
    	};
    	
    	worker.execute();
    	dialog.show();
    }

    private void responseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_responseButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_responseButtonActionPerformed

    private void submitFinalVersionButtonActionPerformed(java.awt.event.ActionEvent evt) {
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
					submitFinalVersionDialog = new Dialog(me, new FinalSubmitPanel(me, paper), "Submit final version");
					submitFinalVersionDialog.show();
				}
			}
    	};
    	
    	worker.execute();
    	dialog.show();
    }

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	try {
			if (Time.timestamp() > Long.parseLong(Settings.getSettingFromDB("submissionDeadline"))) {
				submitButton.setEnabled(false);
				MessageBox.error("The submission date has already passed.", this);
				return;
			}
		} catch (Exception e) {
			return;
		}
    	submitDialog = new Dialog(this, new SubmitPanel(this), "New submission");
    	submitDialog.show();
    }

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	refreshTable();
    }
    
    private void updateTable() throws CmsysException {
    	if (Integer.parseInt(Settings.getSettingFromDB("status")) != 0) {
    		submissionDeadlineLabel.setText("Submission date has already passed");
    		submissionDeadlineLabel.setForeground(Color.red);
    		submitButton.setEnabled(false);
    	} else if (Time.timestamp() > Long.parseLong(Settings.getSettingFromDB("submissionDeadline"))) {
    		submissionDeadlineLabel.setText("Submission date has already passed");
    		submissionDeadlineLabel.setForeground(Color.red);
    		submitButton.setEnabled(false);
    		Settings.updateSetting("status", "1");
    	} else {
    		submitButton.setEnabled(true);
    		submissionDeadlineLabel.setForeground(Color.black);
    		submissionDeadlineLabel.setText("Submission deadline: " + Time.toDate(Long.parseLong(Settings.getSettingFromDB("submissionDeadline"))));
    	}
    	
    	Object[][] paperObj = null;
    	ArrayList<Paper> paperList = Paper.getPaperListByUid(user.getUID());
    	
    	paperObj = new Object[paperList.size()][3];
    	
    	for (int i = 0; i < paperList.size(); i++) {
    		paperObj[i][0] = paperList.get(i).getPid();
    		paperObj[i][1] = paperList.get(i).getTitle();
    		paperObj[i][2] = Status.toString(paperList.get(i).getStatus(), user.getRole());
    	}
    	
    	model = (new javax.swing.table.DefaultTableModel(paperObj, new String [] {"PID", "Title", "Status"}) {
    				private static final long serialVersionUID = -7209182869872950827L;
    				public boolean isCellEditable(int row, int column) {return false;}
    			});

    	papersTable.setModel(model);
    }
    
    private void refreshTable() {
    	Dialog dialog = new Dialog(this, "Refreshing the list...");
    	Component me = this;
    	
    	SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			protected Void doInBackground() {
				try {
					updateTable();
					dialog.close();
				} catch (CmsysException e) {
					dialog.close();
					MessageBox.error("Unable to update the list at the moment.", me);
				}
				return null;
			}
			
			protected void done() {
				RowFilter<Object, Object> filter = new RowFilter<Object, Object>() {
					public boolean include(Entry entry) {
						String status = (String)entry.getValue(2);
						if (((String)(filterComboBox.getSelectedItem())).equals("All"))
							return true;
						return ((String)(filterComboBox.getSelectedItem())).equals(status);
					}
		    	};
			
		    	TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
		    	sorter.setRowFilter(filter);
		    	papersTable.setRowSorter(sorter);
			}
    	};
    	
    	worker.execute();
    	dialog.show();
    }
    
    public void closeSubmitDialog(boolean refresh) {
    	if (submitDialog != null)
    		submitDialog.close();
    	if (refresh)
    		refreshTable();
    }

    public void closeSubmitFinalVersionDialog(boolean refresh) {
    	if (submitFinalVersionDialog != null)
    		submitFinalVersionDialog.close();
    	if (refresh)
    		refreshTable();
    }

    private javax.swing.JComboBox filterComboBox;
    private javax.swing.JLabel filterDesLabel;
    private javax.swing.JSeparator jSeparatorMid;
    private javax.swing.JSeparator jSeparatorTop;
    private javax.swing.JScrollPane papersScrollPane;
    private javax.swing.JTable papersTable;
    private javax.swing.JButton responseButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JLabel submissionDeadlineLabel;
    private javax.swing.JButton submitFinalVersionButton;
    private javax.swing.JButton viewPaperDetailsButton;
    private Dialog submitDialog, submitFinalVersionDialog;
    private javax.swing.table.DefaultTableModel model;
    private User user;
}