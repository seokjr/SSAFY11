USE SSAFY_CORPORATION;

-- 한줄 주석 입니다.
# 한줄 주석 입니다.
/*
    여러줄 주석입니다.
    Ctrl + Enter : 해당 줄 실행
    Ctrl + B : 자동정렬
    SQL 문도 마지막엔 ; 찍어서 마무리해야 한다.
*/

# Q1. 모든 사원 정보 검색
select * from emp;
# Q2-1. 사원이 근무하는 부서 번호
select DEPTNO  from emp;
# Q2-2. 사원이 근무하는 부서 번호(중복제거)
select distinct DEPTNO from emp;
# Q3. 사원의 이름, 부서번호, 업무 조회
select ENAME, DEPTNO, JOB from emp;
select DISTINCT deptno, job from emp;
# Q4. 사원의 이름, 사번, 급여*12 (연봉), 업무 조회
select ENAME as "이름", EMPNO as "사번", SAL*12 as "연봉", JOB as "업무" from emp;
# Q5. 사원의 이름, 사번, 커미션, 급여, 커미션 포함 급여 조회
select ename, empno, comm, sal, sal+comm as "커미션 포함 급여", sal + ifnull(comm, 0) as "커포급2" from emp;
# Q6. 모든 사원의 사번, 이름, 급여, 급여 등급  조회 (5000 이상 -> 높은연봉, 2000 이상 -> 평균 연봉, 그 외 -> 낮은연봉)
select empno, ename, sal,
	case when sal >= 5000 then "높은 연봉"
		when sal >= 2000 then "평균 연봉"
		else "낮은 연봉" 
    end as "급여 등급"
 from emp;
# Q7. 부서 번호가 30인 사원중 급여가 1500 이상인 사원의 이름, 급여, 부서번호 조회
select ename, sal, deptno from emp where deptno = 30 and sal >= 1500;
# Q8. 부서번호가 20 또는 30인 부서에서 근무하는 사원의 사번, 이름, 부서번호 조회
select empno, ename, deptno from emp where deptno = 20 or deptno = 30;
# Q9. 부서번호가 20,30이 아닌 부서에서 근무하는 사원의 사번, 이름, 부서번호 조회
select empno, ename, deptno from emp where deptno != 20 and deptno <> 30;
# select empno, ename, deptno from emp where deptno not (deptno = 20 or deptno = 30);
# Q10. 업무가 MANAGER, ANALYST, PRESIDENT 인 사원의 이름, 사번, 업무조회
select empno, ename, job from emp where job in ('manager', 'analyst', 'president');
# Q11. 부서번호가 10, 20이 아닌 사원의 사번, 이름, 부서번호 조회
select empno, ename, deptno from emp where deptno not in (10, 20);
# Q12. 급여가 2000이상 3000이하 인 사원의 사번, 이름, 급여조회
select empno, ename, sal from emp where sal BETWEEN 2000 and 3000;
# Q13. 입사일이 1981년인 직원의 사번, 이름, 입사일 조회
select empno, ename, hiredate from emp where hiredate BETWEEN "1981-01-01" and "1981-12-31";
# Q14. 커미션인 NULL 인 사원의 사번, 이름, 커미션 조회
SELECT empno, ename, comm FROM emp WHERE comm IS null;
# Q15. 커미션 NULL이 아닌 사원의 사번, 이름, 업무, 커미션 조회
select empno, ename, job, comm from emp where comm is not null;
# Q16. 이름이 M으로 시작하는 사원의 사번, 이름 조회
select empno, ename from emp where ename like 'M%';
# Q17. 이름에 E가 포함된 사원의 사번 이름 조회
select empno, ename from emp where ename like "%E%";
# Q18. 이름의 세번째 알파벳이 'A'인 사원의 사번, 이름 조회
select empno, ename from emp where ename like "__A%";
# select empno, ename from emp where ename like "BLAKE";
# select empno, ename from emp where ename = "BLAKE";
# Q19. 모든 직원의 모든 정보를 이름을 기준으로 내림차순 정룔
select * from emp ORDER BY ename;
# Q20. 모든 사원의 사번 이름, 급여를 조회 (급여 내림차순)
select empno, ename, sal from emp ORDER BY sal DESC;
# Q21. 20, 30번 부서에 근무하는 사원의 사번, 이름, 부서번호, 급여 조회 (부서별 오름차순, 급여순 내림차순)
select empno, ename, deptno, sal from emp where deptno in (20, 30) ORDER BY deptno, sal DESC;
# Q22. 모든 사원에 대하여 사원수, 급여총액, 평균급여, 최고급여, 최저급여 조회
SELECT count(*) as 사원수, sum(sal) as 급여총액, avg(sal) as 평균급여, max(sal) as 최고급여, min(sal) as 최저급여
from emp;
# Q23. 모든 사원에 대하여 부서, 사원수, 급여총액, 평균급여, 최고급여, 최저급여를 부서별로 조회하고, 소수점 둘째자리 반올림
select deptno, count(*) as 사원수, sum(sal) 급여총액, round(avg(sal),2) 평균급여, max(sal) 최고급여, min(sal) 최소급여
from emp
GROUP BY deptno;

# Q24. 모든 사원에 대하여 부서, 업무, 사원수, 급여총액, 평균급여, 최고급여, 최저급여를 부서별, 직급별로 조회
select deptno, job, count(*) as 사원수, sum(sal) 급여총액, round(avg(sal),2) 평균급여, max(sal) 최고급여, min(sal) 최소급여
from emp
GROUP BY deptno, job;
# Q25. 급여(커미션포함) 평균이 2000이상인 부서번호, 부서별 사원수, 평균급여(커미션포함) 조회 
select deptno, count(*) 사원수, round(avg(sal+ ifnull(comm, 0)), 2) as "평균급여(커미션포함)"
from emp
GROUP BY deptno
HAVING avg(sal+ ifnull(comm, 0)) >= 2000;





