-- 03_DML_Insert.sql
select * from scott.booklist;
-- 세개의 테이블에 각 필드의 자료형과 제약사항에 맞게 각 10개의 레코드를 insert 하세요
insert into scott.booklist( subject, makeyear, inprice, rentprice, grade)
values('좀비아이', 2020, 12000, 2500, 'all');
insert into scott.booklist( subject, makeyear, inprice, rentprice, grade)
values('피를 마시는 새', 1997, 17000, 1200, '13');
insert into scott.booklist( subject, makeyear, inprice, rentprice, grade)
values('눈물을 마시는 새', 1999, 17500, 1500, '13');
insert into scott.booklist( subject, makeyear, inprice, rentprice, grade)
values('하얀 늑대들', 1996, 16000, 1400, '13');
insert into scott.booklist( subject, makeyear, inprice, rentprice, grade)
values('그리스 로마 신화', 2002, 12000, 1000, 'all');
insert into scott.booklist( subject, makeyear, inprice, rentprice, grade)
values('그래도 계속 가라', 2008, 16000, 2000, '13');
insert into scott.booklist( subject, makeyear, inprice, rentprice, grade)
values('웹페이지 무작정 따라하기', 1997, 20000, 2000, 'all');
insert into scott.booklist( subject, makeyear, inprice, rentprice, grade)
values('해리포터와 불사조 기사단', 2005, 18000, 1700, '13');
insert into scott.booklist( subject, makeyear, inprice, rentprice, grade)
values('반지의 제왕', 1995, 19000, 2000, '18');
insert into scott.booklist( subject, makeyear, inprice, rentprice, grade)
values('원고지 위의 마왕', 2008, 1100, 600, '13');

ALTER TABLE `scott`.`memberlist`
ADD COLUMN `phone` VARCHAR(45) NULL AFTER `joindate`;


insert into scott.memberlist( name, phone, birth, bpoint, age, gender)
values('박지성', '010-1111-2222', '1981/04/04', 350, 31, 'F');
insert into scott.memberlist( name, phone, birth, bpoint, age, gender)
values('구자철', '010-2121-2323', '1982/05/05', 230, 29, 'M');
insert into scott.memberlist( name, phone, birth, bpoint, age, gender)
values('이운재', '010-3121-4252', '1983/06/06', 200, 45, 'F');
insert into scott.memberlist( name, phone, birth, bpoint, age, gender)
values('임요환', '010-7211-2892', '1987/07/07', 300, 42, 'M');
insert into scott.memberlist( name, phone, birth, bpoint, age, gender)
values('홍진호', '020-2222-2222', '1989/02/02', 220, 22, 'F');
insert into scott.memberlist( name, phone, birth, bpoint, age, gender)
values('염보성', '010-9011-8222', '1991/08/08', 250, 29, 'M');
insert into scott.memberlist( name, phone, birth, bpoint, age, gender)
values('박성준', '010-1318-7202', '1993/09/09', 110, 35, 'F');
insert into scott.memberlist( name, phone, birth, bpoint, age, gender)
values('강민', '010-1151-5226', '1996/10/10', 440, 38, 'M');
insert into scott.memberlist( name, phone, birth, bpoint, age, gender)
values('기욤', '010-9999-2222', '1998/11/11', 170, 41, 'F');





insert into scott.rentlist( booknum, membernum, discount) values(1, 1, 100);
insert into scott.rentlist( booknum, membernum, discount) values(2, 3, 200);
insert into scott.rentlist( booknum, membernum, discount) values(3, 9, 250);
insert into scott.rentlist( booknum, membernum, discount) values(4, 8, 300);
insert into scott.rentlist( booknum, membernum, discount) values(5, 4, 350);
insert into scott.rentlist( booknum, membernum, discount) values(6, 7, 500);
insert into scott.rentlist( booknum, membernum, discount) values(7, 5, 120);
insert into scott.rentlist( booknum, membernum, discount) values(2, 2, 220);
insert into scott.rentlist( booknum, membernum, discount) values(8, 6, 270);
insert into scott.rentlist( booknum, membernum, discount) values(9, 2, 320);


commit

