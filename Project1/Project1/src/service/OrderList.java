/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author silua
 */
import dto.*;
import java.util.ArrayList;
import java.util.Scanner;
import tools.Acceptable;
import tools.Inputter;
import java.util.Date;
import java.io.*;

public class OrderList extends ArrayList<Order>{
    Inputter inputter;
    
    public OrderList(){
        inputter = new Inputter();

    }
//FUNCTION 5
    public void placeOrder(CustomerList cList, SetMenuList mList){
        String customerId, menuId;
        Customer customer;
        if(cList.isEmpty()){
            System.out.println("Customer not exist");
            return;
        }
        
        //ID
        while(true){
            customerId = inputter.getString("Enter Customer ID: ");          
            if(cList.searchById(customerId) != null){
                break;
            }
            System.out.println("Customer id cannot found ");
        }
        
        //menuid
        mList.displayAll();
        System.out.println("YOUR OPTION : ");
        while(true){
            menuId = inputter.getString("Enter menu ID: ").toUpperCase();
            if(mList.searchByCode(menuId) != null){
                break;
            }System.out.println("menu code cannot found");
        }
        
    
        int numOfTables = inputter.getInt("enter number of tables: ", Acceptable.INTERGER_VALID);
        Date eventDate = inputter.getDate("Enter date", Acceptable.DATE_VALID);
        
         
        Order newOrder = new Order(customerId, menuId, numOfTables,eventDate);
        this.add(newOrder);
        
        Customer currentCus = cList.searchById(customerId);
        SetMenu currentSet = mList.searchByCode(menuId);
            System.out.println("Code        :"+currentCus.getId()   );
            System.out.println("Name        :"+currentCus.getName());
            System.out.println("Phone number:"+currentCus.getPhone());
            System.out.println("Email       :"+ currentCus.getEmail());
            System.out.println("--------------------------------------");
            System.out.println("Code of Set Menu    :"+ newOrder.getOrderId());
            System.out.println("Set menu Name       :"+ currentSet.getName());
            System.out.println("Date                :"+ newOrder.getEventDate());
            System.out.println("Tables              :"+ newOrder.getNumOfTables());
            System.out.println(String.format(Locale.US,"Price             %,.0f:",currentSet.getPrice()));
            System.out.println("Ingredients:");
                String [] tam=currentSet.getIngredients().split("#");
                for (String t : tam){
                    System.out.println(t);
                }
            System.out.println("----------------------------------------");
            System.out.println(String.format(Locale.US,"Total cost: %,.0f", currentSet.getPrice() * newOrder.getNumOfTables()));
            System.out.println("----------------------------------------");
            
        
        System.out.println("ORDER PLACED");
        
    }
    
    public void UpdateOrder(SetMenuList mList){
        //order id
        String id = inputter.getString("Enter ORDER ID to UPDATE: ").toUpperCase();
        Order order = searchById(id);
        if(order == null){
            System.out.println("NOT FOUND");
            return;
        }
        
        //menu id
        String menuId = inputter.getString("new menu id:");
        if(!menuId.isEmpty()){
            if(mList.searchByCode(menuId) != null){
                order.setMenuId(menuId);          
            }
            else System.out.println("menu cannot found, save previous menu");
        }
        
        //table
        String newtable = inputter.getString("Enter new number of table ");
        if (!newtable.isEmpty()) {
            try {
                int t = Integer.parseInt(newtable);
                if (t > 0) order.setNumOfTables(t);
            } catch (Exception e){
                System.out.println("INVALID");
            }
        }
        //
        Date newDate = inputter.getDate("Enter new date", Acceptable.DATE_VALID);
        if (newDate != null) {
            order.setEventDate(newDate);
        } else System.out.println("INVALID");
        
        
    }
    
//FUNCTION 7
    //save file
    public void saveToFile(String fname){
        
        try{
            FileOutputStream fos = new FileOutputStream(fname);
            ObjectOutputStream oos = new ObjectOutputStream(fos);           
            for(Order o: this){
                oos.writeObject(o);
            }
            fos.close();
            oos.close();
            System.out.println("file save to file:  "+ fname);       
        } catch(Exception e){
            System.out.println("Error" + e.getMessage());
        }
    }
    

    
    //read from file
    public void readFromFile(String fname){
        try{
            FileInputStream fis = new FileInputStream(fname);
            ObjectInputStream ois = new ObjectInputStream(fis);
              
            while(true){
                try{
                    Order o = (Order) ois.readObject();
                    this.add(o);
                }catch(EOFException e){
                    break;
                }
            }          
            fis.close();
            ois.close();
            System.out.println("load file from" + fname);
        } catch(IOException | ClassNotFoundException e){
            System.out.println("no file");
        }
    }
    
 

//FUNCTION 8
    public void displayAll(){
        for(Order o: this){
            System.out.println(o);
        }
    }

       public Order searchById(String id) {
        for (Order order : this) {
            if (order.getOrderId().equalsIgnoreCase(id)) return order;
        }
        return null;
    }
    
}
    
    
    
   

