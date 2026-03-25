package com.ai.augmented.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1/documents")
@CrossOrigin(origins = "*")
public class DocumentController {

    @PostMapping("/upload")
    public ResponseEntity<String> uploadDocument(@RequestParam("file") MultipartFile file) {
        // TODO: Implement document upload and processing
        return ResponseEntity.ok("File received: " + file.getOriginalFilename());
    }

    @GetMapping("/list")
    public ResponseEntity<String> listDocuments() {
        // TODO: Implement list documents
        return ResponseEntity.ok("[]");
    }

    @DeleteMapping("/{documentId}")
    public ResponseEntity<String> deleteDocument(@PathVariable String documentId) {
        // TODO: Implement delete document
        return ResponseEntity.ok("Document deleted");
    }
}
