package com.sree.learnings.firstai.springfirstaiproject.models.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AiChatBotResponse {
    String question;
    String answer;
}
