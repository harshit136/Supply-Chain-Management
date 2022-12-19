package com.example.supplychainmanagementsystembyharshit;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    public boolean customerLogin(String email, String password) throws SQLException {
        String query = String.format("SELECT * FROM customer WHERE email = '%s' AND password = '%s'", email, password);
        try{
            DatabaseConnection dbCon = new DatabaseConnection();
            ResultSet rs = dbCon.getQueryTable(query);
            if (rs != null && rs.next()) {
                return true;
        }

    }catch (Exception e){
        e.printStackTrace();
    }
    return false;
   }

    public static void main(String[] args) throws SQLException {
        Login login=new Login();
        System.out.println(login.customerLogin("harshitchoudhary136@gmail.com", "abc123"));
    }
}
