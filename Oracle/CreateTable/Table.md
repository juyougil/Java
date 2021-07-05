
아래 고객 요구사항에 맞는 테이블을 만들면?
---
부서를 관리하고 싶어요.     
부서정보는 부서명, 부서위치 입니다.    

직원정보를 관리하고 싶어요.    
관리하고 싶은 정보는 직원명, 직급, 입사일, 소속부서명, 연봉, 주민번호, 전화번호, 연봉등급,  직속상관명 입니다.    

고객정보를 관리하고 싶어요    
관리하고 싶은 정보는 고객명, 전화번호, 주민번호, 담당직원명 입니다.    

연봉등급을 관리하고 싶어요    
관리하고 싶은 정보는 연봉등급, 등급별최소연봉, 등급별최대연봉
<img src="dept.employee.cutomer.salary table.jpg">

---
### king 계정만들기

  - create user king identified by k123;

  - king 계정에 system 과 비슷한 권한 주기

  - grant connect,resource,dba to king

---
### 테이블 및 시퀀스 제거

- #### emp_sq 시퀀스 제거    
  drop sequence emp_sq; --<주의>emp_sq가 없으면 삭제 대상이 없다는 에러 메세지가 출력

- #### cus_sq 시퀀스 제거    
  drop sequence cus_sq;

- #### dept 테이블 제거    
  drop table dept

- #### employee 테이블 제거    
  drop table employee

- #### customer 테이블 제거    
  drop table customer

- #### salary_grade 테이블 제거    
  drop table salary_grade

---
### 테이블 삭제 순서


1. drop sequence emp_sq; --<주의>emp_sq가 없으면 삭제 대상이 없다는 에러 메세지가 출력    

2. drop sequence cus_sq;    

3. drop table salary_grade    

4. drop table customer    

5. drop table employee     테이블 삭제 순서    

6. drop table dept    

---
### 테이블 행 지우기

- delete from 테이블명;




---
### dept 테이블 만들기 create

```
create table dept(
    dep_no  NUMBER(3)                           -- [부서 번호] 저장 컬럼 선언. 자료형은 숫자형    
    ,dep_name   varchar2(20)    not null unique -- [부서 명] 저정 컬럼 선언. 제약조건 비면안되고 중복되면 안됌    
    ,loc    varchar2(20)    not null            -- [부서 위치] 저장 컬럼 선언. 제약조건 비면안됌    
    ,primary key(dep_no)                        -- dep_no 컬럼에 primary key 설정하기.    
 );    
```
--- 
#### 행단위 데이터 입력

```
insert into  dept(dep_no, dep_name, loc) values(10, '총무부', '서울'); -- into 빠지지 않게 조심
insert into  dept(dep_no, dep_name, loc) values(20, '영업부', '부산');
insert into  dept(dep_no, dep_name, loc) values(30, '전산부', '대전');
insert into  dept values(40, '자재부', '광주'); -- 테이플 생성 때 컬럼순서로 데이터 입력할 때  컬럼명을 생략 가능
```
---
#### dept 테이블의 모든 컬렴과 모든 행을 검색하기

select * from dept;



---
#### employee 테이블에서 PK값으로 사용할 일련번호를 생성하는 시퀀스 생성하기 (일련 번호 자동 생성기). 특정 테이블에 PK값으로 사용
```
create sequence emp_sq
    start with 1       --시작 할 숫자
    increment by 1     --증감할 수
    minvalue 1         --최소 수
    maxvalue 999;      --최대 수
```

---
#### employee 테이블 만들기. 직원 정보가 저장되는 테이블이다.
```
create table employee(
    emp_no  number(3)                       --[직원번호]가 저장되는 컬럼 선언.
    ,emp_name    varchar2(20)    not null   --[직원명]이 저장되는 컬럼 선언. 제약조건 비면안됌
    ,dep_no     number(3)                   --[소석부서번호]가 저장되는 컬럼 선언.
    ,jikup      varchar2(20)     not null   --[직급]가 저장되는 컬럼 선언. 제약조건 비면안됌
    ,salary     number(9)   default 0       --[연봉]이 저장되는 컬럼 선언. 제약조건 default 0 (입력이 없을 경우 0을 입력)
    ,hire_data  date    default sysdate     --[입사일]이 저장되는 컬럼 선언. 제약조건  default sysdate(입력이 없을 경우 현재 시간을 입력)
    ,jumin_num  char(13)    not null unique --[주민번호]가 저장되는 컬럼 선언. 제약조건 비면안되고 중복되면 안됌
    ,phone_num  varchar2(15)    not null    --[전화번호]가 저장되는 컬럼 선언. 제약조건 비면안됌
    ,mgr_emp_no number(3)                   --[직속상관직업번호]가 저장되는 컬럼 선언.
    ,primary key(emp_no)                    --[직원번호] 컬럼에 PK 제약조건 주기.
    ,foreign key(dep_no)  references dept(dep_no) --[소속부서번호] 컬럼에 FK 제약조건 주기. dept 테이블에 dep_no 컬럼 참조하게 하기
    ,constraint employee_mgr_emp_no_fk foreign key(mgr_emp_no)  references employee(emp_no) --[직속상관직원번호] 컬럼에 FK 제약조건 주기.
    --employee 테이블에 emp_no 컬럼 참조하게 하기.
    --emPloyee_mgr_emp_no_fk 는 제약 조건에 붙이는 이름이다.
);
```
---
#### 오류가 나는 한가지 예
```
create table employee(
    emp_no        number(3)
    ,emp_name      varchar2(20) not null
    ,dep_no        number(3)
    ,jikup         varchar2(20) not null
    ,salary        number(9) default 0
    ,hire_date     date   default sysdate
    ,jumin_num     char(13) not null unique
    ,phone         varchar2(15) not null
    ,mgr_emp_no    number(3)


    ,primary key(emp_no)
    ,foreign key(dep_no) references dept(dep_no)
    ,constraint employee_mgr_emp_no_fk foreign key(mgr_emp_no) references employee(dep_no) <=fk가 fk참조할 수 없어서 오류가 뜸
);
```
---
#### employee_mgr_emp_no_fk 라는 이름의 FK 제약조건 끄기. 즉 제약 조건 임시 무력화.

alter table employee disable constraint employee_mgr_emp_no_fk;
테이블에 있는 데이터의 자료형을 바꾸고 싶을 때는 alter

---
#### 지금 현재 로그인 한 계정의 날짜 데이터는 '년-월-일'  로 입력 가능하게 하기

alter session set nls_date_format = 'yyyy-mm-dd' ;

---
#### employee 테이블에 행 20개 추가하기

```
insert into employee values( emp_sq.nextval, '홍길동', 10, '사장', 5000, '1980-01-01', '7211271109410', '01099699515', null );
insert into employee values( emp_sq.nextval, '한국남', 20, '부장', 3000, '1988-11-01', '6002061841224', '01024948424', 1 );
insert into employee values( emp_sq.nextval, '이순신', 20, '과장', 3500, '1989-03-01', '6209172010520', '01026352672', 2 );
insert into employee values( emp_sq.nextval, '이미라', 30, '대리', 2503, '1983-04-01', '8409282070226', '01094215694', 17 );
insert into employee values( emp_sq.nextval, '이순라', 20, '사원', 1200, '1990-05-01', '8401041483626', '01028585900', 3 );
insert into employee values( emp_sq.nextval, '공부만', 30, '과장', 4003, '1995-05-01', '8402121563616', '01191338328', 17 );
insert into employee values( emp_sq.nextval, '놀기만', 20, '과장', 2300, '1996-06-01', '8011221713914', '01029463523', 2 );
insert into employee values( emp_sq.nextval, '채송화', 30, '대리', 1703, '1992-06-01', '8105271014112', '01047111052', 17 );
insert into employee values( emp_sq.nextval, '무궁화', 10, '사원', 1100, '1984-08-01', '8303291319116', '01025672300', 12 );
insert into employee values( emp_sq.nextval, '공부해', 30, '사원', 1303, '1988-11-01', '8410031281312', '01027073174', 4 );
insert into employee values( emp_sq.nextval, '류별나', 20, '과장', 1600, '1989-12-01', '8409181463545', '01071628290', 2 );
insert into employee values( emp_sq.nextval, '류명한', 10, '대리', 1800, '1990-10-01', '8207211661117', '01042072622', 20 );
insert into employee values( emp_sq.nextval, '무궁화', 10, '부장', 3000, '1996-11-01', '8603231183011', '01098110955', 1 );
insert into employee values( emp_sq.nextval, '채시라', 20, '사원', 3400, '1993-10-01', '8001172065410', '01044452437', 3 );
insert into employee values( emp_sq.nextval, '최진실', 10, '사원', 2000, '1991-04-01', '8303101932611', '01027491145', 12 );
insert into employee values( emp_sq.nextval, '김유신', 30, '사원', 4000, '1981-04-01', '7912031009014', '01098218448', 4 );
insert into employee values( emp_sq.nextval, '이성계', 30, '부장', 2803, '1984-05-01', '8102261713921', '0165358075', 1 );
insert into employee values( emp_sq.nextval, '강감찬', 30, '사원', 1003, '1986-07-01', '8203121977315', '01033583130', 4 );
insert into employee values( emp_sq.nextval, '임꺽정', 20, '사원', 2200, '1988-04-01', '8701301040111', '01086253078', 7 );
insert into employee values( emp_sq.nextval, '깨똥이', 10, '과장', 4500, '1990-05-01', '8811232452719', '01090084876', 13 );
```
---
#### employee_mgr_emp_no_fk 라는 이름의 FK 제약조건 키기. 즉 제약 조건 임시 활성화.

alter table employee enable constraint employee_mgr_emp_no_fk;

---
#### 테이블 검색
select * from employee;


---
#### customer 테이블에서 PK값으로 사용할 일련번호를 생성하는 시퀀스 생성하기 (일련 번호 자동 생성기). 특정 테이블에 PK값으로 사용
```
create sequence cus_sq
    start with 1
    increment by 1
    minvalue 1
    maxvalue 999;
```

---
#### employee 테이블 만들기. 고객 정보가 저장되는 테이블이다.
```
create table customer(
    cus_no  number(3)                       --[고객번호]가 저장 되는 컬럼 선언.
    ,cus_name    varchar2(20)               --[고객명]이 저장되는 컬럼 선언 제약조건 비면 안됌.
    ,tel_num varchar2(15)    not null       --[전화번호]가 저장되는 칼럼 선언.
    ,jumin_num   char(13) not null unique   --[주민번호]가 저장되는 컬럼 선언. 제약조건 비면안되고 중복되면 안됌.
    ,emp_no  number(3)                      --[직업명]이 저장되는 컬럼 선언.
    ,primary key(cus_no)                    --[고객번호] 컬럼에 PK 제약조건 주기.
    ,foreign key(emp_no)  references employee(emp_no) --[담당직원번호] 컬럼에 FK 제약조건 주기. employee 테이블에 emp_no 컬럼 참조하게 하기
);
```
---
#### customer 테이블에 행 10개 추가하기
```
insert into customer(cus_no, cus_name, tel_num, jumin_num, emp_no) values(cus_sq.nextval,'류민이','123-1234','7001131537915',3);
insert into customer(cus_no, cus_name, tel_num, jumin_num, emp_no) values(cus_sq.nextval,'이강민','343-1454','6902161627914',2);
insert into customer(cus_no, cus_name, tel_num, jumin_num, emp_no) values(cus_sq.nextval,'이영희','144-1655','7503202636215',null);
insert into customer(cus_no, cus_name, tel_num, jumin_num, emp_no) values(cus_sq.nextval,'김철이','673-1674','7704301234567',4);
insert into customer(cus_no, cus_name, tel_num, jumin_num, emp_no) values(cus_sq.nextval,'박류완','123-1674','7205211123675',3);
insert into customer(cus_no, cus_name, tel_num, jumin_num, emp_no) values(cus_sq.nextval,'서캔디','673-1764','6507252534566',null);
insert into customer(cus_no, cus_name, tel_num, jumin_num, emp_no) values(cus_sq.nextval,'신똘이','176-7677','0006083648614',7);
insert into customer(cus_no, cus_name, tel_num, jumin_num, emp_no) values(cus_sq.nextval,'도쇠돌','673-6774','0008041346574',9);
insert into customer(cus_no, cus_name, tel_num, jumin_num, emp_no) values(cus_sq.nextval,'권홍이','767-1234','7312251234689',13);
insert into customer(cus_no, cus_name, tel_num, jumin_num, emp_no) values(cus_sq.nextval,'김안나','767-1677','7510152432168',4);

select * from customer;
```

---
#### salary_grade 테이블 만들기. 연봉 등급을 관리하는 테이블이다.
```
create table salary_grade(
    sal_grade_no    number(2)   primary key --[연봉등급] 저장 컬럼 선언
    ,min_salary number(5)   not null    --[최소연봉] 저장 컬럼 선언
    ,max_salary number(5)   not null    --[최대연봉] 저장 컬럼 선언
);

insert into salary_grade values(1,8000,10000);
insert into salary_grade values(2,6000,7999);
insert into salary_grade values(3,4000,5999);
insert into salary_grade values(4,2000,3999);
insert into salary_grade values(5,1000,1999);

select * from salary_grade;
```
---
#### 지금까지의 모든 입력, 수정, 삭제 적업을 실체 작업으로 인정하기
```
commit;
```
