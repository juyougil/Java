#### <1> 부서별로 [부서번호], [급여함], [평균급여], [인원수]를 출력하면? 단 평균 소수 2째자리에서 반올림 할 것
```
    	select
        		dep_no          "부서번호"
       	 	,sum(salary)    "급여합"
        		,round(avg(salary),1)    "평균급여"
        		,count(*)       "인원수"
    	from
        		employee
    	group by
        		dep_no;
	-------------------------------------------
	select 절에 일반 컬럼과 그룹함수 컬럼이 등장하면 group by 뒤에는 반드시 그룹지을 일반 컬럼이 나와야한다.
```

#### <2> 직급별로 [직급], [급여함], [평균급여], [인원수]를 출력하면?
```
    	select
       		jikup          "부서번호"
        		,sum(salary)    "급여합"
        		,avg(salary)    "평균급여"
        		,count(*)       "인원수"
    	from
        		employee
    	group by
        		jikup;
```

#### <3> 부서별 직급별 [부서번호], [직급], [급여함], [평균급여], [인원수]를 출력하면?
```
    	select
        		dep_no
        		,jikup          "부서번호"
        		,sum(salary)    "급여합"
        		,avg(salary)    "평균급여"
       		,count(*)       "인원수"
    	from
        		employee
    	group by
        		dep_no ,jikup;
```
#### <4> 부서별 직급별 [부서번호], [직급], [급여함], [평균급여], [인원수]를 출력 <조건> 인원수가 3명 이상
```
    	select
        		dep_no
        		,jikup          "부서번호"
        		,sum(salary)    "급여합"
        		,avg(salary)    "평균급여"
        		,count(*)       "인원수"
    	from
        		employee
    	group by
        		dep_no ,jikup
    	having
        		count(*) >= 3
    	order by
        		dep_no;
	--------------------------------------------------
	group by 결과물에서 행을 골라낼 때에는 where를 쓰지 말고 having을 사용한다.
```

#### <5> 부서별 성별로  [부서번호], [성], [급여함], [평균급여], [인원수]를 출력
```
    	select
        		dep_no
        		,decode(substr(jumin_num,7,1),'1','남','3','남','여')        
        		,sum(salary)    "급여합"
        		,round(avg(salary),1)    "평균급여"
        		,count(*)       "인원수"
    	from
        		employee
    	group by
        		dep_no ,decode(substr(jumin_num,7,1),'1','남','3','남','여')
```

#### <6> 입사년도별로  [입사년도], [인원수]를 년도별도 오름차순  출력
```
    	select
        		extract(year from hire_date)||'년' "입사년도"
        		,count(*)||'명'       "인원수"
    	from
        		employee
    	group by
        		extract(year from hire_date)
    	order by
        		"입사년도" asc;

    	select
        		to_char(hire_date,'YYYY')||'년' "입사년도"
        		,count(*)||'명'       "인원수"
    	from
        		employee
    	group by
        		to_char(hire_date,'YYYY')
    	order by
        		"입사년도" asc;
```

#### <7> 부서별로  [부서번호], [평균근무년수]를 출력 근무년수는 소수점 2째 자리에서 반올림할것
```
    	select
        		dep_no
        		,round(avg((sysdate-hire_date)/365),1) ||'년'
    	from
        		employee
    	group by
        		dep_no;
```

#### <8> 입사분기별로  [입사분기], [인원수]를 출력
```
    	select
        		to_char(hire_date,'Q')||'분기'
       		 ,count(*)||'명'
    	from
        		employee
    	group by
       		to_char(hire_date,'Q')||'분기'
```

#### <9> 입사연대별, 성별로 [입사연대], [성], [연대별입사자수] 출력하면?
```
    	select
        		substr(to_char(hire_date,'YYYY'),1,3)||'0년대'
        		,decode(substr(jumin_num,7,1),'1','남','3','남','여')
        		,count(*) ||'명'
    	from
        		employee
    	group by
        		substr(to_char(hire_date,'YYYY'),1,3)||'0년대',
        		decode(substr(jumin_num,7,1),'1','남','3','남','여')
```

#### <10> 직원들이 있는 부서별로 [부서번호], [부서위치], [직원수]를 출력하면?
```
    	select
        		e.dep_no
        		,d.loc
        		,count(e.emp_no)
    	from
        		employee e, dept d
    	where
        		e.dep_no=d.dep_no
    	group by
        		e.dep_no,d.loc;
-- ANSI
    	select
        		e.dep_no
        		,d.loc
        		,count(e.emp_no)
    	from
        		employee e left outer join dept d
    	on
        		e.dep_no=d.dep_no
    	group by
        		e.dep_no,d.loc;




    	select
        		e.dep_no
        		,(select d.loc from dept d where e.dep_no=d.dep_no)
        		,count(*)
    	from
        		employee e
    	group by
        		e.dep_no
```
#### <11> 
```

```



















