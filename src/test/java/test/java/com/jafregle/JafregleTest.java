package test.java.com.jafregle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import main.java.com.jafregle.Jafregle;
import main.java.com.jafregle.Language;
import main.java.com.jafregle.translators.FreeGoogleTranslator;
import main.java.com.jafregle.translators.GoogleTranslator;
import main.java.com.jafregle.translators.ITranslator;
import main.java.com.jafregle.JafregleParamsException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class JafregleTest extends TestCase {
    
    private final String ENGLISH    = "en";
    private final String SPANISH    = "es";
    private final String PORTUGUESE = "pt";
    private final String GERMAN     = "gr";
    private final String FRENCH     = "fr";
    
    List<ITranslator> translators   = new ArrayList<ITranslator>();
    
    @Before
    public void setTranslatorsToTest()
    {
    	GoogleTranslator googleTranslator = new GoogleTranslator();
    	googleTranslator.setGoogleKey("AIzaSyBgY1lZxik73mVrG2SDalAW5zsoaTuflcM");
    	
    	translators.add(new FreeGoogleTranslator());
    	translators.add(googleTranslator);
    }
    
    @Mock
    private ITranslator mockedTranlator;
    
    @Test
    public void testLanguageEnum() throws Exception {
        assertEquals(ENGLISH   , Language.ENGLISH.value());
        assertEquals(SPANISH   , Language.SPANISH.value());
        assertEquals(PORTUGUESE, Language.PORTUGUESE.value());
        assertEquals(GERMAN    , Language.GERMAN.value());
        assertEquals(FRENCH    , Language.FRENCH.value());
    }
    
    @Test
    public void testEnglishToPortuguese() throws Exception {
        Jafregle j = new Jafregle(ENGLISH, PORTUGUESE);
        
        for (ITranslator translator : translators) {
			j.setTranslator(translator);
		    assertEquals("funciona", j.translate("It works"));
        }
    }
    
    @Test
    public void testEnglishToPortugueseEnum() throws Exception {
        Jafregle j = new Jafregle(Language.ENGLISH, Language.PORTUGUESE);
        
        for (ITranslator translator : translators) {
			j.setTranslator(translator);
			assertEquals("funciona", j.translate("It works"));
	    }
    }

    @Test
    public void testEspanholToEnglish() throws Exception {
        Jafregle j = new Jafregle(SPANISH, ENGLISH);
        
        for (ITranslator translator : translators) {
			j.setTranslator(translator);
			assertEquals("hello", j.translate("Hola"));
	    }   
    }
    
    @Test
    public void testEspanholToEnglishEnum() throws Exception {
        Jafregle j = new Jafregle(Language.SPANISH, Language.ENGLISH);
        
        for (ITranslator translator : translators) {
			j.setTranslator(translator);
		    assertEquals("hello", j.translate("Hola"));
		}
    }
    
    @Test
    public void testPrhaseTranslate() throws Exception {
        Jafregle j = new Jafregle(Language.PORTUGUESE, Language.ENGLISH);
        
        for (ITranslator translator : translators) {
			j.setTranslator(translator);
			assertEquals("A translated phrase",j.translate("Uma frase traduzida"));
		}
    }
    
    @Test 
    public void testCachedTranslate() throws Exception
    {
        Jafregle j = new Jafregle(Language.PORTUGUESE, Language.ENGLISH);
        String translated = j.translate("Hello");
        
        assertEquals(translated, j.getCacheHandler().getLast());
    }
    
    @Test
    public void testNewTranslator()
    {
    	Jafregle j =  new Jafregle(Language.ENGLISH, Language.FRENCH);
    	j.setTranslator(new TestFakeTranslator());
    	
    	try {
			assertEquals("It is fake", j.translate("It is fake"));
		} catch (IOException e) {
			fail(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    @Test
    public void testMockedTranslater(){
    	String textToTranslate = "It works";
    	String textResult = "funciona";
    	
    	FreeGoogleTranslator mockedTranlator = Mockito.mock(FreeGoogleTranslator.class);
    	try {
			Mockito.when(mockedTranlator.requestTranslation(textToTranslate, Language.ENGLISH.value(), Language.PORTUGUESE.value()))
			       .thenReturn(textResult);
			
			Jafregle j = new Jafregle(Language.ENGLISH, Language.PORTUGUESE);
			j.setTranslator(mockedTranlator);
			
			String result = j.translate(textToTranslate);
			
			assertEquals(result, textResult);
		} catch (IOException e) {
			fail(e.getMessage());
		}
    }
    
    @Test
    public void testInvalidParams()
    {
        Jafregle invalid = new Jafregle("", "");
        try {
            String foo = invalid.translate("foo");
            fail("Without params it must raise a error");
        } catch (Exception e) {
            assertEquals(e.getClass(), JafregleParamsException.class);
        }
    }
    
    
    class TestFakeTranslator implements ITranslator
    {
		@Override
		public String requestTranslation(String textToTranslate, String from,String to) throws IOException {
			return textToTranslate;
		}
    	
    }
}