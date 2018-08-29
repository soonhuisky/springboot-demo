package com.example.demo.apple.service;

import com.example.demo.apple.modle.Apple;
import com.example.demo.apple.utils.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        String json = "{\"apples\":[{\"colour\":\"red\",\"weight\":3.2,\"name\":\"tom\"},{\"colour\":\"red\",\"weight\":2.6,\"name\":\"zhangsan\"},{\"colour\":\"green\",\"weight\":4.2,\"name\":\"lisi\"}]}";

        List<Apple> apples = JsonUtil.toList(json, new TypeReference<List<Apple>>() {
        }, x -> x.get("apples"));

        System.out.println(apples);
    }
}
