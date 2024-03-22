package com.dushime.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {
    private Connection con;
    private static final String user = "postgres";
    private static final String pass = "1220";
    private static final String dbUrl = "jdbc:postgresql://localhost:5432/auca_system";
    
    public DBConfig(){
        
        try{
        	Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(dbUrl, user, pass);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public Connection getCon(){
        return con;
    }
    
    private void closeCon(Connection conn){
        try{
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
