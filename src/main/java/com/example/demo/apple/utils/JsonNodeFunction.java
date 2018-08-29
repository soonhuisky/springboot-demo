package com.example.demo.apple.utils;

import com.fasterxml.jackson.databind.JsonNode;

@FunctionalInterface
public interface JsonNodeFunction {
    public JsonNode apply(JsonNode jsonNode);
}
