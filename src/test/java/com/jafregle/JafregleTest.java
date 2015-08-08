package com.jafregle;

import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import org.mockito.runners.MockitoJUnitRunner;

import com.jafregle.Jafregle;
import com.jafregle.Language;
import com.jafregle.translators.FreeGoogleTranslator;
import com.jafregle.translators.Translator;

@RunWith(MockitoJUnitRunner.class)
public class JafregleTest extends TestCase {

    @Mock private Translator tranlator;
    @Mock private Jafregle jafregle;
    private String mockedInput  = "test input";
    private String mockedResult = "entrada de teste";
    
    
    @Before
    public void setTranslatorsToTest() throws IOException
    {   
        // set up translator
        tranlator = new FreeGoogleTranslator();
        jafregle = new Jafregle(tranlator);
    }
    
    @Test
    public void whenEnglishToPortugueseGivenItWorksShouldReturnFunciona() throws IOException {
        
        // when
        String input = "It works";
        String resultExpected = "Isso funciona";
        
        //when
        String result = jafregle.translate(input, Language.ENGLISH, Language.PORTUGUESE);
        
        // then
        assertEquals(resultExpected, result);
    }
    
    @Test
    public void whenSpanishToEnglishGivenHelloShouldReturnHola() throws IOException {
        
        // given
        String input = "Hello";
        String resultExpected = "Hola";
        
        // when
        String result = jafregle.translate(input, Language.ENGLISH, Language.SPANISH);
        
        // then
        assertEquals(resultExpected, result);
    }
    
    @Test
    public void whenGivenMoreThanOneWordShouldItWorks() throws IOException {
        
        // given
        String input = "a big phrase with many words";
        String resultExpected = "uma grande frase com muitas palavras";
        
        // when
        String result = jafregle.translate(input, Language.ENGLISH, Language.PORTUGUESE);
        
        // then
        assertEquals(resultExpected, result);
    }
    
    @Test 
    public void givenAnythingWhenTranslateItShouldToCacheIt() throws Exception
    {   
        // given
        String someInput = "test input";
        
        // when
        String result = jafregle.translate(someInput, Language.ENGLISH, Language.PORTUGUESE);
        String resultExpected = jafregle.getCacheHandler().getLast();
        
        // then
        assertEquals(resultExpected, result);
    }
    
    @Test
    public void whenSetNewTranslatorItShouldWorks() throws IOException
    {
        // when
        jafregle.setTranslator(tranlator);
        String result = jafregle.translate(mockedInput, Language.ENGLISH, Language.PORTUGUESE);
        
        //then
        assertEquals(mockedResult, result);
    }
}