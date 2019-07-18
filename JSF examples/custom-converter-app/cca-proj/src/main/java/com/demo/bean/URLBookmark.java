package com.demo.bean;

public class URLBookmark {
    private String fullURL;
    
    public URLBookmark(String fullURL) {
        this.fullURL = fullURL;
    }

    public void setFullURL(String fullURL) {
        this.fullURL = fullURL;
    }

    public String getFullURL() {
        return fullURL;
    }
    
    public String toString() {
        return fullURL;
    }
}
