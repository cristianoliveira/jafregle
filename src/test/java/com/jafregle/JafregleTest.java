package test.java.com.jafregle;

import junit.framework.TestCase;
import main.java.com.jafregle.Jafregle;

import org.junit.Test;

public class JafregleTest extends TestCase{
	
	@Test
	public void testLanguageEnum() throws Exception {
		assertEquals("en", Jafregle.Language.ENGLISH.toString());
		assertEquals("es", Jafregle.Language.SPANISH.toString());
		assertEquals("pt", Jafregle.Language.PORTUGUESE.toString());
		assertEquals("gr", Jafregle.Language.GERMAN.toString());
		assertEquals("fr", Jafregle.Language.FRENCH.toString());
	}
	
	@Test
	public void testEnglishToPortuguese() throws Exception {
		assertEquals("Olá", Jafregle.translate("Hello", "en", "pt"));
	}
	
	@Test
	public void testEnglishToPortugueseEnum() throws Exception {
		assertEquals("Olá", Jafregle.translate("Hello"
				                              , Jafregle.Language.ENGLISH
				                              , Jafregle.Language.PORTUGUESE));
	}

	@Test
	public void testEspanholToEnglish() throws Exception {
		assertEquals("hello", Jafregle.translate("Hola", "es", "en"));
	}
	
	@Test
	public void testEspanholToEnglishEnum() throws Exception {
		assertEquals("hello", Jafregle.translate("Hola"
				                                , Jafregle.Language.SPANISH
				                                , Jafregle.Language.ENGLISH));
	}
	
	@Test
	public void testPrhaseTranslate() throws Exception {
		assertEquals("This is a phrase translation", 
				     Jafregle.translate("Isso é uma tradução de frase"
				                       , Jafregle.Language.PORTUGUESE
				                       , Jafregle.Language.ENGLISH));
	}
}
