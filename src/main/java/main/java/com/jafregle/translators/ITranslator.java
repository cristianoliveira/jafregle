package main.java.com.jafregle.translators;

import java.io.IOException;

public interface ITranslator {
	
	public String requestTranslation(String textToTranslate, String from, String to) throws IOException;
	
}
