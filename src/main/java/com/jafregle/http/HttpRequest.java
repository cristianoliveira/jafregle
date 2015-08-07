package com.jafregle.http;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class HttpRequest {

    private HttpURLConnection httpConnection;

    public HttpRequest(HttpURLConnection httpConnection) {
        this.httpConnection = httpConnection;
    }

    public HttpResponse doRequest() throws IOException {

    	try {
	    
    		InputStream inStream = httpConnection.getInputStream();
    		return new HttpResponse(inStream);
    		
        } catch (FileNotFoundException fileNotFoundException) {
	        
        	throw new IOException("Provider return error: "+httpConnection.getResponseCode());
        }
    }

    public HttpURLConnection getHttpURLConnection() {
        return httpConnection;
    }
}
