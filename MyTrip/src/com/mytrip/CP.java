package com.mytrip;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
    static Connection con;
    public static Connection createC(){
        try {

            //load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create connection with DriverManager
            String url="jdbc:mysql://localhost:3306/alsaher";
            String user="root";
            String password="root";
            con= DriverManager.getConnection(url,user,password);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
