package cmsys.View;

import cmsys.Common.CmsysException;
import cmsys.Common.Settings;

public class PcMemberMainPanel extends javax.swing.JPanel {

	private static final long serialVersionUID = 4393487725248070121L;
	public PcMemberMainPanel() {
        initComponents();
    }

    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        latestEventsScrollPane = new javax.swing.JScrollPane();
        latestEventsTextArea = new javax.swing.JTextArea();
        latestEventsDesLabel = new javax.swing.JLabel();
        mainTabbedPane = new javax.swing.JTabbedPane();

        latestEventsTextArea.setEditable(false);
        latestEventsTextArea.setColumns(20);
        latestEventsTextArea.setRows(5);
        latestEventsScrollPane.setViewportView(latestEventsTextArea);

        latestEventsDesLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        latestEventsDesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        latestEventsDesLabel.setText("Latest events:");

        try {
        	int status = Integer.parseInt(Settings.getSettingFromDB("status"));
        	
			if (status == 1){
				mainTabbedPane.addTab("Review", new PcMemberReviewPreferencePanel());
			} else if (status == 3) {
				mainTabbedPane.addTab("Review", new PcMemberReviewPanel());
			} else {
				MessageBox.information("Submission in progress, no action available at the moment", this);
			}
			
		}catch (CmsysException e) {}
        
        mainTabbedPane.addTab("My details", new MyDetailsPanel());

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(latestEventsDesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(latestEventsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(mainTabbedPane)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mainTabbedPane)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(latestEventsDesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(latestEventsScrollPane)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }


    private javax.swing.JLabel latestEventsDesLabel;
    private javax.swing.JScrollPane latestEventsScrollPane;
    private javax.swing.JTextArea latestEventsTextArea;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTabbedPane mainTabbedPane;
}
