package Atm.Replica.System;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            String url = "jdbc:mysql://localhost:3306/atm?user=root&password=78624845";
            c = DriverManager.getConnection(url);
            if (c == null) {
                System.out.println("Null");
            }else{
                System.out.println("Connected");
            }
            s = c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

