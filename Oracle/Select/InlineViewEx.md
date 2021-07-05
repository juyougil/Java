#### <1> 연봉 서열대로 직원을 검색하되 1행 부터 10행 까지만 검샘하면?
```
--오답
	SELECT
    *
	FROM
		EMPLOYEE E
    WHERE
        ROWNUM<=10
	ORDER BY
		SALARY DESC ;



    SELECT
        ROWNUM
        ,E.*
    FROM
        (SELECT *FROM EMPLOYEE ORDER BY SALARY DESC) E
    WHERE ROWNUM<=10




    SELECT
        ROWNUM
        ,E.*
    FROM
        (SELECT *FROM EMPLOYEE ORDER BY SALARY DESC) E
    WHERE
      ROWNUM>=11  AND ROWNUM<=20
	----------------------------------------
	정답1
	-----------------------------------------
    SELECT * FROM 
		(SELECT ROWNUM RNUM,E.*FROM 
		(SELECT *FROM EMPLOYEE ORDER BY SALARY DESC) E
        	WHERE ROWNUM<=10)
    WHERE
	RNUM>=1;
	-----------------------------------------
	정답2 정답1 보다 2~3배 정도 느리다 
	-----------------------------------------
    SELECT * FROM 
		(SELECT ROWNUM RNUM,E.*FROM 
		(SELECT *FROM EMPLOYEE ORDER BY SALARY DESC) E
        	)
    WHERE
	RNUM>=1 AND RNUM<=10;


    WHERE
    	RNUM>=1
	--------------------------------------------------------
	오라클은 모든 SELECT 결과물에 ROWNUM 컬럼을 붙여준다. 이 컬럼안에는 1부터 시작하는 일련번호가 들어있다.
	-------------------------------------------------------
	ROWNUM 컬럼이 WHERE 절에 들어갈 때 주의사항
		------------------------------------
		ORDER BY 가 있을 경우 정렬된 후에 ROWNUM 컬럼이 붙는게 아니라
		정령되기 전에 ROWNUM 컬럼이 붙고 난 후 정렬이 된다.
		그러므로 ROWNUM 컬럼 안에 일련 번호 뒤 엉켜 버린다.
		---------------------------------------------------
		ROWNUM 자리에 1이 들어가서 FALSE가 나오는 조건이있다면 조건이 성립되지 않는다.
		---------------------------------------------------
	----------------------------------------------------
		<예>	ROWNUM<=3 (O) 
			ROWNUM=1 (O) 
			ROWNUM <=3 (X) 
			ROWNUM > 1 (X) 
			ROWNUM =2 (X) 
			WHERE ROWNUM >= 1 AND ROWNUM <= 3 (O)
			WHERE ROWNUM >= 2 AND ROWNUM <= 3 (O)
	----------------------------------------------------
	인라인 뷰, 즉 FROM 절에 나오는 SELECT는 바깥쪽 SELECT 입장에서는 테이블처럼 생각한다.
	인라인 뷰안에 ROWNUM 컬럼이 있다면 바깥쪽 SELECT 입장에서 안쪽ROWNUM 컬럼은 단순한 일반 컬럼이 된다
	--------------------------------------------------------------
	<참고문제>이렇게 N행~M행 까지 검색하는 이유는? 면접문제 
	--------------------------------------------------------------
		실제로 는 SELECT의 결과물이 웹브라우저로 출력된다.
		만약 SELECT 결과물이 100,000 행이면 다 보여줄 경우 웹브라우저 로딩이 걸린다.
		그러므로 1~10행 또는 1~15행 씩 끊어서 웹브라우저로 출력되야 로딩이 걸리지 않는다.
		이렇게 SELECT 결과물에서 N행 씩 끊어서 화면에 보여주는 것은 [페이징] 처리라고한다 게시판 만들때 씀
	--------------------------------------------------------------
	<패턴>N행~M행 까지 검색하는 SELECT 패턴 정리1
	**************************************************************
	 SELECT * FROM 
		(SELECT ROWNUM RNUM,E.* FROM 
		원하는 정렬 SELECT문
        	WHERE ROWNUM<=마지막행번호)
    	WHERE
		RNUM>=시작행번호;
	**************************************************************
	<패턴>N행~M행 까지 검색하는 SELECT 패턴 정리1
	**************************************************************
	 SELECT * FROM 
		(SELECT ROWNUM RNUM,E.* FROM 
		원하는 정렬 SELECT문
        	)
    	WHERE
		RNUM>=시작행번호 AND RNUM<=마지막행번호;
	**************************************************************
	------------------------------
	고객 나이 서열중 6행~10행 까지
	------------------------------
    		SELECT * FROM
        		(SELECT ROWNUM RNUM,E.* FROM
        		(SELECT *FROM CUSTOMER ORDER BY DECODE(SUBSTR(JUMIN_NUM,7,1),'1','19','2','19','20')||SUBSTR(JUMIN_NUM,1,6)) E
        		WHERE ROWNUM<=10)
    		WHERE
        		RNUM>=6
	-----------------------------
	직원 직급 서열중 2행~5행 까지
	-----------------------------
    		SELECT * FROM
        		(SELECT ROWNUM RNUM,E.* FROM
        		(SELECT *FROM EMPLOYEE ORDER BY DECODE(JIKUP,'사장',1,'부장',2,'과장',4,'대리',5,'주임',6,7)) E
        		WHERE ROWNUM<=5)
    		WHERE
			RNUM>=2
```

#### <2> 오늘부터 10일 이후 까지 날짜 중에 토요일, 일요일, 월요일을 제외한 날의 개수를 구하면?
```
    SELECT
    COUNT(*) FROM
    (SELECT SYSDATE+1 "DAY" FROM DUAL UNION 
    SELECT SYSDATE+2 FROM DUAL UNION 
    SELECT SYSDATE+3 FROM DUAL UNION 
    SELECT SYSDATE+4 FROM DUAL UNION 
    SELECT SYSDATE+5 FROM DUAL UNION 
    SELECT SYSDATE+6 FROM DUAL UNION 
    SELECT SYSDATE+7 FROM DUAL UNION 
    SELECT SYSDATE+8 FROM DUAL UNION 
    SELECT SYSDATE+9 FROM DUAL UNION 
    SELECT SYSDATE+10 FROM DUAL) D
    WHERE
        TO_CHAR(D.DAY,'DY','NLS_DATE_LANGUAGE = KOREAN') != '토'
        AND TO_CHAR(D.DAY,'DY','NLS_DATE_LANGUAGE = KOREAN') != '일'
        AND TO_CHAR(D.DAY,'DY','NLS_DATE_LANGUAGE = KOREAN') != '월'
```

#### <3> 이번달 중에 토요일, 일요일을 제외한 날의 개수를 구하면? = 이번달 평일 수 구하기
```
    SELECT COUNT(*) FROM (SELECT TO_DATE(TO_CHAR(SYSDATE,'YYYY-MM')||'-01','YYYY-MM-DD')+RNUM-1 "XDAY"
    FROM (SELECT ROWNUM RNUM FROM EMPLOYEE UNION SELECT ROWNUM+20 FROM EMPLOYEE)
    WHERE RNUM<=TO_NUMBER(TO_CHAR(LAST_DAY(SYSDATE),'DD'))) D                                                                 

    WHERE
        TO_CHAR(D.XDAY,'DY','NLS_DATE_LANGUAGE = KOREAN') != '토'
        AND TO_CHAR(D.XDAY,'DY','NLS_DATE_LANGUAGE = KOREAN') != '일'
        AND XDAY <=LAST_DAY(SYSDATE)
```
#### <4> 부서별 직급별 [부서번호], [직급], [급여함], [평균급여], [인원수]를 출력 <조건> 인원수가 3명 이상
```
    	SELECT * FROM
	
	
	(select
        		dep_no		"DEP_NO"
        		,jikup          "JIKUP"
        		,sum(salary)    "TOT_SALARY"
        		,round(avg(salary),1)    "AVG_SALARY"
        		,count(*)       "EMP_CNT"
    	from
        		employee
    	group by
        		dep_no ,jikup)
	WHERE
		EMP_CNT >=3
```

#### <5> 월별로 [입사월], [인원수]를 검색하면? <조건>입사월 오름차순 유지하십쇼 <조건>위 결과에서 2월, 9월은 없어서 빠진다. 2월, 9월 도 포함 시키고 인원수는 0으로 포함하려면?
```
	----------------------------------------
	group by , join 사용
	----------------------------------------

    	select
        	m.MONTH||'월'       "입사월"
        	,count(e.emp_name)  "입사인원수"
    	from
        	(select '01' "MONTH" from dual union
        	select '02' from dual union select '03' from dual union select '04' from dual union select '05' from dual union
        	select '06' from dual union select '07' from dual union select '08' from dual union select '09' from dual union
        	select '10' from dual union select '11' from dual union select '12' from dual) m ,employee e
    	where
        	to_char(e.hire_date(+),'MM')=m.MONTH
    	group by
        	m.MONTH||'월'
    	order by
        	m.MONTH||'월'
	----------------------------------------
	상관쿼리 사용
	----------------------------------------     
 	select
        	m.MONTH||'월'       "입사월"
        	,(select count(e.emp_name) from employee e where to_char(e.hire_date(+),'MM')=m.MONTH)  "입사인원수"
    	from
        	(select '01' "MONTH" from dual union
        	select '02' from dual union select '03' from dual union select '04' from dual union select '05' from dual union
        	select '06' from dual union select '07' from dual union select '08' from dual union select '09' from dual union
        	select '10' from dual union select '11' from dual union select '12' from dual ) m
```
