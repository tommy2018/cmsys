package cmsys.View;

public class AdminMainPanel extends javax.swing.JPanel {

	private static final long serialVersionUID = -7532613715890438420L;
	public AdminMainPanel() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        latestEventsScrollPane = new javax.swing.JScrollPane();
        latestEventsTextArea = new javax.swing.JTextArea();
        latestEventsDesLabel = new javax.swing.JLabel();
        mainTabbedPane = new javax.swing.JTabbedPane();

        latestEventsTextArea.setColumns(20);
        latestEventsTextArea.setRows(5);
        latestEventsScrollPane.setViewportView(latestEventsTextArea);

        latestEventsDesLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        latestEventsDesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        latestEventsDesLabel.setText("Latest events:");


        mainTabbedPane.addTab("User management", new UserManagementPanel());
        mainTabbedPane.addTab("System settings", new SystemSettingsPanel());
        mainTabbedPane.addTab("My details", new MyDetailsPanel());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(latestEventsDesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(latestEventsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(mainTabbedPane)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mainTabbedPane)
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }


    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel latestEventsDesLabel;
    private javax.swing.JScrollPane latestEventsScrollPane;
    private javax.swing.JTextArea latestEventsTextArea;
    private javax.swing.JTabbedPane mainTabbedPane;
}
