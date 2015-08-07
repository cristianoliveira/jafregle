package com.jafregle.http;

public class HttpParameterSetParser {

    HttpParameterSet parameters;

    public HttpParameterSetParser(HttpParameterSet parameters) {
        this.parameters = parameters;
    }

    public String asString() {
        if (this.parameters == null || this.parameters.toList().isEmpty())
            return new String();

        StringBuilder par = new StringBuilder("?");

        for (HttpParameter parameter : this.parameters.toList()) {
            par.append(parameter.getName());
            par.append("=");
            par.append(parameter.getValue());
            par.append("&");
        }

        return withoutLastCharacter(par);
    }

    private String withoutLastCharacter(StringBuilder stringBuilder) {
        String result = stringBuilder.toString();
        return result.substring(0, result.length() - 1);
    }
}
