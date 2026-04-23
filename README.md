# 💻 Pre-Training Mini Projects & Use Cases

![Python](https://img.shields.io/badge/Python-blue?logo=python)
![Java](https://img.shields.io/badge/Java-orange?logo=java)
![SQL](https://img.shields.io/badge/SQL-green?logo=mysql)

---

#  Section 1: Mini Projects

---

## Java – Library Management System

**Overview:**  
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

## SQL – Movie Recommendation System

**Overview:**  
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

##  Python – Smart Expense Tracker

**Overview:**  
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
---

# Section 2: Use Case Implementations

---

##  Java – FinSafe (Digital Wallet)

💳 **Overview:**  
A console-based application that simulates a digital wallet with transaction validation.

📸 **Output Preview:**

### ➤ Deposit Money
<p align="center">
  <img src="OUTPUTS/USECASES/java1.png" width="45%" />
</p>

### ➤ Withdraw Money
<p align="center">
  <img src="OUTPUTS/USECASES/java2.png" width="45%" />
</p>

### ➤ Transaction History
<p align="center">
  <img src="OUTPUTS/USECASES/java3.png" width="45%" />
</p>

### ➤ Check Balance
<p align="center">
  <img src="OUTPUTS/USECASES/java4.png" width="45%" />
</p>

---

## SQL – E-Commerce Logistics Tracker

 **Overview:**  
A database system used to track shipments and analyze delivery performance.

🔹 **Key Queries:**

```sql
-- Delayed shipments
SELECT *
FROM Shipments
WHERE ActualDeliveryDate > PromisedDate;
<p align="center"> <img src="OUTPUTS/USECASES/query1.png" width="70%" /> </p>
-- Performance Ranking
select p.partner_name,count(*) as shipments_count,
sum(case when s.shipment_status='Delivered' then 1 else 0 end) as Successful,
sum(case when s.shipment_status='Returned' then 1 else 0 end) as returned from Partners p
join Shipments s on p.partner_id=s.partner_id
group by p.partner_name;
<p align="center"> <img src="OUTPUTS/USECASES/query2.png" width="70%" /> </p>
-- Zone Filter
select target_city as destination_city,count(*) as total_orders
from Shipments
where promised_date>=curdate() -interval 30 day
group by target_city
order by total_orders desc
limit 1;
<p align="center"> <img src="OUTPUTS/USECASES/query3.png" width="70%" /> </p>
-- partner scorecard
select partner_name,round(successful_del*100.0/tot_shipments,2) as success_percent
from(
	select p.partner_name,count(s.shipment_id) as tot_shipments,
		sum(case when s.actual_delivery_date>s.promised_date
		then 1 else 0 
		end) as delayed_shipments,
		sum(case when s.shipment_status='Delivered'
       then 1 else 0
	   end) as successful_del,
		sum(case when s.shipment_status='Returned'
		then 1 else 0
        end) as returned_del
	from partners p
	join shipments s on p.partner_id=s.partner_id
	group by p.partner_name)
as score
order by delayed_shipments asc,success_percent desc;
<p align="center"> <img src="OUTPUTS/USECASES/query4.png" width="70%" /> </p>
```
---
##Python – OpsBot (Log Analyzer)

Overview:
A Python automation tool that processes server logs and generates security alerts.

📸 Output Preview:

➤ Log File Analysis
<p align="center"> <img src="OUTPUTS/USECASES/python1.png" width="45%" /> </p>
➤ Show Summary 
<p align="center"> <img src="OUTPUTS/USECASES/python2.png" width="45%" /> </p ```
