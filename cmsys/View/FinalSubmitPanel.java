package cmsys.View;

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.SwingWorker;

import cmsys.Common.CmsysException;
import cmsys.Common.Log;
import cmsys.Common.UserDefault;
import cmsys.PaperManagement.*;
import cmsys.UserManagement.User;

public class FinalSubmitPanel extends javax.swing.JPanel {

	private static final long serialVersionUID = -973372836189761242L;
	public FinalSubmitPanel(Component parent, Paper paper) {
		this.parent = parent;
		this.paper = paper;
    	initComponents();
    }

    private void initComponents() {

        descriptionLabel = new javax.swing.JLabel();
        instructionDesLabel = new javax.swing.JLabel();
        getTemplateFileButton = new javax.swing.JButton();
        selectFinalVersionButton = new javax.swing.JButton();
        fileNameLabel = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        jSeparatorButtom = new javax.swing.JSeparator();
        closeButton = new javax.swing.JButton();
        titleDesPanel = new javax.swing.JLabel();

        descriptionLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        descriptionLabel.setText("<html>Congratulations!<br>Your paper has been accepted! Please submit the final version of your paper.</html>");

        instructionDesLabel.setText("<html><b>Instruction:</b><br>Re-format your paper as the template file provided.</html>");

        getTemplateFileButton.setText("Get the template file");
        getTemplateFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getTemplateFileButtonActionPerformed(evt);
            }
        });

        selectFinalVersionButton.setText("Submit the final version");
        selectFinalVersionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFinalVersionButtonActionPerformed(evt);
            }
        });

        fileNameLabel.setText("No file selected");

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

        titleDesPanel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        titleDesPanel.setText("Title: " + paper.getTitle());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparatorButtom)
                    .addComponent(descriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(instructionDesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(getTemplateFileButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(selectFinalVersionButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fileNameLabel))
                            .addComponent(titleDesPanel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(titleDesPanel)
                .addGap(18, 18, 18)
                .addComponent(instructionDesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(getTemplateFileButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectFinalVersionButton)
                    .addComponent(fileNameLabel))
                .addGap(18, 18, 18)
                .addComponent(jSeparatorButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(closeButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	((MyPapersPanel)parent).closeSubmitFinalVersionDialog(false);
    }

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	if (pdfFile == null) {
    		MessageBox.warning("Please submit the pdf file", this);
    		return;
    	}
    	
    	Dialog dialog = new Dialog(this, "Submitting your paper, please wait for a moment...");
    	Component me = this;
    	
    	SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			protected Void doInBackground() {
				boolean success = false;
				try {
					try {
						Submission.submitFinalPaper(paper.getPid(), pdfFile);
						dialog.close();
						UserDefault userDefault = UserDefault.getInstance();
						User user = (User)(userDefault.getObj("user"));
						Log.newLog(user.getUID(), "Paper: " + paper.getTitle() + " final version submitted");
						MessageBox.information("Your paper has been submitted, thank you!", me);
						success = true;
					} catch (CmsysException e) {
						dialog.close();
						MessageBox.error("Unable to submit your paper at the moment", me);
					}
				} finally {
					if (success)
						((MyPapersPanel)parent).closeSubmitFinalVersionDialog(true);
				}
				return null;
			}
    	};
    	
    	worker.execute();
    	dialog.show();	
    }

    private void getTemplateFileButtonActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void selectFinalVersionButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	JFileChooser fc = new JFileChooser();
    	
    	fc.showOpenDialog(this);
    	pdfFile = fc.getSelectedFile();
    	
    	if (pdfFile != null)
    		fileNameLabel.setText(pdfFile.getName());
    	else
    		fileNameLabel.setText("No file selected");
    }

    private javax.swing.JButton closeButton;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JLabel fileNameLabel;
    private javax.swing.JButton getTemplateFileButton;
    private javax.swing.JLabel instructionDesLabel;
    private javax.swing.JSeparator jSeparatorButtom;
    private javax.swing.JButton selectFinalVersionButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel titleDesPanel;
    private File pdfFile;
    private Paper paper;
    private Component parent;
}
