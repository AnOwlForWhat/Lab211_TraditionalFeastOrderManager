/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tools;

/**
 *
 * @author silua
 */
public interface Acceptable {

    
    public final String CUS_ID_VALID = "^[CcGgKk]\\d{4}$";
    
    //match toi thieu 2 ki tu, toi da 25 ki tu
    public final String NAME_VALID = "^.{2,25}$";
    //match: bat dau tu 0 theo sau 9 chu so bat ki
    public final String PHONE_VALID = "^0\\d{9}$";
    public final String EMAIL_VALID = "^[A-Za-z0-9+_.-]+@(.+)$";
//    public final String POSITIVE_INTEGER = "^[1-9]\\d*$";
    public final String INTERGER_VALID = "^\\d+$*";
    public final String DATE_VALID = "^\\d{1,2}[/-]\\d{1,2}[/-]\\d{4}$";
    public final String MENU_ID_VALID = "^PW\\d{3,5}$";
    
    public static boolean isValid(String data, String pattern){
        return data.matches(pattern);
    }
    
}
