/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SQL {

    private static SQL sql = null;
    
    private SQL() {
    }
    
    public static SQL getSqlInstance(){
        if(sql == null) sql = new SQL();
        return sql;
    } 
    
    public Connection createConnection(){
        Connection con = null;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://EventManagementDatabase.accdb");
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
    public static void executeUpdate(String query) throws Exception{
        Connection conn = null;
        PreparedStatement pst = null;
        try{
            conn = SQL.getSqlInstance().createConnection();
            conn.setAutoCommit(false);
            pst = conn.prepareStatement(query);
            pst.executeUpdate();
            pst.close();
            
            conn.commit();
            conn.setAutoCommit(true);
        }
        catch(Exception e){
            conn.rollback();
            //throw new RuntimeException();
            e.printStackTrace();
        }
        finally{
            if (conn!=null) conn.close();
            if (pst!=null) pst.close();      
        }
    }
    
    public static ResultSet execute(String query) throws Exception{
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null; 
        try{
            conn = SQL.getSqlInstance().createConnection();
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            pst.close();
        }
        catch(Exception e){
            //throw new RuntimeException();
            e.printStackTrace();
        }
        finally{
            if (conn!=null) conn.close();
            if (pst!=null) pst.close();      
        }
       return rs;
    }
    
    public static void delete(String query) throws Exception{
        Connection conn = null;
        PreparedStatement pst = null; 
        try{
            conn = SQL.getSqlInstance().createConnection();
            pst = conn.prepareStatement(query);
            pst.executeUpdate();
            pst.close();
        }
        catch(Exception e){
            //throw new RuntimeException();
            e.printStackTrace();
        }
        finally{
            if (conn!=null) conn.close();
            if (pst!=null) pst.close();      
        }
    }
    
}
