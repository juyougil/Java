#### <1> EMPLOYEE 테이블로부터 SALARY 컬럼만 제외하고 다 볼수 있는 뷰 EMPLOYEE_VW1를 생성하면?
```
create view employee_vw1 as
select 
	emp_no,emp_name,dep_no,jikup,hire_date,jumin_num,phone_num,mgr_emp_no
from
	employee
```

#### <2> 뷰 employee_vw1에 데이터 '이승엽', 40, '과장', '1990-09-01', '7811231452719', '01090056376', 1 를 입력하면?
```
	-----------------------------------------------------------------------------
	뷰에 insert를 하면 뷰의 근원이 되는 원본 테이블에 insert 된다.
	모조건 insert 되는 것은 아니고 원본 테이블에 insert 되는 상황이어야한다.
	-----------------------------------------------------------------------------
	insert into employee_vw1(emp_no, emp_name, dep_no, jikup, hire_date, jumin_num, phone_num, mgr_emp_no)
	values((select nvl(max(emp_no),0)+1 from employee_vw1),'이승엽', 40, '과장',to_date('1990-09-01','YYYY-MM-DD'), '7811231452719', '01090056376', 1);
	-------------------------------------------------------------------------------
	비록 뷰 employee_vw1에 insert를 했지만 실제로는 employee 테이블에 입력된 것이다.
```

#### <3> 뷰 employee_vw1에서 주민번호 '7811231452719', 직원명 '이승엽'의 직급을 부장으로 수정하면?
```
	-----------------------------------------------------------------------------
	뷰에 insert를 하면 뷰의 근원이 되는 원본 테이블에 insert 된다.
	모조건 insert 되는 것은 아니고 원본 테이블에 insert 되는 상황이어야한다.
	-----------------------------------------------------------------------------
	update  employee_vw1 set jikup = '부장' where emp_name='이승엽' and jumin_num= '7811231452719';
```

#### <4> 뷰 employee_vw1에서 주민번호 '7811231452719'인 직원을 제거하면?
```
	-----------------------------------------------------------------------------
	뷰에 insert를 하면 뷰의 근원이 되는 원본 테이블에 insert 된다.
	모조건 insert 되는 것은 아니고 원본 테이블에 insert 되는 상황이어야한다.
	pk를 참조하고 있다면 삭제가 되지 않음!! 하지만 이승엽은 방급 추가한 데이터라 참조되고 있지 않기때문에 삭제가 가능
	-----------------------------------------------------------------------------
	delete from employee_vw1 where jumin_num = '7811231452719'

```

#### <5> 뷰 employee_vw1를 제거하면?
```
	드롭 뷰또는 테이블명
	drop view employee_vw1; 
```

#### <6> 다음 뷰에 대한 질문에 대답하면?
```
	create view employee_vw4 as
	select emp_no, emp_name, dep_no from employee;
	-----------------------------------------------------------
	<문>위의 뷰를 만든 후 insert into employee_vw4 values(21,'사오순',40); 실행하면 성공하나 실패하나?
	employee 테이블에서 not null, unique 등의 제약조건에 위반되기 때문에 못들어 간다.
```

#### <7> 다음 뷰에 대한 질문에 대답하면? (기)
```
	insert into dept values(60,'전략부','부산');
	--------------------------------------------
	create view dept_vw1 as
		select dep_no, dep_name, loc from dept
		where dep_no=60 with check option;
	--------------------------------------------
	<문>update dept_vw1 set dep_no=70 where dep_no =60 을 실행하면?
	--------------------------------------------------------------------------
		실패. with check option이 있으면 where조건에 위배되는 [입력], [수정]은 불가능하다

		즉 dept_vw1란 이름의 view의 목적은 60번 부서를 검색하는 게 목적이므로 이 목적을 위배하는 행위는 하지마라
		 위배하면 60번 부서를 검색하지 못하게 되니까 위배하지 마라의 의미이다.
	--------------------------------------------------------------------------
	<문>insert into dept values(70,'미래부','대구'); 을 실행하면?
	--------------------------------------------------------------------------
```

#### <8> 다음 뷰에 대한 질문에 대답하면? (기.입)
```
	------------------------------------------------------
	create view employee_vw6 as
		select emp_no, emp_name, dep_no, jikup, salary from employee where salary>=3000
	WITH CHECK OPTION;
	--------------------------------------------------------------
	--------------------------------------------------------------
	<문>update employee_vw6 set salary = salary*0.95 where salary>=3000을 실행하면?
	--------------------------------------------------------------
	실패. with check option이 있으면 where조건에 위배되는 [입력], [수정]은 불가능하다
	현재 5% 인하에서 3000 밑으로 내려가는 직원이 있으므로 이번 update는 실패한다.
	만약 5% 인하에서 밑으로 내려가는 직원이 없다면 이 update는 성공할 것이다.
	--------------------------------------------------------------
	<문>update employee_vw6 set salary = salary*1.95 where salary>=3000을 실행하면?
	--------------------------------------------------------------
	성공. 업데이트로 3000 미만으로 내려가지 않아 조건에 위배되지 않으므로 성공한다.
```

#### <9> 다음 뷰에 대한 질문에 대답하면?(기.입)
```
	create view employee_vw7 as
		select emp_no, emp_name, dep_no, jikup, salary from employee where salary >= >3000 WITH CHECK OPTION;
	--------------------------------------------------------------------------------------------
	--------------------------------------------------------------
	<문>update employee_vw7 set salary = salary*0.95 where salary>=3100을 실행하면?
	--------------------------------------------------------------
	성공.WITH CHECK OPTION이 있으면 where 조건에 위배되는 입력, 수정이 발생한 경우에만 불가능하다.
	현재 5% 인하해서 3100 밑으로 내려가는 직원이 없으므로 이번 update는 성공한다.
```
#### <10> 부서별, 직급별로 [부서번호], [부서명], [직급], [평균연봉]을 출력하는 employee_vw3를 생성하면?
```
 create view employee_vw3 as
    select
        d.dep_no "dep_no"
        ,d.dep_name "dep_name"
        ,e.jikup       "jikup"
        ,avg(e.salary)  "avg_salary"
    from
        dept d, employee e
    where
        d.dep_no=e.dep_no
    group by
        d.dep_no,d.dep_name, e.jikup
    order by
        "dep_no", "avg_salary"  desc
```
