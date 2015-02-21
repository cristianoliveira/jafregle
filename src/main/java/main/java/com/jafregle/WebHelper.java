package main.java.com.jafregle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WebHelper {
    
    private static String USERAGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0";
    private static String CHARSET   = "UTF-8";
    
    public String access(String url, String parameters) throws IOException {
        return requestGET(url, parameters);
    }
    
    public String requestPOST(String url, String parameters) throws IOException  {
        
        StringBuilder fullUrl = new StringBuilder();
        fullUrl.append(url);
        
        URL myURL = new URL(fullUrl.toString());
        HttpURLConnection httpCon = (HttpURLConnection)myURL.openConnection();
        
        httpCon.setDoOutput(true);
            
        OutputStreamWriter writer = new OutputStreamWriter(httpCon.getOutputStream());
        writer.write(parameters);
        writer.flush();
        
        return doRequest(httpCon);
    }
    
    public String requestGET(String url, String params) throws IOException
    {
    	 StringBuilder fullUrl = new StringBuilder();
         fullUrl.append(url);
         fullUrl.append(params);
         
         URL myURL = new URL(fullUrl.toString());
         HttpURLConnection httpCon = (HttpURLConnection)myURL.openConnection();
         httpCon.setRequestMethod("GET");
         httpCon.setRequestProperty("Content-Length", String.valueOf(params.getBytes(CHARSET).length));
         
		 return doRequest(httpCon);

    }

	private String doRequest(HttpURLConnection httpCon) throws IOException {
		 
		setDefaultSettingsTo(httpCon);
		
		 BufferedReader in = new BufferedReader(new InputStreamReader(httpCon.getInputStream(), CHARSET));

         StringBuilder response = new StringBuilder();
         String inputLine;

         while ((inputLine = in.readLine()) != null) 
                response.append(inputLine);

         in.close();
         
		return response.toString();
	}
    
    private void setDefaultSettingsTo(HttpURLConnection httpCon)
    {
    	httpCon.addRequestProperty("User-Agent", USERAGENT);
        httpCon.setRequestProperty("Accept-Charset", CHARSET);
        httpCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpCon.setRequestProperty("Content-Language", "en-US");
    }
}
