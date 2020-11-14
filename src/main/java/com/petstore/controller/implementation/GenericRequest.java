package com.petstore.controller.implementation;

import com.petstore.controller.util.HttpHeaders;
import com.petstore.controller.util.HttpVersion;
import com.petstore.controller.util.RequestCommand;
import com.petstore.controller.web.WebClient;
import com.petstore.model.ApiResponse;
import com.petstore.model.EntityPath;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericRequest<T extends EntityPath> {
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
        headers.put("startLine", startGenerate(RequestCommand.GET, path, HttpVersion.HTTP_1_1));
        return (T) webClient.GET(headers, clazz);


    }

    private String startGenerate(RequestCommand command, String path, HttpVersion version) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(command.name()).append(" ").append(path).append(" ").append(version.getName());
        return String.valueOf(stringBuilder);
    }

    List<T> getListEntity(String path, Type clazz) {
        String startLine = startGenerate(RequestCommand.GET, path, HttpVersion.HTTP_1_1);
        headers.put("startLine", startLine);
        return (List<T>) webClient.GETtList(headers, clazz);

    }

    String getStringResult(String path) {
        String startLine = startGenerate(RequestCommand.GET, path, HttpVersion.HTTP_1_1);
        headers.put("startLine", startLine);
        try {
            return webClient.getResponseString(headers);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    String postEntity(T t) {
        String startLine = startGenerate(RequestCommand.POST, t.getPath(), HttpVersion.HTTP_1_1);
        headers.put("startLine", startLine);
        return webClient.POST(headers, t);
    }


    String putEntity(T t) {
        String startLine = startGenerate(RequestCommand.PUT, t.getPath(), HttpVersion.HTTP_1_1);
        headers.put("startLine", startLine);
        return webClient.PUT(headers, t);
    }

    ApiResponse deleteEntity(String path, String apiKey) {
        String startLine = startGenerate(RequestCommand.DELETE, path, HttpVersion.HTTP_1_1);
        headers.put("startLine", startLine);
        return webClient.DELETE(headers, apiKey);
    }
}
