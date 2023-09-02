/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Login;
import java.sql.ResultSet;

/**
 *
 * @author Ammar
 */
public class LoginDao {
    public static boolean isPasswordMatched(Login login){
        boolean flag = false;
        String email = login.getEmail();
        String password = login.getPassword();
        String query = "select * from Login where Email = '"+email+"'"; 
        try{
            ResultSet rs = SQL.execute(query); 
            if(rs.next() && password.equals(rs.getString("Password"))){
            flag = true;
            }
        } catch(Exception e){
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }
}
