package test.java.com.jafregle;

import java.io.IOException;

import junit.framework.TestCase;
import main.java.com.jafregle.Jafregle;
import main.java.com.jafregle.Language;
import main.java.com.jafregle.translators.ITranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class JafregleTest extends TestCase {

    @Mock private ITranslator mockedTranlator;
    @Mock private Jafregle mockedJafregle;
    private String mockedInput  = "test input";
    private String mockedResult = "test result";
    
    
    @Before
    public void setTranslatorsToTest() throws IOException
    {
        // set up jafregle
        mockedJafregle  = mock(Jafregle.class);
        when(mockedJafregle.translate(mockedInput)).thenReturn(mockedResult);
        
        // set up translator
        mockedTranlator = Mockito.mock(ITranslator.class);
        when(mockedTranlator.requestTranslation( mockedInput
                                               , Language.ENGLISH.value()
                                               , Language.PORTUGUESE.value())).
        thenReturn(mockedResult);
    }
    
    @Test
    public void whenEnglishToPortugueseGivenItWorksShouldReturnFunciona() throws IOException {
        
        // when
        Jafregle j = new Jafregle(Language.ENGLISH, Language.PORTUGUESE);
        String input = "It works";
        String resultExpected = "funciona";
        
        //when
        String result = j.translate(input);
        
        // then
        assertEquals(resultExpected, result);
    }
    
    @Test
    public void whenSpanishToEnglishGivenHelloShouldReturnHola() throws IOException {
        
        // given
        Jafregle j = new Jafregle(Language.ENGLISH, Language.SPANISH);
        String input = "hello";
        String resultExpected = "hola";
        
        // when
        String result = j.translate(input);
        
        // then
        assertEquals(resultExpected, result);
    }
    
    @Test
    public void whenGivenMoreThanOneWordShouldItWorks() throws IOException {
        
        // given
        Jafregle j = new Jafregle(Language.ENGLISH, Language.PORTUGUESE);
        String input = "a big phrase with many words";
        String resultExpected = "uma grande frase com muitas palavras";
        
        // when
        String result = j.translate(input);
        
        // then
        assertEquals(resultExpected, result);
    }
    
    @Test 
    public void givenAnythingWhenTranslateItShouldToCacheIt() throws Exception
    {   
        Jafregle j = new Jafregle(Language.ENGLISH, Language.ENGLISH);
        
        // when
        String result = j.translate(mockedInput);
        String resultExpected = j.getCacheHandler().getLast();
        
        // then
        assertEquals(resultExpected, result);
    }
    
    @Test
    public void whenSetNewTranslatorItShouldWorks() throws IOException
    {
        // when
        mockedJafregle.setTranslator(mockedTranlator);
        String result = mockedJafregle.translate(mockedInput);
        
        //then
        assertEquals(mockedResult, result);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void givenWrongParamsItShouldToRaiseException() throws IOException
    {
        // given
        Jafregle invalid = new Jafregle("", "");
        
        // when 
        invalid.translate("");
        
        // then raise a Excepion
    }
    
}