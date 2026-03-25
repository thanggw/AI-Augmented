package com.ai.augmented.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatResponse {
    private String answer;
    private String[] sources;
    private Float[] confidenceScores;
    private Long processingTimeMs;
}
