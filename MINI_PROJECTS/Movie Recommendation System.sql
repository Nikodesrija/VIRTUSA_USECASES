
create database Movie_recommendation;
use Movie_recommendation;
CREATE TABLE USERS(USER_ID INT PRIMARY KEY,NAME VARCHAR(50),AGE INT);

CREATE TABLE MOVIES(MOVIE_ID INT PRIMARY KEY,TITLE VARCHAR(100),GENRE VARCHAR(50));

CREATE TABLE RATINGS(USER_ID INT,MOVIE_ID INT,RATING INT,FOREIGN KEY(USER_ID) references USERS(USER_ID),
FOREIGN KEY(MOVIE_ID) REFERENCES MOVIES(MOVIE_ID));

CREATE TABLE WATCH_HISTORY(USER_id int,movie_id int,watch_date date,
foreign key(user_id) references users(user_id),foreign key (movie_id) references movies(movie_id));

insert into users values(1,'srija',21),(2,'Rahul',22),(3,'kumari',25),(4,'Rushith',22);

insert into movies values(1,'KGF','Action'),(2,'RRR','Action'),(3,'Titanic','Romance'),(4,'Interstellar','Sci-Fi'),(5,'Baahubali: The Beginning','Action');

insert into ratings values(1,1,4),(1,2,4),(2,2,5),(3,3,5),(4,3,4),(3,4,5);

insert into watch_history values(1,1,'2025-04-11'),(2,2,'2025-04-20'),(3,3,'2025-04-03'),(3,4,'2025-04-03');

select *  from users;
select * from movies;
select * from Ratings;
select * from watch_history;

insert into ratings values(1,5,4),(3,4,4),(4,4,3);
insert into watch_history values(1,5,'2025-04-01'),(3,4,'2019-04-03'),(4,4,'2020-05-13');
update watch_history set movie_id=5 where user_id=3 and movie_id=4;
-- key tasks --
# top-rated movies

select v.title,Round(avg(r.rating),2) as avg_rating
from movies v
join ratings r on v.movie_id=r.movie_id
group by v.title
order by avg_rating desc
limit 3;
 
# most popular genres

select genre,count(*) as total
from movies
group by genre
order by total desc
limit 1;

# recommend movies based on similar users
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

# user behaviour patterns
select user_id,count(*) as movies_watched
from watch_history
group by user_id;

#trending movies
select v.title,count(*) as watch_count
from watch_history w
join movies v on w.movie_id=v.movie_id
group by v.title
order by watch_count desc
limit 3;
 



