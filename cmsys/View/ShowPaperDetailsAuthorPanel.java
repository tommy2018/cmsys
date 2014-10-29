package cmsys.View;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

import cmsys.Common.CmsysException;
import cmsys.PaperManagement.FileManager;
import cmsys.PaperManagement.FinalPaper;
import cmsys.PaperManagement.Paper;

public class ShowPaperDetailsAuthorPanel extends javax.swing.JPanel {

	private static final long serialVersionUID = 7362022043177767372L;
	public ShowPaperDetailsAuthorPanel(Paper paper) {
		this.paper = paper;
        initComponents();
        reFormattedFileButton.setEnabled(false);
        if (paper.getStatus() == 3)
        	reFormattedFileButton.setEnabled(true);
    }

    private void initComponents() {

        titleDesLabel = new javax.swing.JLabel();
        abstractDesLabel = new javax.swing.JLabel();
        authorsDesLabel = new javax.swing.JLabel();
        keywordsDesLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        authorsScrollPane = new javax.swing.JScrollPane();
        authorsTable = new javax.swing.JTable();
        abstractScrollPane = new javax.swing.JScrollPane();
        abstractTextArea = new javax.swing.JTextArea();
        keywordsScrollPane = new javax.swing.JScrollPane();
        keywordsTable = new javax.swing.JTable();
        pdfWhButton = new javax.swing.JButton();
        pdfWohButton = new javax.swing.JButton();
        reFormattedFileButton = new javax.swing.JButton();

        titleDesLabel.setText("Title:");

        abstractDesLabel.setText("Abstract:");

        authorsDesLabel.setText("Authors:");

        keywordsDesLabel.setText("Keywords:");

        titleLabel.setText("--------");

        authorsScrollPane.setViewportView(authorsTable);

        abstractTextArea.setColumns(20);
        abstractTextArea.setRows(5);
        abstractScrollPane.setViewportView(abstractTextArea);

        keywordsScrollPane.setViewportView(keywordsTable);

        pdfWhButton.setText("Get PDF file with header");
        pdfWhButton.setToolTipText("");
        pdfWhButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfWhButtonActionPerformed(evt);
            }
        });

        pdfWohButton.setText("Get PDF file without header");
        pdfWohButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfWohButtonActionPerformed(evt);
            }
        });

        reFormattedFileButton.setText("Get re-formatted file");
        reFormattedFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reFormattedFileButtonActionPerformed(evt);
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
                        .addComponent(titleDesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleLabel))
                    .addComponent(abstractDesLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(abstractScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(keywordsDesLabel)
                                .addComponent(keywordsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(authorsDesLabel)
                                .addComponent(authorsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pdfWhButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pdfWohButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reFormattedFileButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel)
                    .addComponent(titleDesLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(abstractDesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(abstractScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keywordsDesLabel)
                    .addComponent(authorsDesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(authorsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(keywordsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pdfWhButton)
                    .addComponent(pdfWohButton)
                    .addComponent(reFormattedFileButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        abstractTextArea.setEditable(false);
		update();
    }

    private void pdfWhButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	JFileChooser fc = new JFileChooser();
    	File file = null;
    	
    	fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
    	fc.showSaveDialog(this);
    	
    	if (fc != null) {
    		file = fc.getSelectedFile();
    		try {
    			FileManager.getFile(paper.getHashWH(), file.getAbsolutePath());
    			MessageBox.information("Saved to selected location", this);
    		} catch (CmsysException e) {
    			MessageBox.error("Cannot save the file", this);
    		}
    	}
    }

    private void pdfWohButtonActionPerformed(java.awt.event.ActionEvent evt) {
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

    private void reFormattedFileButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	JFileChooser fc = new JFileChooser();
    	File file = null;
    	
    	fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
    	fc.showSaveDialog(this);
    	
    	if (fc != null) {
    		file = fc.getSelectedFile();
    		try {
    			FileManager.getFile(FinalPaper.getFinalPaperFileByPid(paper.getPid()), file.getAbsolutePath());
    			MessageBox.information("Saved to selected location", this);
    		} catch (CmsysException e) {
    			MessageBox.error("Cannot save the file", this);
    		}
    	}
    }
    
    private void update() {
    	Object[][] authorObj = null;
    	Object[][] keywordObj = null;
    	
    	
    	authorObj = new Object[paper.getAuthors().size()][2];
    	keywordObj = new Object[paper.getKeywords().size()][1];
    	
    	for (int i = 0; i < paper.getAuthors().size(); i++) {
    		authorObj[i][0] = paper.getAuthors().get(i).getLastName();
    		authorObj[i][1] = paper.getAuthors().get(i).getFirstName();
    	}
    	
    	for (int i = 0; i < paper.getKeywords().size(); i++) {
    		keywordObj[i][0] = paper.getKeywords().get(i);
    	}
    	
    	authorsModel = (new javax.swing.table.DefaultTableModel(authorObj, new String [] {"Last name", "First name"}) {
    				private static final long serialVersionUID = -7209185000492950827L;
    				public boolean isCellEditable(int row, int column) {return false;}
    			});
    	
    	keywordsModel = (new javax.swing.table.DefaultTableModel(keywordObj, new String [] {"Keyword"}) {
			private static final long serialVersionUID = -7212222869872950827L;
			public boolean isCellEditable(int row, int column) {return false;}
		});

    	authorsTable.setModel(authorsModel);
    	keywordsTable.setModel(keywordsModel);
    	
    	titleLabel.setText(paper.getTitle());
    	abstractTextArea.setText(paper.getPaperAbstract());
    }


    private javax.swing.JLabel abstractDesLabel;
    private javax.swing.JScrollPane abstractScrollPane;
    private javax.swing.JTextArea abstractTextArea;
    private javax.swing.JLabel authorsDesLabel;
    private javax.swing.JScrollPane authorsScrollPane;
    private javax.swing.JTable authorsTable;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel keywordsDesLabel;
    private javax.swing.JScrollPane keywordsScrollPane;
    private javax.swing.JTable keywordsTable;
    private javax.swing.JButton pdfWhButton;
    private javax.swing.JButton pdfWohButton;
    private javax.swing.JButton reFormattedFileButton;
    private javax.swing.JLabel titleDesLabel;
    private Paper paper;
    private DefaultTableModel authorsModel, keywordsModel;
}
