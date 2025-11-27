# 📅 Daily Planner

## 📝 Description
A minimal day-planner app with persistent local storage.  
**Goal:** Understand `SharedPreferences` and basic UI design using **Jetpack Compose**.  
**Problem:** Users want a simple habit planner without the complexity of full-featured productivity apps.  
**Solution:** Provide add, edit, and delete functionality for daily plans, stored locally using `SharedPreferences`.

---

## ❓ Problem Statement
Most productivity apps are overloaded with features like cloud sync, collaboration, and analytics. While powerful, these features can overwhelm beginners and distract users who simply want to track daily habits or tasks.  
This project solves the need for a **lightweight daily planner** that focuses on simplicity, reliability, and local persistence.

---

## 🔄 Solution Workflow
1. **Add Plans** – Users can create new daily tasks or habits.  
2. **Edit Plans** – Existing tasks can be updated quickly.  
3. **Delete Plans** – Remove tasks when no longer needed.  
4. **Persistent Storage** – All tasks are saved locally using `SharedPreferences`, ensuring they remain after app restarts.  
5. **Compose UI** – A clean, modern interface built with Jetpack Compose for smooth user interaction.  

<p>
  <img width="250" height="600" alt="Screenshot 2025-11-27 162150" 
       src="https://github.com/user-attachments/assets/455ffe61-c223-453e-8c86-f4497f2fad65" 
       style="margin: 20px;" />

  <img width="250" height="600" alt="Screenshot 2025-11-27 162213" 
       src="https://github.com/user-attachments/assets/0ee50ce0-5a65-44d9-8644-d31e5165ebd2" 
       style="margin: 20px;" />

---

## 🛠 Tech Stack
- **Kotlin** – Core programming language for Android development.  
- **Jetpack Compose** – Declarative UI toolkit for building native Android interfaces.  
- **SharedPreferences** – Lightweight storage solution for persisting user data locally.  

---

## 🏗 Architecture
- **UI Layer (Jetpack Compose)**  
  - Displays tasks in a list format.  
  - Provides input fields and buttons for add/edit/delete actions.  

- **Data Layer (SharedPreferences)**  
  - Stores tasks as key-value pairs.  
  - Ensures persistence across app restarts.  

- **Logic Layer (Kotlin Classes)**  
  - Handles CRUD operations (Create, Read, Update, Delete).  
  - Connects UI actions with data storage.  

This separation ensures clarity, maintainability, and scalability for future improvements.

---

## 🎯 Relevance and Learning
- Reinforces **Android fundamentals**: state management, user input handling, and persistent storage.  
- Demonstrates **Jetpack Compose** for modern UI development.  
- Builds confidence in **structuring small apps** with clear separation of concerns.  
- Serves as a stepping stone toward more advanced apps using databases (e.g., Room) and cloud sync.  
- Highlights how **SharedPreferences** can be used effectively for small-scale persistence needs.  
