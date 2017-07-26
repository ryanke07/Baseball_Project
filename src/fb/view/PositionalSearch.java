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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dianeyanke
 */
public class PositionalSearch extends javax.swing.JPanel {
    //Some constant values
    private final String path =
      "/Users/dianeyanke/NetBeansProjects/FantasyBaseball/build/classes/src/fb/resources/";
    private final String file = "baseballpic.jpg";
    private String[] comparisonOperators = { " < ", " <= ", " = ", " >= ", " > ", "none" };
    private String[] positions = { "C", "1B", "2B", "3B", "OF", "SS", "ALL" };
    private static final int CAREER_ONLY_SEARCH = 0;
    //Some instance fields
    private MainBaseballFrame base;
    private TeamDisplay caller;
    private int teamID;
    /**
     * Creates new form PositionalSearch
     */
    public PositionalSearch(MainBaseballFrame base, TeamDisplay caller, int teamID) {
        initComponents();
        this.base = base;
        this.caller = caller;
        this.teamID = teamID;
        
        populateComboBoxes();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbAtBats = new javax.swing.JComboBox<>();
        cbHits = new javax.swing.JComboBox<>();
        cbHomeRuns = new javax.swing.JComboBox<>();
        cbRBI = new javax.swing.JComboBox<>();
        cbWalks = new javax.swing.JComboBox<>();
        cbStrikeouts = new javax.swing.JComboBox<>();
        cbErrors = new javax.swing.JComboBox<>();
        cbGames = new javax.swing.JComboBox<>();
        cbPosition = new javax.swing.JComboBox<>();
        tfAtBats = new javax.swing.JTextField();
        tfHits = new javax.swing.JTextField();
        tfHomeRuns = new javax.swing.JTextField();
        tfRBI = new javax.swing.JTextField();
        tfWalks = new javax.swing.JTextField();
        tfStrikeouts = new javax.swing.JTextField();
        tfErrors = new javax.swing.JTextField();
        tfGames = new javax.swing.JTextField();
        btSearch = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Optima", 0, 24)); // NOI18N
        jLabel1.setText("Positional Player Search");

        jLabel2.setIcon(new ImageIcon((Toolkit.getDefaultToolkit().getImage(path+file)).getScaledInstance(77, 63, Image.SCALE_DEFAULT)));

        jLabel3.setText("At Bats");

        jLabel4.setText("Hits");

        jLabel5.setText("Home Runs");

        jLabel6.setText("RBIs");

        jLabel7.setText("Walks");

        jLabel8.setText("Strikeouts");

        jLabel9.setText("Errors");

        jLabel10.setText("Games ");

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel11.setText("Position");

        cbAtBats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbHits.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbHomeRuns.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbRBI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbWalks.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbStrikeouts.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbErrors.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbGames.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tfAtBats.setText("N/A");

        tfHits.setText("N/A");

        tfHomeRuns.setText("N/A");

        tfRBI.setText("N/A");

        tfWalks.setText("N/A");

        tfStrikeouts.setText("N/A");

        tfErrors.setText("N/A");

        tfGames.setText("N/A");

        btSearch.setText("Search.");
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });

        btCancel.setText("Cancel.");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbHomeRuns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfHomeRuns, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cbRBI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfRBI, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btSearch)
                                    .addComponent(cbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btCancel)
                                .addGap(7, 7, 7))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(39, 39, 39)
                                    .addComponent(cbWalks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfWalks, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel10)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbGames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbErrors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cbStrikeouts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfStrikeouts, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                        .addComponent(tfErrors)
                                        .addComponent(tfGames))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbAtBats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(52, 52, 52)
                                        .addComponent(cbHits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfHits, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                    .addComponent(tfAtBats))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbAtBats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAtBats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbHits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfHits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(cbHomeRuns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfHomeRuns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbRBI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfRBI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbWalks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfWalks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cbStrikeouts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfStrikeouts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btCancel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cbErrors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfErrors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cbGames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfGames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btSearch)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        // Return to Team List
        base.switchPanel(base, caller);
    }//GEN-LAST:event_btCancelActionPerformed

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        // Implement the query and construct a Results panel to display results
       
        // Does the user want to only view career statistics?
        Object[] options = {"Yes", "No"};
        //Yes = 0, No = 1
        int optionChosen = JOptionPane.showOptionDialog(base, 
                       "Career statistics only (click no to use individual season statistics) ?",
                       "Career statistics?",
                       JOptionPane.YES_NO_OPTION,
                       JOptionPane.QUESTION_MESSAGE,
                       null,
                       options,
                       options[1]);
        //Obtain the comparison operators selected by the user
        String[] comparisons = new String[9];
        comparisons[0] = (String) cbAtBats.getSelectedItem(); //wins
        comparisons[1] = (String) cbHits.getSelectedItem(); //losses
        comparisons[2] = (String) cbHomeRuns.getSelectedItem(); //saves
        comparisons[3] = (String) cbRBI.getSelectedItem(); //walks
        comparisons[4] = (String) cbWalks.getSelectedItem(); //strikeouts
        comparisons[5] = (String) cbStrikeouts.getSelectedItem(); //e.r.a.
        comparisons[6] = (String) cbErrors.getSelectedItem(); //errors
        comparisons[7] = (String) cbGames.getSelectedItem(); //games
        //The "ALL" option will have to be handled in a special way
        comparisons[8] = " = ";
        //Obtain the parameters of the query from the text fields
        Object[] parameters = new Object[9];
        parameters[0] = (Object) tfAtBats.getText(); //wins
        parameters[1] = (Object) tfHits.getText(); //losses
        parameters[2] = (Object) tfHomeRuns.getText(); //saves
        parameters[3] = (Object) tfRBI.getText(); //walks
        parameters[4] = (Object) tfWalks.getText(); //strikeouts
        parameters[5] = (Object) tfStrikeouts.getText(); //e.r.a.
        parameters[6] = (Object) tfErrors.getText(); //errors
        parameters[7] = (Object) tfGames.getText(); //games
        parameters[8] = (String) cbPosition.getSelectedItem();
        
        validateInputOrSetDefault(parameters, comparisons);
        
        DefaultTableModel dtm = runQueryAndPopulateDTM(comparisons, parameters, optionChosen);
        
        if (dtm != null) {
            //display the results in a new Results panel
            base.switchPanel(base, new Results(base, caller, this, dtm, teamID));
        }
        
        
    }//GEN-LAST:event_btSearchActionPerformed
   
    private DefaultTableModel runQueryAndPopulateDTM(String[] comps, Object[] params, int careerOnly) {
        
        DefaultTableModel tableModelReturned = null;
        
        //Make sure you can get the Connection first
        Connection conn = ConnectionSupplier.getMyConnection();
        Statement stmt = null;
        ResultSet rs = null;
      
        try {
            String query = null;
            //If the statistics should be averaged across a career, follow this path.
            if (careerOnly == CAREER_ONLY_SEARCH) {
                query = "SELECT P.playerID, P.nameFirst, P.nameLast, P.debut, P.finalGame "
                        + "FROM player P, "
                        + "(SELECT playerID, SUM(atBats) AS atBats, SUM(hits) AS hits, "
                        + "SUM(homeRuns) AS homeRuns, SUM(rbi) AS rbi, SUM(baseOnBalls) AS baseOnBalls, "
                        + "SUM(strikeouts) AS strikeouts "
                        + "FROM batting "
                        + "GROUP BY playerID) AS B "
                        + "WHERE P.playerID = B.playerID AND "
                        + "B.atBats" + comps[0] + params[0] + " AND "
                        + "B.hits" + comps[1] + params[1] + " AND "
                        + "B.homeRuns" + comps[2] + params[2] + " AND "
                        + "B.rbi" + comps[3] + params[3] + " AND "
                        + "B.baseOnBalls" + comps[4] + params[4] + " AND "
                        + "B.strikeouts" + comps[5] + params[5] + " "
                        + "AND P.playerID IN ("
                        + "SELECT DISTINCT P2.playerID "
                        + "FROM player P2, "
                        + "(SELECT playerID, SUM(errors) AS errors, SUM(games) AS games FROM fielding ";
                if (params[8] != "ALL") {
                    query = query + "WHERE position = '" + params[8] + "' ";
                }
                query = query + "GROUP BY playerID) AS F "
                        + "WHERE F.playerID = P2.playerID AND "
                        + "F.errors " + comps[6] + params[6] + " AND "
                        + "F.games " + comps[7] + params[7] + ");";
           

            } //otherwise, output statistics for each player for each year they played (project the 'year' attribute)
            else {
               query = "SELECT DISTINCT P.playerID, P.nameFirst, P.nameLast, P.debut, P.finalGame " +
                       "FROM player P, " + 
                       "(SELECT playerID, yearID, SUM(atBats) AS atBats, SUM(hits) AS hits, " +
                       "SUM(homeRuns) AS homeRuns, SUM(rbi) AS rbi, SUM(baseOnBalls) AS baseOnBalls, " +
                       "SUM(strikeouts) AS strikeouts " +
                       "FROM batting " +
                       "GROUP BY yearID, playerID) AS B " +
                       "WHERE P.playerID = B.playerID AND " +
                       "B.atBats" + comps[0] + params[0] + " AND " +
                       "B.hits" + comps[1] + params[1] + " AND " +
                       "B.homeRuns" + comps[2] + params[2] + " AND " +
                       "B.rbi" + comps[3] + params[3] + " AND " +
                       "B.baseOnBalls" + comps[4] + params[4] + " AND " +
                       "B.strikeouts" + comps[5] + params[5] + " " + 
                       "AND P.playerID IN (" + 
                       "SELECT DISTINCT P2.playerID " + 
                       "FROM player P2, " +
                       "(SELECT playerID, yearID, SUM(errors) AS errors, SUM(games) AS games FROM fielding ";
                       if (params[8] != "ALL") {
                           query = query + "WHERE position = '" + params[8] + "' ";
                       }
                       query = query + "GROUP BY yearID, playerID) AS F " +
                               "WHERE F.playerID = P2.playerID AND " +
                               "F.errors " + comps[6] + params[6] + " AND " +
                               "F.games " + comps[7] + params[7] + ");";
                 
            }
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            tableModelReturned = populateTableModel(rs);

        } catch (SQLException e) {
            BaseballUtilities.printSQLException(e);
        } finally {
            try {
                conn.close();
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                //TODO add clean up
                BaseballUtilities.printSQLException(e);
            }
        }
        
       
        
        return tableModelReturned;
    }
    
     private DefaultTableModel populateTableModel(ResultSet rs) {
        
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
            
            return new DefaultTableModel(data, cols);
           // teamsTable.fireTableDataChanged();
            
        } catch (SQLException e) {
            //TODO: add clean up
            BaseballUtilities.printSQLException(e);
        }
        return null;
    }
    
    private void populateComboBoxes() {
        
        DefaultComboBoxModel dcbm1 = new DefaultComboBoxModel(comparisonOperators);
        DefaultComboBoxModel dcbm2 = new DefaultComboBoxModel(comparisonOperators);
        DefaultComboBoxModel dcbm3 = new DefaultComboBoxModel(comparisonOperators);
        DefaultComboBoxModel dcbm4 = new DefaultComboBoxModel(comparisonOperators);
        DefaultComboBoxModel dcbm5 = new DefaultComboBoxModel(comparisonOperators);
        DefaultComboBoxModel dcbm6 = new DefaultComboBoxModel(comparisonOperators);
        DefaultComboBoxModel dcbm7 = new DefaultComboBoxModel(comparisonOperators);
        DefaultComboBoxModel dcbm8 = new DefaultComboBoxModel(comparisonOperators);
        DefaultComboBoxModel dcbm9 = new DefaultComboBoxModel(positions);
        
        cbAtBats.setModel(dcbm1);
        cbHits.setModel(dcbm2);
        cbHomeRuns.setModel(dcbm3);
        cbRBI.setModel(dcbm4);
        cbWalks.setModel(dcbm5);
        cbStrikeouts.setModel(dcbm6);
        cbErrors.setModel(dcbm7);
        cbGames.setModel(dcbm8);
        cbPosition.setModel(dcbm9);
        //set to "=" be default
        cbAtBats.setSelectedIndex(2);
        cbHits.setSelectedIndex(2);
        cbHomeRuns.setSelectedIndex(2);
        cbRBI.setSelectedIndex(2);
        cbWalks.setSelectedIndex(2);
        cbStrikeouts.setSelectedIndex(2);
        cbErrors.setSelectedIndex(2);
        cbGames.setSelectedIndex(2);
        
        //We will assume initially that users select either a specific position
        //+ or every position.  A later improvement would be to allow for subset
        //+ selections.
        cbPosition.setSelectedIndex(6);
    }
    
    private void validateInputOrSetDefault(Object[] p, String[] c) {
        for (int i = 0; i < 8; i++) {
            if (c[i] == "none") {
                p[i] = (Integer) 0;
                c[i] = " >= ";
            } else {
                try {
                    p[i] = Integer.parseInt((String) p[i]);
                    //set a default comparison if they screw up the text entry
                } catch (NumberFormatException e) {
                    p[i] = (Integer) 0;
                    c[i] = " >= ";
                }
            }
        }
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btSearch;
    private javax.swing.JComboBox<String> cbAtBats;
    private javax.swing.JComboBox<String> cbErrors;
    private javax.swing.JComboBox<String> cbGames;
    private javax.swing.JComboBox<String> cbHits;
    private javax.swing.JComboBox<String> cbHomeRuns;
    private javax.swing.JComboBox<String> cbPosition;
    private javax.swing.JComboBox<String> cbRBI;
    private javax.swing.JComboBox<String> cbStrikeouts;
    private javax.swing.JComboBox<String> cbWalks;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField tfAtBats;
    private javax.swing.JTextField tfErrors;
    private javax.swing.JTextField tfGames;
    private javax.swing.JTextField tfHits;
    private javax.swing.JTextField tfHomeRuns;
    private javax.swing.JTextField tfRBI;
    private javax.swing.JTextField tfStrikeouts;
    private javax.swing.JTextField tfWalks;
    // End of variables declaration//GEN-END:variables
}
