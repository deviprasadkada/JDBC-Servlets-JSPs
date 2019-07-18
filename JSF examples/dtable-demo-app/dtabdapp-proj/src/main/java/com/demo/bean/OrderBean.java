package com.demo.bean;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.ArrayList;

import java.util.Arrays;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="order")
@SessionScoped
public class OrderBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String orderNo;
    private String productName;
    private BigDecimal price;
    private int qty;
    
    /*private static Order[] orderList = new Order[] {
        new Order("A001", "Intel CPU", new BigDecimal("700.00"), 1),
        new Order("A015", "Seagate 4TB", new BigDecimal("89.00"), 1),
        new Order("A010", "USB 16GB", new BigDecimal("25.00"), 1),
        new Order("A002", "Logitech Mouse", new BigDecimal("99.00"), 1),
        new Order("A008", "Mini HDMI Port", new BigDecimal("54.00"), 1)
    };*/

    public ArrayList<Order> orderList = new ArrayList<Order>(Arrays.asList(
        new Order("A001", "Intel CPU", new BigDecimal("700.00"), 1),
        new Order("A015", "Seagate 4TB", new BigDecimal("89.00"), 1),
        new Order("A010", "USB 16GB", new BigDecimal("25.00"), 1),
        new Order("A002", "Logitech Mouse", new BigDecimal("99.00"), 1),
        new Order("A008", "Mini HDMI Port", new BigDecimal("54.00"), 1)                                                  
    ));

    
    public ArrayList<Order> getOrderList() {
        return orderList;
    }
    
    public String addAction() {
        System.out.println(this.orderNo + "=====>" + this.productName);
        Order order = new Order(this.orderNo, this.productName, this.price, this.qty);
        orderList.add(order);
        
        return "/index.jsf?faces-redirect=true";
    }
    
    public String testDelete() {
        System.out.println("Tested 1234!");
        Order order = new Order(this.orderNo, this.productName, this.price, this.qty);
        orderList.add(order);
        return "/index.jsf?faces-redirect=true";
    }
    
    public static class Order {
        String orderNo;
        String productName;
        BigDecimal price;
        int qty;

        public Order(String orderNo, String productName, BigDecimal price, int qty) {
            this.orderNo = orderNo;
            this.productName = productName;
            this.price = price;
            this.qty = qty;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getProductName() {
            return productName;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }

        public int getQty() {
            return qty;
        }
    }


    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }

}
