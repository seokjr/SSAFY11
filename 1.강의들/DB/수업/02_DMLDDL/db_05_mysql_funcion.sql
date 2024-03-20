# Q1. 숫자관련 함수 사용
-- 2의 3제곱
SELECT pow(2, 3);
-- FROM dual;

-- 8 나누기 3의 나머지
SELECT mod(8, 3);
-- 최대값, 최솟값
SELECT greatest(15, 34, 1230, 15, 26, 123123123) as "최댓값", least(123,11, 23, 12, 12312, 1) as "최솟값";
-- 반올림
SELECT round(1526.12312, 2);
# Q2. 문자 관련 함수
-- 아스키 코드값 얻기
SELECT ascii("0"), ascii("A"), ascii('a');
-- concat 메서드를 써보자.
SELECT concat("president의 이름은 ", ename, '입니다') as "소개"
FROM emp
WHERE job = "PRESIDENT";
-- 이름의 길이가 5인 직원의 이름을 조회
select ename
from emp
where length(ename) = 5;
SELECT length("김싸피"), char_length("김싸피");
-- 문자열 변경
SELECT replace("Hello abc abc", 'abc', 'ssafy');
-- 문자열 인덱스

-- 모든 직원의 이름 3자리조회

-- LPAD RPAD

-- REVERSE

# Q3. 날짜 관련함수
-- 2초 더하기

-- 날짜차이

-- 오늘은?

# Q4. 트랜잭셕 사용해보기
SET autocommit = 0; # 이제부터 오토 커밋 아니야
USE ssafy;
CREATE TABLE test_table(val VARCHAR(20));

START TRANSACTION;
INSERT INTO test_table VALUE("A");
INSERT INTO test_table VALUE("B");
INSERT INTO test_table VALUE("C");
INSERT INTO test_table VALUE("D");
ROLLBACK;
SELECT * FROM test_table;

START TRANSACTION;
INSERT INTO test_table VALUE("S");
INSERT INTO test_table VALUE("S");
INSERT INTO test_table VALUE("A");
INSERT INTO test_table VALUE("F");
INSERT INTO test_table VALUE("Y");

COMMIT;
SELECT * FROM test_table;