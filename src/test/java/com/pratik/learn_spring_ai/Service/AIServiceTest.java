package com.pratik.learn_spring_ai.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AIServiceTest {

    @Autowired
    private AIService aiService;

    @Test
    public void testGetJoke(){
        var joke = aiService.getJokes("Dog");
        System.out.printf(joke);
    }

}