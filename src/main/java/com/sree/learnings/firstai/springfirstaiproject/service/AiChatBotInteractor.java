package com.sree.learnings.firstai.springfirstaiproject.service;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AiChatBotInteractor {
    private final OllamaChatModel ollamaChatModel;

    public String interact(final String question) {
        ChatResponse response = ollamaChatModel.call(
                new Prompt(
                        question.trim(),
                        OllamaOptions.builder()
                                .model(OllamaModel.LLAMA3_1)
                                .temperature(0.4)
                                .build()
                ));
        return response.getResult()
                .getOutput()
                .getText();
    }
}
