# Quick Start Guide - AI-Augmented RAG System

## ✅ Đã Setup Xong

- ✅ Project structure (frontend + backend)
- ✅ Next.js 14 configuration
- ✅ Spring Boot 3.x configuration
- ✅ Docker Compose (PostgreSQL, Milvus, Redis)
- ✅ CORS configuration
- ✅ Basic REST endpoints
- ✅ Documentation

## 🚀 Các Bước Tiếp Theo

### 1. Install Dependencies

```bash
# Frontend
cd frontend
npm install

# Backend (Maven tự động download)
cd backend
mvn clean install
```

### 2. Setup Environment

```bash
# Copy template file
cp .env.example .env.local

# Edit with your keys
# OPENAI_API_KEY=your_key_here
```

### 3. Start Services

**Terminal 1 - Docker Services:**
```bash
docker-compose up -d
# Đợi các service khởi động xong (khoảng 30-60 giây)
```

**Terminal 2 - Backend:**
```bash
cd backend
mvn spring-boot:run
# Backend chạy tại http://localhost:8080/api
```

**Terminal 3 - Frontend:**
```bash
cd frontend
npm run dev
# Frontend chạy tại http://localhost:3000
```

## 📋 Next Development Priorities

### Phase 1: Document Processing (2-3 ngày)
```java
1. DocumentService.extractTextFromPdf()
2. DocumentService.chunkDocument()
3. Test with sample PDFs
```

### Phase 2: Vector Database Integration (2-3 ngày)
```java
1. Setup Milvus connection
2. Implement DocumentEmbeddingService
3. Store and retrieve embeddings
```

### Phase 3: RAG Engine (3-4 ngày)
```java
1. Integrate LangChain4J
2. Setup OpenAI API / Ollama
3. Implement query retrieval logic
4. Build prompt engineering
```

### Phase 4: Frontend UI (2-3 ngày)
```typescript
1. File upload component
2. Chat interface
3. Document management UI
4. Response display
```

## 🔍 Testing Endpoints

```bash
# Health check
curl http://localhost:8080/api/v1/health

# API info
curl http://localhost:8080/api/v1/info

# (Coming soon) Upload document
# curl -F "file=@document.pdf" http://localhost:8080/api/v1/documents/upload
```

## 📦 Dependencies Already Included

### Frontend
- React 18, Next.js 14
- TypeScript, Tailwind CSS
- Axios for HTTP
- React PDF, Recharts
- Zustand for state management

### Backend
- Spring Boot 3.2
- Spring Data JPA
- LangChain4J 0.30.0
- OpenAI & Ollama support
- Apache PDFBox, POI
- Milvus & Pinecone support
- PostgreSQL driver
- Lombok for boilerplate reduction

## 🆘 Troubleshooting

### Port Already in Use
```bash
# Kill process on port
lsof -ti:8080 | xargs kill -9  # Backend
lsof -ti:3000 | xargs kill -9  # Frontend
```

### Docker Issues
```bash
# View logs
docker logs rag_postgres
docker logs rag_milvus

# Restart services
docker-compose restart
```

### Maven Build Issues
```bash
# Clean and rebuild
mvn clean install -U
```

### Node Issues
```bash
# Clear cache and reinstall
rm -rf node_modules package-lock.json
npm install
```

## 📚 Documentation Files

- **README.md** - Project overview & setup
- **DEVELOPMENT.md** - Development checklist
- **pom.xml** - Maven dependencies
- **package.json** - NPM dependencies
- **.env.example** - Environment template

## 💡 Architecture Notes

```
Request Flow:
┌─────────┐     ┌──────────┐     ┌────────────┐     ┌──────────┐
│ Frontend│────▶│ Next.js  │────▶│   Spring   │────▶│ LangChain│
│ (React) │     │ Server   │     │   Boot API │     │   + LLM  │
└─────────┘     └──────────┘     └────────────┘     └──────────┘
                                         │
                                         ▼
                                   ┌──────────────┐
                                   │ Vector Store │
                                   │   (Milvus)   │
                                   └──────────────┘
```

## 🎯 Success Criteria

- [ ] Backend starts without errors
- [ ] Frontend loads at localhost:3000
- [ ] Health check returns 200 OK
- [ ] Docker services running
- [ ] Can upload test document
- [ ] Can ask question and get response

---

**Happy Coding! 🚀**

Đây là một dự án rất tuyệt vời để showcase AI engineering skills!
