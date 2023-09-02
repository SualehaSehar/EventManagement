/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Ammar
 */
public class Customer extends Person {
    public Customer() {
    }

    public Customer(String id,String name, String gender, String contactNo,  String address, String userType) {
        super(id,name, gender, contactNo, address, userType);
    }
     
    public void selectEvent(){
        
   
    }
    public void payment(){
        
    }
}
