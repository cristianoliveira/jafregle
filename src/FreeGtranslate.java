
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
  

public class FreeGtranslate 
{
	
	static String GOOGLE_URL_API = "http://translate.google.com/translate_a/";	
        static String GOOGLE_PARAMS  = "t?client=t&text=%s&hl=%s&sl=%s&tl=%s&ie=UTF-8&oe=UTF-8&multires=1&otf=1&ssel=3&tsel=3&sc=1";
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
	       String _from       = languageToString(from);
               String _to         = languageToString(to);
               String encodedText = java.net.URLEncoder.encode(textToTranslate, "UTF-8");
               String params      = String.format(GOOGLE_PARAMS, encodedText, _from, _from, _to);
	       String response    = WebHelper.access(GOOGLE_URL_API, params);
	       
               return response;
	       
	}
	
         /**
	 *  Method: Convert enum to string
         */
	private static String languageToString(Language pLang)
	{
		switch (pLang) {
		case PORTUGUESE:
		     return "pt";
		case ENGLISH:
		     return "en";
                case SPANISH:
                     return "es";
		}
		return null;
	}	

	public enum Language
	{
		PORTUGUESE, ENGLISH, SPANISH
	}
}
