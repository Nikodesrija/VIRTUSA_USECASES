# 💻 Pre-Training Mini Projects & Use Cases

![Python](https://img.shields.io/badge/Python-blue?logo=python)
![Java](https://img.shields.io/badge/Java-orange?logo=java)
![SQL](https://img.shields.io/badge/SQL-green?logo=mysql)

---

# 📂 Section 1: Mini Projects

---

## ☕ Java – Library Management System

**Overview:**  
A console-based system designed to manage library operations efficiently.

📸 **Output Preview:**

| ➤ Add Book | ➤ Update Book |
|-----------|---------------|
| <img src="OUTPUTS/MINI_PROJECTS/java1.png" width="100%"> | <img src="OUTPUTS/MINI_PROJECTS/java2.png" width="100%"> |

| ➤ Search Book | ➤ User Registration |
|--------------|--------------------|
| <img src="OUTPUTS/MINI_PROJECTS/java3.png" width="100%"> | <img src="OUTPUTS/MINI_PROJECTS/java4.png" width="100%"> |

| ➤ Issue Book | ➤ Show Books |
|-------------|-------------|
| <img src="OUTPUTS/MINI_PROJECTS/java5.png" width="100%"> | <img src="OUTPUTS/MINI_PROJECTS/java6.png" width="100%"> |

| ➤ Return Book | ➤ Remove Book |
|--------------|--------------|
| <img src="OUTPUTS/MINI_PROJECTS/java7.png" width="100%"> | <img src="OUTPUTS/MINI_PROJECTS/java8.png" width="100%"> |

---

## 🗄️ SQL – Movie Recommendation System

**Overview:**  
A database-driven system that analyzes movie ratings and generates useful insights.


```Sql
--Top Rated Movies
SELECT v.title, ROUND(AVG(r.rating),2) AS avg_rating
FROM movies v
JOIN ratings r ON v.movie_id = r.movie_id
GROUP BY v.title
ORDER BY avg_rating DESC
LIMIT 3;
```
<p align="center"> 
    <img src="OUTPUTS/MINI_PROJECTS/sql-query1.png" width="45%" /> <img src="OUTPUTS/MINI_PROJECTS/sql-query2.png" width="45%" /> 
</p>

```Sql
--Recommendation Query
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
```
<p align="center"> <img src="OUTPUTS/MINI_PROJECTS/sql-query3.png" width="45%" /> <img src="OUTPUTS/MINI_PROJECTS/sql-query4.png" width="45%" /> </p>

```sql
---Trending Movies
SELECT v.title, COUNT(*) AS watch_count
FROM watch_history w
JOIN movies v ON w.movie_id = v.movie_id
GROUP BY v.title
ORDER BY watch_count DESC
LIMIT 3;
```
<p align="center"> <img src="OUTPUTS/MINI_PROJECTS/sql-query5.png" width="45%" /> </p>

----
Python – Smart Expense Tracker

Overview:
A simple application to track and analyze daily expenses.

📸 Output Preview:

<p align="center"> <img src="OUTPUTS/MINI_PROJECTS/python1.png" width="45%" /> <img src="OUTPUTS/MINI_PROJECTS/python2.png" width="45%" /> </p> <p align="center"> <img src="OUTPUTS/MINI_PROJECTS/python3.png" width="45%" /> <img src="OUTPUTS/MINI_PROJECTS/python4.png" width="45%" /> </p>
Section 2: Use Case Implementations
Java – FinSafe (Digital Wallet)

Overview:
A console-based application that simulates a digital wallet.

<p align="center"> <img src="OUTPUTS/USECASES/java1.png" width="45%" /> <img src="OUTPUTS/USECASES/java2.png" width="45%" /> </p> <p align="center"> <img src="OUTPUTS/USECASES/java3.png" width="45%" /> <img src="OUTPUTS/USECASES/java4.png" width="45%" /> </p>
SQL – E-Commerce Logistics Tracker

Overview:
Tracks shipments and analyzes delivery performance.
```sql
--Delayed Shipments
SELECT *
FROM Shipments
WHERE ActualDeliveryDate > PromisedDate;
```
<p align="center"> <img src="OUTPUTS/USECASES/query1.png" width="45%" /> <img src="OUTPUTS/USECASES/query2.png" width="45%" /> </p>

```sql
 Performance Analysis
SELECT target_city, COUNT(*) AS total_orders
FROM Shipments
GROUP BY target_city
ORDER BY total_orders DESC
LIMIT 1;
```
<p align="center"> <img src="OUTPUTS/USECASES/query3.png" width="45%" /> <img src="OUTPUTS/USECASES/query4.png" width="45%" /> </p>
---
Python – OpsBot

Overview:
Analyzes logs and generates alerts.

<p align="center"> <img src="OUTPUTS/USECASES/python1.png" width="45%" /> <img src="OUTPUTS/USECASES/python2.png" width="45%" /> </p> ```
