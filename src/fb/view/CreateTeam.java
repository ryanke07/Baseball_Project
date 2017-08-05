

package src.fb.view;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author dianeyanke
 */
public class CreateTeam extends javax.swing.JPanel {
    String path =
      "/Users/dianeyanke/NetBeansProjects/FantasyBaseball/build/classes/src/fb/resources/";
    String file = "baseballpic.jpg";
    MainBaseballFrame base;
    TeamList caller;
    /**
     * Creates new form CreateTeam
     */
    public CreateTeam(MainBaseballFrame base, TeamList caller) {
        initComponents();
        this.base = base;
        this.caller = caller;
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
        tfName = new javax.swing.JTextField();
        tfSalary = new javax.swing.JTextField();
        createButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Optima", 0, 24)); // NOI18N
        jLabel1.setText("Create Team");
        jLabel1.setToolTipText("");

        jLabel2.setIcon(new ImageIcon((Toolkit.getDefaultToolkit().getImage(path+file)).getScaledInstance(77, 63, Image.SCALE_DEFAULT)));
        jLabel2.setPreferredSize(new java.awt.Dimension(77, 63));
        jLabel2.setSize(new java.awt.Dimension(0, 0));

        jLabel3.setFont(new java.awt.Font("Optima", 2, 13)); // NOI18N
        jLabel3.setText("Name your team and give it a salary cap (optional).");

        jLabel4.setText("Name:");

        jLabel5.setText("Salary Cap: ");

        tfSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSalaryActionPerformed(evt);
            }
        });

        createButton.setText("Create.");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(createButton)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 53, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createButton)
                .addGap(0, 40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tfSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSalaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSalaryActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        
         //Retrieve the text field values
         String teamName = tfName.getText();
         if (teamName == null || teamName.isEmpty()) {
             teamName = "unknown";
         }
         
         int salaryCap;
         try {
             salaryCap = Integer.parseInt(tfSalary.getText());
             if (salaryCap == 0) {
                 salaryCap = Integer.MAX_VALUE;
             }
         } catch (NumberFormatException ex) {
             salaryCap = Integer.MAX_VALUE;
         }
         
         //Retrieve the user's login information
         String user = MainBaseballFrame.getSessionUser();
         String password = MainBaseballFrame.getSessionPassword();
         
         //Add the team to the userteams table of the baseball database
         addTeamToDatabase(teamName, salaryCap, user, password);
         
         //TODO: The timing may be off here.  The panel may switch before the user
         //clicks "Ok" on the dialog.  That may not be a big deal, though.
         
         //Indicate success to the user
         JOptionPane.showMessageDialog(base, "Success!");
         //Switch to the Team List menu
         base.switchPanel(base, new TeamList(base));
         
    }//GEN-LAST:event_createButtonActionPerformed
    /* Utility method to place new team in the userteams table */
    private void addTeamToDatabase(String name, long sal, String user, String pass) {
        
        Connection conn = ConnectionSupplier.getMyConnection();
        Statement stmt = null;
        int ret;
        try {
          stmt = conn.createStatement();
          ret = stmt.executeUpdate("INSERT INTO userteams (salaryCap, name, login, password) "
                             + " VALUES( " + sal + ", '" + name + "', '" 
                             + user + "', '" + pass + "');");
          if (ret != 1) {
              System.err.println("Failed to add team! Database problem...");
              System.exit(1);
          }    
        } catch (SQLException e) {
            //TODO: add clean up
            BaseballUtilities.printSQLException(e);
        }
        finally {
           try {
           conn.close();
           if (stmt != null) { stmt.close(); }
           } catch (SQLException e) {
               //TODO add clean up
               BaseballUtilities.printSQLException(e);
           }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfSalary;
    // End of variables declaration//GEN-END:variables
}
