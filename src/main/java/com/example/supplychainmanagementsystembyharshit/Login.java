package com.example.supplychainmanagementsystembyharshit;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    private byte[] getSHA(String input){
        try{
            MessageDigest messageDigest=MessageDigest.getInstance("SHA-256");
            return messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private String getEncryptedPassword(String password){
        try{
            BigInteger number=new BigInteger(1, getSHA(password));
            StringBuilder hexString=new StringBuilder(number.toString(16));
            return hexString.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

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

//    public static void main(String[] args) throws SQLException {
//        Login login=new Login();
//        System.out.println(login.customerLogin("harshitchoudhary136@gmail.com", "abc123"));
//    }

    public static void main(String[] args) {
        Login login=new Login();
        System.out.println(login.getEncryptedPassword("abc123"));
    }
}
