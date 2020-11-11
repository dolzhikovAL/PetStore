package com.petstore.controller.web;

import com.petstore.model.ApiResponse;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public interface Request<T> {
    T getById(int id);
    T GET(Map<String ,String> headers,Class<T> tClass);
    List<T> GETtList(Map<String ,String> headers, Type tClass);
    String POST(Map<String ,String> headers, T t);
    String PUT(Map<String ,String> headers, T t);
   String DELETE(Map<String ,String> headers,String apiKey);
}
