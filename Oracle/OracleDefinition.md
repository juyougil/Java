## <1> 데이터베이스

- [[검색]]이 용이하도록 일정한 기준에 맞추어 자료를 분류하여 정리해 놓은 [자료의 집합]을 말한다.

- 데이터베이스 조건(입사.기사)
  - 실시간 접근성, 지속적인 변화(=최신의 정보가 정확하게 저장), 동시 공유 등
## <2> RDBMS (Relational Database Management System,관계형 데이터베이스 관리 시스템) 란? (입)
- 데이터가 [컬럼(column=열)]과 [로우(Row)=행]로 이루어진 [테이블]에 저장되며, 
[테이블]사이에 관계를 설정하여 관리하는 SW 또는 시스템을 말한다.

- ### RDBMS 제품의 종류
  -	Oracle 사의 Oracle => 대기업용, 현재 대기업 공기업 프로젝트에서 제일 많이 사용하고 있음.
  - MS 사의 MS-SQL	=> 대기업용
  - Sun Microsystems  사의 MYSQL => 중소기업용
  - Sybase
  - DB2 등

## 테이블 구조

customer||||
---------|-------|-----|---------|
고객번호 | 고객명 | 주소 | 전화번호 |   
1 | 저팔계 | 서울 | 02-1234-1234 |
2 | 사오정 | 부산 | 02-2345-2345 |
3 | 손오공 | 제주 | 02-3456-3456 |
- 행 단위로 데이터를 삽입한다.

## <3> SQL(Structured Query Language)이란?

- RDBMS에 접근해서 데이터의 [입력] ,[수정] ,[삭제], [검색] 하는 등의 기능을 가진 RDBMS 관리 언어 이다.
  - <참고> DB, 즉 오라클을 배운다라는 말은 SQL언어를 배우는 것과 동일하다.

- ### 특징
  - [절차적 언어]가 아닌 [구조적 언어]이다.(입)
	- <참고>절차적(procedural) 언어
	    : 모든 처리 과정을 일일이 기술하고 기술된 순서대로 로직이 처리되는 언어. (C, Java 등)
	- <참고>구조적(structured) 언어
	    : 처리 과정을 일일이 기술할 필요 없이 일정한 틀이나 패턴이 있어 맞게 조건들만 나열하만 로직이 처리되는 언어.

- ### SQL 종류(기,입)
  - #### DDL(Data Definition Language = 데이터 정의 언어) 롤백 대상이 아님
	- 객체를 생성, 수정, 삭제 등의 작업을 한다.
	    - CREATE => 객체 생성
	    - ALTER => 객체 수정 <조심>update가 아니다. 시험문제에 자주 등장
	    - DROP => 객체 삭제
	    - 기타 등등
  - <주의>오라클에서 객체란 이름을가지고 저장되는 놈들을 객체라 부른다. 자바의 객체와 다르다.
  - <참고>오라클에서 객체는 [테이블], [뷰], [트리거], [인덱스], [프로시저], [시퀀스] 등을 말한다.
 
  - #### DML(Data Manipulation Language = 데이터 처리 언어)    데이터는 객체가 아님\
 	- 테이블 안의 데이터를 입력, 수정, 삭제, 검색 등의 작업을 한다. 데이터 입력은 행단위 셀단위 입력은 없음
 		- INSERT => [행 단위]에 데이터 입력
 		- UPDATE => [셀 단위]의 데이터 수정/삭제
 		- DELETE => [행 단위]의 데이터 삭제
 		- SELECT => n행 m열의 데이터 검색. SQL 공부의 90% 차지. DB 실력은 SELECT구사 능력이다.
 		- 기타 등등
  
  - <문제> 셀에 들어있는 데이터를 제거하는 SQL 구문은? 
	UPDATE. 학원 프로잭트에 주도적으로 참여했는지 알 수 있는 질문.
  - <문제> 행 데이터를 제가하는 SQL 구문은?		
	DELETE
  
  - #### DCL(Data Control Language = 데이터 제어 언어)
  	- COMMIT => 트랜잭션 작업 단위에 데이터 입력, 수정, 삭제 작업을 모두 인정. 인정 후 전상태로 복구 불가
  	- ROLLBACK => 트랜잭션 작업 단위에 데이터 입력, 수정, 삭제 작업을 모두 취소. 
  	- GRANT => 접근제어, 작업권한허용
  	- REVOKE => 권한제거
## <4>트랜잭션(Transaction) 이란? (입,기,실)
- 모두 취소되거나 모두 완료되는 2가지 결과로만 진행되는 작업 단위를 말한다.
- 트랜잭션은 주로 입력 수정 삭제 SQL 구문 실행 시 설정한다. 중간에 에러가 났을때 애매해지는것을 방지
- 트랜잭션이 걸린 작업은 가상 잡업이 되고 ROLLBAKC을 실행하면 모두 취소되고 COMMIT를 실행하면 가상작업이 모두 실제로 작업으로 인정된다.
	가상작업이기때문에 COMMIT이나 ROLLBACK을 하지 않으면 적용되지 않음
- 검색은 데이터를 수정 삭제 입력하는게 아니기 때문에 SELECT는 트랜잭션을 걸 수는 있지만 걸 필요없음
- <주의>트랜잭션은 의도를 가지고 설정하는 것이다.
- <주의>트랜잭션이 없는 작업은 N가지 이상의 다양한 결과로 진행 될 수 있다.

## <5> 오라클에서 [계정] 이란 뭡니까?
- 계정은 아이디+권한 오라클에 접속하는 사용자를 말한다
- 사용자 마다 권한을 다르게 줄 수 있다.
- 오라클은 다수의 클라이언트에게 동시에 정보를 제공하는 서버이므로 서버의 특징인 계정과 암호를 가지고 있다.
- <참고>서버(SERVER)?
	- 다수의 클라이언트에게 동시에 정보를 제공하는 H/W 나 S/W 를 말한다.(오라클)
- 오라클 계정의 종류		디폴드 계정 3개 SYS(최대권한) SYSTEM SCOTT
	- SYS		->오라클 설치 시 기본적으로 만들어지는 계정. 모든 것을 할 수 있다. 반지의 제왕!
	- SYSTEM		->오라클 설치 시 기본적으로 만들어지는 계정. 모든 것을 할 수 있다. 단 [데이터베이스] 생성 권한이 없다.
	- SCOTT		->오라클 설치 시 기본적으로 만들어지는 계정. 권한이 거의 없다.
	- 생성 계정		-> 계정 생성 권한을 가진 계정이 만드는 계정으로 계정별 권한이 설정된다.,
			주로 SYS, SYSTEM 계정 또는  SYS, SYSTEM 계정과 동일한 권한을 가진 계정이 만든다.
			
## <6> 데이터베이스 차원에서 스키마 (Schema)란 뭡니까? (입,기,실) <스펠링 주의> 대형 솔루션 회사 시험 타겟!
- [데이터 베이스의 구조]에 대한 정의와 제약조건 등을 기술한 [명세서]를 말한다. (나이에 음수x같은 제약조건)
- [계정]이 생성한 모든 [객체]들을 의미한다. (오라클 객체 => 테이블, 뷰, 인덱스, 프로시저, 트리거 등)    
	객체들이 DB 구조에 대한 정의와 이에 대한 제약조건 등을 기술한 [명세서]이기 때문이다.
- [kim] 계정이 객체(테이블, 인텍스, 뷰 등) 들을 생성했다면 이 객체들 모두를 가리켜 [kim 스키마]=(kim계정으로 만든 모든 객체)라고 한다.
- 생성되는 객체는 [계정명, 객체명] 형식으로 저장된다. 예 [kim.employee] 동일한 계정에서  객체명 중복 불가능
	- abc 계정으로 로그인해 employee 테이블 생성. abc.employee 형태로 저장
	- kim 계정으로 로그인해 employee 테이블 생성. kim.employee 형태로 저장
	- kim 계정으로 로그인해 employee 테이블 생성. kim.employee 형태로 저장 불가능. 이미 있으니까

## <7> 데이터베이스 차원에서 테이블(table)란 뭡니까?
- RDBMS 에서 데이터가 실질적으로 저장되는 [논리적 장소(S/W적인 장소)]를 말한다.
- [컬럼(column=열)]과 [로우(ROW열=행=record)]로 구성되어 있다.
- 테이블은 이름을가지고 저장되는 객체의 한 종류이다.
- 개발자 입장에서 제일 손이 많이 가는 객체이다.
- 테이블에 데이터를 입력하는 SQL은 INSERT 이다.
- 테이블에 데이터를 수정하는 SQL은 UPDATE 이다.
- 테이블에 데이터를 삭제하는 SQL은 DELETE 이다.
- 테이블에 데이터를 검색하는 SQL은 SELECT 이다.

## <8> 테이블(table)을 생성하는 SQL 구문의 형식은?
- CREATE TABLE 테이블명(    
	컬럼명1	자료형	제약조건    
	,컬럼명2	자료형	제약조건    
	,~    
	,컬럼명n	자료형	제약조건    
);
- 자료형(Data tyep) => 테이블의 컬럼에 입력될 데이터의 유형을 말한다. 문자형, 숫자형, [날짜형] 등이 있다.
- 제약조건 =>입력되는 데이터의 입력 가능 조건을 말한다. 제약조건에 위배되는 데이터는 삽입될 수 없다.    
		   제약조건이 생락되면 데이터가 입력되지 않을 경우 null 이 저장된다.
- <주의>테이블명, 컬럼명 제작 규칙 <가독성 중요 의미있게>
	- 영문자, 1~9 ,$ ,# , _ 로 구성되고 반드시 영문자로 시작해야 한다.
	- 30자를 초과할 수 없다. SQL 예약어는 사용할 수 없다.
	- 하나의 계정이 만든 테이블명은 유일해야하고 하나의 테이블 안에서 컬럼명은 유일해야한다
	- 테이블명, 컬럼명, 제약조건명을 "로 감싸거나 " 없이 그냥 써도된다.
	- 테이블명, 컬렴명은 가독성 있게 주는 것이 제일 중요하다.		   
## <9> 오라클에서 자료형의 종류

- ### 문자형
	- CHAR(s)  [단점]=(데이터의 고정길이(고객의 요구사항)가 변할 가능성이 있어 잘 사용하지 않음) 데이터(고객의 요구사항) 변화에 취약함
		- [고정길이] 문자열 저장. s는 byte 수를 의미
		- 설정 크기보다 입력 문자 크기가 작으면 [공백]으로 남는다.
		- 설정 크기보다 입력 문자 크기가 크면 행 자체가 입력되지 않는다.
		- <예>CHAR(4) => 문자 4byte 까지 입력 가능. 즉 영문은 4개까지, 한글 2개 까지 가능    
		 <참고>영문 1자는 1byte 차지, 한글 1자는 2byte 차지.
		- 최대크기는 2000Byte 이다.
		- CHAR는 CHAR(1)과 동일

	- VARCHAR2(s)  단점(성능 부하가 커짐)
		- 가변길이 문자열 저장. s 는 byte 수를 의미.
		- 설정 크기보다 입력 문자 크기가 작으면 크기가 자동으로 줄어든다. (DB 서버  부담은 증가)
		- 설정 크기보다 입력 문자 크기가 크면 행 자체가 입력되지 않는다.
		- <예>BARCHAR2(4) => 문자 4byte 까지 입력가능. 즉 영문4개까지, 한글 2개까지 가능
		- 보통 테이블을 설계할 때는 CHAR타입보다는 VARCHAR2 타입을 많이 사용한다.    
		  임의의 컬럼의 입력값 길이를 정확하게 예측하더라도 나중에 변경될 가능성이 많기 때문이다.
		- 최대크기는 4000Byte 이다.
		- VARCHAR2 만 쓸 수는 없다.

- ### 숫자형 (사칙연산 및 증감을 하지 않는 숫자는 문자표현)
	- NUMBER(p,s)
		- 정수형 또는 실수형 숫자 저장.
		- p(precision) => 전체 자릿수(1~38). s(scale) => 소수점이하 자릿수(-84~127)
		- s 생략 시 디폴트 0 설정.
		- NUMBER 는 p(precision), s(scale) 모두 생략 시 정수, 소수점이하 자릿수 합쳐 40자리 까지 저장.
		- 소수점 자리수가 넘치면 반올림하고 정수 자리수가 넘치면 오류가 난다. 즉 행 입력이 안된다.
		- <예> NUMBER(6, 2) 라고 저장한 컬럼에 1234.56 저장 하면?    
		 1234.56 저장. 6자리 중에 소수점 2자리 즉 6-2=4 즉 정수 부분은 4자리
		- <예> NUMBER(6, 2) 라고 저장한 컬럼에 1234.567 저장 하면?    
		 1234.57 저장. [반올림] 한 후 소수점 2자리 까지 저장.
		- <예> NUMBER(6, 2) 라고 저장한 컬럼에 12345.6 저장 하면?    
		 저장 오류. 정수 자릿수 부족으로 오류 (제약조건 위반으로 행단위 데이터 입력이 안된 경우)
			
- ### 날짜형
	- DATE
		- [년, 원, 일, 시, 분, 초] 저장.
		- 저장 범위는 BC 4712년 1월 1일~9999년 12월 31일.
		- <참고>보통 날짜형 데이터는 SQL 문장에서 [TO_CHAR, TO DATE 변환함수]와 같이 사용된다.     to_data날짜끼리 계산. to_char 정렬 출력
		- <참고>2021월 06월11일 부터 ▶2021년12월25일 까지 남은 일수 검색하는 SQL 구문 작성    
		select to_date('202111225', 'YYYYMMDD')-to_date('20210611', 'YYYYMMDD') from dual
		- 오늘 날짜를 예쁘게 연-월-일 로 검색하는 SQL 구문 작성    
		select to_char(sysdate, 'YYYY-MM-DD') from dual
		- <참고>변환함수는 [TO_CHAR], [TO_DATE], [TO_NUMBER], 와 같이 사용된다.
	- <참고> 기타 문자형에는 CLOB, LONG, NCHAR(s), NVARCHAR2(s), NCLOB 등이 있다.
	- <참고> 기타 숫자형에는 BINARY_FLOAT, BINARY_DOUBLE 도 있다.
	- <참고> 기타 날짜형에는 TIMESTAMP(f), TIMESTAMP(f) WITH TIME ZONE, TIMESTAMP(f) LOCAL WITH TIME ZONE 도 있다.

## <10> 오라클에서 제약조건의 종류 (입,기,실)

- ### not null
	- 반드시 데이터가 입력돼야 한다. 비어있으면 안됨
- ### unique
	- 중복되는 데이터는 입력 불가능하다.
	- <예>주민번호, 전화번호, 직원번호 등등
	- 일발적으로 unique 을 가진 컬럼은 not null 도 같이 들어간다. 그 반대는 예외다.
	- null 값은 예외적으로 여러 개 입력 가능하다.
- ### default
	- 데이터를 입력하지 않으면 디폴트로 설정한 값이 입력된다.
	- <예>회원가입할 때 가입날짜를 입력하지 않아도 그 당일날짜가 저장되는 경우
	- not null을 사용한 효과가 있음
	- 자료형과 자료형의 크기에 맞춰 디폴트 값을 설정해야 한다.
- ### check
	- 지정한 데이터만 입력 가능하다.
	- <예>성별 입력 시 남 또는 여 만 입력되는 경우
- ### primary key
	- not null, unique의 제약 조건 성질을 가진다. 즉 [행과 행을 구분](예: 사원번호)할 수 있는 요일한 데이터가 입력된다.
	- 차후에 foreign key에 의해 참조 당할수 있는 키다.
	- 하나의 테이블에 하나의 primary key만 설정할 수 있다. 즉 테이블당 0~1개만 줄 수 있다.
	- 참조 당하고 있는 primary key는 삭제가 불가능하다 <- 시험문제!!!!!!!!
	- primary key행을 지우고 싶다면 참조하고 있는 foreign key행은 삭제해야한다.
	- [기본키],[주키] 라고도 한다.
- ### foreign key
	- primary key에 존재하는 데이터만 삽입되 수 있다. (=primary key를 참조하는 키다.)
	- 하나에 테이블에 0개 이상의 foreign key를 설정할 수 있다.
	- <주의>예외적으로 null 값은 입력 가능하다. 즉 데이터가 입력되지 않을 수 도 있다.
	- table과 table간의 관계를 설정하는 키다. fk가 있으면 반드시 pk가 있기 때문이다.
	- [참조키], [외래키], [관계키], [종속키] 라고도 한다.
	- primary key에 존재하는 데이터만 삽입 될 수 있기 때문에 일관성과 정확성을 지킬 수 있다.    
- employee테이블 e_no의 제약조건을 primary key(pk)를 사용하고 customer테이블에 e_no에 제약조건 foreign key(fk)를 사용해 employee테이블에 e_no을     customer테이블에 e_no에  참조해온다. (릴레이션)    
이렇게 할 경우 primary key(pk)에 존재하는 데이터만 foreign key(fk)에 삽입되기 때문에 없는 사원번호를 삽입할 일이 없어진다.(에러 방지)

### <문제>
### 1. FK 가 있으면 반드시 PK 가 있다.    
(o) fk는 pk를 참조하기 때문
### 2. unique 가 걸린 컬럼에는 반드시 not null 이 걸린다.    
(x) 거의 그렇지만 반드시는 아니기 때문에 x
### 3. 자료형도 데이터를 걸러내는데 사용된다.    
(o) 자료형을 설정하면 그 자료형만 입력가능하기 때문에 데이터를 걸러내는 기능이 있다.
### 4. not null 이 걸린 컬럼에는 반드시  unique 가 걸린다.    
(x)
### 5. 셀을 삭제하는 명령어는 update 이다.    
(o)
### 6. 행 삭제는 alter 구문이다.    
(x) 행삭제는 딜리트 알터는 객체를 수정 할때 씀
### 7. 행 수정은 update 구문이다.    
(x) 셀단위로 모든 셀을 수정해 행을 수정할 수는 있지만 행자체를 수정할 수는 없다.
### 8. create 로 만든 테이블은 rollback 으로 없앨수 있다.    
(x)
### 9. select 도 트랜잭션을 걸수 있다.    
(o) 걸 수 있다 의미가 없을뿐
### 10. default 가 걸리면 대부분 not null 이다.    
(o) default를 설정해주면 그 값이 들어가기 때문에 not null이다.
### 11. 제약조건을 위배하면 셀에만 데이터가 입력 안된다.    
(x) 제약조건을 위배하면 행 자체가 입력 안됨.    

## <11> 시퀀스(sequence)란? (입50%)							

- [고유 일련 번호]를 생성해서 제공하는 객체이다. 일종의 [일련 번호 생성기] 이다.
- 주로 하나의 테이블에서 PRIMARY KEY 로 지정된 컬럼명에 입력될 [일련 번호] 값을 생성한다.
- ### 단점
	- 입력중에 에러가 나서 행이 들어가지 못해도 번호는 카운트가 되기 때문에 번호가 꼬이는 상황이 발생
		그래서 서브쿼리를 씀
- ### 시퀀스 생성 SQL 구문
	
	create sequence  시퀀스명    
		start with  시작값    
		increment by  증가값    
		minvalue 최소값    
		macvalue 최대값;
- 증가된 새 일련번호 얻는 SQL 구문
	- 시퀀스명.nextval
- 마지막으로 이미 뽑혔던 일련번호 얻는 SQL 구문
	- 시퀀스명.currval
- 시퀀스 삭제 SQL 구문
	- drop sequence 시퀀스명;

## <12> 오라클을 연습하려면 어떤 SW를 설치해야 합니까?
1. 개발자 용 오라클 버전(=OracleXE ) 을 설치한다. system 계정의 비밀번호는 123 으로 한다.
2. 오라클 접속 툴의 한 종류인 SQLgate 를 설치한다. 
3. Sqlgate 를 실행하고 아래 사항을 입력한 후 접속을 한다.
	- IP            => localhost
	- 사용자        => system
	- 암호          => 설정암호
	- SID(서비스명) => XE

## <13> system 계정과 동일한 권한을 가지는 새로운 계정을 만드려면?
1. system 계정으로 접속한 후 코딩 창에서 아래 와 같은 명령으로 king 계정을 만들고 암호는 k123 으로 한다.    
	create user king  identified by k123;
2. 아래 와 같은 명령으로 king 계정에 system 계정과 동일한 권한을 부여한다.    
	grant connect,resource,dba to king;
3. Sqlgate에서 king 계정으로 재 접속을 시도한 후 아래 사항을 입력한 후 접속을 한다.
	- IP            => localhost
	- 사용자        => king  
	- 암호          => k123
	- SID(서비스명) => XE
		
## <14> 오라클 4대 함수
- 내장함수	=> 미리 만들어진 단위 프로그램으로 호출하면 특정 작업을 하고 데이터를 무조건 [리턴]한다
- join (조인)		=> 서로 다른 테이블의 컬럼을 횡으로 붙이는 작업
- subquery	(서브쿼리) 	=> SQL 구문안의 select 문
- group by   		=> 통계 관련 작업

## 오라클의 자주 사용되는 숫자함수
- #### abs(n)
	- 숫자 n의 절대값을 반환.

- #### floor(n)
	- 숫자 n이 정수면 그대로 반환하고, 실수면 실수보다 작으면서 
		제일 가까운 정수를 반환
	- 좌표계에서 쿵 찍어서 왼쪽 정수값

- #### ceil(n)
	- 숫자 n이 정수면 그대로 반환하고, 실수면 실수보다 크면서
	  	제일 가까운 정수를 반환
	- 좌표계에서 쿵 찍어서 오른쪽 정수값

- #### round(n,m)
	- n의소수를 m자리 까지 표현 반올림은 m+1자리에서 발생

- #### trunc(n,m)
	- 숫자 n 에서 소수 m+1 자리부터 버림.

- #### sign(n) 
	- n>0 면 1, n<0 면 -1, n=0이면 0을 반환.

- #### mod(n,m)
	- n / m 후 나머지 값을 반환

- #### power(n,m)
	- n의 m 승을 반환.  

## <15> 오라클의 자주 사용되는 문자 함수
- #### chr(n)
	- 정수 n을 ascii(아스키) 문자기호로 리턴한다.
- #### upper(s)
	- 문자열 s을 대문자로 변환시켜 리턴한다.
- #### lower(s)
	- 문자열 s을 소문자로 변환시켜 려턴한다.
- #### length(s)
	- 문자열 s의 길이를 리턴한다.
- #### substr(s, n1, n2)
	- 문자열 s에서 n1 번째 자리부터 n2개 까지의 문자를 리턴한다.
	- n2 생략 시 마지막 까지 문자를 리턴한다.
	- n1 이 0일 경우 1로 바꿔 실행된다.
	- 자리수는 n1>0(양수) 경우 왼쪽부터, n1<0(음수) 경우 오른쪽부터 샘한다.
- #### trim(s)
	- 문자열 s의 맨좌우측의 공백을 제거하여 리턴한다.
		제거 후 또 있으면 계속 제거 후 리턴한다.
	
- #### replace( s1, s2, s3 )
	- 문자열 s1에서 s2를 s3로 수정해서 리턴한다.
	- <예>
	```
	select replace( 'You are not alone', 'You', 'We' ) from dual;
	select replace( 'You are not alone', 'not' ) from dual;      not이 없어짐
	select translate( 'You are not alone', 'You', 'We' ) from dual; 대응되는 문자를 바꿈 y -> w o-> e
	```
- #### initcap( s )
	- 문자열 s에서 각 단어의 첫 문자만 대문자로 변환하고 나머지는
		모두 소문자로 리턴한다.
	```
	select  initcap( 'abc def' ) from dual;
	```
- #### lpad( s1, n, s2 )
	- n 자리 만큼 확보하고 s1을 오른쪽 정렬 후 왼쪽에 생긴 빈 공백에
	  	문자열 s2를 채워 리턴한다.
	```
	select lpad( 'abc', 7, ' ' ) from dual;
	```
- #### rpad( s1, n, s2 )
	- n 자리 만큼 확보하고 s1을 오른쪽 정렬 후 왼쪽에 생긴 빈 공백에
	  	문자열 s2를 채워 리턴한다.
	```
	select lpad( 'abc', 7, ' ' ) from dual;
	```
- #### instr( s1, s2, n1, n2 )
	- ( s1:타겟문자, s2:찾을문자, 에서 n1:검색시작위치, n2:몇번째 )
	- <주의>오라클에서 위치를 따질 때 시작은 0이 아니라 1이다.
	- 문자열 s1 에서 문자열 s2 가 있는 위치 반환. (자바의 indexOf(~) 와 비슷한 기능)
	```
	select
		instr( 'Every Sha-la-la-la Every wo-o-wo-o', 'la' ),
		instr( 'Every Sha-la-la-la Every wo-o-wo-o', 'la', 1),
		instr( 'Every Sha-la-la-la Every wo-o-wo-o', 'la', 1, 2),
		instr( 'Every Sha-la-la-la Every wo-o-wo-o', 'la', 12, 2)
	from dual;
	```
	
## <16> 날짜 함수 (리턴값의 자료형을 조심)
- #### months_between(날짜1,날짜2)
	- 날짜1과 날짜2의 차이를 [개월수]로 리턴
- #### add_months(날짜1,개월수)
	- 날짜1에 개월수 만큼 더한 [날짜]를 리턴
- #### last_day(날짜)
	- 날짜가 속한 달의 마지막 [날짜]를 리턴하기 날짜
- #### next_day(날짜,요일정수)
	- 날짜 기준으로 돌아올 요일의 [날짜]를 리턴
		요일 정수는 1~7(일~토)
- #### 날짜1-날짜2
	- 날짜1과 날짜2의 차이를 [일수]로 리턴하기
- #### 날짜+정수
	- 날짜에다 정수만큼의 일수를 대한 만큼의 날의 날짜를 리턴하기
- #### 날짜-정수
	- 날짜에다 정수만큼의 일수를 뺀 만큼의 날의 날짜를 리턴하기

## <17> 문자패턴검색
- where 컬럼명 like '패턴문자열' => 컬럼명 안의 데이터가 패턴문자열을 갖고 있으면 그 행을 검색하라
	- <예> select * from employee where emp_name like '김%';
		- 김이 첫글자고 두번째는 무엇이 와도 좋고 길이에 제한없는 문자패턴을 골라라
		- 문자패턴 안의 % 는 무엇이 와도 좋고 길이에 제한없음의 의미이다. 
	- <예> select * from employee where emp_name like '%김';
		- 김으로 끝나는 문자패턴을 골라라.
	- <예> select * from employee where emp_name like '%김%';
		- 김이 들어간 문자패턴을 골라라.

## <18> Join이란?
- 2개 이상의 테이블로 부터 컬럼을 복사해서 횡으로 붙이는 작업을 말한다.
- join은 서로다른 테이블의 행을 붙여 유저가 보기 쉽게 만듬
- inner join과 outer join의 조건이 같다면 결과는 같을 수 있다.

### join(조인)의 종류
- #### inner join
	- 조인 조건에  맞는 행만 포함하는 조인. 대부분이 이 조인이다. (=내부조인이라고도 한다)  
	
	사용예시
	```
	select e.emp_no
           	,e.emp_name
        	,d.dep_name
    	from 
		employee e, dept d
        where 
		e.dep_no = d.dep_no;
		
	ANSI Join	
	select
		e.emp_no
		,e.emp_name
		,d.dep_name
	from
		employee e inner join dept d
	on
		e.dep_no=d.dep_no;
	
	```
- #### outer join
	- 조인 조건에 만족하지 못한 행도 출력하는 조인이다.
	
	사용예시
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
	
	ANSI Join
	select
        	c.cus_name  고객명
        	,c.tel_num  고객전화번호
        	,e.emp_name 담당직원명
        	,e.jikup    담당직원직급
    	from
        	customer c left outer join employee e 
	on
		c.emp_no=e.emp_no(+)
	```
- #### self join
	- 1개의 테이블을 2개 이상으로 보고 하는 조인이다.

	사용예시
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
- #### cross join
	- 2개 이상 테이블에서 각각의 행이 모두 연결되는 조인이다. 연결 조건이 생략된다.
		잘 사용되지 않는 조인이다.
### ANSI 조인형식과 오라클 조인 정의
- #### ANSI 조인
	- 모든 DB 업체에서 공용으로 사용되는 조인이다.
- #### 오라클 조인
	- 오라클에서만 사용되는 조인이다.

## <19> union, union all 이란?
- 서로 다른 테이블의 컬럼을 종으로 붙이는 작업을 말한다.
- union는 중복제거, union all 중복허용이다.    

사용예시
```
select emp_name||'직원', phone_num from employee
union 
select cus_name|| '고객', tel_num from customer;
```
### union 규칙
- 컬럼의 개수가 일치해야한다.
- 붙는 컬럼의 자료형이 일치해야한다.

## <20> subquery(서브쿼리)란?
- select, insert, update, delete 구문 안에 들어 있는 또 다른 select 문을 말한다.
- <주의> from 절에 나오는 select는 서브쿼리가 아니라 inline(인라인뷰)라고 부른다.

- #### 서브쿼리 사용 시 주의점
	- select, update, delete 안의 서브쿼리는 꼭 ( ) 로 묶는다.
	- 경우에 따라 조인대신 서브쿼리를 써도 같은 결과를 낼 수 있다. 이때 join 보다 서브쿼리의 부하가 더 많이 걸린다.
- #### 서브쿼리 종류
	- 비상관쿼리(Noncorrelated Suubquery)
		- [서브쿼리]와[외부쿼리]가 연관성이 없다.
		- [서브쿼리] 실행 후의 결과값을 가지고 [외부 쿼리] 실행된다.
		```
		select * from employee where salary >= (select avg(salary) from employee);
		```
	- 상관커리(correlated Subquery) (중요)
		- [서브쿼리]와[외부쿼리]가 연관성이 있다.
		- [서브쿼리]와[외부쿼리]가 서로 통신하면서 쿼리가 진행된다.
		
		사용예시
		```
		select
			e.emp_no
			,e.emp_name
			,e.jikup
		from
			employee e
		where (select count(*) from customer c where e.emp_no =c.emp_no)>=2 		
		```
## <21> GROUP BY란?
- select 절에 있는 컬럼안의 중복 데이터를 [하나로 그룹] 지어 주는 역할을 한다.
- 주로 그룹을 지어 통계를 낼때 사용한다.
- GROUP BY 구문 문법은 간단하나 통계를 내는 과정에서 각종 함수가 때거지로 등장한다.
	그러므로 GROUP BY 구문은 함수와의 싸움이다.    

사용예시
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
## <22> [인라인뷰(INLINE VIWE)]란?
- FROM 절에 나오는 SELECT를 말한다.
- FROM 절에는 [테이블명]이 나온다. 이 자리에 SELECT 나올 경우 SELECT 결과물을 테이블로 생각하면 된다.
- 인라인뷰는 SELECT 결과물을 테이블로 취급하기 때문에 메모리에 부담을 준다.
- 인라인 뷰안에 ROWNUM 컬럼이 있다면 바깥쪽 SELECT 입장에서 안쪽ROWNUM 컬럼은 단순한 일반 컬럼이 된다    

사용예시
```
SELECT * FROM 
	(SELECT ROWNUM RNUM,E.*FROM 
	(SELECT *FROM EMPLOYEE ORDER BY SALARY DESC) E
        WHERE ROWNUM<=10)
WHERE
	RNUM>=1;
```
### 인라인뷰을 사용한 페이징처리
- SELECT의 결과물이 웹브라우저로 출력된다.
- 만약 SELECT 결과물이 100,000 행이면 다 보여줄 경우 웹브라우저 로딩이 걸린다.
- 그러므로 1~10행 또는 1~15행 씩 끊어서 웹브라우저로 출력되야 로딩이 걸리지 않는다.
- 이렇게 SELECT 결과물에서 N행 씩 끊어서 화면에 보여주는 것은 [페이징] 처리라고한다 게시판 만들때 씀    

사용예시
```
SELECT * FROM 
	(SELECT ROWNUM RNUM,E.* FROM 
	원하는 정렬 SELECT문
        WHERE ROWNUM<=마지막행번호)
WHERE
	RNUM>=시작행번호;
```
## <24> VIEW(뷰) 특징
- 객체로써 저장된다. 즉 이름을 가지고 저장된다.
- 뷰도 테이블이므로 SELECT 대상이 된다.
- 뷰의 근원이 되는 실존 테이블의 데이터가 변경된 후 뷰가 실행되면 뷰에 그대로 반영된다.(=실존 테이블과 VIEW는 항상 동기화 된다.)
- 뷰를 가지고 또 다른 뷰를 만들 수 있다.
### VIEW(뷰) 를 사용하는 목적
#### 1. #### 보안성 때문이다
	- 보여주고 싶지 않은 컬럼을 제외하고 뷰를 만들어 안보이게 만들 수 있다.
#### 2. join 등과 같은 길고 복잡한 select 문장을 뷰로 만들어 테이블처럼 사용되어 [편의성]을 제공한다.
### EMPLOYEE_VW1를 생성
```
create view employee_vw1 as
select 
	emp_no,emp_name,dep_no,jikup,hire_date,jumin_num,phone_num,mgr_emp_no
from
	employee
```
## 뷰를 만드는 SQL문법
### CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW 뷰이름 AS SELECT문장 [WITH READ ONLY] [WITH CHECK OPTION];
- #### OR REPLACE
	- 동일한 뷰가 있으면 덮어쓴다. 즉 기존의 뷰가 갱신된다. 미사용 시 뷰 생성 불가능
- #### FORCE
	- 존재하지 않는 테이블로부터 뷰를 만들 경우라도 뷰를 만든다.
	- FORCE에 의해 생성된 뷰를 SELECT로 검색하면 에러가 발생한다 즉 이름만 존재하고 검색이 불가능한 뷰가 된다.
	- 뷰 생성 시 거론한 존재하지 않는 테이블을 나중에 만들고 나면 뷰도 SELECT로 검색이 가능하다.
- #### NOFORCE
	- 존재하지 않는 테이블에서 뷰를 만들 경우 뷰를 만들지 못한다.
	- FORCE, NOFORCE 모두 생략 시 NOFORCE 설정과 같다.
- #### WITH READ ONLY
	- 뷰에 대해 입력, 수정, 삭제 작업이 불가능하다.
	- 생략 시 특정 조건하에 하나의 테이블에서 만들어진 뷰에 대해서는 입력, 수정, 삭제 작업을 할 수 있고
		실존 테이블에 입력, 수정, 삭제가 된다.
- #### WITH CHECK OPTION
	- 뷰의 WHERE 구문 조건에 위배되는 방향으로 INSERT, UPDATE 작업은 불가능하다.
	- <예>뷰에 WHERE SALARY>=6000 이 있을 경우 SALARY>=6000 조건에 위배되는 방향으로 입력, 수정이 불가능하다.
		예를 들어 SALARY >=6000 조건이 해당하는 행의 SALARY를 6000 미만으로 입력, 수정하는 행위는 불가능하다.
- #### 생성한 뷰의 정보 검색 방법
	- SELECT VIEW_NAME, TEXT FROM USER_VIEW;
- #### SELECT 문에서 실존 테이블에 존재하지 않는 컬럼은 반드시 별칭을 써야한다.

## <25> 테이블 복제 하는 방법
- create table employee2 as select * from employee;
	- 위 SQL 구문은 select 결과물을 실존 테이블로 만드는 SQL 구문이다.
	- 위 SQL 구문으로 테이블 복사하면 데이터, 자료형, 자료형크기, not null 제약 조건만 그대로 복사된다.
	- <주의> not null 제약 조건 이외의 제약 조건은 따라오지 않는다.
### 데이터를 제외하고 복제
- create table employee3 as select * from employee where 1=2;
	- where 조건절에 계속 false가 되는 조건을 걸면 컬럼명, 자료형, 자료형크기, not null 제약조건만 그대로 복사되고
		데이터는 복사되지 않는다.
#### <예> 부서별, 직급별로 [부서번호], [부서명], [직급], [평균연봉]을 출력하는 employee_vw3를 생성
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
