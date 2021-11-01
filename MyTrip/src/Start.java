import com.mytrip.CP;
import com.mytrip.TripDAO;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;

public class Start {
    public static void main(String args []) throws IOException {
        Connection c1= CP.createC();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("press 1 to enter details");
            System.out.println("press 2 to exit");
            System.out.println("press 3 to display all");
            int choice=Integer.parseInt(br.readLine());
            if (choice==1){
                System.out.println("Enter userid");
                String userId=br.readLine();
                System.out.println("Enter user name");
                String userName=br.readLine();
                System.out.println("Enter password");
                String password=br.readLine();
                System.out.println(userId);
                System.out.println(userName);
                System.out.println(password);
                boolean flag=TripDAO.insertUser(userId,userName,password);
                if (flag=true) {
                    System.out.println("added successfully");
                }
                else{
                    System.out.println("not added successfully");
                }
            }
            else if(choice==3){
                TripDAO.display();
            }
            else{
                break;
            }

        }

    }
}
