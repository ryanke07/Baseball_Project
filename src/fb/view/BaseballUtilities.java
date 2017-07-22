/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.fb.view;

import java.sql.SQLException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author dianeyanke
 */
public class BaseballUtilities {
 
    private static String pathToResources = 
            "/Users/dianeyanke/NetBeansProjects/FantasyBaseball/build/classes/src/fb/resources/";
    private static final String endOfLine = System.getProperty("line.separator");

    public static void printSQLException(SQLException ex) {
        
      for (Throwable e : ex) {
	if (e instanceof SQLException) {
	  e.printStackTrace(System.err);
	  System.err.println("SQLState: " + ((SQLException)e).getSQLState());
	  System.err.println("Error Code: " + ((SQLException)e).getErrorCode());
	  System.err.println("Message: " + e.getMessage());
	  Throwable t = ex.getCause();
	  while (t != null) {
	    System.out.println("Cause: " + t);
	    t = t.getCause();
	  }
        }
      }
    }
    /* Purpose: Check a username/password combination for validity
    *
    * param: username - A String representing the user login
    * param: password - A String representing the user password
    * return: true if the combination is valid, false otherwise
    */

    public static boolean checkLogin(final String username, final String password)
    {
        if (username == null || password == null || 
                username.isEmpty() || password.isEmpty()) {
            return false;
        }
        //Open the login information file

        try (BufferedReader br = 
                new BufferedReader(new FileReader(pathToResources + "login.txt"))) {

          //Parse the input: username password -> line format
          String l;
          while ((l = br.readLine()) != null) {
              String result[] = l.split("\\s");

              if (result[0] != null && result[1] != null && 
                      result[0].equals(username) && 
                      result[1].equals(password)) {

                  return true;
              }
          }
        } catch (IOException e) {
          System.err.println("The login file was unavailable!");
          System.exit(1);
        } 

        return false;
    }

    public static void addUser(String username, String password) {
        if (username == null || password == null || 
                username.isEmpty() || password.isEmpty()) {
            return; //username and password must be at least one character
        }
        
         try (BufferedWriter bw = 
                new BufferedWriter(new FileWriter(pathToResources + "login.txt", true))) {
            bw.write(username + " ");
            bw.write(password + endOfLine);
         } catch (IOException ex) {
             System.err.println("The login file was unavailable!");
             System.exit(1);
         }

    }
    
    /* @arg: type --> 2 for pitcher, 1 for positional 
    * @ret: true for a passed test */
    public static boolean checkRoster(int teamID, int type) {
        
        Connection conn = ConnectionSupplier.getMyConnection();
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            String query = null;
        
            if (type == 2) {
                query = "SELECT count(distinct U1.playerID) " + 
                           "FROM on_user_team U1, fielding F1 " + 
                           "WHERE U1.playerID = F1.playerID AND " +
                           "U1.teamID = " + teamID + " AND " +
                           "F1.position = 'P' AND " +
                           "NOT EXISTS (SELECT * FROM on_user_team U2, fielding F2 " +
                           "WHERE U2.playerID = F2.playerID AND " +
                           "U2.teamID = " + teamID + " AND U2.playerID = U1.playerID " +
                           "AND F2.position <> 'P');";
            } else {
                query = "SELECT count(distinct U1.playerID) " + 
                           "FROM on_user_team U1, fielding F1 " + 
                           "WHERE U1.playerID = F1.playerID AND " +
                           "U1.teamID = " + teamID + " AND " +
                           "F1.position <> 'P' AND " +
                           "NOT EXISTS (SELECT * FROM on_user_team U2, fielding F2 " +
                           "WHERE U2.playerID = F2.playerID AND " +
                           "U2.teamID = " + teamID + " AND U2.playerID = U1.playerID " +
                           "AND F2.position = 'P');";  
            }
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            rs.first();
            int num = rs.getInt(1);
           
            //Too many pitchers!
            if (type == 2 && num > 6) { return false; }
            //Too many positional players!
            else if (num > 9) { return false; }
            
        } catch (SQLException e) {
            printSQLException(e);
        }
        finally {
            try {
              if (stmt != null) { stmt.close(); } 
              if (rs != null) { rs.close(); }
            } catch (SQLException e) {
              printSQLException(e);
            }
       }
        return true;
    }

} //end of class
