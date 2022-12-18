select * from member;



create table board(
	num number(5) primary key,
	pass varchar2(30),   -- �Խù��� ���� ������ ���� ��й�ȣ
	userid varchar2(30),
	email varchar2(30),
	title varchar2(50),
	content varchar2(1000),
	readcount number(4) default 0,   --��ȸ��
	writedate date default sysdate    -- �ۼ�����
);

create sequence board_seq start with 1 increment by 1;


alter table board add replycnt number(3) default 0;

alter table board add imgfilename varchar2(255);

select * from board;



insert into board(num, userid, email, pass, title, content)
values( board_seq.nextVal, 'hong', 'abc@naver.com', '1234', 'ù�湮�Դϴ�', 
	'�ݰ����ϴ�. ������ ���� �ݷ��� ������� ��Ź�帳�ϴ�.' );
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'somi', 'adddnaver.com', '1234', '�Խ��� ����',
	'���ϵ帳�ϴ�.  ������ ������ ����Ҳ���');
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'light', 'bnbn@naver.com', '1234', '��������',
	'���� ������ ���ֽ��ϴ�');
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'hana', 'hana@daum.net', '1234', '2022�� �ܿ�' , 
	'���� �߿ﲨ ���ƿ�... �ٵ� �ǰ� ���� �ϼ���....');
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'hana', 'hana@daum.net', '1234', '�ڷγ����̷���' , 
	'��ȸ�� �Ÿ��αⰡ �������ϴ� .... �ϻ����� ���� ����');
insert into board(num, userid, email, pass, title, content)
values( board_seq.nextVal, 'hong', 'abc@naver.com', '1234', 'ù�湮�Դϴ�', 
	'�ݰ����ϴ�. ������ ���� �ݷ��� ������� ��Ź�帳�ϴ�.' );
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'somi', 'adddnaver.com', '1234', '�Խ��� ����',
	'���ϵ帳�ϴ�.  ������ ������ ����Ҳ���');
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'light', 'bnbn@naver.com', '1234', '��������',
	'���� ������ ���ֽ��ϴ�');
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'hana', 'hana@daum.net', '1234', '2022�� ����' , 
	'���� �߿ﲨ ���ƿ�... �ٵ� �ǰ� ���� �ϼ���....');
	insert into board(num, userid, email, pass, title, content)
values( board_seq.nextVal, 'hong', 'abc@naver.com', '1234', 'ù�湮�Դϴ�', 
	'�ݰ����ϴ�. ������ ���� �ݷ��� ������� ��Ź�帳�ϴ�.' );
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'somi', 'adddnaver.com', '1234', '�Խ��� ����',
	'���ϵ帳�ϴ�.  ������ ������ ����Ҳ���');
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'light', 'bnbn@naver.com', '1234', '��������',
	'���� ������ ���ֽ��ϴ�');
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'hana', 'hana@daum.net', '1234', '2022�� �ܿ�' , 
	'���� �߿ﲨ ���ƿ�... �ٵ� �ǰ� ���� �ϼ���....');
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'hana', 'hana@daum.net', '1234', '�ڷγ����̷���' , 
	'��ȸ�� �Ÿ��αⰡ �������ϴ� .... �ϻ����� ���� ����');
insert into board(num, userid, email, pass, title, content)
values( board_seq.nextVal, 'hong', 'abc@naver.com', '1234', 'ù�湮�Դϴ�', 
	'�ݰ����ϴ�. ������ ���� �ݷ��� ������� ��Ź�帳�ϴ�.' );
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'somi', 'adddnaver.com', '1234', '�Խ��� ����',
	'���ϵ帳�ϴ�.  ������ ������ ����Ҳ���');
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'light', 'bnbn@naver.com', '1234', '��������',
	'���� ������ ���ֽ��ϴ�');
insert into board(num, userid, email, pass, title, content)
values(board_seq.nextVal, 'hana', 'hana@daum.net', '1234', '2022�� ����' , 
	'���� �߿ﲨ ���ƿ�... �ٵ� �ǰ� ���� �ϼ���....');
	
	
	
	
	
select * from board;



create table reply(
	replynum number(7) primary key,    -- ��� ����
	boardnum number(5),                --  ����� �ش� �Խù� ��ȣ
	userid varchar2(20),                   -- �� ����
	writedate date default sysdate, -- �ۼ���
	content varchar2(1000)               -- �ۼ� ����
);

-- ����� board ���̺� ������� �ʽ��ϴ�.  �ѵΰ��� ��۸� �޸��� ������� board ���̺� ��� �ʵ带 �μ��� �����ϰ� 
-- �����ص� ������ �Խ��ǿ� �ִ� ���Խù��鿡 ���� ����� �ۼ��ɼ� �ִ� ������ ������ ���⶧����, 
-- ��� ����� �ϳ��� ���̺� �����մϴ�.
-- �̶� �ݵ�� ����Ǵ� ��ۿ��� ��� �Խù��� ������� �Խù� ��ȣ�� ���� �����ؾ� �մϴ�.
-- �׷��� �ش� �Խù��� ȭ�鿡 ǥ�õɶ� �� �Խù��� ��۸� ��ȸ(�˻�)�ؼ� ���� ȭ�鿡 ǥ���Ҽ� �ֽ��ϴ�.

create sequence reply_seq start with 1 increment by 1;



insert into reply values( reply_seq.nextVal, 1, 'somi', sysdate, '�Խ��� ������ ���ϵ帳�ϴ�');
insert into reply values( reply_seq.nextVal, 2, 'light', sysdate, 'ù�Խñ� �ۼ� �����մϴ�');
insert into reply values( reply_seq.nextVal, 3, 'scott', sysdate, '���ְ� ���Դϴ�');



select * from board order by num desc;

select rownum, * from board order by num desc; -- ����

select  rownum,  b.* from (select * from board order by num desc ) b;


select  rownum,  b.* 
from ((select * from board order by num desc ) b) 
where rownum>=21 and rownum<=30;

select * from (
	select * from (
		select rownum as rn, b.* from ((select * from board order by num desc ) b) 
	) where rn >=11
) where rn<=20;











