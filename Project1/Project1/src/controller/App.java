/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author silua
 */

import service.*;
import java.util.Scanner;
import tools.*;
public class App {
    SetMenuList mList; 
    CustomerList cList;
    OrderList oList;
    Inputter inputter;

    public App(){
        mList=new SetMenuList();
        cList = new CustomerList();
        oList = new OrderList();
        inputter = new Inputter();
        mList.readFromFile("FeastMenu.csv");
        cList.readFromFile("Customer.dat");
        oList.readFromFile("Order.dat");
    }
    
    public static void main(String[] args){
        App a=new App();
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("Tranditional Feast Order Management");
            System.out.println("-------------------------------------");
            System.out.println("1. Register customer.");
            System.out.println("2. Update customer information");
            System.out.println("3. Search for customer information by name");
            System.out.println("4. DIsplay feast menus");
            System.out.println("5. Place a feast order");
            System.out.println("6. Update order information]");
            System.out.println("7. Save data in file");
            System.out.println("8. DIsplay Customer or Order lists");
            System.out.println("Others - Quit!");
            System.out.println("--------------------------------------");
            System.out.println("CHOOSE YOUR OPTION: ");
            
            try{
                int option=Integer.parseInt(sc.nextLine());
                switch(option){
                    case 1:
                        a.cList.customerRegistation();break;
                    case 2:
                        a.cList.updateCustomerInfo(); break;
                    case 3:
                        a.cList.searchCustomerByName(); break;
                    case 4:
                        a.mList.displayAll(); break;
                    case 5:
                        a.oList.placeOrder(a.cList, a.mList); break;
                    case 6:
                        a.oList.UpdateOrder(a.mList); break;
                    case 7:
                        a.oList.saveToFile("Order.dat");
                        a.cList.saveToFile("Customer.dat");
                        break;
                    case 8:
                        
                        System.out.println("1. to show CUtomer data\n2. to show order data");
                        int temp = a.inputter.getInt("OPTION: ", Acceptable.INTERGER_VALID );
                        switch (temp) {
                            case 1:
                                a.cList.displayAll();
                                break;

                            case 2:
                                a.oList.displayAll();
                                break;

                            default:
                                System.out.println("Invalid option!");
                        }
                        break;
                    default:
                        System.out.println("Exit");
                        System.exit(0);
                }
                
                System.out.println("Press any key to back to menu");
                sc.nextLine();
                    

            } catch (NumberFormatException e){
                System.exit(0);
            }
        }
        while(true);
    }
}
