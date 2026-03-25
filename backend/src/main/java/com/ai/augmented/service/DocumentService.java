package com.ai.augmented.service;

import com.ai.augmented.model.Document;
import com.ai.augmented.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class DocumentService {

    private final DocumentRepository documentRepository;

    @Value("${upload.directory:/tmp/ai-augmented-uploads}")
    private String uploadDirectory;

    public Document uploadDocument(MultipartFile file) throws IOException {
        log.info("Uploading document: {}", file.getOriginalFilename());

        // Create upload directory if not exists
        Files.createDirectories(Paths.get(uploadDirectory));

        // Generate unique filename
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        String filePath = Paths.get(uploadDirectory, fileName).toString();

        // Save file
        file.transferTo(new File(filePath));

        // Create document entity
        Document document = new Document();
        document.setFileName(file.getOriginalFilename());
        document.setFilePath(filePath);
        document.setFileSize(file.getSize());
        document.setFileType(file.getContentType());
        document.setIndexed(false);

        Document saved = documentRepository.save(document);
        log.info("Document saved: {}", saved.getId());

        return saved;
    }

    public List<Document> listDocuments() {
        return documentRepository.findAll();
    }

    public Document getDocument(String documentId) {
        return documentRepository.findById(documentId)
            .orElseThrow(() -> new RuntimeException("Document not found: " + documentId));
    }

    public void deleteDocument(String documentId) {
        Document document = getDocument(documentId);
        
        // Delete physical file
        try {
            Files.deleteIfExists(Paths.get(document.getFilePath()));
            log.info("File deleted: {}", document.getFilePath());
        } catch (IOException e) {
            log.error("Error deleting file: {}", document.getFilePath(), e);
        }

        // Delete from database
        documentRepository.delete(document);
        log.info("Document deleted: {}", documentId);
    }

    // TODO: Implement document processing
    // - Extract text from PDF/DOC
    // - Split into chunks
    // - Generate embeddings
    // - Store in vector database
}
