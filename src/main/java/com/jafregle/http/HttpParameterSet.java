package com.jafregle.http;

import java.util.ArrayList;
import java.util.List;

public class HttpParameterSet {

    List<HttpParameter> parameters = new ArrayList<HttpParameter>();

    public static HttpParameterSet build() {
        return new HttpParameterSet();
    }

    public void add(HttpParameter parameter) {
        parameters.add(parameter);
    }

    public List<HttpParameter> toList() {
        return parameters;
    }

}
