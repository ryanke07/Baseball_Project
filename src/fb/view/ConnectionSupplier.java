
package src.fb.view;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class containing method for establishing a database connection.
 * @author ryan
 */
public class ConnectionSupplier {
    
    /* Adjust these fields as necessary.  There is no properties file */
    static final String databasePrefix = "baseball";
    static final String user = "ryan";
    static final String hostName = "localhost";
    static final String databaseURL = "jdbc:mysql://"+
                                      hostName+
                                      "/"+
                                      databasePrefix;
    static final String password = "dummy";
    
    public static Connection getMyConnection() {
        
        Connection connection = null;
        Statement statement = null;
        try {
           // Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                                        databaseURL, user, password);
            return connection;
        } 
     //catch (ClassNotFoundException ex) {
       //     ex.printStackTrace();
        //} 
        catch (SQLException e) {
            BaseballUtilities.printSQLException(e);
        }
        /* Omitting the finally block from lecture.  The caller should assume
        * responsibility for closing the connection. */
        return null; //should not reach
    }
}

           
        
    

