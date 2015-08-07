package com.jafregle.translators;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jafregle.http.HttpClient;
import com.jafregle.http.HttpMethod;
import com.jafregle.http.HttpResponse;

public class FreeGoogleTranslator implements Translator {
    
    private final String GOOGLE_URL_API = "http://translate.google.com/translate_a/";    
    private final String GOOGLE_PARAMS  = "single?client=z&sl=%s&tl=%s-CN&ie=UTF-8&oe=UTF-8&dt=t&dt=rm&q=%s";
    private final String PATTERN = "\"(.*?)\"";
    
    @Override
    public String requestTranslation(String textToTranslate, String from, String to) throws IOException
    {
        String encodedText = java.net.URLEncoder.encode(textToTranslate, "UTF-8");
        String params      = String.format(GOOGLE_PARAMS, from, to, encodedText);
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
