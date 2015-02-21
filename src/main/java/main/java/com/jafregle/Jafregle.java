package main.java.com.jafregle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.java.com.jafregle.translators.FreeGoogleTranslator;
import main.java.com.jafregle.translators.ITranslator;

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
    private String from;
    private String to;
    
    private ITranslator translator;
    
    private JafregleCache jafregleCache;
    
    public Jafregle(String from, String to)
    {
        this.from = from;
        this.to   = to;
    }
    
    public Jafregle(Language from, Language to)
    {
        this.from = from.value();
        this.to   = to.value();
    }
    
    
    /**
     *  Translate text string from language (Param "from") 
     *  to specific language (Param "to") 
     *
     * @param  textToTranslate  String text to translate
     * @return                  String with text translated
     * 
     */
    public String translate(String textToTranslate) throws IOException
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
    public String translate(String textToTranslate, Language from, Language to) throws IOException
    {
        return translate(textToTranslate, from.value(), to.value());
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
    public String translate(String textToTranslate, String from, String to) throws IllegalArgumentException, IOException
    {
        if(textToTranslate.isEmpty() || from.isEmpty() || to.isEmpty() )
        {
           throw new IllegalArgumentException("All params must be informed");
        }
        
        String result = getTranslator().requestTranslation(textToTranslate, from, to);
           
        getCacheHandler().add(result);
           
        return result;
    }
    
    /**
     * Set translator to be used
     *
     * @param  translator       ITranslator Interface
     * 
     */
    public void setTranslator(ITranslator translator)
    {
        this.translator = translator;
    }
    
    /**
     * Get current translator 
     *
     * @return  translator       ITranslator Interface
     * 
     */
    public ITranslator getTranslator() 
    {
        if (translator == null) 
        {
            translator = new FreeGoogleTranslator();
        }
        
        return translator;
    }
    
    /**
     * Get cache handler
     *
     * @return  JafregleCache    
     * 
     */
    public JafregleCache getCacheHandler()
    {
        if(jafregleCache == null)
        {
            jafregleCache = new JafregleCache();
        }
        
        return jafregleCache;
    }
}
