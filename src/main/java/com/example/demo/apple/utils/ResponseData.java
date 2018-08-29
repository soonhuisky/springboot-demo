package com.example.demo.apple.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseData {

    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    @JsonProperty("code")
    private String code;
    @JsonProperty("message")
    private String message;
    @JsonProperty("data")
    private Object data;

    public ResponseData(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResponseData success(Object data){
        return new ResponseData(SUCCESS, "", data);
    }

    public static ResponseData success(String message, Object data){
        return new ResponseData(SUCCESS, message, data);
    }

    public static ResponseData error(String message){
        return new ResponseData(ERROR, "", null);

    }

}
