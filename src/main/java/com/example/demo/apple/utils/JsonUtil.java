package com.example.demo.apple.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static Optional<JsonNode> toJson(String str){
        try {
            return Optional.ofNullable(objectMapper.readTree(str));
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    public static Optional<String> toJson(Object object){
        try {
            return Optional.ofNullable(objectMapper.writeValueAsString(object));
        } catch (IOException e) {
            return Optional.empty();
        }
    }


    public static Optional<JsonNode> Object2Json(Object object){
        try {
            String tem = objectMapper.writeValueAsString(object);
            return Optional.ofNullable(objectMapper.readTree(tem));
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    public static <T> Optional<T> toObject(String str, Class<T> tClass){
        try {
            return Optional.ofNullable(objectMapper.readValue(str, tClass));
        } catch (IOException e) {
            return Optional.empty();
        }
    }

    public static <T> List<T> toList(String str, TypeReference typeReference, JsonNodeFunction function){
        try {
            if (JsonUtil.toJson(str).isPresent()){
                JsonNode apply = function.apply(JsonUtil.toJson(str).get());
                return objectMapper.readValue(apply.toString(), typeReference);
            } else {
                return Collections.emptyList();
            }
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    public static <T> List<T> toList(JsonNode jsonNode, TypeReference typeReference){
        try {
            if (JsonUtil.toJson(jsonNode).isPresent()){
                return objectMapper.readValue(jsonNode.toString(), typeReference);
            } else {
                return Collections.emptyList();
            }
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }
}
