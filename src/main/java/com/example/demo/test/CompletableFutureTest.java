package com.example.demo.test;

import com.example.demo.apple.controller.AppleController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {

    private static Logger logger = LoggerFactory.getLogger(AppleController.class);

    public static void main(String[] args) {

        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("111");
            return "str1";
        });



        logger.info("11111");

        CompletableFuture<String> stringCompletableFuture1 = stringCompletableFuture.thenApplyAsync(x -> {
            logger.info(String.valueOf(stringCompletableFuture.isDone()));
            logger.info("222");
            return "str2";
        });

        logger.info("22222");

    }
}
