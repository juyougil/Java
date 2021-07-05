#### <1> 직원번호, 직원명, 소속부서명 검색하면?
```
	select
		e.emp_no
		,e.emp_name
		,d.dep_name
	from
		employee e, dept d
    	where
        	e.dep_no = d.dep_no;
	-------------------------------------
	join => 2개 이상의 테이블의 칼럼을 가져와 행으로 붙이기
```

#### <2> 고객번호, 고객명, 고객담당직원이름 검색하면?
```
	select
		c.cus_no        고객번호
		,c.cus_name     고객명
		,e.emp_name     고객담당직원이름         
	from
		customer c , employee e
    	where
        	c.emp_no = e.emp_no;
	-------------------------------------------
	
	select
		c.cus_no        고객번호
		,c.cus_name     고객명
		,e.emp_name     고객담당직원이름         
	from
		customer c , employee e
    	where
        	c.emp_no = e.emp_no(+);
```

#### <3> 직원번호, 직원명, 소속부서명 검색?
```
	<주의>직원번호와 직원명은 employee 테이블 소속이고, 소속부서명은 dept 테이블 소속이다.
	<주의>단순한 select 가 아닌 2개 테이블로 부터 연관성 있는 [컬럼]을 복사해서 횡으로
		붙이는 작업 즉 조인이 필요하다.
	 조건을 =을사용 equi 조인
	조건을 비교연산자 사용시 non-equi 조인
	----------------------------------------------
	<오라클 조인> 테이블에 별칭을 주고 조인한 것
	----------------------------------------------
    	select e.emp_no
           		,e.emp_name
        		,d.dep_name
    	from employee e, dept d
        		where e.dep_no = d.dep_no;
	----------------------------------------------
	<오라클 조인> 테이블에 별칭 없이 조인한 것
	----------------------------------------------
	select 	employee.emp_no
		,employee.emp_name
		,dept.dep_name
	from
		employee, dept
	where	employee.dep_no = dept.dep_no;
	----------------------------------------------
	<ANS 조인>
	----------------------------------------------
	select
		e.emp_no
		,e.emp_name
		,d.dep_name
	from
		employee e inner join dept d
	on
		e.dep_no=d.dep_no;	
```

#### <4> 고객명, 고객전화번호, 담당직원명, 담당직원직급을 출력하면? <조건>담당직원이 있는 고객만 출력<inner join>
```
	<주의> 담당직원이 있는 고객만 나와야하므로, 즉 조건에 맞는 행만 나와야하므로 inner 조인이다.
	조인가능한 테이블에 갯수를 물어본다면 갯수는 상관없음 실력과는 관계없음 (입)
	--------------------------------------------
	오라클 조인
	--------------------------------------------
    	select
        		c.cus_name  고객명
        		,c.tel_num  고객전화번호
        		,e.emp_name 담당직원명
        		,e.jikup    담당직원직급
    	from
        		customer c,employee e
    	where
        		c.emp_no = e.emp_no;
	--------------------------------------------
	ANSI 조인
	--------------------------------------------	
	select
        		c.cus_name  고객명
        		,c.tel_num  고객전화번호
        		,e.emp_name 담당직원명
        		,e.jikup    담당직원직급
    	from
        		customer c inner join employee e
    	on
        		c.emp_no = e.emp_no;
```
    
#### <5> 고객명, 고객전화번호, 담당직원명, 담당직원직급을 출력하면? <조건>10번 부서의 담당직원이 있는 고객만 출력
```
	오라클 조인
	-------------------------------------
    	select
        		c.cus_name  고객명
        		,c.tel_num  고객전화번호
        		,e.emp_name 담당직원명
        		,e.jikup    담당직원직급
   	 from
        		customer c,employee e
    	where
        		c.emp_no = e.emp_no and e.dep_no =10 ;

	<주의> 오라클 조인에서 where  절에 조인 조건과 행을 골라내는 조건이 같이 나올수 있다. and 로 연결
	--------------------------------------
	ANSI 조인
    	select
        		c.cus_name  고객명
        		,c.tel_num  고객전화번호
        		,e.emp_name 담당직원명
        		,e.jikup    담당직원직급
   	 from
        		customer c inner join employee e
    	on
        		c.emp_no = e.emp_no
    	where
       		e.dep_no =10;

	<주의> ANSI 조인에서 on 절에 조인 조건을 쓰고, where절에 행을 골라내는 조건을 쓴다.
```
#### <6>  고객명, 고객전화번호, 담당직원명, 담당직원직급을 출력하면? <조건>연봉이 3000만원 이상인 담당직원이 있는 고객만 포함
```
	한쪽이 다 나오라는 조건이 없었기때문에 inner join이다.
	--------------------------------------
	오라클 조인
	-------------------------------------
	select
	        	c.cus_name  고객명
        		,c.tel_num  고객전화번호
        		,e.emp_name 담당직원명
        		,e.jikup    담당직원직급	
	from
        		customer c,employee e
    	where
        		c.emp_no = e.emp_no and e.salary >= 3000 ;
	--------------------------------------
	ANSI 조인
	--------------------------------------
	select
	        	c.cus_name  고객명
        		,c.tel_num  고객전화번호
        		,e.emp_name 담당직원명
        		,e.jikup    담당직원직급	
	from
        		customer c,employee e
    	on
        		c.emp_no = e.emp_no
	where
		e.salary >= 3000 ;
```
  
    
    
