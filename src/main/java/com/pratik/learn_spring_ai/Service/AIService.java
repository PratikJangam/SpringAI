package com.pratik.learn_spring_ai.Service;

import com.pratik.learn_spring_ai.dto.Joke;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AIService {

    private final ChatClient chatClient;

    public String getJokes(String topic){

        String systemPrompt = """
            You are joker, and make joke on topic: {topic}
            """;
        PromptTemplate promptTemplate = new PromptTemplate(systemPrompt);
        String renderedText = promptTemplate.render(Map.of("topic", topic));

        var response = chatClient.prompt()
                .user(renderedText)
                .advisors(
                        new SimpleLoggerAdvisor()
                )
                .call()
                //.chatClientResponse();
                .entity(Joke.class);

        //return response.chatResponse().getResult().getOutput().getText();
        return response.text();
    }
}
