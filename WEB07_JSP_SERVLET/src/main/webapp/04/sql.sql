CREATE TABLE MEM(
	ID VARCHAR2(10),
	NAME VARCHAR2(15),
	PWD VARCHAR2(20),
	PHONE VARCHAR2(15)
);

INSERT INTO MEM VALUES('SOMI', '이소미', '1234', '010-1234-1234');
INSERT INTO MEM VALUES('SANG', '전상오', '1234', '010-5555-6666');
INSERT INTO MEM VALUES('LIGHT', '김빛나', '1234', '010-2222-3333');

select * from mem;

alter table mem add constraint pk_mem primary key(id);