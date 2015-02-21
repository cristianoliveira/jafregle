package test.java.com.jafregle.translators;

import java.io.IOException;

import junit.framework.TestCase;
import main.java.com.jafregle.Language;
import main.java.com.jafregle.translators.FreeGoogleTranslator;

import org.junit.Test;

public class FreeGoogleTranslatorTest extends TestCase {

    @Test
    public void testGivenPortugueseToEnglishAndFuncionaItShouldReturnItWorks() throws IOException
    {
        // given
        FreeGoogleTranslator translator = new FreeGoogleTranslator();
        String from = Language.PORTUGUESE.value();
        String to = Language.ENGLISH.value();
        String input = "funciona";
        String resultExpected = "it works";
        
        // when
        String result = translator.requestTranslation(input, from, to);
        
        // then
        assertEquals(resultExpected, result);
    }
}
