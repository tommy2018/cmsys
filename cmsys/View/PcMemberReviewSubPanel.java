package cmsys.View;

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.SwingWorker;

import cmsys.Common.CmsysException;
import cmsys.Common.UserDefault;
import cmsys.PaperManagement.FileManager;
import cmsys.PaperManagement.Paper;
import cmsys.PaperManagement.Review;
import cmsys.UserManagement.User;

public class PcMemberReviewSubPanel extends javax.swing.JPanel {
	
	private static final long serialVersionUID = -3962486282054556836L;
	public PcMemberReviewSubPanel(Component parent, Paper paper) {
    	UserDefault userDefault = UserDefault.getInstance();
    	
    	user = (User)userDefault.getObj("user");
    	this.parent = parent;
		this.paper = paper;
        initComponents();
    }

    private void initComponents() {

        paperContentsPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        abstractDesLabel = new javax.swing.JLabel();
        abstractScrollPane = new javax.swing.JScrollPane();
        abstractTextArea = new javax.swing.JTextArea();
        getPdfButton = new javax.swing.JButton();
        openDiscussionBoardButton = new javax.swing.JButton();
        reviewScrollPane = new javax.swing.JScrollPane();
        reviewPanel = new javax.swing.JPanel();
        isSPComboBox = new javax.swing.JComboBox();
        significanceDesLabel = new javax.swing.JLabel();
        weaknessesScrollPane = new javax.swing.JScrollPane();
        weaknessesTextArea = new javax.swing.JTextArea();
        rcDesLabel = new javax.swing.JLabel();
        weaknessesDesLabel = new javax.swing.JLabel();
        isBPComboBox = new javax.swing.JComboBox();
        originalityDesLabel = new javax.swing.JLabel();
        ocDesLabel = new javax.swing.JLabel();
        presentationComboBox = new javax.swing.JComboBox();
        isSPDesLabel = new javax.swing.JLabel();
        oeDesLabel = new javax.swing.JLabel();
        rcComboBox = new javax.swing.JComboBox();
        strengthsScrollPane = new javax.swing.JScrollPane();
        strengthsTextArea = new javax.swing.JTextArea();
        significanceComboBox = new javax.swing.JComboBox();
        isBPDesLabel = new javax.swing.JLabel();
        relevanceComboBox = new javax.swing.JComboBox();
        presentationDesLabel = new javax.swing.JLabel();
        oeComboBox = new javax.swing.JComboBox();
        ocScrollPane = new javax.swing.JScrollPane();
        ocTextArea = new javax.swing.JTextArea();
        csScrollPane = new javax.swing.JScrollPane();
        csTextArea = new javax.swing.JTextArea();
        strengthsDesLabel = new javax.swing.JLabel();
        relevanceDesLabel = new javax.swing.JLabel();
        originalityComboBox = new javax.swing.JComboBox();
        csDesLabel = new javax.swing.JLabel();
        evaluationDesLabel = new javax.swing.JLabel();
        evaluationComboBox = new javax.swing.JComboBox();
        tqDesLabel = new javax.swing.JLabel();
        tqComboBox = new javax.swing.JComboBox();
        jSeparatorMid = new javax.swing.JSeparator();
        submitButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        paperContentsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Paper contents"));

        titleLabel.setText("Title:");

        abstractDesLabel.setText("Abstract:");

        abstractTextArea.setEditable(false);
        abstractTextArea.setColumns(20);
        abstractTextArea.setRows(5);
        abstractScrollPane.setViewportView(abstractTextArea);

        getPdfButton.setText("Get the pdf file");
        getPdfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getPdfButtonActionPerformed(evt);
            }
        });

        openDiscussionBoardButton.setText("Open discussion board");
        openDiscussionBoardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openDiscussionBoardButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paperContentsPanelLayout = new javax.swing.GroupLayout(paperContentsPanel);
        paperContentsPanel.setLayout(paperContentsPanelLayout);
        paperContentsPanelLayout.setHorizontalGroup(
            paperContentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paperContentsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paperContentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(abstractScrollPane)
                    .addGroup(paperContentsPanelLayout.createSequentialGroup()
                        .addGroup(paperContentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(paperContentsPanelLayout.createSequentialGroup()
                                .addComponent(getPdfButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(openDiscussionBoardButton))
                            .addComponent(abstractDesLabel)
                            .addComponent(titleLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        paperContentsPanelLayout.setVerticalGroup(
            paperContentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paperContentsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(abstractDesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(abstractScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(paperContentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(getPdfButton)
                    .addComponent(openDiscussionBoardButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        reviewScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Review"));

        reviewPanel.setBorder(null);

        isSPComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Yes", "No" }));

        significanceDesLabel.setText("Significance:");

        weaknessesTextArea.setColumns(20);
        weaknessesTextArea.setRows(5);
        weaknessesScrollPane.setViewportView(weaknessesTextArea);

        rcDesLabel.setText("Reviewer's confidence:");

        weaknessesDesLabel.setText("Weaknesses of the paper:");

        isBPComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Yes", "No" }));

        originalityDesLabel.setText("Originality:");

        ocDesLabel.setText("Other comment (*Only visible to PC Chairs):");

        presentationComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Excellent", "Well Written", "Acceptable", "Poor", "Unreadable" }));

        isSPDesLabel.setText("Would this paper be suitable as a short paper?");

        oeDesLabel.setText("Overall evaluation:");

        rcComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Expert", "High", "Medium", "Low", "Null" }));

        strengthsTextArea.setColumns(20);
        strengthsTextArea.setRows(5);
        strengthsScrollPane.setViewportView(strengthsTextArea);

        significanceComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Highly Significant", "Very Significant", "Moderately Significant", "Little Significant", "Not Significant" }));

        isBPDesLabel.setText("Should this paper be considered for a best paper award?");

        relevanceComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Highly Relevant", "Very Relevant", "Moderately Relevant", "Little Relevant", "Not Relevant" }));

        presentationDesLabel.setText("Presentation:");

        oeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Strong accept", "Accept", "Weak accept", "Borderline paper", "weak reject", "Reject", "Strong reject" }));

        ocTextArea.setColumns(20);
        ocTextArea.setRows(5);
        ocScrollPane.setViewportView(ocTextArea);

        csTextArea.setColumns(20);
        csTextArea.setRows(5);
        csScrollPane.setViewportView(csTextArea);

        strengthsDesLabel.setText("Strengths of the paper:");

        relevanceDesLabel.setText("Relevance:");

        originalityComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Highly Originial", "Very Originial", "Moderately Originial", "Little Originial", "Not Originial" }));

        csDesLabel.setText("Comments and suggestions:");

        evaluationDesLabel.setText("Evaluation:");

        evaluationComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Thorough Evaluation", "Strong Evaluation", "Sound Evaluation", "Weak Evaluation", "No Evaluation" }));

        tqDesLabel.setText("Technical quality:");

        tqComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Technically Sound", "Seems Sound", "Minor Flaws", "Major Flaws", "Unsound" }));

        javax.swing.GroupLayout reviewPanelLayout = new javax.swing.GroupLayout(reviewPanel);
        reviewPanel.setLayout(reviewPanelLayout);
        reviewPanelLayout.setHorizontalGroup(
            reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reviewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(strengthsScrollPane)
                    .addGroup(reviewPanelLayout.createSequentialGroup()
                        .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(weaknessesDesLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(strengthsDesLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(csDesLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ocDesLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, reviewPanelLayout.createSequentialGroup()
                                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, reviewPanelLayout.createSequentialGroup()
                                        .addGap(358, 358, 358)
                                        .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(originalityDesLabel)
                                            .addComponent(rcDesLabel)
                                            .addComponent(presentationDesLabel)))
                                    .addGroup(reviewPanelLayout.createSequentialGroup()
                                        .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(relevanceDesLabel)
                                            .addComponent(oeDesLabel)
                                            .addComponent(significanceDesLabel)
                                            .addComponent(tqDesLabel))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(reviewPanelLayout.createSequentialGroup()
                                                .addComponent(tqComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(evaluationDesLabel))
                                            .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(oeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(relevanceComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(significanceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rcComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(originalityComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(evaluationComboBox, 0, 192, Short.MAX_VALUE)
                                    .addComponent(presentationComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(reviewPanelLayout.createSequentialGroup()
                                    .addComponent(isSPDesLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(isSPComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, reviewPanelLayout.createSequentialGroup()
                                    .addComponent(isBPDesLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(isBPComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 26, Short.MAX_VALUE))
                    .addComponent(weaknessesScrollPane)
                    .addComponent(csScrollPane)
                    .addComponent(ocScrollPane)
                    .addComponent(jSeparatorMid))
                .addContainerGap())
        );
        reviewPanelLayout.setVerticalGroup(
            reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reviewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(strengthsDesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(strengthsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(weaknessesDesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(weaknessesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(csDesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(csScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ocDesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ocScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(isBPDesLabel)
                    .addComponent(isBPComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(isSPComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(isSPDesLabel))
                .addGap(8, 8, 8)
                .addComponent(jSeparatorMid, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oeDesLabel)
                    .addComponent(oeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rcDesLabel)
                    .addComponent(rcComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(relevanceDesLabel)
                    .addComponent(relevanceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(originalityDesLabel)
                    .addComponent(originalityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(significanceDesLabel)
                    .addComponent(significanceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(presentationDesLabel)
                    .addComponent(presentationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(evaluationDesLabel)
                    .addComponent(evaluationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tqDesLabel)
                    .addComponent(tqComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        reviewScrollPane.setViewportView(reviewPanel);

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
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
                    .addComponent(paperContentsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reviewScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paperContentsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reviewScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(closeButton))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        
        setText();
    }
    
    private void setText() {
    	titleLabel.setText("Title: " + paper.getTitle());
    	abstractTextArea.setText(paper.getPaperAbstract());
    }

    private void getPdfButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	JFileChooser fc = new JFileChooser();
    	File file = null;
    	
    	fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
    	fc.showSaveDialog(this);
    	
    	if (fc != null) {
    		file = fc.getSelectedFile();
    		try {
    			FileManager.getFile(paper.getHashWOH(), file.getAbsolutePath());
    			MessageBox.information("Saved to selected location", this);
    		} catch (CmsysException e) {
    			MessageBox.error("Cannot save the file", this);
    		}
    	}
    }

    private void openDiscussionBoardButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	Dialog dialog = new Dialog(this, new DiscussionPanel(paper), "Discussion", 0);
    	dialog.show();
    }

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	((PcMemberReviewPanel)parent).closePcMemberReviewSubPanel(false);
    }

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	String strengths, weaknesses, cs, oc;
    	String isBP, isSP, oe, rc, relevance, originality;
    	String significance, presentation, tq, evaluation;
    	Review review = new Review();
    	
    	strengths = strengthsTextArea.getText().trim();
    	weaknesses = strengthsTextArea.getText().trim();
    	oc = ocTextArea.getText().trim();
    	cs = csTextArea.getText().trim();
    	
    	isBP = (String)(isBPComboBox.getSelectedItem());
    	isSP = (String)(isSPComboBox.getSelectedItem());
    	oe = (String)(oeComboBox.getSelectedItem());
    	rc = (String)(rcComboBox.getSelectedItem());
    	relevance = (String)(relevanceComboBox.getSelectedItem());
    	originality = (String)(originalityComboBox.getSelectedItem());
    	significance = (String)(significanceComboBox.getSelectedItem());
    	presentation = (String)(presentationComboBox.getSelectedItem());
    	tq = (String)(tqComboBox.getSelectedItem());
    	evaluation = (String)(evaluationComboBox.getSelectedItem());
    	
    	review.setCs(cs);
		review.setEvaluation(evaluation);
		review.setIsBP(isBP);
		review.setIsSP(isSP);
		review.setOc(oc);
		review.setOe(oe);
		review.setOriginality(originality);
		review.setPid(paper.getPid());
		review.setPresentation(presentation);
		review.setRc(rc);
		review.setRelevance(relevance);
		review.setSignificance(significance);
		review.setStrengths(strengths);
		review.setTq(tq);
		review.setUid(user.getUID());
		review.setWeaknesses(weaknesses);
    	
    	if (cs.length() == 0 || weaknesses.length() == 0 || strengths.length() == 0) {
    		MessageBox.warning("Please fill in all the fields", this);
    		return;
    	}
    	
    	Dialog dialog = new Dialog(this, "Submitting your review, please wait for a moment...");
    	Component me = this;
    	
    	SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			protected Void doInBackground() {
				boolean success = false;
				try {
					try {
						Review.submitReview(review);
						dialog.close();
						MessageBox.information("Your review has been submitted, thank you!", me);
						success = true;
					} catch (CmsysException e) {
						dialog.close();
						MessageBox.error("Unable to submit your review at the moment", me);
					}
				} finally {
					if (success)
						((PcMemberReviewPanel)parent).closePcMemberReviewSubPanel(true);
				}
				return null;
			}
    	};
    	
    	worker.execute();
    	dialog.show();	
    }


    private javax.swing.JLabel abstractDesLabel;
    private javax.swing.JScrollPane abstractScrollPane;
    private javax.swing.JTextArea abstractTextArea;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel csDesLabel;
    private javax.swing.JScrollPane csScrollPane;
    private javax.swing.JTextArea csTextArea;
    private javax.swing.JComboBox evaluationComboBox;
    private javax.swing.JLabel evaluationDesLabel;
    private javax.swing.JButton getPdfButton;
    private javax.swing.JComboBox isBPComboBox;
    private javax.swing.JLabel isBPDesLabel;
    private javax.swing.JLabel isSPDesLabel;
    private javax.swing.JComboBox isSPComboBox;
    private javax.swing.JScrollPane ocScrollPane;
    private javax.swing.JSeparator jSeparatorMid;
    private javax.swing.JTextArea ocTextArea;
    private javax.swing.JLabel ocDesLabel;
    private javax.swing.JComboBox oeComboBox;
    private javax.swing.JLabel oeDesLabel;
    private javax.swing.JButton openDiscussionBoardButton;
    private javax.swing.JComboBox originalityComboBox;
    private javax.swing.JLabel originalityDesLabel;
    private javax.swing.JPanel paperContentsPanel;
    private javax.swing.JComboBox presentationComboBox;
    private javax.swing.JLabel presentationDesLabel;
    private javax.swing.JComboBox rcComboBox;
    private javax.swing.JLabel rcDesLabel;
    private javax.swing.JComboBox relevanceComboBox;
    private javax.swing.JLabel relevanceDesLabel;
    private javax.swing.JPanel reviewPanel;
    private javax.swing.JScrollPane reviewScrollPane;
    private javax.swing.JComboBox significanceComboBox;
    private javax.swing.JLabel significanceDesLabel;
    private javax.swing.JLabel strengthsDesLabel;
    private javax.swing.JScrollPane strengthsScrollPane;
    private javax.swing.JTextArea strengthsTextArea;
    private javax.swing.JButton submitButton;
    private javax.swing.JComboBox tqComboBox;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel tqDesLabel;
    private javax.swing.JLabel weaknessesDesLabel;
    private javax.swing.JScrollPane weaknessesScrollPane;
    private javax.swing.JTextArea weaknessesTextArea;
    private Paper paper;
    private Component parent;
    private User user;
}
