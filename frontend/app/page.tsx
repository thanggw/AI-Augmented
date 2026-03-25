'use client';

import { useState } from 'react';
import { Upload, MessageCircle, Download } from 'lucide-react';

export default function Home() {
  const [documents, setDocuments] = useState<string[]>([]);
  const [question, setQuestion] = useState('');
  const [isLoading, setIsLoading] = useState(false);

  const handleFileUpload = (e: React.ChangeEvent<HTMLInputElement>) => {
    const files = e.target.files;
    if (files) {
      // TODO: Integrate with backend API
      console.log('Files to upload:', files);
    }
  };

  const handleAskQuestion = async () => {
    if (!question.trim()) return;
    
    setIsLoading(true);
    try {
      // TODO: Call backend API
      console.log('Question:', question);
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <main className="min-h-screen bg-gradient-to-br from-blue-50 to-indigo-100 p-8">
      <div className="max-w-6xl mx-auto">
        {/* Header */}
        <div className="mb-12">
          <h1 className="text-4xl font-bold text-gray-900 mb-2">
            AI Document Analyzer
          </h1>
          <p className="text-gray-600">
            Upload documents and ask intelligent questions powered by RAG
          </p>
        </div>

        <div className="grid grid-cols-1 lg:grid-cols-3 gap-8">
          {/* Upload Section */}
          <div className="lg:col-span-1">
            <div className="bg-white rounded-lg shadow-md p-6">
              <h2 className="text-xl font-semibold mb-4">Documents</h2>
              
              <label className="flex items-center justify-center w-full p-6 border-2 border-dashed border-blue-300 rounded-lg cursor-pointer hover:bg-blue-50 transition">
                <div className="flex flex-col items-center justify-center">
                  <Upload className="text-blue-500 mb-2" size={24} />
                  <span className="text-sm text-gray-600">Upload PDF or Doc</span>
                </div>
                <input
                  type="file"
                  multiple
                  accept=".pdf,.doc,.docx"
                  onChange={handleFileUpload}
                  className="hidden"
                />
              </label>

              {documents.length > 0 && (
                <div className="mt-4">
                  <p className="text-sm font-medium text-gray-700 mb-2">
                    Uploaded ({documents.length})
                  </p>
                  <ul className="space-y-2">
                    {documents.map((doc, idx) => (
                      <li key={idx} className="text-sm text-gray-600">
                        {doc}
                      </li>
                    ))}
                  </ul>
                </div>
              )}
            </div>
          </div>

          {/* Chat Section */}
          <div className="lg:col-span-2">
            <div className="bg-white rounded-lg shadow-md p-6 h-full flex flex-col">
              <h2 className="text-xl font-semibold mb-4">Ask a Question</h2>
              
              <div className="flex-1 bg-gray-50 rounded-lg p-4 mb-4 overflow-y-auto">
                <p className="text-gray-500 text-center py-8">
                  Upload documents to get started
                </p>
              </div>

              <div className="flex gap-2">
                <textarea
                  value={question}
                  onChange={(e) => setQuestion(e.target.value)}
                  placeholder="Ask your question here..."
                  className="flex-1 p-3 border border-gray-300 rounded-lg resize-none focus:outline-none focus:ring-2 focus:ring-blue-500"
                  rows={3}
                />
              </div>

              <div className="flex gap-2 mt-4">
                <button
                  onClick={handleAskQuestion}
                  disabled={isLoading || !question.trim()}
                  className="flex-1 bg-blue-500 hover:bg-blue-600 disabled:bg-gray-400 text-white font-medium py-2 px-4 rounded-lg transition flex items-center justify-center gap-2"
                >
                  <MessageCircle size={20} />
                  {isLoading ? 'Analyzing...' : 'Ask AI'}
                </button>
                
                <button className="bg-green-500 hover:bg-green-600 text-white font-medium py-2 px-4 rounded-lg transition flex items-center gap-2">
                  <Download size={20} />
                  Export
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>
  );
}
