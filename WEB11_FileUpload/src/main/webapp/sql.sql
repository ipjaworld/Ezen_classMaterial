create table bookproduct(
	code number(5) primary key,
	name varchar2(100),
	price number(8),
	description varchar2(1000),
	pictureurl varchar2(50)  -- ���ε�� ������ �̸�
);

create sequence bookproduct_seq start with 1 increment by 1;

insert into bookproduct 
values(bookproduct_seq.nextval, 'JQuery and JQuery mobile : �����ϱ� ���� Ǯ�',
25000, '�ҽ��ϳ��� ����ũž�� ����ϱ��� HTML5�� �Բ� ���...', 'jquery.jpg');

insert into bookproduct 
values(bookproduct_seq.nextval, '�ڹ��� ��',
30000, '�ڹ����α׷����� ����, ���ʺ��� �ǹ� ��������...', 'java.gif');

select * from bookproduct;

commit