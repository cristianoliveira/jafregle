package com.jafregle.http;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestFactory {

    public HttpRequest getRequest(HttpMethod method, String url,
                    HttpParameterSet parameters) throws IOException {
        HttpRequest request;

        if (method == HttpMethod.GET) {
            request = requestGET(url, parameters);
        } else {
            request = requestPOST(url, parameters);
        }

        return request;
    }

    private HttpRequest requestGET(String url, HttpParameterSet parameters)
                    throws IOException {
        StringBuilder request = new StringBuilder(url);
        String paramaters = new HttpParameterSetParser(parameters).asString();

        request.append(paramaters);

        HttpURLConnection httpConnection = getDefaultConnection(request
                        .toString());

        httpConnection.setRequestMethod(HttpMethod.GET.asString());
        httpConnection.setRequestProperty("Content-Length",
                        String.valueOf(paramaters.getBytes()));

        return new HttpRequest(httpConnection);
    }

    private HttpRequest requestPOST(String url, HttpParameterSet parameters)
                    throws IOException {
        String paramaters = new HttpParameterSetParser(parameters).asString();

        HttpURLConnection httpConnection = getDefaultConnection(url);
        httpConnection.setRequestMethod(HttpMethod.POST.asString());
        httpConnection.setRequestProperty("Content-Length",
                        String.valueOf(paramaters.getBytes()));

        httpConnection.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(
                        httpConnection.getOutputStream());

        writer.write(paramaters);
        writer.flush();

        return new HttpRequest(httpConnection);
    }

    private HttpURLConnection getDefaultConnection(String request)
                    throws IOException {
        URL urlRequest = new URL(request);
        HttpURLConnection httpConnection = (HttpURLConnection) urlRequest.openConnection();
        httpConnection.addRequestProperty("User-Agent", HttpClient.USERAGENT);
        httpConnection.setRequestProperty("Accept-Charset", HttpClient.CHARSET);
        httpConnection.setRequestProperty("Content-Type",
                        "application/x-www-form-urlencoded");
        httpConnection.setRequestProperty("Content-Language", "en-US");

        return httpConnection;
    }

}
