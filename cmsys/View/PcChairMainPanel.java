package cmsys.View;

import java.util.ArrayList;

import javax.swing.JTextArea;

import cmsys.Common.CmsysException;
import cmsys.Common.CronJob;
import cmsys.Common.Log;
import cmsys.Common.Settings;
import cmsys.Common.UserDefault;
import cmsys.UserManagement.User;

public class PcChairMainPanel extends javax.swing.JPanel {

	private static final long serialVersionUID = 3423186180949616268L;
	public PcChairMainPanel() {
		
        initComponents();
        UserDefault userDefault = UserDefault.getInstance();
        User user = (User)(userDefault.getObj("user"));
        
        ArrayList<Log> logList;
		try {
			logList = Log.getLogByUid(user.getUID());
			String temp = "";
			for (Log log: logList) {
	        	temp += log.getMessage() + '\n';
	        }
			latestEventsTextArea.setText(temp);
		} catch (CmsysException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        latestEventsScrollPane = new javax.swing.JScrollPane();
        latestEventsDesLabel = new javax.swing.JLabel();
        mainTabbedPane = new javax.swing.JTabbedPane();
        latestEventsTextArea = new JTextArea();
        
        latestEventsTextArea.setEditable(false);
        latestEventsTextArea.setColumns(20);
        latestEventsTextArea.setRows(5);
        latestEventsScrollPane.setViewportView(latestEventsTextArea);

        latestEventsDesLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        latestEventsDesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        latestEventsDesLabel.setText("Latest events:");

        try {
        	CronJob.updateSystemStatus();
        	int status = Integer.parseInt(Settings.getSettingFromDB("status"));
        	
			if (status == 2){
				mainTabbedPane.addTab("Distribution", new DistributionPanel());
				mainTabbedPane.addTab("Papers", new PapersPanel());
			} else {
				mainTabbedPane.addTab("Papers", new PapersPanel());
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
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel latestEventsDesLabel;
    private javax.swing.JScrollPane latestEventsScrollPane;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JTextArea latestEventsTextArea;
    // End of variables declaration//GEN-END:variables
}
