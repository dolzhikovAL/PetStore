package com.petstore.controller.util;

public enum HttpHeaders {
    HOST("host"),
    CONNECTION("connection"),
    ACCEPT("accept"),
    USER_AGENT("user-agent"),
    REFERER("referer"),
    ACCEPT_ENCODING("accept-Encoding"),
    ACCEPT_LANGUAGE("accept-language"),
    CONTENT_TYPE("content-type"),
    API_KEY("api-key"),
    CONTENT_LENGTH("content-length");

    private String name;
    private String defaultValue;

    HttpHeaders(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefaultValue() {
        setDefValue();
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    private void setDefValue() {
        defaultValue = name.equals(HOST.name) ? "petstore.swagger.io" :
                name.equals(CONNECTION.name) ? "keep-alive" :
                        name.equals(ACCEPT.name) ? "application json" :
                                name.equals(USER_AGENT.name) ? "" :
                                        name.equals(REFERER.name) ? "http://petstore.swagger.io" :
                                                name.equals(ACCEPT_ENCODING.name) ? "gzip ,deflate" :
                                                        name.equals(ACCEPT_LANGUAGE.name) ? "en-US,en;q=0.9" : //?
                                                                name.equals(CONTENT_TYPE) ? "application/json" :
                                                                        null;

    }
}
