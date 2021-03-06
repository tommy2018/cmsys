package cmsys.View;

@SuppressWarnings("serial")
public class SystemSettingsPanel extends javax.swing.JPanel {

    public SystemSettingsPanel() {
        initComponents();
    }
    private void initComponents() {

        submittionDeadlineDesLabel = new javax.swing.JLabel();
        numOfPapersDesLabel = new javax.swing.JLabel();
        conferenceNameDesLabel = new javax.swing.JLabel();
        conferenceLocationDesLabel = new javax.swing.JLabel();
        conferenceNameTextField = new javax.swing.JTextField();
        submittionDeadlineTextField = new javax.swing.JTextField();
        conferenceLocationTextField = new javax.swing.JTextField();
        numOfPapersTextField = new javax.swing.JTextField();
        otherOptionsPanel = new javax.swing.JPanel();
        closeSubmittionButton = new javax.swing.JButton();
        finaliseButton = new javax.swing.JButton();
        closeSubmittionDesLabel = new javax.swing.JLabel();
        finaliseDesLabel = new javax.swing.JLabel();
        applySettingsButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();

        submittionDeadlineDesLabel.setText("Submission deadline:");

        numOfPapersDesLabel.setText("Number of papers to be distribuited to a PC memeber:");

        conferenceNameDesLabel.setText("Conference name:");

        conferenceLocationDesLabel.setText("Conference loaction:");

        numOfPapersTextField.setToolTipText("");

        otherOptionsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Other options"));

        closeSubmittionButton.setText("Close the submittion now!");

        finaliseButton.setText("Finalise this conference");
        finaliseButton.setToolTipText("");

        closeSubmittionDesLabel.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        closeSubmittionDesLabel.setForeground(java.awt.Color.red);
        closeSubmittionDesLabel.setText("<html>- Close the submittion manually.<br>- No more submittion will be accepted.<br>- Papers will be distributed to PC members.</html>");

        finaliseDesLabel.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        finaliseDesLabel.setForeground(java.awt.Color.red);
        finaliseDesLabel.setText("<html>- Close and archive this conference.<br>- No more changes can be made.<br>- Normal users and authors no longer have access<br>to the system.</html>");

        javax.swing.GroupLayout otherOptionsPanelLayout = new javax.swing.GroupLayout(otherOptionsPanel);
        otherOptionsPanel.setLayout(otherOptionsPanelLayout);
        otherOptionsPanelLayout.setHorizontalGroup(
            otherOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(otherOptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(otherOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(closeSubmittionButton)
                    .addComponent(finaliseButton)
                    .addComponent(closeSubmittionDesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finaliseDesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        otherOptionsPanelLayout.setVerticalGroup(
            otherOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(otherOptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(closeSubmittionButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeSubmittionDesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(finaliseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(finaliseDesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        applySettingsButton.setText("Apply settings");

        clearButton.setText("Clear");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(clearButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(applySettingsButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(conferenceLocationDesLabel)
                                    .addComponent(conferenceNameDesLabel)
                                    .addComponent(numOfPapersDesLabel))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(conferenceNameTextField)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(submittionDeadlineDesLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(submittionDeadlineTextField)
                            .addComponent(conferenceLocationTextField)
                            .addComponent(numOfPapersTextField)
                            .addComponent(otherOptionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(conferenceNameDesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(conferenceNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(conferenceLocationDesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(conferenceLocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(submittionDeadlineDesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submittionDeadlineTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(numOfPapersDesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numOfPapersTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(otherOptionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(applySettingsButton)
                    .addComponent(clearButton))
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applySettingsButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton closeSubmittionButton;
    private javax.swing.JLabel closeSubmittionDesLabel;
    private javax.swing.JLabel conferenceLocationDesLabel;
    private javax.swing.JTextField conferenceLocationTextField;
    private javax.swing.JLabel conferenceNameDesLabel;
    private javax.swing.JTextField conferenceNameTextField;
    private javax.swing.JButton finaliseButton;
    private javax.swing.JLabel finaliseDesLabel;
    private javax.swing.JLabel numOfPapersDesLabel;
    private javax.swing.JTextField numOfPapersTextField;
    private javax.swing.JPanel otherOptionsPanel;
    private javax.swing.JLabel submittionDeadlineDesLabel;
    private javax.swing.JTextField submittionDeadlineTextField;
    // End of variables declaration//GEN-END:variables
}
