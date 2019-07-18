package com.demo.bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
@ManagedBean
@SessionScoped
public class UserBean implements Serializable{
	
	String bookmarkURL;

	public String getBookmarkURL() {
		return bookmarkURL;
	}

	public void setBookmarkURL(String bookmarkURL) {
		this.bookmarkURL = bookmarkURL;
	}

}
