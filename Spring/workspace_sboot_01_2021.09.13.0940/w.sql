create table login(
    login_no    number(3)                        --점수 0~999 저장 가능
    ,login_id    varchar2(20) not null unique    --로그인 아이디 저장
    ,pwd        varchar2(20) not null            --르그인 암호 저장
    ,primary key(login_no)
);

insert into login values(1,'abc','123');
insert into login values(2,'xyz','123');
insert into login values(3,'tom','123');


select * from login;