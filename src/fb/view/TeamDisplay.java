/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.fb.view;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dianeyanke
 */
public class TeamDisplay extends javax.swing.JPanel {
    private final String path =
      "/Users/dianeyanke/NetBeansProjects/FantasyBaseball/build/classes/src/fb/resources/";
    private final String file = "baseballpic.jpg";
    private MainBaseballFrame base;
    private int teamID;
    
    /**
     * Creates new form TeamDisplay
     */
    public TeamDisplay(MainBaseballFrame base, int teamID, int sal, String name) {
        initComponents();
        this.base = base;
        this.teamID = teamID;
        lbName.setText(name);
        lbSalary.setText("$" + sal);
        
        //Populate the display table with any player belonging to this team
        Connection conn = ConnectionSupplier.getMyConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
          stmt = conn.createStatement();
          rs = stmt.executeQuery("select P.playerID, P.nameFirst, P.nameLast,"
                                  + " P.debut, P.finalGame "
                                  + "from on_user_team U, player P " 
                                  + "where U.playerID = P.playerID AND "
                                  + "U.teamID = " + teamID + ";");
          
          populatePlayersTable(rs);
          
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
    
    private void populatePlayersTable(ResultSet rs) {
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
            
            tblPlayers.setModel(new DefaultTableModel(data, cols));
           // tblPlayers.fireTableDataChanged();
            
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
        lbName = new javax.swing.JLabel();
        lbSalary = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlayers = new javax.swing.JTable();
        btReview = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btAdd = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Optima", 0, 24)); // NOI18N
        jLabel1.setText("Team Display");

        jLabel2.setIcon(new ImageIcon((Toolkit.getDefaultToolkit().getImage(path+file)).getScaledInstance(77, 63, Image.SCALE_DEFAULT)));
        jLabel2.setPreferredSize(new java.awt.Dimension(77, 63));
        jLabel2.setSize(new java.awt.Dimension(77, 63));

        lbName.setFont(new java.awt.Font("Optima", 1, 18)); // NOI18N
        lbName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbName.setText("Unknown");

        lbSalary.setFont(new java.awt.Font("Optima", 2, 18)); // NOI18N
        lbSalary.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSalary.setText("Unlimited");

        tblPlayers.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPlayers);

        btReview.setText("Review Player.");

        btDelete.setText("Delete Player.");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btAdd.setText("Add Player.");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSalary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btReview)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAdd)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbName)
                    .addComponent(lbSalary))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btReview)
                    .addComponent(btDelete)
                    .addComponent(btAdd))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        // Remove the selected player from the on_user_team table
        int selectedRow = tblPlayers.getSelectedRow();
        String playerID = (String) tblPlayers.getValueAt(selectedRow, 0);
        String deleteQuery = "DELETE FROM on_user_team WHERE playerID = '" + playerID + "';";
        
        Connection conn = ConnectionSupplier.getMyConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
          stmt = conn.createStatement();
          int ret = stmt.executeUpdate(deleteQuery);
          
          //Do we want to print a message indicating failure?
          
          //Repopulate
          rs = stmt.executeQuery("select P.playerID, P.nameFirst, P.nameLast,"
                                  + " P.debut, P.finalGame "
                                  + "from on_user_team U, player P " 
                                  + "where U.playerID = P.playerID AND "
                                  + "U.teamID = " + teamID + ";");
          populatePlayersTable(rs);
          
          //Redraw
          ((DefaultTableModel)tblPlayers.getModel()).fireTableDataChanged();
        
        } catch (SQLException e) {
          BaseballUtilities.printSQLException(e);
        }
        finally {
            try {
              if (conn != null) { conn.close(); }
              if (stmt != null) { stmt.close(); }
              if (rs != null) {rs.close(); }
            } catch (SQLException e) {
              BaseballUtilities.printSQLException(e);
            }
        }
        
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        //Does the user want to add a pitcher or a positional player?
        Object[] options = {"Cancel", "Positional Player", "Pitcher"};
        int n = JOptionPane.showOptionDialog(base, 
                       "What kind of player would you like to add?",
                       "What Kind of Player?",
                       JOptionPane.YES_NO_CANCEL_OPTION,
                       JOptionPane.QUESTION_MESSAGE,
                       null,
                       options,
                       options[2]);
        //n = 2 is pitcher, n = 1 is positional, n = 0 is cancel
        if (n == 2) {
            //Do they have room on the team for a pitcher?
            boolean roomEnough = BaseballUtilities.checkRoster(teamID, 2);
            if (!roomEnough) {
                JOptionPane.showMessageDialog(base, 
                        "You cannot have more than six pitchers per roster.");
            }
            base.switchPanel(base, new PitcherSearch(base, this, teamID));
        } else if (n == 1) {
            //Do they have room on the team for a positional player?
            boolean roomEnough = BaseballUtilities.checkRoster(teamID, 1);
            if (!roomEnough) {
                JOptionPane.showMessageDialog(base, 
                        "You cannot have more than nine positional players per roster.");
            }
            base.switchPanel(base, new PositionalSearch(base, this, teamID));
        } else { 
            //do nothing - cancel option
        }
    }//GEN-LAST:event_btAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btReview;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbSalary;
    private javax.swing.JTable tblPlayers;
    // End of variables declaration//GEN-END:variables
}
