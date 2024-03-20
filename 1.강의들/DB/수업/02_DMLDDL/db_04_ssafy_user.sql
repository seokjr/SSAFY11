# Q1. ssafydb 데이터 베이스 생성 및 사용
CREATE DATABASE IF NOT EXISTS ssafydb;
USE ssafydb;
# Q2. ssafy_user 테이블 생성
CREATE TABLE ssafy_user(
	-- 학번
    user_num INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    -- id
	user_id VARCHAR(20) NOT NULL,
    -- 이름
    user_name VARCHAR(20) NOT NULL,
    -- PW
    user_password VARCHAR(20) NOT NULL,
    -- email
    user_email VARCHAR(30),
    -- 가입날짜
    signup_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
DESC ssafy_user;
# Q3. INSERT 쿼리를 사용해보자.
-- 모든 컬럼 입력
INSERT INTO ssafy_user
VALUES (1, "godqhr", "양띵균", "1234", "godqhr@gmail.com", now());
-- 원하는 컬럼만 입력
INSERT INTO ssafy_user (user_id, user_name, user_password)
VALUES ("ssafy", "김싸피", "ssafy");
-- 여러 개의 데이터를 한번에 넣고 싶어.
INSERT INTO ssafy_user (user_id, user_name, user_password)
VALUES ("ssafy1", "정싸피", "ssafy1"),
		("ssafy2", "현싸피", "ssafy2"),
		("ssafy3", "송싸피", "ssafy3"),
		("ssafy4", "박싸피", "ssafy4");

# Q4. 데이터를 수정해보자
-- PK를 이용하여 딱 한 레코드만 수정하였음
UPDATE ssafy_user
SET user_name = "kimssafy"
WHERE user_num = "2";

UPDATE ssafy_user
SET user_name = 'anonymous';


# Q5. 데이터를 삭제해보자
DELETE FROM ssafy_user
WHERE user_num = 4;
DELETE FROM ssafy_user;
SELECT * FROM ssafy_user;
