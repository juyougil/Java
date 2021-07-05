#### <1> employee 테이블에 '장보고', 40, '대리', 3500, '2012-05-28', '8311091109310', '01092499215',3 데이터를 입력하면?
```
	----------------------------------------------------------------------------------
	시컨스를 사용하여 PK 같을 입력 예
	----------------------------------------------------------------------------------
	insert into employee( 
	    emp_no, emp_name, dep_no, jikup, salary, hire_date, jumin_num, phone_num, mgr_emp_no 
	)
	values( 
	    emp_sq.nextval, '장보고', 40, '대리', 3500, to_date('2012-05-28','YYYY-MM-DD'), '8311091109310', '01092499215', 3 
	);
	----------------------------------------------------------------------------------
	서브쿼리를 사용하여 PK 값을 입력 예
	----------------------------------------------------------------------------------
	insert into employee( 
	    emp_no, emp_name, dep_no, jikup, salary, hire_date, jumin_num, phone_num, mgr_emp_no 
	)
	values( 
	    (select nvl(max(emp_no),0)+1 from employee), 
		'장보고', 40, '대리', 3500, to_date('2012-05-28','YYYY-MM-DD'), '8311091109310', '01092499215', 3 
	);
```
#### <2> employee 테이블에 직원 번호가 18번이고 주민번호 '8203121977315', 이름 강감찬 직원의 직급을 주임으로 수정하려면?
```
	----------------------------------------------------------------------------------
	주민번호를 사용하여 수정 예(좋은 답이 아니다. 왜? 주민번호는 DBA가 준 값이 아니므로 신뢰도가 떨어진다.)
	----------------------------------------------------------------------------------
	update
		employee
	set
		jikup='주임'
	where
		jumin_num = '8203121977315'
	----------------------------------------------------------------------------------
	PK를 사용하여 수정 예(좋은 답이다. 왜? PK는 DBA가 준 값이니까 신뢰도가 높다.)
	----------------------------------------------------------------------------------
	update
		employee
	set
		jikup='주임'
	where
		emp_no = 18
```

#### <3> employee 테이블에 여성 직원의 월급을 500만원 인상하는 update문은?
```
	update
		employee
	set
		salary = salary+500
	where
		substr(jumin_num,7,1) in ('2','4')
	-----------------------------------------------
	update
		employee
	set
		salary = salary+500
	where
		substr(jumin_num,7,1) = any ('2','4')
	-----------------------------------------------
	update
		employee
	set
		salary = salary+500
	where
		jumin_num like '______2%' or jumin_num like '______4%'
```

#### <4> employee 테이블에 평균 연봉 이상의 직원 연봉을 2% 삭감하면?
```
	update
		employee
	set
		salary = salary+salary*0.98
	where
		salary>= (select avg(salary) from employee;)

```

#### <5> employee 테이블에 평균 연봉 보다 적은 연봉자의 연봉을 50만원 인상하면?
```
	update
		employee
	set
		salary = salary+50
	where
		salary < (select avg(salary) from employee;)
```

#### <6> employee 테이블에 담당고객이 있는 직원의 급여를 5% 인상하면?
```
	update
		employee
	set
		salary = salary*1.05
	where
		emp_no in (select distinct emp_no from  customer  where emp_no is not null)	

	update
		employee
	set
		salary = salary*1.05
	where
		emp_no= any (select distinct emp_no from  customer  where emp_no is not null)
```

#### <7> 연봉 서열 2~5위 까지 5명의 연봉을 10% 인하하면 정렬 기준 =>연봉 높은 순서>직급 높은 순서>입사일 빠른 순서> 나이 높은 순서
```
	update
        		employee
	set
        		salary=salary*0.90
    	where
        		emp_no in (SELECT emp_no FROM
        				(SELECT ROWNUM RNUM,E.* FROM
        				(SELECT *FROM EMPLOYEE ORDER BY salary desc ,DECODE(JIKUP,'사장',1,'부장',2,'과장',4,'대리',5,'주임',6,7)) E
        				WHERE ROWNUM<=5)
    			WHERE
			RNUM>=2)
```
