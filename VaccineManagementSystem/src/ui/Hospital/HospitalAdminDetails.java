/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.Hospital;

import model.EcoSystem;
import model.Employee.Employee;
import model.Enterprise.Enterprise;
import model.WorkQueue.Order;
import model.WorkQueue.Product;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.TwilioSMSUtil;
import static util.UtilClass.isOnlyTextWithWhiteSpaces;
import static util.UtilClass.isPhoneNumberVerified;
import static util.UtilClass.isValidTextString;

/**
 *
 * @author pawan
 */
public class HospitalAdminDetails extends javax.swing.JPanel {

    Enterprise enterprise;
    Order order;
    JPanel userProcessContainer;
    EcoSystem ecoSystem;

    /**
     * Creates new form CustomerDetails
     */
    public HospitalAdminDetails(JPanel userProcessContainer, Order order, Enterprise enterprise, EcoSystem ecoSystem) {
        initComponents();
        this.enterprise = enterprise;
        this.order = order;
        this.userProcessContainer = userProcessContainer;
        this.ecoSystem = ecoSystem;
        int total = 0;

        lblTotal.setText(String.valueOf(order.totalFDA()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtCard = new javax.swing.JTextField();
        btnCompletePayment = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtxtMobile = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 204, 204));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel1.setText("Name");
        add(jLabel1);
        jLabel1.setBounds(590, 330, 60, 30);

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel2.setText("CardNumber");
        add(jLabel2);
        jLabel2.setBounds(580, 390, 100, 30);

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        add(txtName);
        txtName.setBounds(676, 323, 210, 40);
        add(txtCard);
        txtCard.setBounds(680, 390, 210, 40);

        btnCompletePayment.setBackground(new java.awt.Color(0, 153, 0));
        btnCompletePayment.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        btnCompletePayment.setForeground(new java.awt.Color(255, 255, 255));
        btnCompletePayment.setText("Complete payment");
        btnCompletePayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompletePaymentActionPerformed(evt);
            }
        });
        add(btnCompletePayment);
        btnCompletePayment.setBounds(730, 570, 230, 70);

        btnBack.setBackground(new java.awt.Color(0, 102, 204));
        btnBack.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(17, 9, 110, 40);

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel3.setText("Order Total:");
        add(jLabel3);
        jLabel3.setBounds(580, 260, 110, 50);

        lblTotal.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblTotal.setText("<Order Total>");
        add(lblTotal);
        lblTotal.setBounds(691, 267, 160, 40);

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setText("Mobile No");
        add(jLabel4);
        jLabel4.setBounds(590, 470, 162, 18);
        add(jtxtMobile);
        jtxtMobile.setBounds(680, 460, 210, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnCompletePaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompletePaymentActionPerformed
        // TODO add your handling code here:
        try {
            if (!isOnlyTextWithWhiteSpaces(txtName.getText())) {
                JOptionPane.showMessageDialog(this, "Please enter valid name");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please enter valid name");
        }

        try {
            if (!isValidTextString(txtCard.getText())) {
                JOptionPane.showMessageDialog(this, "Please enter valid card no");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please enter valid card no");
        }

        try {
            if (!isPhoneNumberVerified(jtxtMobile.getText())) {
                JOptionPane.showMessageDialog(this, "Please enter valid phone");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please enter valid phone");
        }
        
        if (order.getProductList().size() == 0) {
            JOptionPane.showMessageDialog(this, "Please add items to the cart");
            return;
        }
        if (txtCard.getText().isEmpty() || txtName.getText().isEmpty() || jtxtMobile.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are mandatory");
            return;
        }
        if (checkCardValid(txtCard.getText())) {
            Employee customer = new Employee(txtName.getText(), txtCard.getText());
            Order newOrder = new Order();
            newOrder.setNetworkName(order.getNetworkName());
            newOrder.setSender(order.getSender());
            newOrder.setSenderEnterprise(order.getSenderEnterprise());
            newOrder.setReceiverEnterprise(order.getReceiverEnterprise());
            newOrder.setStatus("waiting for FDA to accept");
            for (Product prod : order.getProductList()) {
                newOrder.getProductList().add(prod);
            }
            ecoSystem.getWorkQueue().getWorkRequestList().add(newOrder);
            JOptionPane.showMessageDialog(this, "Thankyou for shopping with us");
            order.setStatus("waiting for FDA admin to accept");
            order.getProductList().clear();
            String mobile = "+1" + jtxtMobile.getText();
            TwilioSMSUtil
                    .sendTextMessage(mobile,
                            "Hi " + txtName.getText() + ", " + "Thank you for choosing us. Your payment has been debited from Card ending xxxx" + txtCard.getText().substring(12) + ". Stay safe and Healthy.");

            redirectBackAfterPayemnt();
        } else {
            JOptionPane.showMessageDialog(this, "Please enter valid card number");
        }
    }//GEN-LAST:event_btnCompletePaymentActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        redirectBackAfterPayemnt();
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCompletePayment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jtxtMobile;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTextField txtCard;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
    public boolean checkCardValid(String card) {
        Pattern pattern = Pattern.compile("^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(card);
        return matcher.find();
    }

    public void redirectBackAfterPayemnt() {
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        BuyProductsFromFDA dwjp = (BuyProductsFromFDA) component;
        dwjp.populateProductList();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }
}