/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;
import java.util.Date;
import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 *
 * @author silua
 */
public class Order implements Serializable{
    private String orderId;
    private String customerId;
    private String province;
    private String menuId;
    private int numOfTables;
    private Date eventDate;
    
    public Order(String customerId, String menuId, int numOfTables, Date eventDate) {
        this.orderId = generateOrderCode();
        this.customerId = customerId;
        this.menuId = menuId;
        this.numOfTables = numOfTables;
        this.eventDate = eventDate;
    }
    
    private String generateOrderCode(){
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        return sdf.format(now);
    }
    public Order() {
        this.orderId = generateOrderCode();
        this.customerId = "";
        this.menuId = "";
        this.numOfTables = 0;
        this.eventDate = new Date();
    }

    public Order(String orderId, String customerId, String province, String menuId, int numOfTables, Date eventDate) {
        this.orderId = generateOrderCode();
        this.customerId = customerId;
        this.province = province;
        this.menuId = menuId;
        this.numOfTables = numOfTables;
        this.eventDate = eventDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public int getNumOfTables() {
        return numOfTables;
    }

    public void setNumOfTables(int numOfTables) {
        this.numOfTables = numOfTables;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
    
    @Override
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("ORDERID: %s \nDATE: %s \nCUSTOMERID: %s \nMENUID: %s \nTABLES: %d\n------------------------", 
                            orderId, sdf.format(eventDate), customerId, menuId, numOfTables);
    }
}

