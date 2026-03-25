package com.ai.augmented.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentResponse {
    private String id;
    private String fileName;
    private Long fileSize;
    private String fileType;
    private String uploadedAt;
    private Boolean indexed;
}
