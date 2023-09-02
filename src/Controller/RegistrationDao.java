/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Customer;
import Model.Login;
import Model.Manager;
import Model.Person;
import java.sql.ResultSet;

/**
 *
 * @author Ammar
 */
public class RegistrationDao {
    public static boolean addPerson(Person person,Login login){
        boolean flag = false;
        String id = person.getId();
        String no = person.getContactNo();
        String name = person.getName();
        String type = person.getUserType();
        String gender = person.getGender();
        String address = person.getAddress();
        String loginID = login.getId();
        String email = login.getEmail();
        String password = login.getPassword();
        try{
            String query2 = "insert into Person(ID,PhoneNumber,UserName,UserType,Gender,Address) values ('"+id+"','"+no+"','"+name+"','"+type+"','"+gender+"','"+address+"')";
            SQL.executeUpdate(query2); 
            String query3 = "insert into Login(ID,Email,Password,PersonID) values ('"+loginID+"','"+email+"','"+password+"','"+id+"')";
            SQL.executeUpdate(query3);
            flag = true;
        } catch(Exception e){
            //System.out.println(e.getMessage());
            e.printStackTrace();
            flag = false;
        }
        return flag;
        }
               
    public static boolean isEmailExisted(String email){
        boolean flag = false;
        String query = "select * from Login where Email = '"+email+"'"; 
        try{
            ResultSet rs = SQL.execute(query); 
            if(rs.next()){
                flag = true;
            }
        } catch(Exception e){
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }
    public static boolean isPhoneNumberExisted(String phn){
        boolean flag = false;
        String query = "select * from Person where PhoneNumber = '"+phn+"'"; 
        try{
            ResultSet rs = SQL.execute(query); 
            if(rs.next()){
                flag = true;
            }
        } catch(Exception e){
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }
    public static Person getPersonByEmail(String email){
        String query = "select * from Login where Email = '"+email+"'";
        Person person = null;
        try{
            ResultSet rs = SQL.execute(query); 
            if(rs.next()){
                String personid = rs.getString("PersonID");
                String query1 = "select * from Person where ID = '"+personid+"'";
                rs = SQL.execute(query1);
                if(rs.next()){
                String name = rs.getString("UserName");
                String gender = rs.getString("Gender");
                String no = rs.getString("PhoneNumber");
                String address = rs.getString("Address");
                String userType = rs.getString("UserType");
                if(userType.equalsIgnoreCase("MANAGER")){
                    person = new Manager(personid,name,gender,no,address,userType);
                }else{
                    person = new Customer(personid,name,gender,no,address,userType);
                }
                }
            }
        } catch(Exception e){
            //System.out.println(e.getMessage());
            e.printStackTrace();
    } 
        return person;
}
     
}    
     

