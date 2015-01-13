package jafregle;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class WebHelper {
	
	public static String access(String url, String parameters) throws Exception {
        String fullUrl = url + parameters;
        URL myURL = new URL(fullUrl);
        HttpURLConnection httpCon = (HttpURLConnection)myURL.openConnection();
        httpCon.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
        httpCon.setRequestMethod("GET");
        httpCon.setRequestProperty("Accept-Charset", "UTF-8");
        httpCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpCon.setRequestProperty("Content-Length", "" + Integer.toString(10000));
        httpCon.setRequestProperty("Content-Language", "en-US");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(httpCon.getInputStream(), "UTF-8"));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
               response.append(inputLine);

        in.close();

        return response.toString();
    }
}
