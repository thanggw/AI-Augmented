package com.ai.augmented.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/chat")
@CrossOrigin(origins = "*")
public class ChatController {

    @PostMapping("/ask")
    public ResponseEntity<String> askQuestion(@RequestBody ChatRequest request) {
        // TODO: Implement RAG query logic
        return ResponseEntity.ok("{\"answer\":\"Not implemented yet\"}");
    }

    public static class ChatRequest {
        public String question;
        public String[] documentIds;
    }
}
