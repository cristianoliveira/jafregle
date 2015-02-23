package main.java.com.jafregle.translators;

import java.io.IOException;

import main.java.com.jafregle.http.HttpClient;
import main.java.com.jafregle.http.HttpMethod;
import main.java.com.jafregle.http.HttpParameter;
import main.java.com.jafregle.http.HttpParameterSet;
import main.java.com.jafregle.http.HttpResponse;

public class GoogleApiTranslator implements ITranslator{

    final String GOOGLE_API_URL = "https://www.googleapis.com/language/translate/v2?";
    final String GOOGLE_API_PARAMS = "key=%s&q=%s&source=%s&target=%s";
    
    String googleKey;
    
    public GoogleApiTranslator(String googleKey)
    {
        this.googleKey = googleKey;
    }
    
    @Override
    public String requestTranslation(String textToTranslate, String from, String to) throws IllegalArgumentException, IOException {
        
        if(googleKey.isEmpty())
            throw new IllegalArgumentException("Google Key must to be informed.");
        
        String encodedText = java.net.URLEncoder.encode(textToTranslate, "UTF-8");
        
        String params = String.format(GOOGLE_API_PARAMS, googleKey, encodedText, from, to);
        
        HttpResponse result = new HttpClient().request(HttpMethod.GET, new StringBuilder(GOOGLE_API_URL).append(params).toString());
        return result.asString();
    }

}