--DDL(Data Definition Language)데이터 정의어
select * from BOOKLIST;
--테이블의 생성(Create)

--Create Table 테이블 이름(
--      필드명1 DATATYPE [DEFAULT값 or 제약조건 및 형식],
--      필드명2 DATATYPE [DEFAULT값 or 제약조건 및 형식],
--      필드명3 DATATYPE [DEFAULT값 or 제약조건 및 형식],
--      ...
--      필드명 DATATYPE [DEFAULT값 or 제약조건 및 형식]
--);

--Create Table 명령의 세부 규칙
--테이블의 이름은 객체를 의미할 수 있는 적잘한 이름을 사용함(자바 변수 이름 규칙과 거의 동일)
--다른 테이블과 중복되지 않게 테이블 이름을 지정함
--한 테이블 내에서 필드이름도 중복되지 않게 함
--각 필드들은 ","로 구분하여 생성함
--create를 비롯한 모든 sql명령은 ";"로 끝남-  단독실행에서는 생략이 가능합니다
--필드명 뒤에 DATATYPE은 반드시 지정하고 []안에 내용은 해당내용이 있을 때 작성하며 생략 가능
--테이블 명과 필드명은 반드시 문자로 시작해야 하고 예약어 명령어 등을 테이블명과 필드명으로 쓸수 없음
--테이블 생성시 대/소문자 구분은 하지 않음(기본적으로 테이블이나 컬럼명은 대문자로 만들어짐)
--DATE 데이터형식은 별도로 크기를 지정하지 않음
--문자데이터의 DataType->varchar2(10),  숫자데이터의 DataType -> number(4)
--문자 데이터 유형은 반드시 가질 수 있는 최대 길이를 표시해야 함
--컬럼과 컬럼의 구분은 콤마로 하되, 마지막 컬럼은 콤마를 찍지 않음


--도서대여점의 도서목록 테이블의 생성
-- 테이블명 : BookList
--필드:booknum, subject, makeyear, inprice, outprice,
--자료형:booknum(문자5자리), subject(문자30), makeyear(숫자4), inprice(숫자6), outprice(숫자4)
--제약조건: booknum(Not null), subject(Not null)
-- 기본키 : booknum

create table booklist(
	booknum varchar2(5) not null ,   --  not null 필드에 입력되는 값이 null 일 수 업는 제약조건
	subject varchar2(30) not null,
	makeyear number(4) ,
	inprice number(6) ,
	outprice number(4),    -- 필드명 옆에 현재 필드에만 적용하는 제약조건을 필드수준의 제약조건이라고 합니다
	
	-- 여기부터 테이블 수준의 제약조건입니다. 테이블 수준의 제약 조건은 이와 같이 필드 정의를 모두 끝내고, 그 아래에 테이블
	-- 전체를 대상으로 하는 제약조건들을 기술합니다
	constraint bl_pk primary key( booknum )
	-- constraint : 테이블 수준의 제약조건을 지정하는 키워드
	-- bl_pk : 테이블 외부에서 현재 제약조건을 컨트롤 하기 위한 제약조건의 이름
	-- primary key( booknum ) : 기본키로 booknum 을 지정하겠다는 뜻입니다
);

create table booklist(
	booknum varchar2(5) not null ,   --  not null 필드에 입력되는 값이 null 일 수 업는 제약조건
	subject varchar2(30) not null,
	makeyear number(4) ,
	inprice number(6) ,
	outprice number(4),
	constraint bl_pk primary key( booknum )
);

drop table booklist;

select * from booklist;


-- 제약조건 (CONSTRAINT)
-- PRIMARY KEY
--    - 테이블에 저장된 레코드를 고유하게 식별하기 위한 키, 하나의 테이블에 하나의 기본키만 정의 할 수 
--      있습니다
--    - 여러 필드가 조합된 기본키 생성 가능합니다
--    - 기본키는 중복된 값을 갖을 수 없으며 빈칸도 있을 수 없습니다
--    - PRIMARY KEY = UNIQUE KEY + NOT NULL
--  UNIQUE KEY
--    - 테이블에 저장된 행 데이터를 고유하게 식별하기 위한 고유키를 정의 합니다
--    - 단 NULL 은 고유키 제약의 대상의 아니므로, NULL값을 가진 행이 여러개가 UNIQUE KEY 
--      제약에   위반하지는 않습니다
--  NOT NULL
--    - 비어있는 상태, 아무것도 없는 상태를 허용하지 않습니다   - 입력 필수
--  CHECK
--    - 입력할 수 있는 값의 범위를 제한한다. CHECK 제약으로는 TRUE or FALSE로   평가할 수 있는
--      논리식을  지정합니다
--   FOREIGN KEY 
--     - 관계형 데이터 베이스에서 테이블간에 관계를 정의하기 위해 기본키를  다른 테이블의  외래키로 
--       복사하는 경우 외래키가 생성됩니다    - 참조 무결성 제약 옵션이 생성







-- 테이블 생성 2
-- 테이블 이름 : MemberList(회원리스트)
-- 필드 : memberNum, memberName,   Phone,    Birth, Bpoint
-- 데이터 형식 :  memberNum :  VARCHAR2(5),    memberName : VARCHAR2(12), 
--                   Phone : VARCHAR2(13),     Birth : DATE,    Bpoint :  NUMBER(6)
-- 제약 조건 : memberNum,    memberName,    Phone 세개의 필드 Not Null  - 필드레벨로 설정
--                  memberNum : Primary Key  -  테이블 레벨로 설정

create table memberlist(
	memberNum varchar2(5) not null,
	memberName varchar2(12) not null,
	phone varchar2(13) not null,
	birth date,
	bpoint number(6) default 0,   -- 필드 기본값 
	joindate date default sysdate,   -- sysdate : 오늘날짜를 표시하는 오라클의 키워드
	constraint mb_pk primary key(memberNum)		
);
drop table memberlist purge;
select * from memberlist;




-- 테이블 생성 3
-- 테이블 이름 : rentlist
-- 필드 :  rent_date(date) , indexk(NUMBER(3)), booknum(VARCHAR2(5)),
--            membernum(VARCHAR2(5)), discount(NUMBER(4))
-- 제약조건 : booknum, membernum : not null
-- 기본값 : rent_date - 오늘 날짜

create table rentlist(
	rent_date date default sysdate,    -- 대여날짜
	indexk number(3) not null ,          -- 대여순번 : 1부터 시작해서 늘어나는 숫자이고 하루가 지나면 reset
	booknum varchar2(5) not null ,     -- 대여해간 도서번호
	membernum varchar2(5) not null , -- 대여한 회원의 회원번호
	discount number(4) ,  -- 할인금액
	constraint rt_pk primary key(rent_date, indexk ) ,
	constraint fk1 foreign key( booknum ) references booklist(booknum),
	constraint fk2 foreign key( membernum )  references memberlist(membernum)
);
-- rent_date  와 indexk 를 조합하여 기본키(rt_pk)를 생성합니다. 두개의 필드가 조합되어 기본키로 지정될
--       수 있습니다.   이를 슈퍼키라고 합니다.
--  rentlist 테이블의 booknum 은 booklist 테이블의 booknum 을 참조하는 외래키로 지정(제약조건이름 fk1)
--  rentlist 테이블의 membernum 은 memebrlist 테이블의 membernum 을 참조하는 외래키로 지정
--  (제약조건이름 fk2)


drop table rentlist purge;
select * from rentlist;


commit

















