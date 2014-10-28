package cmsys.View;


import java.awt.Component;
import java.util.ArrayList;

import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import cmsys.Common.CmsysException;
import cmsys.Common.CronJob;
import cmsys.Common.Settings;
import cmsys.Common.Time;
import cmsys.Common.UserDefault;
import cmsys.PaperManagement.Paper;
import cmsys.PaperManagement.Review;
import cmsys.PaperManagement.Status;
import cmsys.UserManagement.User;

public class PapersPanel extends javax.swing.JPanel {

	private static final long serialVersionUID = -457958327717370557L;
	public PapersPanel() {
    	UserDefault userDefault = UserDefault.getInstance();
    	
    	user = (User)userDefault.getObj("user");
        initComponents();
    }

    private void initComponents() {

        papersScrollPane = new javax.swing.JScrollPane();
        papersTable = new javax.swing.JTable();
        viewPaperDetailsButton = new javax.swing.JButton();
        acceptButton = new javax.swing.JButton();
        declineButton = new javax.swing.JButton();
        filterComboBox = new javax.swing.JComboBox();
        filterDesLabel = new javax.swing.JLabel();
        jSeparatorMid = new javax.swing.JSeparator();
        refreshButton = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();
        jSeparatorTop = new javax.swing.JSeparator();

        papersScrollPane.setViewportView(papersTable);

        viewPaperDetailsButton.setText("View paper details (inc. Reviews)");
        viewPaperDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPaperDetailsButtonActionPerformed(evt);
            }
        });

        acceptButton.setText("Accept this paper");
        acceptButton.setEnabled(false);
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        declineButton.setText("Decline this paper");
        declineButton.setEnabled(false);
        declineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                declineButtonActionPerformed(evt);
            }
        });

        filterComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Submitted", "Revewing", "Reviewed", "Awaiting response", "Awaiting final version submission", "Accepted", "Rejected" }));

        filterDesLabel.setText("Filter:");

        refreshButton.setText("Refresh");
        refreshButton.setToolTipText("");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        statusLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusLabel.setText("");
        
        papersTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        
        try {
			updateTable();
		} catch (CmsysException e) {}

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(papersScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jSeparatorMid)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(viewPaperDetailsButton)
                            .addComponent(refreshButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(acceptButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(declineButton)))
                        .addGap(0, 111, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(filterDesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparatorTop))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparatorTop, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterDesLabel))
                .addGap(5, 5, 5)
                .addComponent(jSeparatorMid, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(papersScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(viewPaperDetailsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(declineButton)
                    .addComponent(acceptButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        viewPaperDetailsButton.setEnabled(false);
        
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
					acceptButton.setEnabled(false);
			        viewPaperDetailsButton.setEnabled(false);
			        declineButton.setEnabled(false);
			        return;
				}
				
		        viewPaperDetailsButton.setEnabled(false);
		        
		        int selectedRow = papersTable.convertRowIndexToModel(papersTable.getSelectedRow());
		        int status = Status.toInt((String)(papersTable.getModel().getValueAt(selectedRow, 2)));
		        switch (status) {
		        	case 2:
		        	case 3:
		        	case 4:
		        		viewPaperDetailsButton.setEnabled(true);
		        		break;
					case 6:
						acceptButton.setEnabled(true);
						declineButton.setEnabled(true);
						viewPaperDetailsButton.setEnabled(true);
						break;
				}
				
				viewPaperDetailsButton.setEnabled(true);
			}
        });
    }

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	refreshTable();
    }

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	int selectedRow = papersTable.convertRowIndexToModel(papersTable.getSelectedRow());
        int pid = (int)(papersTable.getModel().getValueAt(selectedRow, 0));
        Component me = this;
        Dialog dialog = new Dialog(this, "Applying...");
        
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			protected Void doInBackground() {
				try {
					Paper paper = null;
					paper = Paper.getPaperByPid(pid);
					Paper.accept(paper.getPid());
					dialog.close();
					MessageBox.information("Paper accepted.", me);
				} catch (CmsysException e) {
					dialog.close();
					MessageBox.error("Unable to perform this action.", me);
				}
				return null;
			}
			
			protected void done() {
				refreshTable();
			}
    	};
    	
    	worker.execute();
    	dialog.show();
    }

    private void declineButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	int selectedRow = papersTable.convertRowIndexToModel(papersTable.getSelectedRow());
        int pid = (int)(papersTable.getModel().getValueAt(selectedRow, 0));
        Component me = this;
        Dialog dialog = new Dialog(this, "Applying...");
        
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			protected Void doInBackground() {
				try {
					Paper paper = null;
					paper = Paper.getPaperByPid(pid);
					Paper.decline(paper.getPid());
					dialog.close();
					MessageBox.information("Paper accepted.", me);
				} catch (CmsysException e) {
					dialog.close();
					MessageBox.error("Unable to perform this action.", me);
				}
				return null;
			}
			
			protected void done() {
				refreshTable();
			}
    	};
    	
    	worker.execute();
    	dialog.show();
    }

    private void viewPaperDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	int selectedRow = papersTable.convertRowIndexToModel(papersTable.getSelectedRow());
        int pid = (int)(papersTable.getModel().getValueAt(selectedRow, 0));
        Component me = this;
        Dialog dialog = new Dialog(this, "Getting information...");
        
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			private Paper paper = null;
			ArrayList<Review> reviewList = null;
			boolean success = false;
			
			protected Void doInBackground() {
				try {
					reviewList = new ArrayList<Review>();
					paper = Paper.getPaperByPid(pid);
					reviewList = Review.getReviewListByPid(paper.getPid());
					success = true;
					dialog.close();
				} catch (CmsysException e) {
					dialog.close();
					MessageBox.error("Unable to get the information needed.", me);
				}
				return null;
			}
			
			protected void done() {
				if (success) {
					Dialog viewReviewDialog = new Dialog(me, new ViewResponsePanel(paper, reviewList), "View response", 0);
					viewReviewDialog.show();
				}
			}
    	};
    	
    	worker.execute();
    	dialog.show();
    }


    private void updateTable() throws CmsysException {
    	CronJob.updateSystemStatus();
    	int status = Integer.parseInt(Settings.getSettingFromDB("status"));
    	
    	if (status == 0) {
    		statusLabel.setText("Status: Accepting submission");
    	} else if (status == 1) {
    		statusLabel.setText("Status: Awaiting PC Members' preferences");
    	} else if (status == 2) {
    		MessageBox.warning("System status changed, restart required.", this);
    		System.exit(0);
    	} else if (status == 6) {
    		statusLabel.setText("Status: Finalised");
    	} else {
    		statusLabel.setText("Status: Normal");
    	}
    	
    	Object[][] paperObj = null;
    	ArrayList<Paper> paperList = Paper.getPaperList();
    	
    	paperObj = new Object[paperList.size()][4];
    	
    	for (int i = 0; i < paperList.size(); i++) {
    		paperObj[i][0] = paperList.get(i).getPid();
    		paperObj[i][1] = paperList.get(i).getTitle();
    		paperObj[i][2] = Status.toString(paperList.get(i).getStatus(), user.getRole());
    	}
    	
    	model = (new javax.swing.table.DefaultTableModel(paperObj, new String [] {"PID", "Title", "Status"}) {
    				private static final long serialVersionUID = -7209182822222950827L;
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    private javax.swing.JButton declineButton;
    private javax.swing.JComboBox filterComboBox;
    private javax.swing.JLabel filterDesLabel;
    private javax.swing.JSeparator jSeparatorMid;
    private javax.swing.JSeparator jSeparatorTop;
    private javax.swing.JScrollPane papersScrollPane;
    private javax.swing.JTable papersTable;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton viewPaperDetailsButton;
    private javax.swing.JLabel statusLabel;
    private User user;
    private DefaultTableModel model;
    // End of variables declaration//GEN-END:variables
}
