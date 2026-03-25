#!/bin/bash

# AI-Augmented RAG System - Quick Setup Script
# This script sets up everything for you

set -e

echo "================================"
echo "AI-Augmented RAG System Setup"
echo "================================"
echo ""

# Colors
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Check prerequisites
echo -e "${YELLOW}Checking prerequisites...${NC}"
command -v npm &> /dev/null || { echo "npm not found"; exit 1; }
command -v mvn &> /dev/null || { echo "Maven not found"; exit 1; }
command -v docker &> /dev/null || { echo "Docker not found"; exit 1; }
echo -e "${GREEN}✓ All prerequisites found${NC}"
echo ""

# Setup Frontend
echo -e "${YELLOW}Setting up Frontend...${NC}"
cd frontend
npm install
echo -e "${GREEN}✓ Frontend dependencies installed${NC}"
echo ""

# Setup Backend
echo -e "${YELLOW}Setting up Backend...${NC}"
cd ../backend
mvn clean install -DskipTests
echo -e "${GREEN}✓ Backend dependencies installed${NC}"
echo ""

# Setup Environment
echo -e "${YELLOW}Setting up environment variables...${NC}"
if [ ! -f ".env.local" ]; then
    cp .env.example .env.local
    echo -e "${YELLOW}⚠️  Please update .env.local with your API keys${NC}"
fi
echo -e "${GREEN}✓ Environment setup complete${NC}"
echo ""

echo -e "${GREEN}================================${NC}"
echo -e "${GREEN}Setup Complete!${NC}"
echo -e "${GREEN}================================${NC}"
echo ""
echo "Next steps:"
echo ""
echo "1. Start Docker services:"
echo "   docker-compose up -d"
echo ""
echo "2. Start Backend (Terminal 1):"
echo "   cd backend && mvn spring-boot:run"
echo ""
echo "3. Start Frontend (Terminal 2):"
echo "   cd frontend && npm run dev"
echo ""
echo "Then open http://localhost:3000 in your browser"
echo ""
