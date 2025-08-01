package com.promptservice.model;

import java.util.List;
import java.util.Map;

public class OpenAIRequest {
    private String model = "gpt-3.5-turbo";
    private List<Map<String, String>> messages;

    public OpenAIRequest(List<Map<String, String>> messages) {
        this.messages = messages;
    }

    public String getModel() {
        return model;
    }

    public List<Map<String, String>> getMessages() {
        return messages;
    }
}