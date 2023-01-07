/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.SystemAdminWorkArea;

import model.EcoSystem;
import model.Network.Network;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author udaykk
 */
public class SelectNetwork extends javax.swing.JPanel {
    JPanel userProcessContainer;
    EcoSystem ecoSystem;
    /**
     * Creates new form SelectNetwork
     */
    public SelectNetwork(JPanel userProcessContainer, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecoSystem = ecoSystem;
        populateCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboxNetwork = new javax.swing.JComboBox<>();
        btnSelectNetwork = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));
        setLayout(null);

        cboxNetwork.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cboxNetwork);
        cboxNetwork.setBounds(270, 90, 170, 40);

        btnSelectNetwork.setText("Select Network");
        btnSelectNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectNetworkActionPerformed(evt);
            }
        });
        add(btnSelectNetwork);
        btnSelectNetwork.setBounds(270, 180, 170, 40);

        jButton1.setBackground(new java.awt.Color(0, 102, 204));
        jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("<<Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(10, 30, 80, 27);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectNetworkActionPerformed
        // TODO add your handling code here:
        for(Network network:ecoSystem.getNetworkList()){
            if(cboxNetwork.getSelectedItem().toString().equals(network.getName())){
                VaccineAnalyticsReportsJPanel manageEnterpriseAdminJPanel=new VaccineAnalyticsReportsJPanel(userProcessContainer, ecoSystem, network.getName());
                userProcessContainer.add("manageEnterpriseAdminJPanel",manageEnterpriseAdminJPanel);
                CardLayout layout=(CardLayout)userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            }
        }
    }//GEN-LAST:event_btnSelectNetworkActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelectNetwork;
    private javax.swing.JComboBox<String> cboxNetwork;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables

    private void populateCombo() {
        cboxNetwork.removeAllItems();
        for(Network network:ecoSystem.getNetworkList()){
            cboxNetwork.addItem(network.getName());
        }
    }
}