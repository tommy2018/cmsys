package cmsys.View;

import java.util.ArrayList;

import cmsys.Common.CmsysException;
import cmsys.Common.UserDefault;
import cmsys.PaperManagement.Paper;
import cmsys.PaperManagement.Review;
import cmsys.UserManagement.User;

public class ViewResponsePanel extends javax.swing.JPanel {

	private static final long serialVersionUID = 999228787168356579L;
	public ViewResponsePanel(Paper paper, ArrayList<Review> reviewList) {
		UserDefault userDefault = UserDefault.getInstance();
		
		user = (User)(userDefault.getObj("user"));
        this.reviewList = reviewList;
        this.index = 0;
        initComponents();
        titleLabel.setText("Title: " + paper.getTitle());
        updateReviews(index);
        setButtonSatus(index);
    }

    private void initComponents() {

        descriptionLabel = new javax.swing.JLabel();
        reviewScrollPane = new javax.swing.JScrollPane();
        reviewTextArea = new javax.swing.JTextArea();
        nextButton = new javax.swing.JButton();
        previousButton = new javax.swing.JButton();
        currentLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();

        descriptionLabel.setText("<html><b>This paper has been reviewed.</b></html>");

        reviewTextArea.setEditable(false);
        reviewTextArea.setColumns(20);
        reviewTextArea.setRows(5);
        reviewScrollPane.setViewportView(reviewTextArea);

        nextButton.setText(">");
        nextButton.setEnabled(false);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        previousButton.setText("<");
        previousButton.setEnabled(false);
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        currentLabel.setText("--- / ---");

        titleLabel.setText("Title:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reviewScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(currentLabel)
                        .addGap(18, 18, 18)
                        .addComponent(previousButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titleLabel))
                        .addGap(0, 377, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reviewScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton)
                    .addComponent(previousButton)
                    .addComponent(currentLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {
        index++;
        if(index >= reviewList.size()) {
            index = reviewList.size() - 1;
        }
        setButtonSatus(index);
        updateReviews(index);
    }

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {
        index--;
        if(index < 0){
            index = 0;
        }
        setButtonSatus(index);
        updateReviews(index);
    }

    private void setButtonSatus(int current) {
        if(current == reviewList.size() - 1) {
            nextButton.setEnabled(false);
        }
        else {
            nextButton.setEnabled(true);
        }
        
        if(current == 0) {
            previousButton.setEnabled(false);
        }
        else {
            previousButton.setEnabled(true);
        }
    }
    
    private void updateReviews(int current) {
        Review review = reviewList.get(current);
        String info = null;
        
        if (user.getRole() == 1 || user.getRole() == 2) {
        	info =  "Strengths of the paper:\n" + review.getStrengths() + "\n\n" 
                    + "Weaknesses of the paper:\n" + review.getWeaknesses() + "\n\n"
                    + "Detailed comments and suggestions to improve the paper:\n" + review.getCs() + "\n\n"
                    + "-----------------------------------\n"
                    + "Would this paper be suitable as a short paper? " + review.getIsSP() + "\n"
                    + "Should this paper be considered for a best paper award? " + review.getIsBP() + "\n"
                    + "-----------------------------------\n"
                    + "Overall evaluation: " + review.getOe() + "\n"
                    + "Reviewer's confidence: " + review.getRc() + "\n"
                    + "Relevance: " + review.getRelevance() + "\n"
                    + "Originality: " + review.getOriginality() + "\n"
                    + "Significance: " + review.getSignificance() + "\n"
                    + "Presentation: " + review.getPresentation() + "\n";
        } else {
        	User reviewer;
        	
			try {
				reviewer = User.getUserByUid(review.getUid());
				info =  "Reviewed by: " + reviewer.getUsername()
						+ "\n-----------------------------------\n"
						+ "\nStrengths of the paper:\n" + review.getStrengths() + "\n\n" 
	                    + "Weaknesses of the paper:\n" + review.getWeaknesses() + "\n\n"
	                    + "Detailed comments and suggestions to improve the paper:\n" + review.getCs() + "\n\n"
	                    + "Other comments (Not available to the author):\n" + review.getOc() + "\n\n"
	                    + "-----------------------------------\n"
	                    + "Would this paper be suitable as a short paper? " + review.getIsSP() + "\n"
	                    + "Should this paper be considered for a best paper award? " + review.getIsBP() + "\n"
	                    + "-----------------------------------\n"
	                    + "Overall evaluation: " + review.getOe() + "\n"
	                    + "Reviewer's confidence: " + review.getRc() + "\n"
	                    + "Relevance: " + review.getRelevance() + "\n"
	                    + "Originality: " + review.getOriginality() + "\n"
	                    + "Significance: " + review.getSignificance() + "\n"
	                    + "Presentation: " + review.getPresentation() + "\n";
			} catch (CmsysException e) {
			}        	
        }
        
        reviewTextArea.setText(info);
        reviewTextArea.setCaretPosition(0);
        currentLabel.setText((current+1) + "/" + reviewList.size());
    }
    
    private ArrayList<Review> reviewList;
    private int index;
    private javax.swing.JLabel currentLabel;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previousButton;
    private javax.swing.JScrollPane reviewScrollPane;
    private javax.swing.JTextArea reviewTextArea;
    private javax.swing.JLabel titleLabel;
    private User user;
}
