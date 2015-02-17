package test.java.com.jafregle;

import junit.framework.TestCase;
import main.java.com.jafregle.Jafregle;
import main.java.com.jafregle.Jafregle.Language;
import main.java.com.jafregle.JafregleParamsException;

import org.junit.Test;
import org.junit.runners.JUnit4;

public class JafregleTest extends TestCase{
	
	private final String ENGLISH    = "en";
	private final String SPANISH    = "es";
	private final String PORTUGUESE = "pt";
	private final String GERMAN     = "gr";
	private final String FRENCH     = "fr";
	
    @Test
	public void testLanguageEnum() throws Exception {
		assertEquals(ENGLISH   , Jafregle.Language.ENGLISH.toString());
		assertEquals(SPANISH   , Jafregle.Language.SPANISH.toString());
		assertEquals(PORTUGUESE, Jafregle.Language.PORTUGUESE.toString());
		assertEquals(GERMAN    , Jafregle.Language.GERMAN.toString());
		assertEquals(FRENCH    , Jafregle.Language.FRENCH.toString());
	}
	
	@Test
	public void testEnglishToPortuguese() throws Exception {
		Jafregle j = new Jafregle(ENGLISH, PORTUGUESE);
		assertEquals("Olá", j.translate("Hello"));
	}
	
	@Test
	public void testEnglishToPortugueseEnum() throws Exception {
		Jafregle j = new Jafregle(Language.ENGLISH, Language.PORTUGUESE);
		assertEquals("Olá", j.translate("Hello"));
	}

	@Test
	public void testEspanholToEnglish() throws Exception {
		Jafregle j = new Jafregle(SPANISH, ENGLISH);
		assertEquals("hello", j.translate("Hola"));
	}
	
	@Test
	public void testEspanholToEnglishEnum() throws Exception {
		Jafregle j = new Jafregle(Language.SPANISH, Language.ENGLISH);
		assertEquals("hello", j.translate("Hola"));
	}
	
	@Test
	public void testPrhaseTranslate() throws Exception {
		Jafregle j = new Jafregle(Language.PORTUGUESE, Language.ENGLISH);
		assertEquals("This is a translated phrase",j.translate("Isso é uma frase traduzida"));
	}
	
	@Test 
	public void testCachedTranslate() throws Exception
	{
		Jafregle j = new Jafregle(Language.PORTUGUESE, Language.ENGLISH);
		String translated = j.translate("Hello");
		
		assertEquals(translated, j.getLastTranslate());
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
}