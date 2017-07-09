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
/**
 *
 * @author dianeyanke
 */
public class BaseballUtilities {
  


    private static String pathToResources = 
            "/Users/dianeyanke/NetBeansProjects/FantasyBaseball/build/classes/src/fb/resources/";

    

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

        //TODO: write login information to login.txt

    }

} //end of class
