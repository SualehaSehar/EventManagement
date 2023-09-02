/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.FoodManagement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Ammar
 */
public class FoodManagementDao {
    public static boolean addFood(FoodManagement em){
        boolean flag = false;
        int id = em.getFoodId();
        String name = em.getFoodName();
        double cost = em.getFoodCost();
        String image = em.getFoodImage();
        String query = "insert into Food(FoodID,FoodName,FoodCost,FoodImage)"
                +"values ('"+id+"','"+name+"','"+cost+"','"+image+"')";
        try{
            SQL.executeUpdate(query); ;
            flag = true;
        } catch(Exception e){
            e.printStackTrace();
            flag = false;
        }
        return flag;
        }
    
    public static ArrayList<FoodManagement> readFood(){
        ArrayList<FoodManagement> eq_list = new ArrayList<>();
        String query = "select * from Food";
        try{
            ResultSet rs = SQL.execute(query); 
            while(rs.next()){
                int id = rs.getInt("FoodID");
                String name = rs.getString("FoodName");
                double cost = rs.getDouble("FoodCost");
                String url = rs.getString("FoodImage");
                eq_list.add(new FoodManagement(id,name,cost,url));
            }
            
        } catch(Exception e){
            e.printStackTrace();
        }
        return eq_list;
        }
    
    public static void deleteFood(int id){
        String query = "delete from Food where FoodID ='"+id+"'";
        try{
            SQL.delete(query);    
        } catch(Exception e){
            e.printStackTrace();
        } 
    }
    public static void updateFood(int id,String name,double cost,String url){
        String query = "update Food set FoodName = '"+name+"',FoodCost = '"+cost+"',FoodImage = '"+url+"' where FoodID = '"+id+"'";
        try{
            SQL.executeUpdate(query);    
        } catch(Exception e){
            e.printStackTrace();
        } 
    }
    public static boolean isIDExisted(int id){
        boolean flag = false;
        String query = "select * from Food where FoodID = '"+id+"'"; 
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
}
