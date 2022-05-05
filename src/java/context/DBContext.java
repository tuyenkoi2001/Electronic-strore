package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hoàng Xuân Tuyền
 */
public class DBContext {
    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=Electronic-store;"
            + "integratedSecurity=true";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "1234";
    
    private Connection conn = null;

    public Connection getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
    
    public Connection getInstance(){
        if(conn == null){
            return getConnection();
        }
        else return conn;
    }
}
