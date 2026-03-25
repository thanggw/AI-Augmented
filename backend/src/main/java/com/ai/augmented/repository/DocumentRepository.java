package com.ai.augmented.repository;

import com.ai.augmented.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, String> {
    List<Document> findByIndexed(Boolean indexed);
    List<Document> findByFileType(String fileType);
}
