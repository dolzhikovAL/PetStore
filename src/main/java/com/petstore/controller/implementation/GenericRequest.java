package com.petstore.controller.implementation;

import com.petstore.controller.util.HttpHeaders;
import com.petstore.controller.util.RequestCommand;
import com.petstore.controller.web.WebClient;
import com.petstore.model.EntityPath;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericRequest<T extends EntityPath> {
    private final String version = "HTTP/1.1";
    static WebClient webClient;
    private Map<String, String> headers = new HashMap<>();


    static {
        try {
            webClient = new WebClient(HttpHeaders.HOST.getDefaultValue(), 80);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    GenericRequest() {
        headers.put(HttpHeaders.HOST.getName(), HttpHeaders.HOST.getDefaultValue());
        headers.put(HttpHeaders.ACCEPT.getName(), HttpHeaders.ACCEPT.getDefaultValue());
        headers.put(HttpHeaders.ACCEPT_LANGUAGE.getName(), HttpHeaders.ACCEPT_LANGUAGE.getDefaultValue());
        headers.put(HttpHeaders.ACCEPT_ENCODING.getName(), HttpHeaders.ACCEPT_ENCODING.getDefaultValue());
        headers.put(HttpHeaders.REFERER.getName(), HttpHeaders.REFERER.getDefaultValue());
        headers.put(HttpHeaders.CONNECTION.getName(), HttpHeaders.CONNECTION.getDefaultValue());
    }

    T getEntityByPath(String path, Class clazz) {
        StringBuilder stringBuilder = new StringBuilder();
        headers.put("startLine", startGenerate(RequestCommand.GET, path));
        T t = (T) webClient.GET(headers, clazz);
        return t;

    }

    private String startGenerate(RequestCommand command, String path) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(command.name()).append(" ").append(path).append(" ").append(version);
        return String.valueOf(stringBuilder);
    }

    List<T> getListEntity(String path, Type clazz) {
        String startLine = startGenerate(RequestCommand.GET, path);
        headers.put("startLine", startLine);
        List<T> list = (List<T>) webClient.GETtList(headers, clazz);
        return list;
    }

    String getStringResult(String path) {
        String startLine = startGenerate(RequestCommand.GET, path);
        headers.put("startLine", startLine);
        try {
            return webClient.getResponseString(headers);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    String postEntity(T t) {
        String startLine = startGenerate(RequestCommand.POST, t.getPath());
        headers.put("startLine", startLine);
        return webClient.POST(headers, t);
    }

    String postEntity(T[] t) {
        String startLine = startGenerate(RequestCommand.POST, t[0].getPath() + "--- create from array");
        headers.put("startLine", startLine);
        return webClient.POST(headers, t);
    }

    String putEntity(T t) {
        String startLine = startGenerate(RequestCommand.POST, t.getPath());
        headers.put("startLine", startLine);
        return webClient.PUT(headers, t);
    }

    String deleteEntity(String path,String apiKey) {
        String startLine = startGenerate(RequestCommand.POST, path);
        headers.put("startLine", startLine);
        return webClient.DELETE(headers,apiKey);
    }
}
