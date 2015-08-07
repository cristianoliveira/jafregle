package com.jafregle.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HttpResponse {

    InputStream inStream;

    public HttpResponse(InputStream inStream) {
        this.inStream = inStream;
    }

    public String asString() throws IOException {
        if (inStream == null)
            return null;

        BufferedReader in = new BufferedReader(new InputStreamReader(inStream, HttpClient.CHARSET));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            response.append(inputLine);

        in.close();

        return response.toString();
    }

}
