/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import dto.SetMenu;
import java.util.ArrayList;
import java.util.Locale;
import java.io.*;
/**
 *
 * @author silua
 */
public class SetMenuList extends ArrayList<SetMenu> {
    
    
    public void readFromFile(String filename){
        FileReader f=null;
        BufferedReader bf=null;
        try{
            f=new FileReader(filename);
            bf=new BufferedReader(f);
            String s=bf.readLine();//doc dong dau tien, la caption trong cai file
            while(bf.ready()){
                s=bf.readLine();//s="PW01,...";
                String[] arr=s.split(",");// arr=["PW001",",Wedding party 01","375000",]
                if (arr.length ==4){
                    SetMenu m = new SetMenu();
                    m.setCode(arr[0]);
                    m.setName(arr[1]);
                    m.setPrice(Double.parseDouble(arr[2].trim()));
                    m.setIngredients(arr[3].replace("\"", "").trim());
                    add(m);
                }
            }
        } catch (Exception e){
            System.out.println("loi file");
        }finally{
            try{
                if(f!=null) f.close();
                if(bf!=null) bf.close();
        } catch (Exception e){
                System.out.println("loi dong file");
            }
            
        }
    }
    public void displayAll(){
            System.out.println("------------------------------------------------------");
            System.out.println("List of Set menus for ordering party");
            System.out.println("------------------------------------------------------");
            for (SetMenu m : this){
                System.out.println("code       :" + m.getCode());
                System.out.println("Name       :" + m.getName());
//                System.out.println("Price      :" + m.getPrice());
                System.out.println(String.format(Locale.US, "Price      :%,.0f Vnd", m.getPrice()));


                System.out.println("Ingredients:");
                String [] tam=m.getIngredients().split("#");
                for (String t : tam){
                    System.out.println(t);
                }
                System.out.println("---------------------------------------------------");
              
            }
                        
}
    public SetMenu searchByCode(String code) {
        for (SetMenu m : this) {
            if (m.getCode().equalsIgnoreCase(code)) return m;
        }
        return null;
    }
}

