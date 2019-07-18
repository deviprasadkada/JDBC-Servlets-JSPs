package com.demo;

import java.net.URL;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
 
@FacesConverter("com.demo.URLConverter")
public class URLConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
		String value) {
		
		String HTTP = "http://www.";
		StringBuilder url = new StringBuilder();
                URLBookmark urlBookmark = null;
                
                

		//if not start with http://, then add it
		if(!value.startsWith(HTTP, 0)){
			url.append(HTTP);
		}
		url.append(value);
                try{
                    URL validateURL = new URL(url.toString());
                    //if URL is invalid
                    if(!validateURL.toURI().isAbsolute()){
                            
                            FacesMessage msg = 
                                    new FacesMessage("URL Conversion error.", 
                                                    "Invalid URL format.");
                            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                            throw new ConverterException(msg);
                        
                    }
                    urlBookmark = new URLBookmark(url.toString());
        } catch(Exception e) {
            e.printStackTrace();
        }
		
                
		
		return urlBookmark;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {

		return value.toString();
		
	}	
}
