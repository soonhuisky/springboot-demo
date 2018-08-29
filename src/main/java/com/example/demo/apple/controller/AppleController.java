package com.example.demo.apple.controller;

import com.example.demo.apple.modle.Apple;
import com.example.demo.apple.service.AppleService;
import com.example.demo.apple.utils.ResponseData;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/hello")
public class AppleController {

    private static Logger logger = LoggerFactory.getLogger(AppleController.class);

    @Autowired
    private AppleService appleService;


    @RequestMapping(value = "/apple", method = RequestMethod.GET)
    @ResponseBody
    public CompletableFuture<String> test0() {
        logger.info("controller ");
        return appleService.getApple();
    }

    @RequestMapping(value = "/apples", method = RequestMethod.GET)
    @ResponseBody
    public CompletableFuture<ResponseData> list(){
        return appleService.list().thenApplyAsync(ResponseData::success);
    }


    @RequestMapping(value = "/apples", method = RequestMethod.POST)
    @ResponseBody
    public CompletableFuture<ResponseData> add(@RequestBody Apple apple){
        return appleService.add(apple)
                .thenApplyAsync(x -> x.map(ResponseData::success)
                        .orElse(ResponseData.error("add apple error")));
    }
}
