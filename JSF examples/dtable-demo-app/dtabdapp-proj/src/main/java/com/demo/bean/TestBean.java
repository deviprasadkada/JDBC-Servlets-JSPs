package com.demo.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TestBean {
    
    public String testSubmit() {
        System.out.println("Tested!");
        
        return "/index.jsf?faces-redirect=true";
    }
    
}
