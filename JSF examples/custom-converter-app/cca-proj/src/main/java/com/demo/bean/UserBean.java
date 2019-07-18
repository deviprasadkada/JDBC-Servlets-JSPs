package com.demo.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UserBean {
    
    private URLBookmark urlBookmark;

    public void setUrlBookmark(URLBookmark urlBookmark) {
        this.urlBookmark = urlBookmark;
    }

    public URLBookmark getUrlBookmark() {
        return urlBookmark;
    }

}
