package com.example.demo.apple.utils;

import com.example.demo.apple.modle.Apple;

@FunctionalInterface
public interface ApplePredicate {
    boolean test(Apple apple);
}
