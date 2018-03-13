/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakerymanager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author jeromem
 */
public class Connector {
    
    private final String username;
    private final String password;
    private final String serverName;
    private final int port;
    private final String dbms;
    private final String dbName;

    public Connector(String username, String password, String serverName, int port, String dbms, String dbName) {
        this.username = username;
        this.password = password;
        this.serverName = serverName;
        this.port = port;
        this.dbms = dbms;
        this.dbName = dbName;
    }

    public Connector(String username, String password) {
        this.username = username;
        this.password = password;
        this.dbms = "mysql";
        this.serverName = "localhost";
        this.port = 3306;
        this.dbName = "BakeryDB";
    }
    
    public Connection getConnection() throws SQLException {

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.username);
        connectionProps.put("password", this.password);

        if (this.dbms.equals("mysql")) {
            conn = DriverManager.getConnection(
                       "jdbc:" + this.dbms + "://" +
                       this.serverName +
                       ":" + this.port + "/",
                       connectionProps);
        } else if (this.dbms.equals("derby")) {
            conn = DriverManager.getConnection(
                       "jdbc:" + this.dbms + ":" +
                       this.dbName +
                       ";create=true",
                       connectionProps);
        }
        System.out.println("Connected to database");
        
        return conn;
    }
    
            
}
