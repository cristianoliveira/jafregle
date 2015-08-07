package com.jafregle;

import org.junit.Test;

import com.jafregle.Language;

import junit.framework.TestCase;

public class LanguageTest extends TestCase{
	
	private final String ENGLISH    = "en";
    private final String SPANISH    = "es";
    private final String PORTUGUESE = "pt";
    private final String GERMAN     = "gr";
    private final String FRENCH     = "fr";
	
	
	@Test
    public void testLanguageEnum() throws Exception {
        assertEquals(ENGLISH   , Language.ENGLISH.value());
        assertEquals(SPANISH   , Language.SPANISH.value());
        assertEquals(PORTUGUESE, Language.PORTUGUESE.value());
        assertEquals(GERMAN    , Language.GERMAN.value());
        assertEquals(FRENCH    , Language.FRENCH.value());
    }
}
