CREATE SCHEMA IF NOT EXISTS test_movie;
USE test_movie;
DELETE TABLE IF EXISTS movie;
CREATE TABLE movie (
    ID int NOT NULL,
    Title varchar(40) NOT NULL,
    ReleaseDate date,
    RunningTime int NOT NULL
);
ALTER TABLE movie ADD COLUMN Director varchar(40) NOT NULL;
ALTER TABLE movie MODIFY COLUMN Director varchar(32);
ALTER TABLE movie DROP COLUMN Director;
INSERT INTO movie (ID, Title, ReleaseDate, RunningTime) 
VALUES 
(1000, '이터널스','2021-11-05', 156),
(1001, '트랜스포터','2002-10-02', 92),
(1002, '해리포터와 마법사의돌','2001-12-14', 152),
(1003, '해리포터와 비밀의방','2002-12-14', 162),
(1004, '기생충', '2019-05-30', 153);
UPDATE movie SET Title = '해리포터와 불의 잔' WHERE id = 1003;
DELETE FROM movie WHERE RunningTime <= 100;
DELETE FROM movie;