### 비상관 쿼리
#### <1> 최고 연봉을 받는 직원을 검색하라
```
	select * from employee where salary >= (select max(salary) from employee);
	-------------------------------------
	서브쿼리 select max(salary) from employee 가 먼저 실행되고 난후 리턴되는 최고연봉을 가지고 바깥 쿼리가 실행된다.
	워 쿼리는 비상관 쿼리이다. [서브 쿼리] 실행 후의 결과값을 가지고 [외부 쿼리] 실행되기 때문이다.
	<주의> ~ where salary = max(salary); 이렇게 하면 안된다.
```

#### <2> 평균 연봉을 받는 직원을 검색하라
```
select * from employee where salary >= (select avg(salary) from employee);
```

#### <3>  20번 부서에서 최고 연봉을 받는 직원을 검색하라
```
	------------------------------------
	select * from employee where salary = (select max(salary) from employee where dep_no = 20);
	------------------------------------
	위에 서브쿼리 결과값은 3500이다 결국 연봉이 3500인 직원을 골라내므로
	20번 부서의 최고 연봉자와 같은 연봉을 받는 모든 직원을 검색한다.

	20번 부서의 최고 연봉을 받는 직원을 구하려면
	서브쿼리뿐만 아니라 메인쿼리에서도 20번 부서라는 조건을 걸어주어야 한다.
	------------------------
	답
	------------------------
	select * from employee where salary = (select max(salary) from employee where dep_no = 20) and dep_no = 20;
```

#### <4> 10번 부서 직원들이 관리하는 [고객번호], [고객명],[직원번호]를 검색하면?
```
	------
	조인	
	------
	select
		c.cus_no
		c.cus_name
		c.emp_no
	from
		customer c, employee e
	where
		c.emp_no = e.emp_no and e.dep_no 10;



	---------
	서브쿼리
	---------
    	select
        	cus_no
        	,cus_name
        	,emp_no
    	from customer
    	where  emp_no in(select emp_no from employee where dep_no =10)
     
	----------
    	select
        	cus_no
        	,cus_name
        	,emp_no
    	from customer
    	where  emp_no = any(select emp_no from employee where dep_no =10)
	-------------------------------------------------------------------
		in 뒤에 n행1열의 결과가 나오는 서브쿼리가 나오면 n행1열의 데이터가 in 뒤에 콤마(,)로 나열된다.
```

#### <5> [직원명], [직급], [연봉], [전체연봉에서 차지하는 비율]을 검색하라. [전체연봉에서 차지하는 비율]은 소수점 버람하고 %로 표현하라.
```
    	select
        	emp_no
        	,jikup
        	,salary
        	,floor((salary/(select sum(salary) from employee))*100)||'%'  "연봉비율"
    	from
        	employee
    	order by
        	floor(salary/(select sum(salary) from employee))
	--------------------------------------------
    	select
        	emp_no
        	,jikup
        	,salary
        	,trunc((salary/(select sum(salary) from employee))*100,0)||'%'  "연봉비율"
    	from
        	employee
    	order by
        	floor(salary/(select sum(salary) from employee))
	---------------------------------------------
	정렬기준도 서브쿼리로, 자료형이 숫자여야함
	---------------------------------------------
	<주의> 정렬할 때는 소수점 컨트롤을 하지 말고 소수점있는 그대로 정렬해야 정확한 정렬이 된다. 정렬할때 컬럼 자료형과 길이 확인 
```

#### <6> 평균 연봉 이상이고 최대 연봉 미만의 [직원명], [연봉], [전체평균연봉], [전체최대연봉]을 출력하면?
```
   	select
        	emp_name 직원명
        	,salary  연봉
        	,(select avg(salary) from employee) 전체평균연봉
        	,(select max(salary) from employee) 전체최대연봉
    	from
        	employee
    	where salary >= (select avg(salary) from employee) and salary < (select max(salary) from employee);
```

#### <7> 최고 연봉 직원의 [직원번호],[직원명],[부서명],[연봉]을 검색하면?
```
    	select
	    	e.emp_no
		,e.emp_name
		,d.dep_name
		,e.salary
	from
		employee e, dept d
	where
		e.dep_no= d.dep_no and salary = (select max(salary) from employee)
```
### 상관 쿼리
#### <8> 담당 고객이 2명 이상인 [직원번호], [직원명], [직급]을 검색하면?
```
    	select
        	e.emp_no
        	,e.emp_name
        	,e.jikup
    	from
        	employee e
    	where (select count(*) from customer c where e.emp_no =c.emp_no)>=2 
	-----------------------------------------------------------------
	서브쿼리안에 메인쿼리의 테이블 별칭을 쓰고 있다면 상관 쿼리
	-----------------------------------------------------------------
	where에서 ture면 출력
```

#### <9> [직원번호], [직원명], [소속부서명]을 검색하면?
```
	--------------------
	조인
	--------------------
	select
		e.emp_no
		,e.emp_name
		,d.dep_name
	from
		employee e, dept d
	where
		e.dep_no = d.dep_no
	-------------------------
	서브쿼리
	-------------------------
	select
		e.emp_no
		,e.emp_name
		,(select d.dep_name from dept d where d.dep_no=e.dep_no)
	from
		employee e;
```
#### <10> [직원번호], [직원명], [담당고객수]을 검색하면?
```
    select
        e.emp_no
        ,e.emp_name
        ,(select count(*) from customer c where e.emp_no=c.emp_no)
    from
        employee e
```
#### <11> 아래 처럼 [부서명], [부서직원수], [부서담당고객수]을 검색하면?
```
    select
        d.dep_name
        ,(select count(e.dep_no) from employee e where d.dep_no= e.dep_no)
        ,(select count(e.emp_no) from employee e, customer c where d.dep_no= e.dep_no and e.emp_no=c.emp_no)
    from
        dept d	
```
#### <12> 고객번호, 고객명, 고객전화번호, 담당직원명, 담당직원직급, 부서번호를 출력하면? <조건> 담당직원이 없는 고객도 포함 단 조인을 사용하지 말고 서브쿼리를 사용하십시오
```
	서브쿼리
	---------------

    	select
        		c.cus_no      "고객번호"
        		,c.cus_name   "고객명"
        		,c.tel_num    "고객전하번호"
        		,(select e.emp_name from employee e where e.emp_no= c.emp_no) "담당직원명"
        		,(select e.jikup from employee e where e.emp_no= c.emp_no)    "담당직원직급"
        		,(select e.dep_no from employee e where e.emp_no= c.emp_no)   "부서번호"
    	from
        		customer c
	----------------------------
	조인 오라클
	----------------------------
	    select
        		c.cus_no
        		,c.cus_name
        		,c.tel_num
        		,e.emp_name
        		,e.jikup
        		,e.dep_no
    	from
        		customer c, employee e
    	where
        		c.emp_no=e.emp_no(+)    
	----------------------------
	조인 ANSI
	----------------------------
	    select
        		c.cus_no
        		,c.cus_name
        		,c.tel_num
        		,e.emp_name
        		,e.jikup
        		,e.dep_no
   	from
        		customer c left outer join employee e on c.emp_no=e.emp_no    
```

#### <13> 고객번호, 고객명, 고객전화번호, 담당직원명, 담당직원직급, 부서번호를 출력하면? <조건> 고객정보는 모두 보이고 직원번호는 10번 부서만 보일것	단 조인을 사용하지 말고 서브쿼리를 사용하십시오
```
	서브쿼리
	---------------
    	select
        		c.cus_no        "고객번호"
        		,c.cus_name     "고객명"
        		,c.tel_num      "고객전화번호"
        		,(select e.emp_name from employee e where e.emp_no=c.emp_no and e.dep_no=10) "담당직원명"
        		,(select e.jikup from employee e where e.emp_no=c.emp_no and e.dep_no=10)    "담당직원직급"
        		,(select e.dep_no from employee e where e.emp_no=c.emp_no and e.dep_no=10)   "부서번호"
    	from
        		customer c
	order by 1 asc ;
	----------------------------
	조인 오라클
	----------------------------
    	select
        		c.cus_no
        		,c.cus_name
        		,c.tel_num
        		,e.emp_name
        		,e.jikup
        		,e.dep_no
   	from
        		customer c, employee e
    	where  
        		c.emp_no=e.emp_no(+) and e.dep_no(+)= 10

	----------------------------
	조인 ANSI
	----------------------------
    	select
        		c.cus_no
        		,c.cus_name
        		,c.tel_num
        		,e.emp_name
        		,e.jikup
        		,e.dep_no
    	from
        		customer c left outer join employee e on c.emp_no=e.emp_no and e.dep_no= 10
```

#### <14>  



## self join
#### <15> [직원번호], [직원명], [연봉], [연봉순위]을 검색하면?
```
    	select
        	e1.emp_no
        	,e1.emp_name
        	,e1.salary
        	,(select count(*)+1 from employee e2 where e1.salary<e2.salary) 
    	from
        	employee e1 
    	order by (select count(*)+1 from employee e2 where e1.salary<e2.salary) asc;
	-------------------------------------------------------------------
	내 연봉보다 높은 사람의 수를 카운트
```

#### <16> [직원번호], [직원명], [직급], [주민번호], [직급서열순위]을 출력하면? 단 직급이 같으면 나이 많은 직원이 [직급서열순위] 위이다. 그리고 [직급서열순위] 오름차순 유지
```
    	select
        		e1.emp_no
        		,e1.emp_name
        		,e1.jikup
        		,e1.jumin_num
        		,(select count(*)+1 from employee e2
        		where (decode(e1.jikup,'사장','1','부장','2','과장','3','대리','4','5') 
        		> 
        		decode(e2.jikup,'사장','1','부장','2','과장','3','대리','4','5')) 
        		or
        		(e1.jikup=e2.jikup 
        		and
         		to_number(decode(substr(e1.jumin_num,7,1),'1','19','2','19','20')||substr(e1.jumin_num,1,6)) 
         		>
          		to_number(decode(substr(e2.jumin_num,7,1),'1','19','2','19','20')||substr(e2.jumin_num,1,6)))) "순위"
    	from
        		employee e1
    	order by 5 asc;
```
