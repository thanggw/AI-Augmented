@echo off
REM AI-Augmented RAG System - Quick Setup Script (Windows)

echo.
echo ================================
echo AI-Augmented RAG System Setup
echo ================================
echo.

REM Check prerequisites
echo Checking prerequisites...
where npm >nul 2>nul || (echo npm not found && exit /b 1)
where mvn >nul 2>nul || (echo Maven not found && exit /b 1)
where docker >nul 2>nul || (echo Docker not found && exit /b 1)
echo ✓ All prerequisites found
echo.

REM Setup Frontend
echo Setting up Frontend...
cd frontend
call npm install
echo ✓ Frontend dependencies installed
echo.

REM Setup Backend
echo Setting up Backend...
cd ..\backend
call mvn clean install -DskipTests
echo ✓ Backend dependencies installed
echo.

REM Setup Environment
echo Setting up environment variables...
if not exist ".env.local" (
    copy .env.example .env.local
    echo ⚠️  Please update .env.local with your API keys
)
echo ✓ Environment setup complete
echo.

echo.
echo ================================
echo Setup Complete!
echo ================================
echo.
echo Next steps:
echo.
echo 1. Start Docker services:
echo    docker-compose up -d
echo.
echo 2. Start Backend (Terminal 1):
echo    cd backend && mvn spring-boot:run
echo.
echo 3. Start Frontend (Terminal 2):
echo    cd frontend && npm run dev
echo.
echo Then open http://localhost:3000 in your browser
echo.
