package com.ai.augmented.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*")
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("RAG System is running");
    }

    @GetMapping("/info")
    public ResponseEntity<ApiInfo> info() {
        return ResponseEntity.ok(new ApiInfo("AI-Augmented RAG System", "1.0.0"));
    }

    public static class ApiInfo {
        public final String name;
        public final String version;

        public ApiInfo(String name, String version) {
            this.name = name;
            this.version = version;
        }
    }
}
