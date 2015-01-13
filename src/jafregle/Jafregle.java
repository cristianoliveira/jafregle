package jafregle;

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
    
    private static final String GOOGLE_URL_API = "http://translate.google.com/translate_a/";    
    private static final String GOOGLE_PARAMS  = "t?client=t&text=%s&hl=%s&sl=%s&tl=%s&ie=UTF-8&oe=UTF-8&multires=1&otf=1&ssel=3&tsel=3&sc=1";
    private static final String PATTERN = "\"([^\"]*?)\"";
    
    /**
     *  Translate text string from language (Param "from") to especific language (Param "to") 
     *
     * @param  textToTranslate  String text to translate
     * @param  from             Enum language from text
     * @param  to               Enum language to translate
     * @return                  String whit text translated
     * 
     */
    public static String translate(String textToTranslate, Language from, Language to) throws Exception
    {
        return translate(textToTranslate, from.toString(), to.toString());
    }
    
    public static String translate(String textToTranslate, String from, String to) throws Exception
    {
           String encodedText = java.net.URLEncoder.encode(textToTranslate, "UTF-8");
           String params      = String.format(GOOGLE_PARAMS, encodedText, from, from, to);
           String result      = WebHelper.access(GOOGLE_URL_API, params);
           
           List<String> translates = cleanResult(result);
           
           return translates.get(0);
    }
    
    private static List<String> cleanResult(String result)
    {
        Pattern pat = Pattern.compile(PATTERN);
        List<String> allMatches = new ArrayList<String>();
        
        Matcher matcher = pat.matcher(result);
        
        while (matcher.find()) {
            allMatches.add(matcher.group().replace("\"", ""));
        }
        
        return allMatches;
    }

    public enum Language
    {
        PORTUGUESE("pt"), 
        ENGLISH("en"), 
        SPANISH("es"),
        GERMAN("de"),
        FRENCH("fr");
        
        private String value;
        
        Language(String value)
        {
        	this.value = value;
        }
        
        @Override
        public String toString()
        {
            return this.value;
        }
    }
}
