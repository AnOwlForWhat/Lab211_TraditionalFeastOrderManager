/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

/**
 *
 * @author silua
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Inputter {
    Scanner sc;
    
    public Inputter(){
    this.sc = new Scanner(System.in);
    }
    
    public String getString(String msg){
        System.out.println(msg);
        return sc.nextLine();
    }
   
    public String inputUpdate(String msg, String pattern){
        String input;
        while(true){
            input = getString(msg);
            if(input.isEmpty()) return "";
            if(Acceptable.isValid(input, pattern)) return input;
            System.out.println("INVALID INPUT, KEEP PREVIOUS DATA"); 
        }
    }
    
    public String inputAndLoop(String msg, String pattern){
        String input;
        while(true){
            input = getString(msg);
            if(Acceptable.isValid(input, pattern)) return input;
            
            System.out.println("INVALID INPUT");
        }
    }
    
    public int getInt(String msg, String pattern){
        while(true){
            String input = getString(msg);
            if(Acceptable.isValid(input, Acceptable.INTERGER_VALID)){
                int n = Integer.parseInt(input);
                if(n > 0 ) return n;
                else System.out.println("Must be greater than 0");
            }
            System.out.println("INVALID NNUMBER");
        }
    }
    
    public Date getDate(String msg,String pa){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        while(true){
            try{
            String input = getString(msg);
            Date date = sdf.parse(input);
            //current day
            Date today = new Date();
            if(date.after(today)){
                return date;
            } 
            else System.out.println("must be in the future");
            } catch(Exception e){
                System.out.println("INVALID date");
            }
        }
    }
    

}
