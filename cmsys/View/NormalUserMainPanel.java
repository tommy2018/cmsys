package cmsys.View;

import java.util.ArrayList;

import cmsys.Common.CmsysException;
import cmsys.Common.Log;
import cmsys.Common.UserDefault;
import cmsys.UserManagement.User;

public class NormalUserMainPanel extends javax.swing.JPanel {

	private static final long serialVersionUID = -4851645849373554801L;
	public NormalUserMainPanel() {
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
        latestEventsTextArea = new javax.swing.JTextArea();
        latestEventsDesLabel = new javax.swing.JLabel();
        mainTabbedPane = new javax.swing.JTabbedPane();
        myPapersPanel = new MyPapersPanel();
        myDetailsPanel = new MyDetailsPanel();

        latestEventsTextArea.setColumns(20);
        latestEventsTextArea.setRows(5);
        latestEventsScrollPane.setViewportView(latestEventsTextArea);

        latestEventsDesLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        latestEventsDesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        latestEventsDesLabel.setText("Latest events:");

        mainTabbedPane.addTab("My papers", myPapersPanel);
        mainTabbedPane.addTab("My details", myDetailsPanel);

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

    private javax.swing.JPanel myPapersPanel;
    private javax.swing.JPanel myDetailsPanel;
    private javax.swing.JLabel latestEventsDesLabel;
    private javax.swing.JScrollPane latestEventsScrollPane;
    private javax.swing.JTextArea latestEventsTextArea;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTabbedPane mainTabbedPane;
}
