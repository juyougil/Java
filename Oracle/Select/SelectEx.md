#### <1> employee 테이블에서 모든 컬럼, 모든행의 데이터를 검색하면?
```
select emp_no, emp_name, dep_no, jikup, salary, hire_date, jumin_num, phone_num from employee; --> 내가 쓴 순서대로 보여줌
	
select emp_no,
	emp_name
	,dep_no
	,jikup
	,salary		 --> 위에 코드 정리 버전 내용은 같음
	,hire_date
	,jumin_num
	,phone_num
from
	employee;


select * from employee;  --> 테이블 만들때 순서대로 보여줌
```

#### <2> employee 테이블에서 emp_no, emp_name, jikup, salary, hire_date 컬럼의 데이터를 검색하면?
```
	select
		emp_no
		,emp_name
		,jikup, salary
		,hire_date
	from
		employee;
```

#### <3> employee 테이블에서 emp_no, emp_name, jikup, salary, hire_date를 검색하면서 별칭을(=alias) 즉 헤더를 사원번호, 직원명, 직급, 연봉, 입사일로 하고 연봉에 '만원' 이란 문자를 붙여 검색하면?
```
alias(알리알스): 컬럼명 뒤에 as "원하는이름" (알리오스) " "는 알리알스에서만 씀
	이름에 공백을 넣으려면 ""는 생략 불가능
	--------------------------------------------------
	select
		emp_no		as "직원번호"
		,emp_name	as "직원명"
		,jikup		as "직급"
		,salary||'만원'	as "연봉" ->오라클의 연결 연산자 || 로 컬럼데이터에 '만원'이라는 문자를 붙임 테이블데 들어가는 문자 [데이터]들 넣은 것이기 때문에 '로 감쌈
		,hire_date	as "입사일"
	from
		employee;
	--------------------------------------------------
	<참고>as 생략이 가능하다.
	<참고>별칭에 공백이 없으면 " 도 생략이 가능하다. 그렇치만 "는 사용하자. 
		이름에 공백을 넣으려면 ""는 생략 불가능
	<참고>오라클에서 연결 연산자는 + 가 아니라 || 이다. 자바와 다르다.
	<참고>"는 alias(알리알스)같은 테이블에 들어가는 데이터가 아닌 문자에 씀
```

#### <4> employee 테이블에서 직원명, 직급, 연봉, 세금을 검색하면? (세금은 연봉의 12%)
```
	select
		emp_name	as "직원명"
		,jikup		as "직급"
		,salary*0.12||'만원'	as "연봉"  <-salary자료형이 number이기 때문에 곱하기가 가능
		,salary*0.88||'만원'	as "실수령액"
	from
		employee;
```

#### <5> employee 테이블에서 직급을 중복 없이 검색하면?
```
distinct을 사용  () 생략 가능

 	select distinct jikup from employee;
 	select distinct (jikup) from employee;
 	select unique (jikup)   from employee;
```

#### <6> employee 테이블에서 부서번호와 직급을 중복 없이 검색하면?
```
	select distinct jikup, dep_no from employee;
	select unique jikup, dep_no from employee;
```

#### <7> employee 테이블에서 연봉이 3000 이상인 직원을 검색하면?
```
where 칼럼명 비교 연산자(부등호가 먼저><) 사용(true아니면 fauls) . 조건에 따라 행을 골라낼때 사용 페이징처리
where가 없으면 모든 행을 출력한다는 의미	
	select * from employee where salary >= 3000;
	select * from employee where salary == 3000; ->==는 없음 =로 바꿔야함
```

#### <8> employee 테이블에서 연봉 오름차순으로 검색하면? 
```
order by 칼럼명 asc(오름차순). 행을 내가 원하는 순서로 정렬할때 사용
	---------------------------------------------------------------------------------------------
	select * from employee order by salary asc;		asc는 생략 가능
	---------------------------------------------------------------------------------------------
	select * from employee order by salary;
	---------------------------------------------------------------------------------------------
	select * from employee order by 5 asc; ->테이블 생성시 순서에 맞는 위치번호를 써도 가능
	---------------------------------------------------------------------------------------------
	select * from employee order by 5; 
	---------------------------------------------------------------------------------------------
<참고>오라클은 인덱스 번호가 1부터 시작하기 때문에 salary의 위치번호가 5이다.
```

#### <9> employee 테이블에서 연봉 내림차순으로 검색하면? 
```
	----------------------------------------------------------------------------------
	select * from employee order by salary desc; 내림차순 desc는 생략 불가능
	----------------------------------------------------------------------------------
	select * from employee order by 5 desc; ->테이블 생성시 순서에 맞는 위치번호를 써도 가능
	----------------------------------------------------------------------------------
```

#### <10> employee 테이블에서 부서번호 오름차순을 유지하면서 연봉 내림차순으로 검색하면?
```
	select * from employee order by dep_no asc, salary desc;
	select * from employee order by dep_no, salary desc;	--> asc를 생략, 둘다 desc인 것으로 착각 하면 안됨!!!
```

#### <11> employee 테이블에서 직급이 높은 차순으로 나열해서 검색하면?
```
	select * from employee order by jikup desc;
	select * from employee order by jikup asc;
	위 답은 모두 잘못된 것
	직급순서는 인간이 생각하는 기준이지 오라클의 단순한 정렬개념하고는 다르다.
	추후 조건문을 써서 정렬의 기준을 바꾸어야 답이 나온다.
<답>
	----------------------------------------------------------------------------------
	select * from employee order by decode(jikup,'사장',1,'부장',2,'과장',3,'대리',4,'사원',5) asc;
	----------------------------------------------------------------------------------


<변형>
	----------------------------------------------------------------------------------
	select * from employee order by decode(jikup,'사장',1,'부장',2,'과장',3,'대리',4,'사원',5) desc;
	----------------------------------------------------------------------------------
	 select * from employee order by decode(jikup,'사장',1,'부장',2,'과장',3,'대리',4,'사원',5) asc, salary desc;
	----------------------------------------------------------------------------------
	<명심>고객의 요구 사항을 보고 select 문을 작성하는 것도 중요하지만
		이미 작성된 select 문을 보고 고객의 요구 사항을 알아내는 것도 중요하다.

```

#### <12> employee 테이블에서 부장만 검색하면?
```
select * from employee where jikup = '부장';
```

#### <13> employee 테이블에서 20번 부서의 과장만 검색하면?
```
and 사용
	    select * from employee where dep_no = 20 and jikup = '과장';
```

#### <14> employee 테이블에서 20번 부서 또는 과장만 검색하면?
```
or사용
	 select * from employee where dep_no = 20 or jikup = '과장';
```

#### <15> employee 테이블에서 과장 중에 연봉 3400 이상을 검색하면?
```
select * from employee where salary >= 3400 and jikup = '과장';
```

#### <16> employee 테이블에서 실수령 액이 4000만원 이상 받는 직원을 검색하면? 세금은 12%
```
select * from employee where salary*0.88 >= 4000;
```

#### <17> employee 테이블에서 세금을 제일 많이 내는 직원 순서로 나열하면서 부서번호가 내림차순이면서 사장이 아닌 직원을 검색하면?
```
select * from employee where jikup != '사장' order by salary*0.12 desc, dep_no desc; 
```

#### <18> employee 테이블에서 20번 부서 중에 연봉 2000~3000 사이 검색하면?
```
	select * from employee where dep_no = 20 and salary>= 2000 and salary<=3000;
	select * from employee where dep_no = 20 and salary between 2000 and 3000;

between는 이상과 이하에 사용
```

#### <19> employee 테이블에서 직속 상관이 없는 직원을 검색하면?
```
null은 실존 값이 아니기 때문에 is나 is not을 사용!!
	select * from employee where mgr_emp_no is null; -> =는 실존 데이터만 검색 가능하기 때문에 안됨
```

#### <20> employee 테이블에서 직속 상관이 있는 직원을 검색하면?
```
select * from employee where mgr_emp_no is not null;
```

#### <21> employee 테이블에서 [최소 연봉],[최대 연봉],[평균 연봉],[연봉 총합],[총인 원수]를 검색해서 출력하면?
```
[최소 연봉] min함수 사용
	select min(salary) from employee;

[최대 연봉] max함수 사용
	select max(salary) from employee;

[평균 연봉]
null값이 있다면 평균에서 제외됨
	select avg(salary) from employee;

[연봉 총합] 
	select sum(salary) from employee;

[총인 원수]
count는 null값을 제외하고 카운트
총인원수 not null이 걸려있는 칼람의 데이터의 총갯수를 구하면 알수있음
*로 모든 행의 수  카운트 가능
	select count(salary) from employee;
    select count(*) from employee;

<답>
select
	min(salary) as "최소 연봉"  --salary 컬렴에서 최소값을 리턴
	,max(salary) as "최대 연봉" --salary 컬렴에서 최대갊을 리턴
	,avg(salary) as "평균 연봉" --salary 컬렴에서 평균값을 리턴
                                		--<조심> avg 사용시 null이 있으면 더할때 빠지고 나누는 개수에서도 빠진다.
	,sum(salary) as "연봉총합"  --salary 컬럼에서 총합을 리턴
	,count(*) as "총인원수"     -->count(*)는 총행의 갯수
	from
		employee;
	--------------------------------------------------
	min, max, avg,sum,count 함수들을 그룹함수 또는 통계함수라고 부르기도한다.
	그룹지어서 연산을 하는 함수이기 때문이다.
	그룹함수들은 주로  group by와 같이 많이 사용된다.
	---------------------------------------------------
	min, max, avg,sum,count 함수들을 null값은 제외하고 계산한다.
	--------------------------------------------------
	count(컬럼명) => 컬럼안의 null 아닌 데이터의 개수를 리턴한다.
	count(컬럼명) => 행의 개수를 리턴한다.

```

#### <22> 아래 SQL구문은 무슨 문제의 답인가?    
- select count(emp_no) from customer;
  - 담당직원이 있는 고객의 명수, emp_no 컬럼안의 데이터가 담당 직원의 직원번호이므로 
	    중복을 제거하면 고객을 담당하고 있는 직원의 수가 됨.
      
#### <23> 고객을 담당하고 있는 직원의 명수는?
```
distinct 사용 -> 컬럼안의 데이터 중복을 제거
	select count(distinct emp_no) from customer;
```

#### <24>  직속상관이 있는 직원의 명수는?
```
	select count(mgr_emp_no) from employee;
	------------------------------------------------
	<주의>mgr_emp_no 컬럼안의 데이터가 뭔지 파악해야한다. 바로 직속 상관의 직원번호이다.
	-----------------------------------------------
```

#### <25> 부하직원이 있는 직원의 명수는?
```
	select count(distinct mgr_emp_no) from employee;
	------------------------------------------------------
	distinct컬럼명 => 컬럼안의 데이터의 중복을 제거
	------------------------------------------------------
	<주의>count 에는 업무적 특징이 숨어 있어 조심히 날려야한다.

```

#### <26> employee 테이블에서 [직원번호],[직원명],[생일월-생일일] 검색해서 출력하면?
```
substr(시작할 위치,가져올 갯수)
	select
		emp_no as "직원번호"
		,emp_name as "직원명"
		,substr(jumin_num,3,2)||'-'||substr(jumin_num,5,2)	as"생일월일"
	from
		employee;
	----------------------------------------------------------
	substr(컬럼명, 복사시작순서번호, 복사할개수) 시작순서번호 부터 복사할개수 만큼 복사해서 리턴
						엄청난 사용빈도를 자랑한다.

```

#### <27> customer  테이블에서 모든 컬럼, 모든 행을 검샘해서 출력하면? 단 주민번호는 901225-2****** 형태로 출력
```
	select
		cus_no
		,cus_name
		,tel_num
		,substr(jumin_num,1,6)||'-'||substr(jumin_num,7,1)||'******'
		,emp_no
	froms
		customer;
	-------------------------------------------------------------
	<주의>모든 행 이란 말이 나오면 where절이 없다.
	-------------------------------------------------------------
	substr(컬럼명, 복사시작순서번호, 복사할개수) 시작순서번호 부터 복사할개수 만큼 복사해서 리턴
						엄청난 사용빈도를 자랑한다.
	-------------------------------------------------------------
	|| =>좌우의 문자열을 붙이는 연산자, 즉 연결 연산자이다. 오라클에서 +는 사칙연산자이다.
	'tom'||123 -> 'tom'||'123' -> 'tom123'
```

#### <28> customer  테이블에서 고객번호, 고객명, 담당직원번호를 출력하면? 단 직원번호가 없으면 null 출력하지 말고 '없음'으로 표시 
```
null값을 처리해주는 함수 nvl(컬럼명, null일때 대체 데이터).
null이 아니면 그냥 리턴 null이면 null값일때 대체데이터를 리턴하는 [null 처리 내장함수]
nvl함수는 컬럼의 자료형과 대체데이터의 자료형이 같아야 한다.
null값을 통계에 포함시키고 싶을때 사용가능

<오류 예시>
	select
		cus_no
		,cus_name
		,nvl(emp_no, '없음') -> 오류: emp_no의 자료형은 number인데 문자를 출력하려고 해서.
	from
		customer;
<답>
||''로 숫자를 문자로 변형
	select
		cus_no
		,cus_name
		,nvl(emp_no||'', '없음')
	from
		customer;
```

#### <29> customer  테이블에서 고객번호, 고객명, 담당직원존재여부를 출력하면? 단 직원번호가 있으면 '있음', 없으면 '없음'으로 표시 
```
nvl2(컬럼명,null값이 아닐때 대체데이터, null일때 대체 데이터) 사용 
null이 아니면 null값아닐때 대체데이터 리턴 null이면 null값일때 대체데이터를 리턴하는 [null 처리 내장함수]


	select
		cus_no
		,cus_name
		,nvl2(emp_no,'있음', '없음')
	from
		customer;
```

#### <30> employee 테이블에서 직원번호, 직원명, 직급, 성별을 출력하면?
```
	select
		emp_no
		,emp_name
		,jikup
		,case 
			substr(jumin_num,7,1)
			when '1' then '남' 
			when '3' then '남'
			when '2' then '여' 
			when '4' then '여' 
		end
	from
		employee;
------------------------------------------------------------
else 사용
	select
		emp_no
		,emp_name
		,jikup
		,case 
			substr(jumin_num,7,1)
			when '1' then '남' 
			when '3' then '남'
			else '여'
		end
	from
		employee;
-------------------------------------------------------------
이렇게 할 경우 같다 뿐만 아닌 부등호를 사용해 비교할수있음

	select
		emp_no
		,emp_name
		,jikup
		,case 
			when substr(jumin_num,7,1) = '1' then '남'
			when substr(jumin_num,7,1) = '3' then '남' 
			else '여'
		end
	from
		employee;
--------------------------------------------------------------
decode()		같다 이외에는 안됨
	select
		emp_no
		,emp_name
		,jikup
		,decode(substr(jumin_num,7,1)
		,'1','남'
		,'3','남'
		,'여')
	from
		employee;
---------------------------------------------------------------
case~end 구문의 패턴 설명
---------------------------------------------------------------
	case 컬럼명
		when 데이터1 then 리턴값1
		when 데이터2 then 리턴값2
		~
		else 리턴값n
	end
	----------------------------------------------------
		컬럼명 안의 데이터가 데이터1과 같으면 리턴값1 을 리턴
		컬럼명 안의 데이터가 데이터2과 같으면 리턴값2 을 리턴
		~
		그외에는 리턴값n을 리턴
	<패턴1>----------------------------------------------------
	case 
		when 컬럼명=데이터1 then 리턴값1
		when 컬럼명=데이터2 then 리턴값2
		~
		else 리턴값n
	end
	----------------------------------------------------
		컬럼명 안의 데이터가 데이터1과 같으면 리턴값1 을 리턴
		컬럼명 안의 데이터가 데이터2과 같으면 리턴값2 을 리턴
		~
		그외에는 리턴값n을 리턴
	-----------------------------------------------------------------------
	패턴2에서 = 대신에 필요에 따라 >=,>,<,<=,!=등의 비교연산자도 사용할 수 있다.
	필요에 따라 else 리턴값n은 생략 될 수 있다.
---------------------------------------------------------------
decode(~) 구문의 패턴 설명
---------------------------------------------------------------
	decode(
		칼럼명	
		,비교데이터1,리턴값1			
		,비교데이터2,리턴값2			
		,~
		,리턴값n
	)
	------------------------------------------------------
	컬럼명 안의 데이터가 데이터1과 같으면 리턴값1 을 리턴
		컬럼명 안의 데이터가 데이터2과 같으면 리턴값2 을 리턴
		~
		그외에는 리턴값n을 리턴
	-------------------------------------------------------
	필요에 따라 else 리턴값n은 생략 될 수 있다.
	decode 단점 => 같다라는 경우에 만 사용된다.
			=>오라클에서만 사용되는 전용함수이다. case ~ end 구문은 모든 DB에서 사용가능




오라클 조건문 case(),decode()

case 컬령명 when 비교데이터 then 대체데이터 end
마지막은 end로 마무리 해주어야 함.

모든 데이터베이스에서 사용가능
case는 부등호 사용가능
decode는 같다 이외에는 비교불가능 대신 간단함
```

#### <31> employee 테이블에서 직원번호, 직원명, 직급, 출생년도(4자리)를 출력하면?
```
case
----------------------------------------------
	select
		emp_no
		,emp_name
		,jikup
		,case
			substr(jumin_num,7,1)
			when '1' then '19'
			when '2' then '19'
			when '3' then '20'
			when '4' then '20'
		end ||substr(jumin_num,1,2)
	from
		employee;
------------------------------------------------
decode
------------------------------------------------
 	select
		emp_no
		,emp_name
		,jikup
        ,decode(substr(jumin_num,7,1)
		,'1','19'
		,'2','19'
		,'3','20'
        ,	,'4','20') ||substr(jumin_num,1,2)
	from
		employee;
------------------------------------------------
-else 사용   
	select
		emp_no
		,emp_name
		,jikup
		,case
			substr(jumin_num,7,1)
			when '1' then '19'
			when '2' then '19'
			else '20'
		end ||substr(jumin_num,1,2)
	from
		employee;
------------------------------------------------
 	select
		emp_no
		,emp_name
		,jikup
        ,decode(substr(jumin_num,7,1)
		,'1','19'
		,'2','19'
		,'20') ||substr(jumin_num,1,2)
	from
		employee;
------------------------------------------------   
```

#### <32> employee 테이블에서 직원번호, 직원명, 직급, 출생년대(4자리)를 출력하면?
```
    select
		emp_no
		,emp_name
		,jikup
		,case
			substr(jumin_num,7,1)
			when '1' then '19'
			when '2' then '19'
			else '20'
		end ||substr(jumin_num,1,1)||'0년대'
	from
		employee;



    select
		emp_no
		,emp_name
		,jikup
        ,decode(substr(jumin_num,7,1)
		,'1','19'
		,'2','19'
		,'20') ||substr(jumin_num,1,1)||'0년대'
	from
		employee;
```

#### <33> employee 테이블에서 나이순으로 출력하면? 연장자가 먼저 나오도록.
```
	select * from employee order by jumin_num asc; -->이렇게 하면 2000년생이 먼저 나오기 때문에 안됨 주민번호가 00으로 시작
--------------------------------------------------------------------------
<답>	

	select 
		* 
	from 
		employee 
	order by
		case 
			when substr(jumin_num,7,1) = '1' then '19'
			when substr(jumin_num,7,1) = '2' then '19' 
			else '20'
		end|| substr(jumin_num,1,6)
		asc
	-------------------------------------------------------------------------
	order by 뒤는 정렬 기준 컬럼이 나온다. 정렬 기준 컬럼을 case가 끌어안아서 다른 형태로 바꾼 것이다.
	-------------------------------------------------------------------------
	order by 구문의 패턴
	-------------------------
		order by 컬럼명|컬럼순서번호|컬럼알리아스 asc|desc
```

#### <34> employee 테이블에서 직급순서대로 정렬하여 모든 컬럼을 보이면?
```
	select * from employee order by jikup asc; --> 가나다순으로 정렬이 되서 원하는 답이 나오지 않음.
---------------------
	select 
		* 
	from 
		employee 
	order by
		case jikup
		when '사장' then 1
		when '부장' then 2
		when '과장' then 3
		when '대리' then 4
		when '주임' then 5
		else 6	
		end
		asc;
---------------------
	select 
		* 
	from 
		employee1
	order by
		decode(jikup
		,'사장',1
		,'부장',2
		,'과장',3
		,'대리',4
		,'주임',5
		,6)	
		asc;

	위 구문에서 desc사용시 직급이 낮은 순서대로 정렬
	------------------------------------------------------------
	order by 뒤는 정렬 기준 컬럼이 나온다. 정렬 기준 컬럼을 case가 끌어안아서 다른 형태로 바꾼 것이다.
	------------------------------------------------------------
	정렬 시 사장은 1로 보고, 부장은 2로 보고, 과장은 3으로 보고, 대리는 4로 보고, 주임은 5로 보고
	기타는 6으로 보고 오름차순으로 정렬한다. 즉 직급을 정수로 바꾸어서 정렬을 한 것이다.

```

#### <35> employee 테이블에서 직원번호, 직원명, 입사일(년-월-일(요일)분기 시분초) 검색하면?
```
	select emp_no
		,emp_name
		,to_char(hire_date,'YYYY-MM-DD(DAY) Q AM HH24:MI:SS', 'NLS_DATE_LANGUAGE = Korean')
		,to_char(hire_date,'YYYY-MM-DD(DAY) Q HH24:MI:SS', 'NLS_DATE_LANGUAGE = Korean')
	from 
		employee;
	-----------------------------------------------------------------
	to_char(날짜 또는 숫자 컬럼명, '출력 시 원하는 문자 패턴')
	-----------------------------------------------------------------
		지정한 날짜  또는 숫자를 원하는 출력문자패턴으로 바꾸어 주는 변환함수의 일종
		리턴시 원하는 문자 패턴
			YYYY 	=> 년도 4자리
			MM 	=> 월 2자리
			DD 	=> 일 2자리
			AM HH 	=> 오전|오후 1~12사이의 시간
			HH24 	=> 0~23시 사이의 시간
			MI	=> 0~59 사이의 분
			SS	=> 0~59 사이의 초
			DAY	=> 영문 요일 풀네임
			DY	=> 영문 요일 약어
			D	=> 요일을 숫자로 출력 일요일 1 월요일 2 등등 요일을 비교할때 씀 
			Q	=> 1~4분기
	-----------------------------------------------------------------
	to_char(hire_date,'YYYY-MM-DD')
	-----------------------------------------------------------------
		hire_date 컬럼안의 데이터를 년-월-일 패턴의 문자열로 바꾸어 리턴하라.
```

#### <36> employee 테이블에서 직원번호, 직원명, 입사일(X년-X월-XX일(요일)X분기 X시X분X초) 검색하면?
```
||사용
	select 
		emp_no
		,emp_name
		,to_char(hire_date,'YYYY')||'년'||to_char(hire_date,'MM')||'월'||to_char(hire_date,'DD')||'일'||to_char(hire_date,'(DAY)','NLS_DATE_LANGUAGE = Korean')
        		||to_char(hire_date,'Q')||'분기'||to_char(hire_date,'HH')||'시'||to_char(hire_date,'MI')||'분'||to_char(hire_date,'SS')||'초'
	from 
		employee;
------------------------------------------------------------------------------------------------------------------------
""사용해 간단하게 만들기    
	select
        		emp_no
		,emp_name
		,to_char(hire_date,'YYYY"년"MM"월"DD"일"(DAY) Q"분기" AM HH24"시"MI"분"SS"초"', 'NLS_DATE_LANGUAGE = Korean')
	from
		employee;
```

#### <37> employee 테이블에서 직원번호, 직원명, 나이 검색하면?
```
to_number(숫자문자내장된컬럼명) => 문자형 숫자나 날짜를 숫자로 변환하는 변환 함수
---------------------------------------------------------------------
	select 
		emp_no
		,emp_name
		,to_number(to_char(sysdate,'YYYY'))
		-
       		to_number(
        			case
				substr(jumin_num,7,1)
				when '1' then '19'
				when '2' then '19'
				else '20'
				end||substr(jumin_num,1,2))+1||'세'
	from
		employee;
```

#### <38> employee 테이블에서 직원번호, 직원명, 근무년차를 검색하면?
```
오라클은 날짜-날짜의 결과값은 날짜차이만큼의 일수이다.
ceil() 소수 첫째 자리에서 무조건 올림해서 리턴하는 수학 함수의 일종이다.
floor() 소수 첫째 자리에서 무조건 내림해서 리턴하는 수학 함수의 일종이다.
-------------------------------------------------------------------------
오늘날짜를 입사일로 뺀다음 365를 나눈 후 소수첫째자리 올림
-------------------------------------------------------------------------
    	select 
		emp_no
		,emp_name
		,ceil((sysdate-hire_date)/365)||'년차'
	from
		employee;
```

#### <39> employee 테이블에서 직원번호, 직원명, 연령대를 검색해서 출력하면?
```
    select
	emp_no
	,emp_name
	,floor((to_number(to_char(sysdate,'YYYY'))-
        	to_number(
        		case
			substr(jumin_num,7,1)
			when '1' then '19'
			when '2' then '19'
			else '20'
		end||substr(jumin_num,1,2))+1)*0.1)||'0대'
	from
		employee;
```

#### <40> employee 테이블에서 직원번호, 직원명, 100일잔치날짜를 검색해서 출력하면?
```
날짜+정수 => 날짜에 정수만큼의 일수를 더한 날짜를 리턴
날짜-정수 => 날짜에 정수만큼의 일수를 뺀 날짜를 리턴
날짜1-날짜2 => 날짜1과 날짜2 까지의 차이를 일수로 리턴. 일수 양수가 날짜1 이 날짜2보다 큰 거다.

	select
		emp_no
		,emp_name
		,to_char(
                		to_date(
                        		case
			                substr(jumin_num,7,1)
			                when '1' then '19'
			                when '2' then '19'
			                else '20'
		                    	end ||substr(jumin_num,1,6)
                        		,'YYYYMMDD'
                			)+100
        			,'YYYY-MM-DD'
        			)
	from	
		employee;
```

#### <41> 개강일이 2021년5월12일 이고 종강일이 2021년11월10일 이다. 며칠 동안 학원 생활을 하나?
```
dual 실존하지 않는 더미 테이블. 테이블없이 그냥 출력하고싶을때 씀

	select
    		to_date('20211110','YYYYMMDD')
		-
		to_date('2021012','YYYYMMDD')
	from
    		dual;
```

#### <42> employee 테이블에서 직원번호, 직원명, 현재나이, 입사일 당시 나이 검색해서 출력하면?
```
	select emp_no
		,emp_name
		,to_number(
               		 to_char(sysdate,'YYYY')
               		 )-
       		 to_number(
          			  case
			    substr(jumin_num,7,1)
			    when '1' then '19'
			    when '2' then '19'
			    else '20'end||substr(jumin_num,1,2)
               	 	)+1||'세' 현재나이


        		,to_number(
              		  to_char(hire_date,'YYYY')
              		  )-
       		 to_number(
                		case
			    substr(jumin_num,7,1)
			    when '1' then '19'
			    when '2' then '19'
			    else '20'end||substr(jumin_num,1,2)
               		 )+1||'세' 입사일당시나이
	from
		employee;
```

#### <43> employee 테이블에서 직원번호, 직원명, 주민번호, 다가올생일날(년-월-일), 생일까지남을일수를 검색하면?
```
도전 1번째
	select
		emp_no
		,emp_name
		,jumin_num
       		 ,case
            		when sysdate-to_date(substr(jumin_num,3,4),'MMDD') >= 0 then to_char(sysdate,'YYYY')+'1'||'-'||to_char(to_date(substr(jumin_num,3,4),'MMDD'),'MM-DD')
            		else to_char(sysdate,'YYYY')||'-'||to_char(to_date(substr(jumin_num,3,4),'MMDD'),'MM-DD')
       		 end as "다가올 생일날"

       		 ,case
            		 when sysdate-to_date(substr(jumin_num,3,4),'MMDD') >= 0 then ceil((to_date(substr(jumin_num,3,4),'MMDD')+365)-sysdate)
             		else ceil(to_date(substr(jumin_num,3,4),'MMDD')-sysdate)
        		 end  "생일까지 남은 기간"
	from
		employee;

------------------------------------------------------------------------------------------------------------------------
도전 2번째	
	select
		emp_no
		,emp_name
		,jumin_num
        		,case
            		when sysdate-to_date(substr(jumin_num,3,4),'MMDD') >= 0 then to_char((to_date(substr(jumin_num,3,4),'MMDD')+365),'YYYY-MM-DD')
           		 else to_char(to_date(substr(jumin_num,3,4),'MMDD'),'YYYY-MM-DD')
      		 end as "다가올 생일날"

        		,case
             		when sysdate-to_date(substr(jumin_num,3,4),'MMDD') >= 0 then ceil((to_date(substr(jumin_num,3,4),'MMDD')+365)-sysdate)
             		else ceil(to_date(substr(jumin_num,3,4),'MMDD')-sysdate)
         		end  "생일까지 남은 기간"
	from
		employee;

--------------------------------------------------------------------------------------------------------------------------------        
강사님 버전(완벽)   최종 버전
    	select
		emp_no
		,emp_name
		,jumin_num
       		 ,case
            		when sysdate-to_date(to_char(sysdate,'YYYY')||substr(jumin_num,3,4),'YYYYMMDD') >= 0
            		then to_char(to_date(to_number(to_char(sysdate,'YYYY')+1)||substr(jumin_num,3,4),'YYYYMMDD'),'YYYY-MM-DD(DY)','NLS_DATE_LANGUAGE = Korean')
            		else to_char(to_date(to_char(sysdate,'YYYY')||substr(jumin_num,3,4),'YYYYMMDD'),'YYYY-MM-DD(DY)','NLS_DATE_LANGUAGE = Korean')
        			end as "다가올 생일날"
        		,case
             		when sysdate-to_date(to_char(sysdate,'YYYY')||substr(jumin_num,3,4),'YYYYMMDD') >= 0
            		then floor((to_date(to_number(to_char(sysdate,'YYYY')+1)||substr(jumin_num,3,4),'YYYYMMDD'))-sysdate)
             		else floor(to_date(to_char(sysdate,'YYYY')||substr(jumin_num,3,4),'YYYYMMDD')-sysdate)
         			end  "생일까지 남은 기간"
	from
		employee;
	order by "생일까지 남은 기간" asc;
---------------------------------------------------------------------------------------------------------------------------------
강사님 버전(완벽)   최종 버전2    extract(year from sysdate)사용

    	select	
		emp_no
		,emp_name
		,jumin_num
        		,case
           			when sysdate-to_date(to_char(sysdate,'YYYY')||substr(jumin_num,3,4),'YYYYMMDD') >= 0
            		then to_char(to_date(extract(year from sysdate)+1||substr(jumin_num,3,4),'YYYYMMDD'),'YYYY-MM-DD(DY)','NLS_DATE_LANGUAGE = Korean')
            		else to_char(to_date(to_char(sysdate,'YYYY')||substr(jumin_num,3,4),'YYYYMMDD'),'YYYY-MM-DD(DY)','NLS_DATE_LANGUAGE = Korean')
        			end as "다가올 생일날"
        		,case
             		when sysdate-to_date(to_char(sysdate,'YYYY')||substr(jumin_num,3,4),'YYYYMMDD') >= 0
             		then floor(to_date(extract(year from sysdate)+1||substr(jumin_num,3,4),'YYYYMMDD')-sysdate)
             		else floor(to_date(to_char(sysdate,'YYYY')||substr(jumin_num,3,4),'YYYYMMDD')-sysdate)
         			end  "생일까지 남은 기간"
	from
		employee
    	order by "생일까지 남은 기간" asc;
```

#### <44> employee 테이블에서 직원번호, 직원명, 직급, 연봉(xxx,xxxx,xxx만원)을 검색하면?
```
	select
		emp_no		"직원번호"
		,emp_name	"직원명"
		,jikup		"직급"
		,to_char(salary,'999,999,999')		"연봉"
	from
		employee;
	-----------------------------------------------------------
	to_char(salary,'999,999,999')	=> salary 컬럼안의 숫자를 3자리 마다 끊어서 ,를 삽입해 문자로 리턴하기
				     만약 각 9 자리에  대응하는 숫자가 없으면 화면에 출력이 안된다.	
	-------------------------------------------------------------
	to_char(salary,'000,000,000')  => salary 컬럼안의 숫자를 3자리 마다 끊어서 ,를 삽입해 문자로 리턴하기
				     맨 앞에 0이 있으면 그자리가 비면 0이 대체된다. 따라서 나머지도 9여도
				     전부 0으로 대체 된다.
```

#### <45> employee 테이블에서 수요일에 태어난 직원을 검색하라.
```
	select * from employee
    		where
    		to_char(to_date(
    			case substr(jumin_num,7,1)
        			when '1' then '19'
        			when '2' then '19'
        			else '20'
        			end||substr(jumin_num,1,6),'YYYYMMDD'),'DAY','NLS_DATE_LANGUAGE = Korean') ='수요일'
```

#### <46> employee 테이블에서 70년대생 남자 직원을 검색하라.
```
	select * from employee
    		where
    			case
    			substr(jumin_num,7,1) when '1' then '남'when '3' then '남' else '여' end ='남'
    			and
    			case
    			substr(jumin_num,7,1) when '1' then '19'when '2' then '19' else '20' end ||substr(jumin_num,1,1) = '197'

	
	select * from employee
    		where substr(jumin_num,7,1) = '7'
		and
		substr(jumin_num,1,1) ='1'
```

#### <47> employee 테이블에서 1960년대, 1970년대 충생자중 남자만 검색하라.
```
	select * from employee
    		where
    			case
    			substr(jumin_num,7,1) when '1' then '남'when '3' then '남' else '여' end ='남'
    			and
    			case
    			substr(jumin_num,7,1) when '1' then '19'when '2' then '19' else '20' end ||substr(jumin_num,1,1) = '197' 
    			and
    			case
    			substr(jumin_num,7,1) when '1' then '19'when '2' then '19' else '20' end ||substr(jumin_num,1,1) = '196'


	select * from employee
    		where (substr(jumin_num,1,1) = '7' or substr(jumin_num,1,1) = '6')
		and
		(substr(jumin_num,7,1) ='1' or substr(jumin_num,7,1) = '3')
```

#### <48> employee 테이블에서 오래 근무한 직원이 먼저 나오게 검색하면?
```
	select * from employee order by sysdate-hire_date desc;
	--------------------------------------------------------
	sysdate-hire_date => 지금날짜-입사일. 날짜에서 날짜를 빼면 차이만큼 일수를 리턴
```

#### <49> employee 테이블에서 직원번호, 직원명, 근무일수, 근무개월수, 입사후5개월후날짜(년-월-일), 입사한 달의 마지막 날짜, 입사한날짜에서 돌아오는 일요일 날짜(년-월-일) 검색하면? 단 근무일수는 소수 2자리에서 반올림
```
	select
		emp_no			"직원번호"
		,emp_name		"직원명"	
		,trunc(sysdate-hire_date,1)	"근무일수"
		,round(months_between(sysdate,hire_date),1)	"근무일수개월수"
		,to_char(add_months(hire_date,5),'YYYY-MM-DD') "입사후5개월후날짜"
		,to_char(last_day(hire_date),'YYYY-MM-DD')   "입사달의마지막날짜"
		,to_char(next_day(hire_date,1),'YYYY-MM-DD') "돌아오는일요일날짜"
	from
		employee
```

#### <50> employee 테이블에서 직급이 과장인 직원을 검색하면?
```
select * from employee where jikup = '과장'
```
