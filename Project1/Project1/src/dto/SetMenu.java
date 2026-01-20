/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author silua
 */
public class SetMenu {
    private String code;
    private String name;
    private double price;
    private String Ingredients;
    
    public SetMenu(){
        
    }

    public SetMenu(String code, String name, double price, String Ingredients) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.Ingredients = Ingredients;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIngredients() {
        return Ingredients;
    }

    public void setIngredients(String Ingredients) {
        this.Ingredients = Ingredients;
    }
    
    public String toString(){
        return String.format("");
    }

}
