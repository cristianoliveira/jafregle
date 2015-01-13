package tests;

import static org.junit.Assert.*;
import jafregle.Jafregle;

import org.junit.Test;

public class JafregleTest {
	
	@Test
	public void testEnglishEnum() throws Exception {
		assertEquals("en", Jafregle.Language.ENGLISH.toString());
	}

	@Test
	public void testSpanishEnum() throws Exception {
		assertEquals("es", Jafregle.Language.SPANISH.toString());
	}
	
	@Test
	public void testPortugueseEnum() throws Exception {
		assertEquals("pt", Jafregle.Language.PORTUGUESE.toString());
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
		String res = Jafregle.translate("Hola", "es", "en");
		assertEquals("hello", res);
	}
	
	@Test
	public void testEspanholToEnglishEnum() throws Exception {
		String res = Jafregle.translate("Hola"
				                       , Jafregle.Language.SPANISH
                                       , Jafregle.Language.ENGLISH);
		assertEquals("hello", res);
	}
}
