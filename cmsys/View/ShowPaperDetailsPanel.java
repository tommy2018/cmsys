package cmsys.View;

import javax.swing.table.DefaultTableModel;

import cmsys.PaperManagement.Paper;

public class ShowPaperDetailsPanel extends javax.swing.JPanel {

	private static final long serialVersionUID = 5931247799659801376L;
	public ShowPaperDetailsPanel(Paper paper) {
    	this.paper = paper;
        initComponents();
    }

    private void initComponents() {

        titleDesLabel = new javax.swing.JLabel();
        abstractDesLabel = new javax.swing.JLabel();
        keywordsDesLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        abstractScrollPane = new javax.swing.JScrollPane();
        abstractTextArea = new javax.swing.JTextArea();
        keywordsScrollPane = new javax.swing.JScrollPane();
        keywordsTable = new javax.swing.JTable();
        pdfWohButton = new javax.swing.JButton();

        titleDesLabel.setText("Title:");

        abstractDesLabel.setText("Abstract:");

        keywordsDesLabel.setText("Keywords:");

        titleLabel.setText("--------");

        abstractTextArea.setColumns(20);
        abstractTextArea.setRows(5);
        abstractScrollPane.setViewportView(abstractTextArea);

        keywordsScrollPane.setViewportView(keywordsTable);

        pdfWohButton.setText("Get PDF file");
        pdfWohButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfWohButtonActionPerformed(evt);
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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(abstractDesLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pdfWohButton))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(abstractScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(keywordsDesLabel)
                            .addGap(507, 507, 507))
                        .addComponent(keywordsScrollPane, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel)
                    .addComponent(titleDesLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(abstractDesLabel)
                    .addComponent(pdfWohButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(abstractScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(keywordsDesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(keywordsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        abstractTextArea.setEditable(false);
        update();
    }

    private void pdfWohButtonActionPerformed(java.awt.event.ActionEvent evt) {
    }
    
    private void update() {
    	Object[][] keywordObj = null;

    	keywordObj = new Object[paper.getKeywords().size()][1];
    	
    	for (int i = 0; i < paper.getKeywords().size(); i++) {
    		keywordObj[i][0] = paper.getKeywords().get(i);
    	}
    	
    	keywordsModel = (new javax.swing.table.DefaultTableModel(keywordObj, new String [] {"Keyword"}) {
			private static final long serialVersionUID = -7212222869872950827L;
			public boolean isCellEditable(int row, int column) {return false;}
		});
    	
    	keywordsTable.setModel(keywordsModel);


    	titleLabel.setText(paper.getTitle());
    	abstractTextArea.setText(paper.getPaperAbstract());
    }

    private javax.swing.JLabel abstractDesLabel;
    private javax.swing.JScrollPane abstractScrollPane;
    private javax.swing.JTextArea abstractTextArea;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel keywordsDesLabel;
    private javax.swing.JScrollPane keywordsScrollPane;
    private javax.swing.JTable keywordsTable;
    private javax.swing.JButton pdfWohButton;
    private javax.swing.JLabel titleDesLabel;
    private Paper paper;
    private DefaultTableModel keywordsModel;
}
