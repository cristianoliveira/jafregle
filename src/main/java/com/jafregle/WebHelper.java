package main.java.com.jafregle;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class WebHelper {
	
	private static String USERAGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0";
	private static String CHARSET   = "UTF-8";
	
	public static String access(String url, String parameters) throws Exception {
		return access(url, parameters, Method.GET);
	}
	public static String access(String url, String parameters, Method method) throws Exception {
        
		String fullUrl = url;
        
        if(method == Method.GET)
        	fullUrl += parameters;
        
        URL myURL = new URL(fullUrl);
        HttpURLConnection httpCon = (HttpURLConnection)myURL.openConnection();
        httpCon.addRequestProperty("User-Agent", USERAGENT);
        httpCon.setRequestMethod("GET");
        httpCon.setRequestProperty("Accept-Charset", CHARSET);
        httpCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpCon.setRequestProperty("Content-Length", "" + Integer.toString(10000));
        httpCon.setRequestProperty("Content-Language", "en-US");
        
        if(method == Method.POST)
        {
        	httpCon.setDoOutput(true);
        	
        	OutputStreamWriter writer = new OutputStreamWriter(httpCon.getOutputStream());
	        writer.write(parameters);
	        writer.flush();
        }
        
        BufferedReader in = new BufferedReader(new InputStreamReader(httpCon.getInputStream(), CHARSET));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
               response.append(inputLine);

        in.close();

        return response.toString();
    }
	
	public enum Method
	{
		
		POST("POST"), 
		GET("GET"), 
		DELETE("DELETE"), 
		PUT("PUT");
		
		private String val;
		Method(String val)
		{
			this.val = val;
		}
		
		@Override
		public String toString()
		{
			return this.val;
		}
	}
}
