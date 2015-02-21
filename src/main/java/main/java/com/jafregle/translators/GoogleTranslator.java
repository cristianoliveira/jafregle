package main.java.com.jafregle.translators;

import java.io.IOException;

import main.java.com.jafregle.WebHelper;

public class GoogleTranslator implements ITranslator{

    final String GOOGLE_API_URL = "https://www.googleapis.com/language/translate/v2?";
    final String GOOGLE_API_PARAMS = "key=%s&q=%s&source=%s&target=%s";
    
    String googleKey;
    
    public void setGoogleKey(String googleKey)
    {
        this.googleKey = googleKey;
    }
    
    @Override
    public String requestTranslation(String textToTranslate, String from, String to) throws IOException {
        
        if(googleKey.isEmpty())
            new IllegalArgumentException("Google Key must to be informed.");
        
        String encodedText = java.net.URLEncoder.encode(textToTranslate, "UTF-8");
        
        String params      = String.format(GOOGLE_API_PARAMS, googleKey, encodedText, from, to);
        
        String result      = new WebHelper().access(GOOGLE_API_URL, params);
        
        return result;
    }

}
