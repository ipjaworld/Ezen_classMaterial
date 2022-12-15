create table bookproduct(
	code number(5) primary key,
	name varchar2(100),
	price number(8),
	description varchar2(1000),
	pictureurl varchar2(50)  -- 업로드된 파일의 이름
);

create sequence bookproduct_seq start with 1 increment by 1;

insert into bookproduct 
values(bookproduct_seq.nextval, 'JQuery and JQuery mobile : 이해하기 쉼게 풀어쓴',
25000, '소스하나로 데스크탑과 모바일까지 HTML5와 함께 사용...', 'jquery.jpg');

insert into bookproduct 
values(bookproduct_seq.nextval, '자바의 신',
30000, '자바프로그래밍의 정석, 기초부터 실무 에제까지...', 'java.gif');

select * from bookproduct;

commit