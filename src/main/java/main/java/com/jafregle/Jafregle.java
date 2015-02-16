package main.java.com.jafregle;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @author Cristian Oliveira
 * @author www.cristianoliveira.com.br
 */
  

public class Jafregle 
{
    
    private final String GOOGLE_URL_API = "http://translate.google.com/translate_a/";    
    private final String GOOGLE_PARAMS  = "t?client=t&text=%s&hl=%s&sl=%s&tl=%s&ie=UTF-8&oe=UTF-8&multires=1&otf=1&ssel=3&tsel=3&sc=1";
    private final String PATTERN = "\"([^\"]*?)\"";
    
    private List<String> cachedTranslates = new ArrayList<String>();
    
    private String from;
    private String to;
    
    public Jafregle(String from, String to)
    {
    	this.from = from;
    	this.to   = to;
    }
    
    public Jafregle(Language from, Language to)
    {
    	this.from = from.toString();
    	this.to   = to.toString();
    }
    
    /**
     *  Translate text string from language (Param "from") 
     *  to specific language (Param "to") 
     *
     * @param  textToTranslate  String text to translate
     * @return                  String with text translated
     * 
     */
    public String translate(String textToTranslate) throws Exception
    {
    	return translate(textToTranslate, from, to);
    }
    
    /**
     *  Translate text string from language (Param "from") to especific language (Param "to") 
     *
     * @param  textToTranslate  String text to translate
     * @param  from             Enum language from text
     * @param  to               Enum language to translate
     * @return                  String whit text translated
     * 
     */
    public String translate(String textToTranslate, Language from, Language to) throws Exception
    {
        return translate(textToTranslate, from.toString(), to.toString());
    }
    
    /**
     *  Translate text string from language (Param "from") to especific language (Param "to") 
     *
     * @param  textToTranslate  String text to translate
     * @param  from             String language from text
     * @param  to               String language to translate
     * @return                  String with text translated
     * 
     */
    public String translate(String textToTranslate, String from, String to) throws Exception
    {
    	if(textToTranslate.isEmpty() || from.isEmpty() || to.isEmpty() )
    		throw new JafregleParamsException();
    	
           String encodedText = java.net.URLEncoder.encode(textToTranslate, "UTF-8");
           String params      = String.format(GOOGLE_PARAMS, encodedText, from, from, to);
           String result      = new WebHelper().access(GOOGLE_URL_API, params);
           
           String raw = castResult(result);
           
           cachedTranslates.add(raw);
           
           return raw;
    }
    
    /**
     *  Return last translated text
     *
     *  @return String 
     * 
     */
    public String getLastTranslate()
    {
    	return cachedTranslates.get(cachedTranslates.size() - 1);
    }
    
    /**
     *  Translate text string from language (Param "from") to especific language (Param "to") 
     *
     * @return String with last text translated
     * 
     */
    public List<String> getCachedTranslate()
    {
    	return cachedTranslates;
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

    public enum Language
    {
        PORTUGUESE("pt"), 
        ENGLISH("en"), 
        FRENCH("fr"), 
        GERMAN("gr"), 
        SPANISH("es");
        
        String value;
        
        private Language(String value) {
        	this.value = value;
        }
        
        @Override
        public String toString(){
        	return this.value;
        }
    }
}
