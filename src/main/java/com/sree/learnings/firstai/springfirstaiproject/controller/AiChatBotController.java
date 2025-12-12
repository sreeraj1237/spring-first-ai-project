package com.sree.learnings.firstai.springfirstaiproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import com.sree.learnings.firstai.springfirstaiproject.models.request.AiChatBotRequest;
import com.sree.learnings.firstai.springfirstaiproject.models.response.AiChatBotResponse;
import com.sree.learnings.firstai.springfirstaiproject.service.AiChatBotInteractor;

@RestController
@RequestMapping(("/chat"))
@RequiredArgsConstructor
public class AiChatBotController {

    private final AiChatBotInteractor aiChatBotInteractor;

    @PostMapping
    public ResponseEntity<Object> chat(@RequestBody AiChatBotRequest request) {
        String response = aiChatBotInteractor.interact(request.getQuestion());
        return ResponseEntity.ok(AiChatBotResponse.builder()
                .question(request.getQuestion())
                .answer(response)
                .build());
    }
}
