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

<p align="center">
  **➤ Add Book**
  <img src="OUTPUTS/MINI_PROJECTS/java1.jpg" width="45%" />
   **➤ Update Book**
 <img src="OUTPUTS/MINI_PROJECTSs/java2.jpg" width="45%" />
   **➤ Search Book**
  <img src="OUTPUTS/MINI_PROJECTS/java3.jpg" width="45%" />
    **➤ User Register**
  <img src="OUTPUTS/MINI_PROJECTS/java4.jpg" width="45%" />
    **➤ Issue Book**
  <img src="OUTPUTS/MINI_PROJECTS/java5.jpg" width="45%" />
    **➤ Show Books**
  <img src="OUTPUTS/MINI_PROJECTS/java6.jpg" width="45%" />
    **➤ Return Book**
  <img src="OUTPUTS/MINI_PROJECTS/java7.jpg" width="45%" />
    **➤ Remove Book**
  <img src="OUTPUTS/MINI_PROJECTS/java8.jpg" width="45%" />
</p>

---

## 🗄️ SQL – Movie Recommendation System

🎬 **Overview:**  
A database-driven system that analyzes movie ratings and generates useful insights.

🔹 **Key Queries:**
-- Top rated movies
select v.title,Round(avg(r.rating),2) as avg_rating
from movies v
join ratings r on v.movie_id=r.movie_id
group by v.title
order by avg_rating desc
limit 3;
<p align="center"> <img src="OUTPUTS/MINI_PROJECTS/sql-query1.png" width="70%" /> </p>
-- Genre popularity
select genre,count(*) as total
from movies
group by genre
order by total desc
limit 1;
<p align="center"> <img src="OUTPUTS/MINI_PROJECTS/sql-query2.png" width="70%" /> </p>
-- recommend movies based on similar users
select distinct v.title
from Ratings r
join movies v on r.movie_id=v.movie_id
where r.user_id in(
	select r2.user_id from ratings r1
	join ratings r2
	on r1.movie_id=r2.movie_id
	where r1.user_id=1 and r1.rating>=4
	and r2.user_id!=1) 
and r.movie_id not in(
	select movie_id from ratings
    where user_id=1
)
and r.rating>=4;
<p align="center"> <img src="OUTPUTS/MINI_PROJECTS/sql-query3.png" width="70%" /> </p>
---user behaviour patterns
select user_id,count(*) as movies_watched
from watch_history
group by user_id;
<p align="center"> <img src="OUTPUTS/MINI_PROJECTS/sql-query4.png" width="70%" /> </p>
--trending movies
select v.title,count(*) as watch_count
from watch_history w
join movies v on w.movie_id=v.movie_id
group by v.title
order by watch_count desc
limit 3;
<p align="center"> <img src="OUTPUTS/MINI_PROJECTS/sql-query5.png" width="70%" /> </p>
🐍 Python – Smart Expense Tracker

💰 Overview:
A simple application to track and analyze daily expenses.

📸 Output Preview:
<p align="center">
  **➤ Add Expense**
  <img src="OUTPUTS/MINI_PROJECTS/Python1.jpg" width="45%" />
   **➤ Show Expense**
 <img src="OUTPUTS/MINI_PROJECTS/python2.jpg" width="45%" />
   **➤ Category-wise Expense**
  <img src="OUTPUTS/MINI_PROJECTS/python3.jpg" width="45%" />
    **➤Highest Spending Category**
  <img src="OUTPUTS/MINI_PROJECTS/python4.jpg" width="45%" />
</p>
