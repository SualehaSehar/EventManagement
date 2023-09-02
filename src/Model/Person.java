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
public class Person {
    protected String id;
    protected String name;
    protected String gender;
    protected String contactNo;
    protected String address;
    protected String userType;

    public Person() {
    }
    
    public Person(String id, String name,String gender,String contactNo,String address,String usertype) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.contactNo = contactNo;
        this.address = address;
        this.userType = usertype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", contactNo=" + contactNo + ", address=" + address + ", userType=" + userType + '}';
    }
    
    

    
}
