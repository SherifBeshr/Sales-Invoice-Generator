
package sig.view;

import javax.swing.JTextField;


/**
 *
 * @author Sherif
 */
public class InvoiceDialog extends javax.swing.JDialog{

    /**
     * Creates new form createInvoiceDialog
     * @param frame
     */
    public InvoiceDialog(MainFrame frame){

        initComponents();
        setLocationRelativeTo(null);        // Set location to center
        
        okInvoiceBtn.addActionListener(frame.getHandler());
        cancelInvoiceBtn.addActionListener(frame.getHandler());
        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        invoiceDateField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        customerNameField = new javax.swing.JTextField();
        okInvoiceBtn = new javax.swing.JButton();
        //NewInvoiceOk.addActionListener(handler);
        cancelInvoiceBtn = new javax.swing.JButton();
        //cancelInvoiceBtn.addActionListener(mainframe.handler);
        //cancelInvoiceBtn..addActionListener(frame.getActionHandler());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create New Invoice");

        jLabel3.setText("Invoice Date");

        invoiceDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceDateFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Customer Name");

        okInvoiceBtn.setText("Ok");
        okInvoiceBtn.setActionCommand("New Inv Ok");
        okInvoiceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okInvoiceBtnActionPerformed(evt);
            }
        });

        cancelInvoiceBtn.setText("Cancel");
        cancelInvoiceBtn.setActionCommand("New Inv Cancel");
        cancelInvoiceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelInvoiceBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invoiceDateField)
                            .addComponent(customerNameField)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(okInvoiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(cancelInvoiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(invoiceDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(customerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okInvoiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelInvoiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void invoiceDateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceDateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_invoiceDateFieldActionPerformed

    private void cancelInvoiceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelInvoiceBtnActionPerformed

    }//GEN-LAST:event_cancelInvoiceBtnActionPerformed

    private void okInvoiceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okInvoiceBtnActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_okInvoiceBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelInvoiceBtn;
    private javax.swing.JTextField customerNameField;
    private javax.swing.JTextField invoiceDateField;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton okInvoiceBtn;
    // End of variables declaration//GEN-END:variables

    public JTextField getCustomerNameField() {
        return customerNameField;
    }

    public JTextField getInvoiceDateField() {
        return invoiceDateField;
    }


}
