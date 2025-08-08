# AI-Based Interview Preparation App 🎯

An AI-powered interview preparation tool that generates role-specific interview questions, lets users answer them (with a time limit!), evaluates responses using AI, and tracks performance over time.

## 🚀 Features
- **AI Question Generation** – Generates tailored questions based on field & difficulty level.
- **Timed Answers** – Users have 30 minutes to answer each question.
- **AI Answer Evaluation** – Automatic scoring and feedback.
- **Performance Tracking** – View historical scores & progress.
- **User Management** – Role-based access for users & admins.

## 🛠 Tech Stack
- **Backend:** Spring Boot 3.4.6, Java 21
- **Database:** MongoDB Atlas
- **AI Integration:** Qroq API
- **Authentication:** JWT-based
- **Build Tool:** Maven

---

## 📌 API Endpoints

### 1. Generate Interview Questions
**POST** `/api/questions/generate`  
Generates AI-powered interview questions for a specific field and difficulty level.

**Request Body:**
```json
{
  "field": "Java",
  "level": "Intermediate"
}
```

### Response:

```json

[
  "What is polymorphism in Java?",
  "Explain the concept of garbage collection in Java."
]

```

### 2. Get All Questions for a User
GET /api/questions/user/{userId}
Fetches all generated questions for a specific user.

## Path Variable:
userId — ID of the user

Response:
``` json

[
  {
    "question": "What is polymorphism in Java?",
    "createdAt": "2025-08-08T12:30:00"
  }
]
```

### 3. Submit an Answer
POST /api/answers/submit
Submits an answer to a question. Must be done within 30 minutes of question creation.

Request Body:
```json 
{
  "userId": "12345",
  "questionId": "67890",
  "answer": "Polymorphism allows objects to take multiple forms..."
}
```

## Response:

```json
{
  "message": "Answer submitted successfully",
  "status": "OK"
}
```
## 4. Evaluate Answer
POST /api/answers/evaluate
Uses AI to evaluate a submitted answer.

Request Body:

```json

{
  "answer": "Polymorphism allows objects to take multiple forms..."
}
```
### Response:

```json
{
  "score": 8,
  "feedback": "Good explanation, but could include examples."
}
```
## 5. Get User Performance
GET /api/users/{userId}/performance
Fetches performance history for a user.

### Response:

```json
{
  "totalQuestions": 20,
  "averageScore": 7.5,
  "completed": 18
}
```

## ⚡ How It Works
User selects field and level.

AI generates a list of interview questions.

User answers each question within 30 minutes.

AI evaluates and scores the answer.

User can track their performance over time.

## 📂 Project Structure
```json
src/
 ├── config/         # Configuration files (JWT, AI API keys)
 ├── controller/     # REST controllers
 ├── entity/         # MongoDB document models
 ├── repository/     # MongoDB repositories
 ├── service/        # Business logic & AI integration
 └── InterviewPrepApp.java  # Main entry point
 ```


## 🚀 Getting Started
### Prerequisites

Java 21+

Maven

MongoDB Atlas account

Qroq API key

# Clone the repository
git clone https://github.com/your-username/ai-interview-prep.git

# Navigate into the folder
cd ai-interview-prep

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
📜 License
This project is licensed under the MIT License.

💡 Future Plans
Add voice-based answering using Vosk

Add gamification features (leaderboard, streaks)

Support for multiple languages

