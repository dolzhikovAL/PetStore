package com.petstore.controller.util;

public enum HttpVersion {
    HTTP_1_1("HTTP/1.1"),HTTP_1_0("HTTP/1.0");

    HttpVersion(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
