package main.java.com.jafregle.translators;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.java.com.jafregle.http.HttpClient;
import main.java.com.jafregle.http.HttpMethod;
import main.java.com.jafregle.http.HttpResponse;

public class FreeGoogleTranslator implements ITranslator {
    
    private final String GOOGLE_URL_API = "http://translate.google.com/translate_a/";    
    private final String GOOGLE_PARAMS  = "t?client=t&text=%s&hl=%s&sl=%s&tl=%s&ie=UTF-8&oe=UTF-8&multires=1&otf=1&ssel=3&tsel=3&sc=1";
    private final String PATTERN = "\"([^\"]*?)\"";
    
    @Override
    public String requestTranslation(String textToTranslate, String from, String to) throws IOException
    {
        String encodedText = java.net.URLEncoder.encode(textToTranslate, "UTF-8");
        String params      = String.format(GOOGLE_PARAMS, encodedText, from, from, to);
        
        HttpResponse result = new HttpClient().request(HttpMethod.GET, new StringBuilder(GOOGLE_URL_API).append(params).toString());
        
        return castResult(result.asString());
    }
    
    private String castResult(String result)
    {
       Pattern pat = Pattern.compile(PATTERN);
       List<String> allMatches = new ArrayList<String>();
       
       Matcher matcher = pat.matcher(result);
       
       while (matcher.find()) {
           allMatches.add(matcher.group().replace("\"", ""));
       }
       
       return allMatches.get(0);
    }


}
