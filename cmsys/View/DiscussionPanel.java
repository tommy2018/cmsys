package cmsys.View;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.SwingWorker;
import cmsys.Common.CmsysException;
import cmsys.Common.Time;
import cmsys.Common.UserDefault;
import cmsys.PaperManagement.Discussion;
import cmsys.PaperManagement.DiscussionComment;
import cmsys.PaperManagement.Paper;
import cmsys.UserManagement.User;

public class DiscussionPanel extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;
	public DiscussionPanel(Paper paper) {
    	UserDefault userDefault = UserDefault.getInstance();
    	
    	user = (User)userDefault.getObj("user");
		this.paper = paper;
        initComponents();
    }

    private void initComponents() {

        replyPanel = new javax.swing.JPanel();
        replyScrollPane = new javax.swing.JScrollPane();
        replyTextArea = new javax.swing.JTextArea();
        replyButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        discussionPanel = new javax.swing.JPanel();
        discussionScrollPane = new javax.swing.JScrollPane();
        discussionTextArea = new javax.swing.JTextArea();
        refreshButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        jSeparatorMid = new javax.swing.JSeparator();

        replyPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Reply"));

        replyTextArea.setColumns(20);
        replyTextArea.setRows(5);
        replyScrollPane.setViewportView(replyTextArea);

        replyButton.setText("Reply");
        replyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replyButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout replyPanelLayout = new javax.swing.GroupLayout(replyPanel);
        replyPanel.setLayout(replyPanelLayout);
        replyPanelLayout.setHorizontalGroup(
            replyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(replyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(replyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(replyScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, replyPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(replyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        replyPanelLayout.setVerticalGroup(
            replyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(replyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(replyScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(replyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(replyButton)
                    .addComponent(clearButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        discussionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Discussion"));

        discussionTextArea.setEditable(false);
        discussionTextArea.setColumns(20);
        discussionTextArea.setRows(5);
        discussionScrollPane.setViewportView(discussionTextArea);

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout discussionPanelLayout = new javax.swing.GroupLayout(discussionPanel);
        discussionPanel.setLayout(discussionPanelLayout);
        discussionPanelLayout.setHorizontalGroup(
            discussionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(discussionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(discussionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(discussionScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, discussionPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(refreshButton)))
                .addContainerGap())
        );
        discussionPanelLayout.setVerticalGroup(
            discussionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(discussionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(discussionScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(refreshButton)
                .addGap(6, 6, 6))
        );

        titleLabel.setText("Paper title:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(replyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparatorMid)
                    .addComponent(discussionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparatorMid, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(discussionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(replyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        titleLabel.setText("Title: " + paper.getTitle());
        refreshButton.setEnabled(false);
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			protected Void doInBackground() {
				try {
					try {
						updateComment();
					} catch (CmsysException e) {
					}
					return null;
				} finally {
					refreshButton.setEnabled(true);
				}
			}
    	};
    	worker.execute();
    }

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	refresh();
    }

    private void replyButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	String reply = replyTextArea.getText().trim();
    	
    	if (reply.length() == 0) {
    		MessageBox.warning("Please fill in the reply field", this);
    		return;
    	}
    	
    	Dialog dialog = new Dialog(this, "Submitting your reply, please wait for a moment...");
    	Component me = this;
    	
    	SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
    		boolean success = false;
    		
			protected Void doInBackground() {
				try {
					DiscussionComment dc = new DiscussionComment();
					
					dc.setTimestamp(Time.timestamp());
					dc.setContent(reply);
					dc.setUid(user.getUID());
					
					Discussion.addComment(paper.getPid(), dc);
					
					dialog.close();
					success = true;
					replyTextArea.setText("");
				} catch (CmsysException e) {
					dialog.close();
					MessageBox.error("Unable to submit your reply at the moment", me);
				}
				return null;
			}
			
			protected void done() {
				if (success)
					refresh();
			}
    	};
    	
    	worker.execute();
    	dialog.show();
    }

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	replyTextArea.setText("");
    }
    
    private void updateComment() throws CmsysException {
    	ArrayList<DiscussionComment> commentList = Discussion.getDiscussionByPid(paper.getPid());
    	
    	String comments = "";
    	
    	for (DiscussionComment comment: commentList) {
    		comments += comment.toString();
    	}
    	
    	discussionTextArea.setText(comments);
    }
    
    private void refresh() {
    	Dialog dialog = new Dialog(this, "Refreshing...");
    	Component me = this;
    	
    	SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			protected Void doInBackground() {
				try {
					updateComment();
					dialog.close();
				} catch (CmsysException e) {
					dialog.close();
					MessageBox.error("Unable to update the comment list at the moment.", me);
				}
				return null;
			}
    	};
    	
    	worker.execute();
    	dialog.show();
    }


    private javax.swing.JButton clearButton;
    private javax.swing.JPanel discussionPanel;
    private javax.swing.JScrollPane discussionScrollPane;
    private javax.swing.JTextArea discussionTextArea;
    private javax.swing.JSeparator jSeparatorMid;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton replyButton;
    private javax.swing.JPanel replyPanel;
    private javax.swing.JScrollPane replyScrollPane;
    private javax.swing.JTextArea replyTextArea;
    private javax.swing.JLabel titleLabel;
    private Paper paper;
    private User user;
}
