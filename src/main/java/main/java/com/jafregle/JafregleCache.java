package main.java.com.jafregle;

import java.util.ArrayList;
import java.util.List;

public class JafregleCache {

	private List<String> cachedTranslates = new ArrayList<String>();
	
	public void add(String textTranslated)
	{
		cachedTranslates.add(textTranslated);
	}
	
	public String getLast()
	{
		return cachedTranslates.get(cachedTranslates.size() - 1);
	}
	
	public String get(int index)
	{
		return cachedTranslates.get(index);
	}
	
	public void clean()
	{
		cachedTranslates.clear();
	}
}
