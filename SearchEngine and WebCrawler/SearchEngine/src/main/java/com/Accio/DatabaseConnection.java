package com.Accio;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DatabaseConnection {
    static Connection connection = null;
    //connection is a static instance it will be only one for the class
    public static Connection getConnection(){
        if(connection != null){
            return connection;
        }
        String user = "root";
        String pwd = "password";
        String db = "searchengineapp";
        return getConnection(user, pwd, db);
    }
    private static Connection getConnection(String user, String pwd, String db){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + db + "?user=" + user + "&password=" + pwd);
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }catch(ClassNotFoundException classNotFoundException){
            classNotFoundException.printStackTrace();
        }
        return connection;
        //if you are returning a static instance then the function should also be static
    }
}
