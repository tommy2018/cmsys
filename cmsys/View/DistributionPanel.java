package cmsys.View;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.SwingWorker;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import cmsys.Common.CmsysException;
import cmsys.Common.CronJob;
import cmsys.Common.Time;
import cmsys.PaperManagement.Distribution;
import cmsys.PaperManagement.Paper;
import cmsys.UserManagement.User;

public class DistributionPanel extends javax.swing.JPanel {

	private static final long serialVersionUID = -1545135391742887910L;
	public DistributionPanel() {
        initComponents();
        try {
			dmap = Distribution.getDistributionList();
		} catch (CmsysException e) {}
        updateTable();
    }

    private void initComponents() {

        descriptionLabel = new javax.swing.JLabel();
        distributionScrollPane = new javax.swing.JScrollPane();
        distributionTree = new javax.swing.JTree();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        confirmButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        descriptionLabel.setText("<html>The system has assigned papaers to PC members.<br>You can make a final change before the distribution.</html>");

        distributionScrollPane.setViewportView(distributionTree);

        addButton.setText("-");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("+");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        confirmButton.setText("Confirm");
        confirmButton.setToolTipText("");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(closeButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(confirmButton))
                            .addComponent(distributionScrollPane))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addButton)
                            .addComponent(removeButton))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(removeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addButton))
                    .addComponent(distributionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(closeButton)
                    .addComponent(confirmButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addButton.setEnabled(false);
        removeButton.setEnabled(false);
        closeButton.setVisible(false);
    }

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	Component me = this;
        Dialog dialog = new Dialog(this, "Applying...");
        
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			protected Void doInBackground() {
				try {
					Iterator it = dmap.entrySet().iterator();
			    	
					while (it.hasNext()) {
			    		Map.Entry pairs = (Map.Entry)it.next();
			    		ArrayList<Integer> temp = (ArrayList<Integer>) pairs.getValue();
			    		
			    		Paper paper = Paper.getPaperByPid((int)(pairs.getKey()));
			    		for (Integer uid: temp) {
				    		Distribution.distribute(paper.getPid(), uid, Time.timestamp() + 1728000000);
				    	}
					}
					
					CronJob.changeSystemStatusToRevewing();
					
					dialog.close();
					MessageBox.warning("System status has changed, restart required", me);
					System.exit(0);
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

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_closeButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButtonActionPerformed

    
    private void updateTable() {
    	DefaultMutableTreeNode top = new DefaultMutableTreeNode("Papers");
    	Iterator it = dmap.entrySet().iterator();
    	
    	while (it.hasNext()) {
    		Map.Entry pairs = (Map.Entry)it.next();
    		ArrayList<Integer> temp = (ArrayList<Integer>) pairs.getValue();
    		String title = "";
    		
    		try {
				title = Paper.getPaperByPid((int)(pairs.getKey())).getTitle();
			} catch (CmsysException e1) {}
    		
    		DefaultMutableTreeNode node = new DefaultMutableTreeNode("Pid: " + (int)(pairs.getKey()) + " Title: " +title);
    		
    		for (Integer uid: temp) {
    			String userName = "";
    			
				try {
					userName = User.getUserByUid(uid).getUsername();
				} catch (CmsysException e) {}
				
    			DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("Username: " + userName);
    			node.add(node2);
    		}
    		
    		top.add(node);
    	}
    	
    	model = new DefaultTreeModel(top);
    	distributionTree.setModel(model);
    	distributionTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
    }

    private javax.swing.JButton addButton;
    private javax.swing.JButton confirmButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JScrollPane distributionScrollPane;
    private javax.swing.JTree distributionTree;
    private javax.swing.JButton removeButton;
    private DefaultTreeModel model;
    private HashMap<Integer, ArrayList<Integer>> dmap;
}
