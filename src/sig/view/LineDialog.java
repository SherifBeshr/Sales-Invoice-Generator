/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package sig.view;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Sherif
 */
public class LineDialog extends javax.swing.JDialog {

    /**
     * Creates new form LineDialogz
     * @param frame
     */
    public LineDialog(MainFrame frame) {
        initComponents();
        setLocationRelativeTo(null);        // Set location to center
        
        okNewLine.addActionListener(frame.getHandler());
        cancelNewLine.addActionListener(frame.getHandler());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        itemNameField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        itemCountField = new javax.swing.JTextField();
        okNewLine = new javax.swing.JButton();
        cancelNewLine = new javax.swing.JButton();
        itemPriceField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create New Item");

        itemNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNameFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Item Count");

        okNewLine.setText("Ok");
        okNewLine.setActionCommand("New Line Ok");
        okNewLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okNewLineActionPerformed(evt);
            }
        });

        cancelNewLine.setText("Cancel");
        cancelNewLine.setActionCommand("New Line Cancel");
        cancelNewLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelNewLineActionPerformed(evt);
            }
        });

        jLabel5.setText("Item Price");

        jLabel3.setText("Item Name");

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
                            .addComponent(itemNameField)
                            .addComponent(itemCountField)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(okNewLine, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(cancelNewLine, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(itemPriceField)
                        .addGap(1, 1, 1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(itemNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(itemCountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(itemPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okNewLine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelNewLine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemNameFieldActionPerformed

    private void okNewLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okNewLineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_okNewLineActionPerformed

    private void cancelNewLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelNewLineActionPerformed

    }//GEN-LAST:event_cancelNewLineActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelNewLine;
    private javax.swing.JTextField itemCountField;
    private javax.swing.JTextField itemNameField;
    private javax.swing.JTextField itemPriceField;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton okNewLine;
    // End of variables declaration//GEN-END:variables

    public JButton getCancelNewLine() {
        return cancelNewLine;
    }

    public JTextField getItemCountField() {
        return itemCountField;
    }

    public JTextField getItemNameField() {
        return itemNameField;
    }

    public JTextField getItemPriceField() {
        return itemPriceField;
    }


}
