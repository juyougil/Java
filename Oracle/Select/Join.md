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

#### <7> [직원부서명],[직원명],[직원직급],[담당고객명],[고객전화]를 출력하면? <조건> 직원 이름 오름차순 정렬
```
	--------------------------------------
	오라클 조인
	-------------------------------------
    	select
        		d.dep_name
        		,e.emp_name
        		,e.jikup
        		,c.cus_name
        		,c.tel_num
    	from
        		dept d, employee e, customer c
    	where
        		d.dep_no = e.dep_no and e.emp_no = c.emp_no
   	 order by 
		e.emp_name;
	--------------------------------------
	ANSI 조인
	--------------------------------------
	select
         		d.dep_name
        		,e.emp_name
        		,e.jikup
        		,c.cus_name
        		,c.tel_num
   	from
        		(employee e inner join dept d
    	on    
        		d.dep_no = e.dep_no) inner join customer c 
	on  
		e.emp_no = c.emp_no
        
    	order by
        		e.emp_name;	
	ANSI 단점 3개의 테이블로부터 코드가 길어진다
```

#### <8> 직원명 ,직원직급 ,소속부서명 , 연봉등급 을 출력하면? 연봉등급 오름차순, 직급높은순서 오름차순, 나이높은 순서 내림
```
	--------------------------------------
	오라클 조인
	-------------------------------------
    	select
        		e.emp_name
        		,e.jikup
        		,d.dep_name
        		,s.sal_grade_no
    	from
        		employee e, dept d, salary_grade s
    	where e.dep_no = d.dep_no
        		and
        		salary between min_salary and max_salary
    	order by s.sal_grade_no asc,
    		case    e.jikup
		when '사장' then 1
		when '부장' then 2
		when '과장' then 3
		when '대리' then 4
		when '주임' then 5
		else 6
		end
		asc,
        		case when substr(e.jumin_num,7,1) in('1','2') then '19' else '20' end || substr(e.jumin_num,1,6) asc;


	--------------------------------------
	ANSI 조인
	--------------------------------------
    	select
        		e.emp_name
        		,e.jikup
        		,d.dep_name
        		,s.sal_grade_no
   	 from
        		(employee e inner join dept d on e.dep_no = d.dep_no) inner join salary_grade s on salary between min_salary and max_salary
   	 order by s.sal_grade_no asc,
    		decode(e.jikup,'사장',1,'부장', 2,'과장' ,3,'대리',4,'주임',5,6)asc,
       		case when substr(e.jumin_num,7,1) in('1','2') then '19' else '20' end || substr(e.jumin_num,1,6) asc;
```

#### <9> 부하직원명, 부하직원직급, 직속상관명, 직속상관직급을 출력하면? <조건>상관이 있는 직원만 포함
```
    	select
       		employees.emp_name   부하직원명
        		,employees.jikup     부하직원직급
        		,mgr.emp_name        직속상관명
        		,mgr.jikup           직속상관직급
   	 from
        		employee employees, employee mgr
    	where
       		 employees.mgr_emp_no = mgr.emp_no and employees.mgr_emp_no is not null;
```

#### <10> 직속상관명, 직속상관직급, 부하직원명, 부하직원직급을 출력하면? <조건> 상관이 있는 직원만 포함
```
    	select
        		mgr.emp_name   직속상관명
        		,mgr.jikup     직속상관직급
        		,employees.emp_name        부하직원명
        		,employees.jikup          부하직원직급
   	from
        		employee employees, employee mgr
    	where
        		employees.mgr_emp_no = mgr.emp_no
   	order by mgr.emp_no ;

    	select
         		mgr.emp_name   직속상관명
        		,mgr.jikup     직속상관직급
        		,employees.emp_name        부하직원명
        		,employees.jikup          부하직원직급
    	from
        		employee employees inner join employee mgr
    	on
       		employees.mgr_emp_no = mgr.emp_no
    	order by mgr.emp_no;
```
		
#### <11> 부서명, 직원명, 직원직급, 연봉등급, 상관명, 상관직급, 고객명을 출력하면?	inner join 대표문제!!!!!!!!!!
```
    	select
        		e1.emp_name
        		,e1.jikup
        		,d.dep_name
        		,s.sal_grade_no
        		,e2.emp_name
        		,e2.jikup
        		,c.cus_name
   	 from
       		employee e1, employee e2, dept d,salary_grade s, customer c
   	 where
        		e1.mgr_emp_no = e2.emp_no and d.dep_no = e1.dep_no and e1.emp_no = c.emp_no and e1.salary between min_salary and max_salary
            
        
    	select
        		e1.emp_name
        		,e1.jikup
        		,d.dep_name
        		,s.sal_grade_no
        		,e2.emp_name
        		,e2.jikup
        		,c.cus_name
    	from
        		((((employee e1 inner join employee e2 on e1.mgr_emp_no = e2.emp_no)
         		inner join dept d on d.dep_no = e1.dep_no) 
         		inner join salary_grade s on e1.salary between min_salary and max_salary) 
         		inner join customer c on e1.emp_no = c.emp_no);

```
### outer join
#### <12> 고객명, 고객전화번호, 담당직원명, 담당직원직급을 출력하면? <조건>담당직원이 없는 고객도 포함
```
    	select
        		c.cus_name  고객명
        		,c.tel_num  고객전화번호
        		,e.emp_name 담당직원명
        		,e.jikup    담당직원직급
    	from
        		customer c, employee e
    	where
        		c.emp_no=e.emp_no(+);
	--------------------------------------------
	c.emp_no = e.emp_no(+) 의미
		(+)가 붙은 컬럼의 반대편 컬럼의 소속 테이블 행은 모두 나오고
		(+)가 붙은 e.emp_no 컬럼의 소속 테이블 행은 조건에 맞는 게 없으면 null 이라도 달고 나오라는 뜻
		c.emp_no = e.emp_no(+)
```
