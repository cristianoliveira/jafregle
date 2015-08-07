package com.jafregle.translators;

import java.io.IOException;

import junit.framework.TestCase;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.jafregle.Jafregle;
import com.jafregle.Language;
import com.jafregle.translators.GoogleApiTranslator;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GoogleApiTranslatorTest extends TestCase{
	
	GoogleApiTranslator mockedGoogleApiTranslator = mock(GoogleApiTranslator.class);
    String mockedInput  = "it works";
    String mockedResult = "funciona";
    
	@Before
	public void setUp() throws IOException
	{
		when(mockedGoogleApiTranslator.requestTranslation( mockedInput
				                                         , Language.ENGLISH.value() 
				                                         , Language.PORTUGUESE.value())).
        thenReturn(mockedResult);
	}
	
	
    @Test
    public void testGivenEnglishToPortugueseAndItWorksItShouldToReturnFunciona() throws IOException
    {
    	// given 
    	String result = mockedGoogleApiTranslator.requestTranslation(mockedInput, Language.ENGLISH.value() , Language.PORTUGUESE.value());
    	
    	// then
    	assertEquals(mockedResult, result);
    }
    
    @Test(expected=Exception.class)
    public void testGivenInvalidParamItShouldToRaiseIllegalArgumentException() throws Exception
    {
    	// given
    	GoogleApiTranslator invalid = new GoogleApiTranslator("");
    	
    	// when
    	invalid.requestTranslation(mockedInput, Language.ENGLISH.value() , Language.PORTUGUESE.value());
    	
    	// then raise IllegalArgumentException
    }
    
    
}
