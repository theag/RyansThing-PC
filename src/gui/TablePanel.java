/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.Table;
import data.TableEntry;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author nbp184
 */
public class TablePanel extends javax.swing.JPanel {
    
    javax.swing.JPanel current;

    /**
     * Creates new form TablePanel
     * @param tbl
     */
    public TablePanel(Table tbl) {
        initComponents();
        rbTextRollon.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbgTypeActionPerformed(evt);
            }
        });
        if(tbl != null) {
            txtName.setText(tbl.name);
            if(tbl.hasItems()) {
                current = new ItemsPanel(tbl.getEntries());
                current.setName("items");
            } else {
                rbTextRollon.setSelected(true);
                current = new TextRollonPanel(tbl.text, tbl.getRollon());
                current.setName("textrollon");
            }
        } else {
            current = new ItemsPanel(null);
            current.setName("items");
        }
        pnlType.setLayout(new BorderLayout());
        pnlType.add(current, BorderLayout.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbgType = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        rbTextRollon = new javax.swing.JRadioButton();
        rbItems = new javax.swing.JRadioButton();
        pnlType = new javax.swing.JPanel();
        btnUpdateTab = new javax.swing.JButton();
        btnDeleteTable = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Name:");

        txtName.setColumns(20);

        rbTextRollon.setBackground(new java.awt.Color(255, 255, 255));
        rbgType.add(rbTextRollon);
        rbTextRollon.setText("Text & Rollon");

        rbItems.setBackground(new java.awt.Color(255, 255, 255));
        rbgType.add(rbItems);
        rbItems.setSelected(true);
        rbItems.setText("Items");
        rbItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbgTypeActionPerformed(evt);
            }
        });

        pnlType.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlTypeLayout = new javax.swing.GroupLayout(pnlType);
        pnlType.setLayout(pnlTypeLayout);
        pnlTypeLayout.setHorizontalGroup(
            pnlTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlTypeLayout.setVerticalGroup(
            pnlTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        btnUpdateTab.setText("Update Tab");
        btnUpdateTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTabActionPerformed(evt);
            }
        });

        btnDeleteTable.setText("Delete Table");
        btnDeleteTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbItems)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbTextRollon))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdateTab))
                    .addComponent(btnDeleteTable))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateTab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbItems)
                    .addComponent(rbTextRollon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteTable)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rbgTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbgTypeActionPerformed
        if(rbItems.isSelected() && current.getName().compareTo("items") != 0) {
            pnlType.remove(current);
            current = new ItemsPanel(null);
            current.setName("items");
            pnlType.add(current, BorderLayout.CENTER);
            pnlType.validate();
            pnlType.repaint();
        } else if(rbTextRollon.isSelected() && current.getName().compareTo("textrollon") != 0) {
            pnlType.remove(current);
            current = new TextRollonPanel(null, null);
            current.setName("textrollon");
            pnlType.add(current, BorderLayout.CENTER);
            pnlType.validate();
            pnlType.repaint();
        }
    }//GEN-LAST:event_rbgTypeActionPerformed

    private void btnUpdateTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTabActionPerformed
        String name = txtName.getText().trim();
        if(name.isEmpty()) {
            name = "New Table";
        }
        TablePanelListener[] listeners = listenerList.getListeners(TablePanelListener.class);
        for(TablePanelListener listener : listeners) {
            listener.nameChanged(name);
        }
    }//GEN-LAST:event_btnUpdateTabActionPerformed

    private void btnDeleteTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTableActionPerformed
        int result = JOptionPane.showConfirmDialog(this.getParent(), "Are you sure you wish to delete this table?\nIt cannot be undone.", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION) {
            TablePanelListener[] listeners = listenerList.getListeners(TablePanelListener.class);
            for(TablePanelListener listener : listeners) {
                listener.removeMe();
            }
        }
    }//GEN-LAST:event_btnDeleteTableActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteTable;
    private javax.swing.JButton btnUpdateTab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnlType;
    private javax.swing.JRadioButton rbItems;
    private javax.swing.JRadioButton rbTextRollon;
    private javax.swing.ButtonGroup rbgType;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

    public void addTablePanelListener(TablePanelListener listener) {
        listenerList.add(TablePanelListener.class, listener);
    }

    Table getTable() {
        Table rv = new Table(txtName.getText().trim());
        if(rbItems.isSelected()) {
            ItemsPanel ip = (ItemsPanel)current;
            for(TableEntry te : ip.items) {
                rv.addEntry(te, 1);
            }
        } else if(rbTextRollon.isSelected()) {
            TextRollonPanel trp = (TextRollonPanel)current;
            rv.text = trp.getTableText();
            for(String s : trp.rollon) {
                rv.addRollon(s);
            }
        } else {
            System.out.println("nope");
        }
        return rv;
    }
}
