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
public class Login {
    private String id;
    private String email;
    private String password;

    public Login() {
    }
    
    public Login(String id,String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
    
    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" + "id=" + id + ", email=" + email + ", password=" + password + '}';
    }
   
}

