package com.jafregle.translators;

import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Test;

import com.jafregle.Language;
import com.jafregle.translators.FreeGoogleTranslator;

public class FreeGoogleTranslatorTest extends TestCase {

    @Test
    public void testGivenPortugueseToEnglishAndFuncionaItShouldReturnItWorks() throws IOException
    {
        // given
        FreeGoogleTranslator translator = new FreeGoogleTranslator();
        String from = Language.PORTUGUESE.value();
        String to = Language.ENGLISH.value();
        String input = "Funciona";
        String resultExpected = "It works";
        
        // when
        String result = translator.requestTranslation(input, from, to);
        
        // then
        assertEquals(resultExpected, result);
    }
}
