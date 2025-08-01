package com.promptservice.controller;

import com.promptservice.service.OpenAIService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/ai")
public class AIController {

    private final OpenAIService openAIService;

    public AIController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @PostMapping("/chat")
    public Map<String, String> chat(@RequestBody Map<String, String> request) throws IOException {
        String prompt = request.get("prompt");
        String aiResponse = openAIService.getAIResponse(prompt);
        return Map.of("response", aiResponse);
    }
}