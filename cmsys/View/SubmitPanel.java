package cmsys.View;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import cmsys.PaperManagement.*;
import cmsys.UserManagement.User;
import cmsys.Common.*;

import java.awt.Component;
import java.io.*;
import java.util.ArrayList;

public class SubmitPanel extends javax.swing.JPanel {
	
	private static final long serialVersionUID = -5278755803015801659L;
	public SubmitPanel(Component parent) {
		keywordsModel = new DefaultTableModel(null, new String[] {"Keyword"});
		authorsModel = new DefaultTableModel(null, new String[] {"First name", "Last name"});
		this.parent = parent;
        initComponents();
    }

    private void initComponents() {

        titleDesLabel = new javax.swing.JLabel();
        abstractDesLabel = new javax.swing.JLabel();
        pdfWhButton = new javax.swing.JButton();
        pdfWohButton = new javax.swing.JButton();
        titleTextField = new javax.swing.JTextField();
        abstractScrollPane = new javax.swing.JScrollPane();
        abstractTextArea = new javax.swing.JTextArea();
        addAuthorPanel = new javax.swing.JPanel();
        authorsDesLabel = new javax.swing.JLabel();
        authorsScrollPane = new javax.swing.JScrollPane();
        authorsTable = new javax.swing.JTable();
        addAuthorButton = new javax.swing.JButton();
        removeAuthorButton = new javax.swing.JButton();
        addKeywordPanel = new javax.swing.JPanel();
        keywordsDesLabel = new javax.swing.JLabel();
        keywordsScrollPane = new javax.swing.JScrollPane();
        keywordsTable = new javax.swing.JTable();
        addKeywordButton = new javax.swing.JButton();
        removeKeywordButton = new javax.swing.JButton();
        pdfWhFileNameLabel = new javax.swing.JLabel();
        pdfWohFileNameLabel = new javax.swing.JLabel();
        jSeparatorBottom = new javax.swing.JSeparator();
        submitButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        titleDesLabel.setText("Title*:");

        abstractDesLabel.setText("Abstract*:");

        pdfWhButton.setText("PDF file with header");
        pdfWhButton.setToolTipText("");
        pdfWhButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfWhButtonActionPerformed(evt);
            }
        });

        pdfWohButton.setText("PDF file without header");
        pdfWohButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfWohButtonActionPerformed(evt);
            }
        });

        abstractTextArea.setColumns(20);
        abstractTextArea.setRows(5);
        abstractScrollPane.setViewportView(abstractTextArea);

        authorsDesLabel.setText("Authors*:");

        authorsTable.setModel(authorsModel);
        authorsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        authorsScrollPane.setViewportView(authorsTable);

        addAuthorButton.setText("+");
        addAuthorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAuthorButtonActionPerformed(evt);
            }
        });

        removeAuthorButton.setText("-");
        removeAuthorButton.setToolTipText("");
        removeAuthorButton.setEnabled(false);
        removeAuthorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAuthorButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addAuthorPanelLayout = new javax.swing.GroupLayout(addAuthorPanel);
        addAuthorPanel.setLayout(addAuthorPanelLayout);
        addAuthorPanelLayout.setHorizontalGroup(
            addAuthorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addAuthorPanelLayout.createSequentialGroup()
                .addGroup(addAuthorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(authorsDesLabel)
                    .addGroup(addAuthorPanelLayout.createSequentialGroup()
                        .addComponent(authorsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addAuthorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addAuthorButton)
                            .addComponent(removeAuthorButton))))
                .addGap(0, 35, Short.MAX_VALUE))
        );
        addAuthorPanelLayout.setVerticalGroup(
            addAuthorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addAuthorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(authorsDesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addAuthorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(authorsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addAuthorPanelLayout.createSequentialGroup()
                        .addComponent(addAuthorButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeAuthorButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        keywordsDesLabel.setText("Keywords*:");
        
        keywordsTable.setModel(keywordsModel);
        keywordsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        keywordsScrollPane.setViewportView(keywordsTable);

        addKeywordButton.setText("+");
        addKeywordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addKeywordButtonActionPerformed(evt);
            }
        });

        removeKeywordButton.setText("-");
        removeKeywordButton.setToolTipText("");
        removeAuthorButton.setEnabled(false);
        removeKeywordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeKeywordButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addKeywordPanelLayout = new javax.swing.GroupLayout(addKeywordPanel);
        addKeywordPanel.setLayout(addKeywordPanelLayout);
        addKeywordPanelLayout.setHorizontalGroup(
            addKeywordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addKeywordPanelLayout.createSequentialGroup()
                .addComponent(keywordsDesLabel)
                .addGap(0, 256, Short.MAX_VALUE))
            .addGroup(addKeywordPanelLayout.createSequentialGroup()
                .addComponent(keywordsScrollPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addKeywordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addKeywordButton)
                    .addComponent(removeKeywordButton)))
        );
        addKeywordPanelLayout.setVerticalGroup(
            addKeywordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addKeywordPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(keywordsDesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addKeywordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(keywordsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addKeywordPanelLayout.createSequentialGroup()
                        .addComponent(addKeywordButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeKeywordButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pdfWhFileNameLabel.setText("No file selected");

        pdfWohFileNameLabel.setText("No file selected");

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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pdfWohButton)
                            .addComponent(pdfWhButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pdfWhFileNameLabel)
                            .addComponent(pdfWohFileNameLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(abstractDesLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(abstractScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(titleDesLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(titleTextField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addAuthorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addKeywordPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jSeparatorBottom, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(submitButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleDesLabel)
                    .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(abstractDesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(abstractScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(addAuthorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addKeywordPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pdfWhButton)
                    .addComponent(pdfWhFileNameLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pdfWohButton)
                    .addComponent(pdfWohFileNameLabel))
                .addGap(18, 18, 18)
                .addComponent(jSeparatorBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(closeButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        authorsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (authorsTable.getSelectedRow() == -1)
					removeAuthorButton.setEnabled(false);
				else
					removeAuthorButton.setEnabled(true);
			}
        });
        
        keywordsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (keywordsTable.getSelectedRow() == -1)
					removeKeywordButton.setEnabled(false);
				else
					removeKeywordButton.setEnabled(true);
			}
        });
    }

    private void addAuthorButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	authorsModel.addRow(new Object[]{"First name", "Last name"});
    }

    private void removeAuthorButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	int selectedRow = authorsTable.convertRowIndexToModel(authorsTable.getSelectedRow());
    	authorsModel.removeRow(selectedRow);
    }

    private void addKeywordButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	keywordsModel.addRow(new Object[]{"Keyword"});
    }

    private void removeKeywordButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	int selectedRow = keywordsTable.convertRowIndexToModel(keywordsTable.getSelectedRow());
    	keywordsModel.removeRow(selectedRow);
    }

    private void pdfWhButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	JFileChooser fc = new JFileChooser();
    	
    	fc.showOpenDialog(this);
    	pdfFileWH = fc.getSelectedFile();
    	
    	if (pdfFileWH != null)
    		pdfWhFileNameLabel.setText(pdfFileWH.getName());
    	else
    		pdfWhFileNameLabel.setText("No file selected");
    }

    private void pdfWohButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfWohButtonActionPerformed
    	JFileChooser fc = new JFileChooser();
    	
    	fc.showOpenDialog(this);
    	pdfFileWOH = fc.getSelectedFile();
    	
    	if (pdfFileWOH != null)
    		pdfWohFileNameLabel.setText(pdfFileWOH.getName());
    	else
    		pdfWohFileNameLabel.setText("No file selected");
    }

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	((MyPapersPanel)parent).closeSubmitDialog(false);
    }

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	try {
			if (Time.timestamp() > Long.parseLong(Settings.getSettingFromDB("submissionDeadline"))) {
				submitButton.setEnabled(true);
				MessageBox.error("The submission date has already passed.", this);
				return;
			}
		} catch (Exception e) {}
    	
    	UserDefault userDefault = UserDefault.getInstance();
    	User user = (User)(userDefault.getObj("user"));
    	String title = titleTextField.getText().trim();
    	String paperAbstract = abstractTextArea.getText().trim();
    	ArrayList<Author> authors = new ArrayList<Author>();
    	ArrayList<String> keywords  = new ArrayList<String>();
    	Component me = this;
    	
    	for (int i = 0; i < authorsModel.getRowCount(); i++) {
    		Author author = new Author();
    		author.setFirstName((String)((authorsModel.getValueAt(i, 0))));
    		author.setLastName((String)((authorsModel.getValueAt(i, 1))));
    		authors.add(author);
    	}
    	
    	for (int i = 0; i < keywordsModel.getRowCount(); i++) {
    		keywords.add((String)((keywordsModel.getValueAt(i, 0))));
    	}
    	
    	if (title.length() == 0) {
    		MessageBox.warning("Please fill in the title", this);
    		return;
    	}
    	
    	if (paperAbstract.length() == 0) {
    		MessageBox.warning("Please fill in the abstract", this);
    		return;
    	}
    	
    	if (authors.size() <= 0) {
    		MessageBox.warning("Please add at least one author", this);
    		return;
    	}
    	
    	if (keywords.size() <= 0) {
    		MessageBox.warning("Please add at least one keyword", this);
    		return;
    	}
    	
    	if (pdfFileWH == null || pdfFileWOH == null) {
    		MessageBox.warning("Please submit both pdf files", this);
    		return;
    	}
    	
    	Dialog dialog = new Dialog(this, "Submitting your paper, please wait for a moment...");
    	
    	SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			protected Void doInBackground() {
				boolean success = false;
				
				try {
					try {
						Submission.submitPaper(user.getUID(), title, paperAbstract, authors, keywords, pdfFileWH, pdfFileWOH);
						dialog.close();
						MessageBox.information("Your paper has been submitted, thank you!", me);
						success = true;
					} catch (CmsysException e) {
						dialog.close();
						MessageBox.error("Unable to submit your paper at the moment", me);
					}
				} finally {
					if (success)
						((MyPapersPanel)parent).closeSubmitDialog(true);
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
    private javax.swing.JButton addAuthorButton;
    private javax.swing.JPanel addAuthorPanel;
    private javax.swing.JButton addKeywordButton;
    private javax.swing.JPanel addKeywordPanel;
    private javax.swing.JLabel authorsDesLabel;
    private javax.swing.JScrollPane authorsScrollPane;
    private javax.swing.JTable authorsTable;
    private javax.swing.JButton closeButton;
    private javax.swing.JSeparator jSeparatorBottom;
    private javax.swing.JLabel keywordsDesLabel;
    private javax.swing.JScrollPane keywordsScrollPane;
    private javax.swing.JTable keywordsTable;
    private javax.swing.JButton pdfWhButton;
    private javax.swing.JLabel pdfWhFileNameLabel;
    private javax.swing.JButton pdfWohButton;
    private javax.swing.JLabel pdfWohFileNameLabel;
    private javax.swing.JButton removeAuthorButton;
    private javax.swing.JButton removeKeywordButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel titleDesLabel;
    private javax.swing.JTextField titleTextField;
    private File pdfFileWH, pdfFileWOH;
    DefaultTableModel authorsModel, keywordsModel;
    Component parent;
}
