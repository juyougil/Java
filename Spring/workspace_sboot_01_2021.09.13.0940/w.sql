create table login(
    login_no    number(3)                        --���� 0~999 ���� ����
    ,login_id    varchar2(20) not null unique    --�α��� ���̵� ����
    ,pwd        varchar2(20) not null            --������ ��ȣ ����
    ,primary key(login_no)
);

insert into login values(1,'abc','123');
insert into login values(2,'xyz','123');
insert into login values(3,'tom','123');


select * from login;