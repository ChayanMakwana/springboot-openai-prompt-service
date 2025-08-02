package com.promptservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.promptservice.model.OpenAIRequest;
import com.promptservice.model.OpenAIResponse;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class OpenAIService {

    @Value("${openai.api.key}")
    private String apiKey;

    @Value("${openai.api.url}")
    private String apiUrl;

    public String getAIResponse(String prompt) throws IOException {
        OkHttpClient client = new OkHttpClient();

        List<Map<String, String>> messages = List.of(
                Map.of("role", "user", "content", prompt)
        );
        OpenAIRequest openAIRequest = new OpenAIRequest(messages);

        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writeValueAsString(openAIRequest);

        Request request = new Request.Builder()
                .url(apiUrl)
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .post(RequestBody.create(requestBody, MediaType.get("application/json")))
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            String body = response.body().string();
            OpenAIResponse aiResponse = mapper.readValue(body, OpenAIResponse.class);
            return aiResponse.getChoices().get(0).getMessage().getContent();
        }
    }
}