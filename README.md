# AI-Augmented RAG System

Hệ thống **Retrieval-Augmented Generation (RAG)** thông minh để tóm tắt và phân tích tài liệu. Người dùng có thể tải lên các file PDF/Doc và AI sẽ trả lời câu hỏi dựa trên dữ liệu cụ thể đó.

## 🎯 Tính năng Chính

✅ Upload và xử lý tài liệu (PDF, DOC, DOCX)  
✅ Vector Database tích hợp (Milvus, Pinecone)  
✅ RAG Query Engine bằng LangChain4J  
✅ LLM Integration (OpenAI GPT-4, Llama 3 Self-hosted)  
✅ Tự động sinh báo cáo và biểu đồ  
✅ CORS Support cho Frontend-Backend

## 🏗️ Kiến Trúc Project

```
AI-Augmented/
├── frontend/                 # Next.js Application
│   ├── app/                 # App Router pages
│   ├── components/          # React Components
│   ├── lib/                 # Utilities & API client
│   ├── public/              # Static assets
│   └── package.json
├── backend/                 # Spring Boot Application
│   ├── src/
│   │   ├── main/java/com/ai/augmented/
│   │   │   ├── config/      # Spring configurations
│   │   │   ├── controller/  # REST endpoints
│   │   │   ├── service/     # Business logic
│   │   │   ├── model/       # JPA entities
│   │   │   ├── repository/  # Data access layer
│   │   │   ├── dto/         # Data Transfer Objects
│   │   │   └── util/        # Utility classes
│   │   └── resources/       # application.properties
│   └── pom.xml              # Maven dependencies
├── docker-compose.yml       # Vector DB + PostgreSQL
└── README.md
```

## 🚀 Hướng Dẫn Cài Đặt

### Yêu Cầu Hệ Thống
- **Node.js** 18+ (cho Next.js)
- **Java** 17+ (cho Spring Boot)
- **Maven** 3.8+
- **Docker & Docker Compose** (tùy chọn)
- **OpenAI API Key** hoặc Llama 3 Self-hosted

### 1️⃣ Setup Database & Vector Store

```bash
# Khởi động Docker services
docker-compose up -d

# Kiểm tra các services
docker ps
```

**Truy cập các interfaces:**
- Milvus: http://localhost:19530
- MinIO: http://localhost:9001 (minioadmin/minioadmin)
- PostgreSQL: localhost:5432
- Redis: localhost:6379

### 2️⃣ Setup Backend (Spring Boot)

```bash
cd backend

# Build project
mvn clean install

# Run application
mvn spring-boot:run

# Backend sẽ chạy tại: http://localhost:8080/api
# Health check: http://localhost:8080/api/v1/health
```

### 3️⃣ Setup Frontend (Next.js)

```bash
cd frontend

# Install dependencies
npm install

# Tạo file .env.local
echo "NEXT_PUBLIC_API_URL=http://localhost:8080/api" > .env.local

# Run development server
npm run dev

# Frontend sẽ chạy tại: http://localhost:3000
```

## 📝 API Endpoints (đang phát triển)

### Health & Info
```
GET  /api/v1/health          - Kiểm tra trạng thái
GET  /api/v1/info            - Thông tin API
```

### Documents Management
```
POST   /api/v1/documents/upload     - Upload tài liệu
GET    /api/v1/documents/list       - Danh sách tài liệu
DELETE /api/v1/documents/{id}       - Xóa tài liệu
```

### Chat/Query
```
POST /api/v1/chat/ask        - Hỏi câu hỏi về tài liệu
```

## 🔧 Cấu Hình Môi Trường

### Backend (.env hoặc application.properties)
```properties
OPENAI_API_KEY=your_api_key_here
OPENAI_MODEL=gpt-4

# Hoặc dùng Llama 3 self-hosted
OLLAMA_BASE_URL=http://localhost:11434

# Vector Database
PINECONE_API_KEY=your_pinecone_key
PINECONE_ENV=your_pinecone_env
```

### Frontend (.env.local)
```
NEXT_PUBLIC_API_URL=http://localhost:8080/api
```

## 🛠️ Phát Triển

### Backend - Thêm Tính Năng Document Processing
1. Implement `DocumentService` để xử lý PDF/DOC
2. Tích hợp LangChain4J cho document splitting
3. Kết nối Vector Database (Milvus/Pinecone)

### Backend - Implement RAG Query
1. Tạo `RagService` cho retrieval logic
2. Tích hợp OpenAI/Llama 3 LLM
3. Implement prompt engineering

### Frontend - UI Enhancements
1. File upload component với progress tracking
2. Chat interface với conversation history
3. Report generation & chart visualization

## 📊 Tech Stack

| Layer | Technology |
|-------|-----------|
| Frontend | Next.js 14+, TypeScript, Tailwind CSS, Recharts |
| Backend | Spring Boot 3.x, Java 17, Maven |
| AI/LLM | LangChain4J, OpenAI API / Ollama |
| Vector DB | Milvus, Pinecone |
| Database | PostgreSQL |
| Caching | Redis |
| DevOps | Docker, Docker Compose |

## 📚 Tài Liệu Tham Khảo

- [LangChain4J Documentation](https://docs.langchain4j.dev/)
- [Spring Boot 3.x Guide](https://spring.io/projects/spring-boot)
- [Next.js Documentation](https://nextjs.org/docs)
- [Milvus Documentation](https://milvus.io/docs)
- [Pinecone Documentation](https://docs.pinecone.io/)

## 🤝 Contributing

Pull requests welcome! Vui lòng tạo feature branch trước khi submit.

## 📄 License

MIT License

---

**Created with ❤️ by AI Engineering Enthusiast**
