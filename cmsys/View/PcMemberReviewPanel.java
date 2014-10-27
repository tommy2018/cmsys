package cmsys.View;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.RowFilter;
import javax.swing.SwingWorker;
import javax.swing.RowFilter.Entry;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import cmsys.Common.CmsysException;
import cmsys.Common.UserDefault;
import cmsys.PaperManagement.Paper;
import cmsys.PaperManagement.Status;
import cmsys.UserManagement.User;

public class PcMemberReviewPanel extends javax.swing.JPanel {

    public PcMemberReviewPanel() {
    	UserDefault userDefault = UserDefault.getInstance();
    	
    	user = (User)userDefault.getObj("user");
        initComponents();
    }

    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        papersDesLabel = new javax.swing.JLabel();
        papersScrollPane = new javax.swing.JScrollPane();
        papersTable = new javax.swing.JTable();
        reviewOptionsPanel = new javax.swing.JPanel();
        reviewButton = new javax.swing.JButton();
        abstractScrollPane = new javax.swing.JScrollPane();
        abstractTextArea = new javax.swing.JTextArea();
        abstractDesLabel = new javax.swing.JLabel();
        titleDesLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();
        numPapersLabel = new javax.swing.JLabel();
        jSeparatorTop = new javax.swing.JSeparator();

        papersDesLabel.setText("Papers to be reviewed:");

        papersScrollPane.setViewportView(papersTable);

        reviewOptionsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Review options"));
        reviewOptionsPanel.setToolTipText("");

        reviewButton.setText("Review this paper");
        reviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewButtonActionPerformed(evt);
            }
        });

        abstractTextArea.setColumns(20);
        abstractTextArea.setRows(5);
        abstractScrollPane.setViewportView(abstractTextArea);

        abstractDesLabel.setText("Abstract:");

        titleDesLabel.setText("Title:");

        javax.swing.GroupLayout reviewOptionsPanelLayout = new javax.swing.GroupLayout(reviewOptionsPanel);
        reviewOptionsPanel.setLayout(reviewOptionsPanelLayout);
        reviewOptionsPanelLayout.setHorizontalGroup(
            reviewOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reviewOptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(reviewOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(abstractScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                    .addGroup(reviewOptionsPanelLayout.createSequentialGroup()
                        .addGroup(reviewOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(reviewButton)
                            .addGroup(reviewOptionsPanelLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(titleDesLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(titleLabel))
                            .addComponent(abstractDesLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        reviewOptionsPanelLayout.setVerticalGroup(
            reviewOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reviewOptionsPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(reviewOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel)
                    .addComponent(titleDesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(abstractDesLabel)
                .addGap(18, 18, 18)
                .addComponent(abstractScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reviewButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        refreshButton.setText("Refresh");
        refreshButton.setToolTipText("");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(papersScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(papersDesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshButton))
                    .addComponent(reviewOptionsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(papersDesLabel)
                    .addComponent(refreshButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(papersScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reviewOptionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        numPapersLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        numPapersLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numPapersLabel.setText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numPapersLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparatorTop))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(numPapersLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparatorTop, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        try {
			updateTable();
		} catch (CmsysException e) {}
        
        reviewButton.setEnabled(false);
        abstractTextArea.setEditable(false);
        
        papersTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {
				papersTableActionPerformed();
			}
        });
    }
    
    private void papersTableActionPerformed() {
    	if (papersTable.getSelectedRow() == -1) {
			reviewButton.setEnabled(false);
			abstractTextArea.setText("");
			titleLabel.setText("");
	        return;
		}
    	
    	reviewButton.setEnabled(false);
		abstractTextArea.setText("");
		titleLabel.setText("");
		
		int selectedRow = papersTable.convertRowIndexToModel(papersTable.getSelectedRow());
        int pid = (int)(papersTable.getModel().getValueAt(selectedRow, 0));

    	
    	Dialog dialog = new Dialog(this, "Getting information...");
    	Component me = this;
    	
    	SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			protected Void doInBackground() {
				try {
					Paper paper = Paper.getPaperByPid(pid);
					
					abstractTextArea.setText(paper.getPaperAbstract());
					titleLabel.setText(paper.getTitle());
					
					if (paper.getStatus() == 5)
						reviewButton.setEnabled(true);
					dialog.close();
				} catch (CmsysException e) {
					dialog.close();
					MessageBox.error("Unable to get the information at the moment", me);
				}
		        
				return null;
			}
    	};
    	
    	worker.execute();
    	dialog.show();
    }

    private void reviewButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	int selectedRow = papersTable.convertRowIndexToModel(papersTable.getSelectedRow());
        int pid = (int)(papersTable.getModel().getValueAt(selectedRow, 0));
        Component me = this;
        Dialog dialog = new Dialog(this, "Getting information...");
        
		SwingWorker<Paper, Void> worker = new SwingWorker<Paper, Void>() {
			private Paper paper = null;
			
			protected Paper doInBackground() {
				try {
					paper = Paper.getPaperByPid(pid);
					dialog.close();
					
				} catch (CmsysException e) {
					dialog.close();
					MessageBox.error("Unable to get the information needed.", me);
				}
				return paper;
			}
			
			protected void done() {
				if (paper != null) {
					reviewDialog = new Dialog(me, new PcMemberReviewSubPanel(me, paper), "Review");
					reviewDialog.show();
				}
			}
    	};
    	
    	worker.execute();
    	dialog.show();
    }

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	refreshTable();
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
    	};
    	
    	worker.execute();
    	dialog.show();
    }
    
    private void updateTable() throws CmsysException {
    	Object[][] paperObj = null;
    	ArrayList<Paper> paperList = Paper.getReviewPaperListByUid(user.getUID());
    	
    	if (paperList.size() == 0)
    		numPapersLabel.setText("No paper to be reviewed");
    	else
    		numPapersLabel.setText("Number of papers to be reviewed: " + paperList.size());
    	
    	paperObj = new Object[paperList.size()][3];
    	
    	for (int i = 0; i < paperList.size(); i++) {
    		paperObj[i][0] = paperList.get(i).getPid();
    		paperObj[i][1] = paperList.get(i).getTitle();
    	}
    	
    	model = (new javax.swing.table.DefaultTableModel(paperObj, new String [] {"PID", "Title"}) {
    				private static final long serialVersionUID = -7209182869872950827L;
    				public boolean isCellEditable(int row, int column) {return false;}
    			});

    	papersTable.setModel(model);
    }
    
    public void closePcMemberReviewSubPanel(boolean refresh) {
    	if (reviewDialog != null)
    		reviewDialog.close();
    	if (refresh)
    		refreshTable();	
    }
    
    private javax.swing.JLabel abstractDesLabel;
    private javax.swing.JScrollPane abstractScrollPane;
    private javax.swing.JTextArea abstractTextArea;
    private javax.swing.JSeparator jSeparatorTop;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel papersDesLabel;
    private javax.swing.JScrollPane papersScrollPane;
    private javax.swing.JTable papersTable;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton reviewButton;
    private javax.swing.JPanel reviewOptionsPanel;
    private javax.swing.JLabel numPapersLabel;
    private javax.swing.JLabel titleDesLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.table.DefaultTableModel model;
    private User user;
    private Dialog reviewDialog;
}
