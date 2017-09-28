/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.InitiativeTracker;
import data.JournalCalendar;
import data.LogLoad;
import data.ReadTable;
import data.Table;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author nbp184
 */
public class MainFrame extends javax.swing.JFrame {

    private Log log;
    private ArrayList<Table> tables;
    private JournalCalendar jc;
    private InitiativeTracker it;
    private JFileChooser fc;
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        setLocationRelativeTo(null);
        try {
            log = new Log(txtLog);
            lblLog.setText(log.getLabel());
            tables = new ArrayList<>();
            File dir = new File(IniFile.getInstance().tables);
            File[] files = dir.listFiles();
            if(files != null) {
                for(File file : files) {
                    ReadTable.read(file, tables);
                }
            }
            lstSecondaryTables.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    lstTablesMouseClicked(evt);
                }
            });
            lstMainTables.setListData(getMain(tables));
            lstSecondaryTables.setListData(getSecondary(tables));
            jc = new JournalCalendar();
            it = new InitiativeTracker();
            fc = new JFileChooser();
            fc.setFileFilter(new FileFilter() {

                @Override
                public boolean accept(File f) {
                    return f.isDirectory() || f.getName().endsWith(".txt");
                }

                @Override
                public String getDescription() {
                    return "Text files (*.txt)";
                }
            });
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage()+"\n"+ex.getClass().getName(), "Error", JOptionPane.ERROR_MESSAGE);
            this.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JTextArea();
        lblLog = new javax.swing.JLabel();
        txtTableSearch = new javax.swing.JTextField();
        btnCurrentTime = new javax.swing.JButton();
        btnAddHour = new javax.swing.JButton();
        bntAddDay = new javax.swing.JButton();
        btnAddWeek = new javax.swing.JButton();
        btnAddSeason = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnWildTurn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnDunTurn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        bntHavenTurn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnCurrentRoundTurn = new javax.swing.JButton();
        btnAddYear = new javax.swing.JButton();
        btnAddRound = new javax.swing.JButton();
        btnLoadLog = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstMainTables = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstSecondaryTables = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txtLog.setColumns(20);
        txtLog.setRows(5);
        jScrollPane2.setViewportView(txtLog);

        lblLog.setText("jLabel1");

        txtTableSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTableSearchActionPerformed(evt);
            }
        });

        btnCurrentTime.setText("Current Time");
        btnCurrentTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCurrentTimeActionPerformed(evt);
            }
        });

        btnAddHour.setText("Add Hour");
        btnAddHour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddHourActionPerformed(evt);
            }
        });

        bntAddDay.setText("Add Day");
        bntAddDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAddDayActionPerformed(evt);
            }
        });

        btnAddWeek.setText("Add Week");
        btnAddWeek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddWeekActionPerformed(evt);
            }
        });

        btnAddSeason.setText("Add Season");
        btnAddSeason.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSeasonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Hazards");

        btnWildTurn.setText("Turn");
        btnWildTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWildTurnActionPerformed(evt);
            }
        });

        jLabel2.setText("Wilderness");

        btnDunTurn.setText("Turn");
        btnDunTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDunTurnActionPerformed(evt);
            }
        });

        jLabel3.setText("Dungeon");

        bntHavenTurn.setText("Turn");
        bntHavenTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntHavenTurnActionPerformed(evt);
            }
        });

        jLabel4.setText("Haven");

        btnCurrentRoundTurn.setText("Current Round/Turn");
        btnCurrentRoundTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCurrentRoundTurnActionPerformed(evt);
            }
        });

        btnAddYear.setText("Add Year");
        btnAddYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddYearActionPerformed(evt);
            }
        });

        btnAddRound.setText("Add Round");
        btnAddRound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRoundActionPerformed(evt);
            }
        });

        btnLoadLog.setText("Load Log");
        btnLoadLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadLogActionPerformed(evt);
            }
        });

        lstMainTables.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lstMainTables.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstMainTables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstTablesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(lstMainTables);

        jTabbedPane1.addTab("Main", jScrollPane3);

        lstSecondaryTables.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lstSecondaryTables.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(lstSecondaryTables);

        jTabbedPane1.addTab("Secondary", jScrollPane4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTableSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblLog)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLoadLog)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bntHavenTurn)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnDunTurn)
                                            .addComponent(btnWildTurn))
                                        .addGap(45, 45, 45)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnAddRound)
                                            .addComponent(btnCurrentRoundTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCurrentTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddHour, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bntAddDay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddWeek, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddSeason, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(46, 46, 46))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCurrentTime)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddHour)
                            .addComponent(btnWildTurn)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAddRound)
                        .addGap(15, 15, 15)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntAddDay)
                    .addComponent(btnDunTurn)
                    .addComponent(jLabel3)
                    .addComponent(btnCurrentRoundTurn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddWeek)
                    .addComponent(bntHavenTurn)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddSeason)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddYear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadLog)
                    .addComponent(lblLog))
                .addGap(6, 6, 6))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(txtTableSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        log.save();
    }//GEN-LAST:event_formWindowClosing

    private void txtTableSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTableSearchActionPerformed
        if(txtTableSearch.getText().isEmpty()) {
            lstMainTables.setListData(getMain(tables));
            lstSecondaryTables.setListData(getSecondary(tables));
        } else {
            ArrayList<Table> search = new ArrayList<>();
            String searchText = txtTableSearch.getText().toLowerCase();
            for(Table t : tables) {
                if(t.name.toLowerCase().contains(searchText)) {
                    search.add(t);
                }
            }
            lstMainTables.setListData(getMain(search));
            lstSecondaryTables.setListData(getSecondary(search));
        }
    }//GEN-LAST:event_txtTableSearchActionPerformed

    private void btnCurrentTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCurrentTimeActionPerformed
        log.addText(jc.toString());
    }//GEN-LAST:event_btnCurrentTimeActionPerformed

    private void btnAddHourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddHourActionPerformed
        jc.addTime(JournalCalendar.HOUR);
        log.addText(jc.toString());
    }//GEN-LAST:event_btnAddHourActionPerformed

    private void bntAddDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAddDayActionPerformed
        jc.addTime(JournalCalendar.DAY);
        log.addText(jc.toString());
    }//GEN-LAST:event_bntAddDayActionPerformed

    private void btnAddWeekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddWeekActionPerformed
        jc.addTime(JournalCalendar.WEEK);
        log.addText(jc.toString());
    }//GEN-LAST:event_btnAddWeekActionPerformed

    private void btnAddSeasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSeasonActionPerformed
        jc.addTime(JournalCalendar.SEASON);
        log.addText(jc.toString());
    }//GEN-LAST:event_btnAddSeasonActionPerformed

    private void btnWildTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWildTurnActionPerformed
        it.addTurn();
        for(Table t : tables) {
            if(t.name.compareTo("Wilderness Hazards") == 0) {
                log.addText(it.toString() +": " +doRoll(t));
                break;
            }
        }
    }//GEN-LAST:event_btnWildTurnActionPerformed

    private void btnDunTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDunTurnActionPerformed
        it.addTurn();
        for(Table t : tables) {
            if(t.name.compareTo("Dungeon Hazards") == 0) {
                log.addText(it.toString() +": " +doRoll(t));
                break;
            }
        }
    }//GEN-LAST:event_btnDunTurnActionPerformed

    private void bntHavenTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntHavenTurnActionPerformed
        it.addTurn();
        for(Table t : tables) {
            if(t.name.compareTo("Haven Hazards") == 0) {
                log.addText(it.toString() +": " +doRoll(t));
                break;
            }
        }
    }//GEN-LAST:event_bntHavenTurnActionPerformed

    private void btnCurrentRoundTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCurrentRoundTurnActionPerformed
        log.addText(it.toString());
    }//GEN-LAST:event_btnCurrentRoundTurnActionPerformed

    private void btnAddYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddYearActionPerformed
        jc.addTime(JournalCalendar.YEAR);
        log.addText(jc.toString());
    }//GEN-LAST:event_btnAddYearActionPerformed

    private void btnAddRoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRoundActionPerformed
        it.addRound();
        log.addText(it.toString());
    }//GEN-LAST:event_btnAddRoundActionPerformed

    private void btnLoadLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadLogActionPerformed
        int result = fc.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION) {
            log = new Log(txtLog, fc.getSelectedFile());
            try {
                LogLoad ll = LogLoad.loadLog(fc.getSelectedFile());
                it = ll.initiativeTracker;
                jc = ll.journalCalendar;
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
                System.out.println(ex.getLocalizedMessage());
                JOptionPane.showMessageDialog(null, "Error reading log.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnLoadLogActionPerformed

    private void lstTablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstTablesMouseClicked
        if(evt.getClickCount() == 2) {
            javax.swing.JList lst = (javax.swing.JList)evt.getSource();
            log.addText(doRoll((Table)lst.getSelectedValue()));
        }
    }//GEN-LAST:event_lstTablesMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAddDay;
    private javax.swing.JButton bntHavenTurn;
    private javax.swing.JButton btnAddHour;
    private javax.swing.JButton btnAddRound;
    private javax.swing.JButton btnAddSeason;
    private javax.swing.JButton btnAddWeek;
    private javax.swing.JButton btnAddYear;
    private javax.swing.JButton btnCurrentRoundTurn;
    private javax.swing.JButton btnCurrentTime;
    private javax.swing.JButton btnDunTurn;
    private javax.swing.JButton btnLoadLog;
    private javax.swing.JButton btnWildTurn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblLog;
    private javax.swing.JList lstMainTables;
    private javax.swing.JList lstSecondaryTables;
    private javax.swing.JTextArea txtLog;
    private javax.swing.JTextField txtTableSearch;
    // End of variables declaration//GEN-END:variables

    private String doRoll(Table t) {
        String result = t.roll();
        while(result.contains("<")) {
            int i1 = result.indexOf("<");
            int i2 = result.indexOf(">");
            String tName = result.substring(i1+1, i2);
            boolean foundTable = false;
            for(Table o : tables) {
                if(o.name.compareTo(tName) == 0) {
                    result = result.substring(0, i1) +o.roll() +result.substring(i2+1);
                    foundTable = true;
                    break;
                }
            }
            if(!foundTable) {
                JOptionPane.showMessageDialog(this, "Can't find table \"" +tName +"\".", "Error", JOptionPane.ERROR_MESSAGE);
                result = result.replace("<" +tName +">", "(" +tName +")");
            }
        }
        return result;
    }
    
    private Table[] getMain(ArrayList<Table> tblList) {
        int count = 0;
        for(Table t : tblList) {
            if(t.isMain) {
                count++;
            }
        }
        Table[] rv = new Table[count];
        count = 0;
        for(Table t : tblList) {
            if(t.isMain) {
                rv[count++] = t;
            }
        }
        return rv;
    }

    private Table[] getSecondary(ArrayList<Table> tblList) {
        int count = 0;
        for(Table t : tblList) {
            if(!t.isMain) {
                count++;
            }
        }
        Table[] rv = new Table[count];
        count = 0;
        for(Table t : tblList) {
            if(!t.isMain) {
                rv[count++] = t;
            }
        }
        return rv;
    }
}
