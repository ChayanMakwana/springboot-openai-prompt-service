# Spring Boot OpenAI Prompt Service

This is a small project to get hands-on experience with using OpenAI's GPT API in a Java Spring Boot application. I built this to better understand REST communication with AI models and explore how to integrate LLMs into backend services.

### Features

- Spring Boot REST API
- Uses OpenAI's `gpt-3.5-turbo`
- Accepts user prompt and returns AI-generated response

### How to Run

1. Add your OpenAI API key in `application.properties`
2. Run the application:
   ```bash
   ./mvnw spring-boot:run

### Sample request

curl -X POST http://localhost:8080/api/ai/chat \
-H "Content-Type: application/json" \
-d '{"prompt": "Explain Java streams"}'
