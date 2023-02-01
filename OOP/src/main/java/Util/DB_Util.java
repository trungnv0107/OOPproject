package Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Util {
    private static DB_Util instance;
    public static DB_Util getInstance(){
        if(instance != null){
           return instance = instance;
        }
        return instance = new DB_Util();
    }
    public Connection getConnection(){
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=OOP_DB;encrypt=true;trustServerCertificate=true;";
            String username = "sa";
            String password = "01072000";
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
