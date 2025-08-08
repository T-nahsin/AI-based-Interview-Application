# 🎯 AI Interview Prep App

A smart interview prep tool built with **Spring Boot** + **MongoDB Atlas**.  
Generates role-based questions using **Qroq AI**, stores them with timestamps, and gives you **30 minutes** to answer each one.

---

## 🚀 What it does
- 🔹 **AI-generated questions** (role-specific via Qroq API)  
- 🔹 **User-specific assignment** — questions tied to whoever requested them  
- 🔹 **Time tracking** — 30-minute limit per question  
- 🔹 **JWT Auth** for secure access  
- 🔹 **MongoDB Atlas** for storage  
- 🔹 Keeps a **history of questions & answers**  
- 🛠 Future: AI answer evaluation, speech-to-text answers, React dashboard  

---

## 🛠 Tech Stack
- **Backend**: Spring Boot 3.4.6 + Java 21  
- **DB**: MongoDB Atlas  
- **AI API**: Qroq AI (tested earlier with Ollama & Hugging Face)  
- **Auth**: JWT  
- **Extras**: Lombok, Spring Data MongoDB  

---

## ⚙️ Setup
1. **Clone the repo**
```bash
git clone https://github.com/your-username/ai-interview-prep.git
cd ai-interview-prep
