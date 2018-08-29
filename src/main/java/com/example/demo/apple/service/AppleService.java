package com.example.demo.apple.service;

import com.example.demo.apple.modle.Apple;
import com.example.demo.apple.utils.ApplePredicate;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface AppleService {
    CompletableFuture<String> getApple();

    CompletableFuture<String> getAppleFunction(ApplePredicate predicate);

    CompletableFuture<List<Apple>> list();

    CompletableFuture<Optional<Apple>> getById(String id);

    CompletableFuture<Optional<Apple>> add(Apple apple);
}
