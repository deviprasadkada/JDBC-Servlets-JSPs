package com.demo.bean;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LoginBean {
    
    private String username;
    private String password;
    

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String process() {
        System.out.println(username);
        if(username.equals("Admin"))
            return "/welcome.jsf?faces-redirect=true";
        
        return "/error.jsf?faces-redirect=true";
    }
    
}
