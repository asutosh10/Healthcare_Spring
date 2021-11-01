package com.mytrip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TripDAO {
    public static boolean insertUser(String userId,String userName,String password){
        boolean flag=false;
        try {
            Connection con = CP.createC();
            String q = "insert into user values(?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1,userId);
            pstmt.setString(2,userName);
            pstmt.setString(3,password);
            pstmt.executeUpdate();
            flag=true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    public static void display(){
        try {
            Connection con = CP.createC();
            String q="select * from user";
            Statement stmt = con.createStatement();
            ResultSet set=stmt.executeQuery(q);
            while(set.next()){
                String userId=set.getString(1);
                String userName=set.getString(2);
                String password=set.getString(3);
                System.out.println(userId+" "+userName+" "+password);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
