package com.jafregle.http;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jafregle.http.*;

public class HttpParameterSetParserTest {
    
    @Test
    public void testGivenNullWhenParseItShouldReturnEmptyString() {
        // given
        HttpParameterSetParser parser = new HttpParameterSetParser(null);
        String resultExpected = new String();
        
        // when
        String result = parser.asString();
        
        // then
        assertEquals(resultExpected, result);
    }
    
    @Test
    public void testGivenEmptyHttpParameterSetWhenParseItShouldReturnEmptyString()
    {
        // given
        HttpParameterSet parameters = HttpParameterSet.build();
        HttpParameterSetParser parser = new HttpParameterSetParser(parameters);
        String resultExpected = new String();
        
        // when
        String result = parser.asString();
        
        // then
        assertEquals(resultExpected, result);
    }
    
    @Test
    public void testGivenOneHttpParameterSetWhenParseItShouldReturnString()
    {
        // given
        HttpParameterSet parameters = HttpParameterSet.build();
        parameters.add(new HttpParameter("pname","pvalue"));
        HttpParameterSetParser parser = new HttpParameterSetParser(parameters);
        String resultExpected = "?pname=pvalue";
        
        // when
        String result = parser.asString();
        
        // then
        assertEquals(resultExpected, result);
    }
    
    @Test
    public void testGivenMoreThanOneHttpParameterSetWhenParseItShouldReturnString()
    {
        // given
        HttpParameterSet parameters = HttpParameterSet.build();
        parameters.add(new HttpParameter("pname","pvalue"));
        parameters.add(new HttpParameter("pname2","pvalue2"));
        parameters.add(new HttpParameter("pname3","pvalue3"));
        HttpParameterSetParser parser = new HttpParameterSetParser(parameters);
        String resultExpected = "?pname=pvalue&pname2=pvalue2&pname3=pvalue3";
        
        // when
        String result = parser.asString();
        
        // then
        assertEquals(resultExpected, result);
    }

}
