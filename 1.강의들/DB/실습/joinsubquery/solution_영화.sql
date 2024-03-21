select count(*) as "행 수" from movie cross join cinema;
select * from movie inner join cinema on movie.CinemaCode = cinema.CinemaCode;
select * from movie inner join cinema on movie.CinemaCode = cinema.CinemaCode where cinema.location like "서울";
select count(*) as "개수", cinema.location from movie inner join cinema on movie.CinemaCode = cinema.CinemaCode where cinema.location like "광주";
select cinema.cinemaname, count(*) as "상영 중" from movie inner join cinema on movie.cinemacode = cinema.cinemacode group by cinemaname;
SELECT COUNT(movie.cinemacode) AS "상영 중", cinema.location AS "지역" FROM movie INNER JOIN cinema ON movie.cinemacode = cinema.cinemacode GROUP BY cinema.location HAVING COUNT(*) = 1;
select title, runningtime from movie where runningtime >= (select runningtime from movie where title = "이터널스");
select cinemaName from cinema where cinemacode in (select cinemacode from movie where runningtime >= 156);
SELECT title, runningtime FROM movie WHERE title LIKE "%해리포터%" AND runningtime >= 156;
