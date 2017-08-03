/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.fb.view;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dianeyanke
 */
public class PlayerDisplay extends javax.swing.JPanel {

    private final static int PITCHER = 0;
    private final static int POSITIONAL = 1;
    private String ls = System.getProperty("line.separator");

    private MainBaseballFrame mbf;
    private JPanel caller;
    private String[] playerInfo;
    private int playerType;

    /**
     * Creates new form PlayerDisplay
     */
    public PlayerDisplay(MainBaseballFrame mbf, JPanel caller, String[] playerInfo, int playerType) {
        initComponents();
        this.mbf = mbf;
        this.caller = caller;
        this.playerInfo = playerInfo;
        this.playerType = playerType;

        //Set the player's name (the title of the display window)
        lblName.setText(playerInfo[1] + " " + playerInfo[2]);
        //Set the textArea's text to describe the average career statistics
        findAndDisplayStatistics(playerInfo[0]);
        findAndDisplayStadiums(playerInfo[0]);
        findAndDisplaySalary(playerInfo[0]);

    }

    private void findAndDisplayStatistics(String playerID) {
        //First step: use the stored procedure get_seasons to create 
        //the average statistics across the players career
        Connection conn = ConnectionSupplier.getMyConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String query = null;

        try {

            //get the # of seasons first
            CallableStatement myCS = conn.prepareCall("{call get_seasons(?, ?)}");
            myCS.setString(1, playerID);
            myCS.execute();
            int years = myCS.getInt(2);  //tested on Willie Mays

            //Two paths: pitcher or positional
            if (playerType == POSITIONAL) {
                query = "SELECT Bat.playerID, SUM(atBats) as AB, SUM(hits) as H, "
                        + "SUM(homeRuns) as HR, SUM(rbi) as RBI, SUM(baseOnBalls) as B, "
                        + "SUM(strikeouts) as K, SUM(errors) as E, SUM(games) as G "
                        + "FROM batting Bat INNER JOIN fielding Field ON "
                        + "Bat.playerID = Field.playerID AND "
                        + "Bat.yearID = Field.yearID AND "
                        + "Bat.teamID = Field.teamID "
                        + "WHERE Bat.playerID = ? "
                        + "GROUP BY Bat.playerID;";
                stmt = conn.prepareStatement(query);
                stmt.setString(1, playerID);
                rs = stmt.executeQuery();
                //get the single row result and print the data
                while (rs.next()) {
                    String s = "BATTING" + ls
                            + "At Bats: " + (int) (Double.parseDouble(rs.getObject(2).toString())) / years + ls
                            + "Hits: " + (int) (Double.parseDouble(rs.getObject(3).toString())) / years + ls
                            + "Home Runs: " + (int) (Double.parseDouble(rs.getObject(4).toString())) / years + ls
                            + "RBI(s): " + (int) (Double.parseDouble(rs.getObject(5).toString())) / years + ls
                            + "Base on Balls: " + (int) (Double.parseDouble(rs.getObject(6).toString())) / years + ls
                            + "Strikeouts: " + (int) (Double.parseDouble(rs.getObject(7).toString())) / years + ls
                            + "FIELDING" + ls
                            + "Errors: " + (int) (Double.parseDouble(rs.getObject(8).toString())) / years + ls
                            + "Games: " + (int) (Double.parseDouble(rs.getObject(9).toString())) / years + ls;

                    taStatistics.setText(s);
                }
            } else { //pitcher path
                query = "SELECT Pitch.playerID, SUM(wins) as W, SUM(losses) as L, "
                        + "SUM(saves) as S, SUM(walks) as BB, SUM(strikeouts) as K, "
                        + "SUM(era) as ERA, SUM(errors) as E, SUM(Field.games) as G "
                        + "FROM pitching Pitch INNER JOIN fielding Field ON "
                        + "Pitch.playerID = Field.playerID AND "
                        + "Pitch.yearID = Field.yearID AND "
                        + "Pitch.teamID = Field.teamID "
                        + "WHERE Pitch.playerID = ? "
                        + "GROUP BY Pitch.playerID;";
                stmt = conn.prepareStatement(query);
                stmt.setString(1, playerID);
                rs = stmt.executeQuery();
                //get the single row result and print the data
                while (rs.next()) {
                    String s = "PITCHING" + ls
                            + "Wins: " + (int) (Double.parseDouble(rs.getObject(2).toString())) / years + ls
                            + "Losses: " + (int) (Double.parseDouble(rs.getObject(3).toString())) / years + ls
                            + "Saves: " + (int) (Double.parseDouble(rs.getObject(4).toString())) / years + ls
                            + "Walks: " + (int) (Double.parseDouble(rs.getObject(5).toString())) / years + ls
                            + "Strikeouts: " + (int) (Double.parseDouble(rs.getObject(6).toString())) / years + ls
                            + "Earned Run Average: " + (Double.parseDouble(rs.getObject(7).toString())) / years + ls
                            + "FIELDING" + ls
                            + "Errors: " + (int) (Double.parseDouble(rs.getObject(8).toString())) / years + ls
                            + "Games: " + (int) (Double.parseDouble(rs.getObject(9).toString())) / years + ls;

                    taStatistics.setText(s);
                }
            }

        } catch (SQLException e) {
            BaseballUtilities.printSQLException(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                BaseballUtilities.printSQLException(e);
            }
        }
    }
    
    private void findAndDisplayStadiums(String playerID) {
        Connection conn = ConnectionSupplier.getMyConnection();
        Statement stmt = null;
        ResultSet rs = null;
        String query = "select distinct R.parkname from realteams R " +
                       "where R.teamID IN " +
                       "(select F.teamID from fielding F where F.playerID = '" + playerID +
                       "' AND R.yearID = F.yearID);";
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                taStadiums.append(rs.getString(1) + ls);
            }
        } catch (SQLException e) {
            BaseballUtilities.printSQLException(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                BaseballUtilities.printSQLException(e);
            }
        }
    }
    
    private void findAndDisplaySalary(String pid) {
        Double salary = 0.0;
        
        Connection conn = ConnectionSupplier.getMyConnection();
        CallableStatement cs = null;
        
        try {
            cs = conn.prepareCall("{call get_sal(?,?)}");
            cs.setString(1, pid);
            cs.execute();
            salary =  cs.getDouble(2);
            
            if (Math.abs(salary) < 0.1 && Math.abs(salary) > -0.1) {
                tfSalaries.setText("Data not available for this player.");
            }
            else {
                tfSalaries.setText(String.format("%.2f", salary.doubleValue()));
            }
            
        } catch (SQLException e) {
            BaseballUtilities.printSQLException(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (cs != null) {
                    cs.close();
                }
            } catch (SQLException e) {
                BaseballUtilities.printSQLException(e);
            }
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

        lblName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taStatistics = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taStadiums = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfSalaries = new javax.swing.JTextField();
        btReturn = new javax.swing.JButton();

        lblName.setFont(new java.awt.Font("Optima", 0, 24)); // NOI18N
        lblName.setText("Name");

        taStatistics.setEditable(false);
        taStatistics.setColumns(20);
        taStatistics.setRows(5);
        jScrollPane1.setViewportView(taStatistics);

        jLabel2.setText("Statistics (Career Averages)");

        taStadiums.setEditable(false);
        taStadiums.setColumns(20);
        taStadiums.setRows(5);
        jScrollPane2.setViewportView(taStadiums);

        jLabel1.setText("Stadiums");

        jLabel3.setText("Salary");

        btReturn.setText("Return.");
        btReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(btReturn))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addComponent(tfSalaries, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                                            .addComponent(jLabel3)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSalaries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btReturn)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReturnActionPerformed
        // return to the Results class
        mbf.switchPanel(mbf, caller);
    }//GEN-LAST:event_btReturnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btReturn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblName;
    private javax.swing.JTextArea taStadiums;
    private javax.swing.JTextArea taStatistics;
    private javax.swing.JTextField tfSalaries;
    // End of variables declaration//GEN-END:variables
}
