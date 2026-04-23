# 🚀 Pre-Training Projects Portfolio

![Python](https://img.shields.io/badge/Python-Project-blue?logo=python)
![Java](https://img.shields.io/badge/Java-OOP-orange?logo=java)
![SQL](https://img.shields.io/badge/SQL-Database-green?logo=mysql)
![Status](https://img.shields.io/badge/Status-Completed-success)

---

# 🧩 Section 1: Mini Projects

---

## ☕ Java – Library Management System

📖 **Overview:**  
A console-based system designed to manage library operations efficiently.

📸 **Output Preview:**

### ➤ Add Book
<p align="center">
  <img src="OUTPUTS/MINI_PROJECTS/java1.png" width="45%" />
</p>

### ➤ Update Book
<p align="center">
  <img src="OUTPUTS/MINI_PROJECTS/java2.png" width="45%" />
</p>

### ➤ Search Book
<p align="center">
  <img src="OUTPUTS/MINI_PROJECTS/java3.png" width="45%" />
</p>

### ➤ User Register
<p align="center">
  <img src="OUTPUTS/MINI_PROJECTS/java4.png" width="45%" />
</p>

### ➤ Issue Book
<p align="center">
  <img src="OUTPUTS/MINI_PROJECTS/java5.png" width="45%" />
</p>

### ➤ Show Books
<p align="center">
  <img src="OUTPUTS/MINI_PROJECTS/java6.png" width="45%" />
</p>

### ➤ Return Book
<p align="center">
  <img src="OUTPUTS/MINI_PROJECTS/java7.png" width="45%" />
</p>

### ➤ Remove Book
<p align="center">
  <img src="OUTPUTS/MINI_PROJECTS/java8.png" width="45%" />
</p>

---

## 🗄️ SQL – Movie Recommendation System

🎬 **Overview:**  
A database-driven system that analyzes movie ratings and generates useful insights.

🔹 **Key Queries:**
```sql
-- Top rated movies
SELECT v.title, ROUND(AVG(r.rating),2) AS avg_rating
FROM movies v
JOIN ratings r ON v.movie_id = r.movie_id
<p align="center"> <img src="OUTPUTS/MINI_PROJECTS/sql-query1.png" width="70%" /> </p>
-- Genre popularity
SELECT genre, COUNT(*) AS total
FROM movies
GROUP BY genre
ORDER BY total DESC
LIMIT 1;
<p align="center"> <img src="OUTPUTS/MINI_PROJECTS/sql-query2.png" width="70%" /> </p>
-- Recommendation based on similar users
SELECT DISTINCT v.title
FROM Ratings r
JOIN movies v ON r.movie_id = v.movie_id
WHERE r.user_id IN (
    SELECT r2.user_id
    FROM ratings r1
    JOIN ratings r2 ON r1.movie_id = r2.movie_id
    WHERE r1.user_id = 1 AND r1.rating >= 4
    AND r2.user_id != 1
)
AND r.movie_id NOT IN (
    SELECT movie_id FROM ratings WHERE user_id = 1
)
AND r.rating >= 4;
<p align="center"> <img src="OUTPUTS/MINI_PROJECTS/sql-query3.png" width="70%" /> </p>
-- User behaviour patterns
SELECT user_id, COUNT(*) AS movies_watched
FROM watch_history
GROUP BY user_id;
<p align="center"> <img src="OUTPUTS/MINI_PROJECTS/sql-query4.png" width="70%" /> </p>
-- Trending movies
SELECT v.title, COUNT(*) AS watch_count
FROM watch_history w
JOIN movies v ON w.movie_id = v.movie_id
GROUP BY v.title
ORDER BY watch_count DESC
LIMIT 3;
<p align="center"> <img src="...sql-query5.png" width="70%" />
<p align="center">
  <img src="OUTPUTS/MINI_PROJECTS/sql-query5.png" width="70%" />
</p>
```
---

## 🐍 Python – Smart Expense Tracker

💰 **Overview:**  
A simple application to track and analyze daily expenses.

📸 **Output Preview:**

### ➤ Add Expense
<p align="center">
  <img src="OUTPUTS/MINI_PROJECTS/python1.png" width="45%" />
</p>

### ➤ Show Expenses
<p align="center">
  <img src="OUTPUTS/MINI_PROJECTS/python2.png" width="45%" />
</p>

### ➤ Category-wise Analysis
<p align="center">
  <img src="OUTPUTS/MINI_PROJECTS/python3.png" width="45%" />
</p>

### ➤ Highest Spending Category
<p align="center">
  <img src="OUTPUTS/MINI_PROJECTS/python4.png" width="45%" />
</p>
