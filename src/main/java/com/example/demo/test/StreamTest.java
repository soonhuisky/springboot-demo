package com.example.demo.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    private static Logger logger = LoggerFactory.getLogger("StreamTest");

    public static void main(String[] args) {

        long begin = System.currentTimeMillis();

        List<Double> collect = Stream.generate(Math::random)
                .limit(10)
                .collect(Collectors.toList());

        long step1 = System.currentTimeMillis();
        logger.info("create stream cost {} millis", (step1 - begin));


        //外部遍历
        List<Double> result = new ArrayList<>();
        for (double x : collect) {
            if (x > 0.6) {
                result.add(x);
            }
        }

        long step2 = System.currentTimeMillis();
        logger.info("for loop cost {} millis", (step2 - step1));


        //内部遍历
        List<Double> collect1 = collect.parallelStream()
                .filter(x -> x > 0.6)
                .collect(Collectors.toList());

        long step3 = System.currentTimeMillis();
        logger.info("stream loop cost {} millis", (step3 - step2));

        logger.info("finish");
    }
}
