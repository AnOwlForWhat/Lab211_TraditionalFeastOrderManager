/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author silua
 */
import dto.Customer;
import tools.Acceptable;
import tools.Inputter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;



public class CustomerList extends ArrayList<Customer>{

    
    private  final Inputter inputter;
    
    public CustomerList(){
            inputter = new Inputter();
        }
        
//FUNCTION 1
    public void customerRegistation(){   
        String id, name, phone, email;

        System.out.println("---Customer Registor---");
        
        //input
        
        id = inputter.inputAndLoop("Enter customer ID (C/G/K + 4 digits): ", Acceptable.CUS_ID_VALID).toUpperCase();
        name = inputter.inputAndLoop("Enter customer NAME: ", Acceptable.NAME_VALID);
        phone = inputter.inputAndLoop("Enter customer PHONE: ", Acceptable.PHONE_VALID);
        email = inputter.inputAndLoop("Enter customer EMAIL: ", Acceptable.EMAIL_VALID);

        //create object + add
        this.add(new Customer(id, name,phone, email));
        System.out.println("Customer Registered");
        }
    
//FUNCTION 2
    public void updateCustomerInfo(){
        System.out.println("Customer Update INFORMATION");
        String id = inputter.getString("Enter Customer ID to UPDATE: ").toUpperCase();
        Customer customer = searchById(id);
        if(customer == null){
            System.out.println("CUSTOMER NOT FOUND");
            return;
        }
        System.out.println("CUSTOMER DATA: ");
        System.out.println(customer);
        
        String name = inputter.inputAndLoop("Enter customer NAME: ", Acceptable.NAME_VALID);
        if(!name.isEmpty()) customer.setName(name);
        
        String phone = inputter.inputAndLoop("Enter customer PHONE: ", Acceptable.PHONE_VALID);
        if(!phone.isEmpty()) customer.setPhone(phone);
        
        String email = inputter.inputAndLoop("Enter customer EMAIL: ", Acceptable.EMAIL_VALID);
        if(!email.isEmpty()) customer.setEmail(email);
        
        
        System.out.println("INFORMATION UPDATED");
    }
    
//FUNCTION 3
    public void searchCustomerByName(){
        String name = inputter.inputAndLoop("Enter customer NAME: ", Acceptable.NAME_VALID).toUpperCase();              
        boolean check = false;
        for(Customer c: this){
            if(c.getName().toUpperCase().contains(name)){
                System.out.println(c);
                check = true;
            }
        }
        if(check == false) System.out.println("Customer not found");
    }
    
    
//FUNCTION 7
    //save file
    public void saveToFile(String fname){
        
        try{
            FileOutputStream fos = new FileOutputStream(fname);
            ObjectOutputStream oos = new ObjectOutputStream(fos);           
            for(Customer c: this){
                oos.writeObject(c);
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
                    Customer c = (Customer) ois.readObject();
                    this.add(c);
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
    
    //FUNC 8
    public void displayAll(){
        
        for(Customer c: this){
            System.out.println(c);
        }
    }
    
    
    public Customer searchById(String id){
        for(Customer c: this){
            if(c.getId().equalsIgnoreCase(id)) return c;
        }
        return null;
    }
}


