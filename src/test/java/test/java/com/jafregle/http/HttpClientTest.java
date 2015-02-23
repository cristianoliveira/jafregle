package test.java.com.jafregle.http;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URL;

import main.java.com.jafregle.http.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class HttpClientTest {
    
    final String GITHUB_README = "https://raw.githubusercontent.com/DataPoa/datapoa-java-client/master/README.md";

    @Test
    public void testGivenOnlyUrlWhenGetRequestItShouldReturnHttpResponse() throws IOException 
    {
        // given
        HttpClient httpClient = new HttpClient();
        String googleUrl = GITHUB_README;
        
        // when
        HttpResponse response = httpClient.request(HttpMethod.POST, googleUrl);
        
        // then
        assertNotNull(response);
    }
    
    @Test
    public void testGivenValidParametersWhenGetRequestItShouldReturnHttpResponse() throws IOException
    {
        // given
        HttpClient httpClient = new HttpClient();
        String googleUrl = "http://google.com";
        HttpParameterSet parameters = HttpParameterSet.build();
        parameters.add(new HttpParameter("q","Test"));
        
        // when
        HttpResponse response = httpClient.request(HttpMethod.GET, googleUrl);
        
        // then
        assertNotNull(response);
    }
    
    @Test
    public void testGivenURLWhenGetRequestItShouldReturnHttpResponse() throws IOException
    {
        // given
        HttpClient httpClient = new HttpClient();
        URL googleUrl = new URL("http://google.com");
        HttpParameterSet parameters = HttpParameterSet.build();
        parameters.add(new HttpParameter("q","Test"));
        
        // when
        HttpResponse response = httpClient.request(HttpMethod.GET, googleUrl);
        
        // then
        assertEquals(response.getClass(), HttpResponse.class);
    }
    

    @Test(expected = IllegalArgumentException.class)
    public void testGivenInvalidUrlWhenGetRequestItShouldRaiseExceotion() throws IOException 
    {
        // given
        HttpClient httpClient = new HttpClient();
        String invalidUrl = "http://";
        
        // when
        httpClient.request(HttpMethod.POST, invalidUrl);
        
        // then raise IllegalArgumentException
    }
    

}
