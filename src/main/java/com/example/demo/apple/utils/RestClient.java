package com.example.demo.apple.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Component
public class RestClient {

    private final RestTemplate restTemplate;

    @Autowired
    public RestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public <T> CompletableFuture<Optional<T>> getByFunction(String url, Class<T> tClass, JsonNodeFunction function) {
        return CompletableFuture.supplyAsync(() -> {
            JsonNode body = restTemplate.getForEntity(url, JsonNode.class).getBody();
            JsonNode apply = function.apply(body);
            return JsonUtil.toObject(apply.toString(), tClass);
        }).exceptionally(x -> Optional.empty());
    }


    public <T> CompletableFuture<List<T>> getListByFunction(String url, TypeReference typeReference, JsonNodeFunction function) {
        return CompletableFuture.supplyAsync(() -> {
            JsonNode body = restTemplate.getForEntity(url, JsonNode.class).getBody();
            return JsonUtil.toList(body.toString(), typeReference, function);
        });
    }


    public <T> CompletableFuture<Optional<T>> postBody(String url, JsonNode body, Class<T> tClass) {
        return CompletableFuture.supplyAsync(() -> {
            ResponseEntity<T> tResponseEntity = restTemplate.postForEntity(url, body, tClass);
            return Optional.ofNullable(tResponseEntity.getBody());
        }).exceptionally(x -> Optional.empty());
    }
}
