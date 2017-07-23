/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.fb.view;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dianeyanke
 */
public class TeamList extends javax.swing.JPanel {
    String path =
      "/Users/dianeyanke/NetBeansProjects/FantasyBaseball/build/classes/src/fb/resources/";
    String file = "baseballpic.jpg";
    MainBaseballFrame base;
    /**
     * Creates new form TeamList
     */
    public TeamList(MainBaseballFrame base) {
        initComponents();
        this.base = base;
        
        createTeamButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent evt) {
                base.switchPanel(base, new CreateTeam(base));
            }
    });
        
        /* Code to populate the table using userteam data */
        
        //conn is handled elsewhere, but we assume responsibility for closing it
        // ?? Can we guarantee that conn will not be null ?? 
        Connection conn = ConnectionSupplier.getMyConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
          stmt = conn.createStatement();
          rs = stmt.executeQuery("select U.teamID, U.salaryCap, U.name, U.login "
                                  + "from userteams U where \"" +
                                  MainBaseballFrame.getSessionUser() +
                                  "\" = U.login AND \"" +
                                  MainBaseballFrame.getSessionPassword() + 
                                  "\" = U.password;");
          
          populateTeamsTable(rs);
          
        } catch (SQLException e) {
            //TODO: add clean up
            BaseballUtilities.printSQLException(e);
        }
        finally {
           try {
           conn.close();
           if (stmt != null) { stmt.close(); }
           if (rs != null) { rs.close(); }
           } catch (SQLException e) {
               //TODO add clean up
               BaseballUtilities.printSQLException(e);
           }
            
        }
        
    }
    
    private void populateTeamsTable(ResultSet rs) {
        
        try {
            ResultSetMetaData meta = rs.getMetaData();
            
            //Table Header
            Vector<String> cols = new Vector<String>();
            int numCols = meta.getColumnCount();
            //numbering starts from 1!
            for (int currCol = 1; currCol <= numCols; currCol++) {
                cols.add(meta.getColumnName(currCol));
            }
            
            //Table Body
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> holder = new Vector<Object>();
                for (int currCol = 1; currCol <= numCols; currCol++) {
                    holder.add(rs.getObject(currCol));
                }
                data.add(holder);
            }
            
            teamsTable.setModel(new DefaultTableModel(data, cols));
           // teamsTable.fireTableDataChanged();
            
        } catch (SQLException e) {
            //TODO: add clean up
            BaseballUtilities.printSQLException(e);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        selectTeamButton = new javax.swing.JButton();
        createTeamButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        teamsTable = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Optima", 0, 24)); // NOI18N
        jLabel1.setText("Teams List");

        jLabel2.setIcon(new ImageIcon((Toolkit.getDefaultToolkit().getImage(path+file)).getScaledInstance(77, 63, Image.SCALE_DEFAULT)));
        jLabel2.setPreferredSize(new java.awt.Dimension(77, 63));

        selectTeamButton.setText("Select team.");
        selectTeamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectTeamButtonActionPerformed(evt);
            }
        });

        createTeamButton.setText("Create new team.");

        teamsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(teamsTable);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(selectTeamButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createTeamButton)
                .addContainerGap(158, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectTeamButton)
                    .addComponent(createTeamButton))
                .addGap(0, 18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void selectTeamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectTeamButtonActionPerformed
        //Figure out what the teamID is for the selected row
        int selectedRow = teamsTable.getSelectedRow();
        if (selectedRow < 0) return;
        int teamID = (Integer) teamsTable.getValueAt(selectedRow, 0);
        int salaryCap = (Integer) teamsTable.getValueAt(selectedRow, 1);
        String name = (String) teamsTable.getValueAt(selectedRow, 2);
        //Construct a new Team Display pane and add it to the main frame
        base.switchPanel(base, new TeamDisplay(base, teamID, salaryCap, name));
    }//GEN-LAST:event_selectTeamButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createTeamButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton selectTeamButton;
    private javax.swing.JTable teamsTable;
    // End of variables declaration//GEN-END:variables
}
