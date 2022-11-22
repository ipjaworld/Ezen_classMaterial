-- 11_JOIN.sql


-- 데이터베이스의 특징 :  특징이기도 하지만 반드시 지켜져야할 규칙이기도 합니다.
-- 1. 계속적인 변화 : 데이터의 삽입(insert), 갱신(update), 삭제(delete) 작업을 통해  항상 최신의 데이터를 유지합니다.
-- 2. 실시간 접근 : 쿼리(Query-질의어:사용자가 사용하여 요청하는 sql 문)에 대해 실시간 처리 응답을 할수 있습니다(있어야합니다)
-- 3. 동시접근 , 동시공유 : 컴퓨터가 접근할 수 있는 저장매체에 저장되어 둘이상의 사용자나 응용프로그램이 언제든지 동시에 이용할 수 있습니다.
-- 4. 내용에의한 참조 : 데이터의 물리적 주소가 아닌 내용, 즉 데이터의 값에 의한 참조를 할 수 있습니다.
-- 5. 데이터 중복의 최소화 : 동일한 자료는 중복되어 저장되지 않게 합니다.



-- JOIN
-- ; 두개이상의 테이블에 나눠져 있는 관련 데이터들을 하나의 테이블로 모아서 조회하고자 할때 사용하는 명령입니다.


--[1] 이름 Douglas Grant 이 근무하는 부서명을 출력하고자 한다면...(대상 테이블 employees, departments )

-- 이 명령을 실행후 얻어진 부서번호로 아래와 같이 부서번호 검색하여 부서명과 지역명을 알아냅니다
select department_id from employees where emp_name = 'Douglas Grant';
select department_name from departments where department_id=50;

select * from departments;
select * from employees;

-- 위의 두개의 명령을 하나의 명형으로 합해주는 역할을 join 명령이 실행합니다

--[2] join : 두개이상의 테이블에 나뉘어 져 있는 데이터를 한번의 sql문으로 원하는 결과를 얻습니다

--cross join : 두개 이상의 테이블이 조인될때 where절에 의해 공통되는 컬럼에 의한 결합이 발생하지 않는 경우 
-- 외래키로 연결되어 있지 않은 두개의 테이블을  where 절 없이  조인할때가 최악의 결과가 나타납니다.
-- * 가장 최악의 결과를 얻는 조인 방식
-- A 테이블과   B 테이블의 cross join 된다면
-- A테이블의 1번 레코드와 B테이블의 모든 레코드와 하나하나 모두 조합
-- A테이블의 2번 레코드와 B테이블의 모든 레코드와 하나하나 모두  조합
-- A테이블의 3번 레코드와 B테이블의 모든 레코드와 하나하나 모두  조합
-- ....

-- A테이블의 필드가 B,C,D 가 있고, B테이블에 E. F. G 가 있다면
-- 크로스조인으로 합쳐진 테이블의 필드는 B,C,D,E,F,G 가 됩니다.

-- A테이블에 B C D의 필드값이 1, 2, 3 이 있고(레코드 한개 존재) 
-- B테이블에 E F G의 필드값이 4, 5, 6 하고 7, 8, 9 가 있다면(레코드 두개 존재)
-- 크로스조인으로 합쳐진 테이블의 레코드는 1, 2, 3, 4, 5, 6    하고   1, 2, 3, 7, 8, 9 이렇게 두개가 만들어집니다

-- 위 A테이블에 4,5,6 값을 갖는 레코드가 하나 더 있다면
-- 조인된 결과레코드는  1 2 3 4 5 6   1 2 3 7 8 9     4 5 6 4 5 6   4 5 6 7 8 9



-- A테이블의 레코드가 8개, B테이블의 레코드가 7개 라면 총 크로스조인의 결과 레코드수는 8x7 = 56
-- A테이블의 필드가 8개, B테이블의 필드가 3개 라면 총 크로스조인의 결과 필드수는 8+3 = 11
 select * from dept   -- 레코드 4, 필드 3
 select * from emp  -- 레코드 14, 필드 8
 -- 크로스 조인 
select * from emp, dept   -- 레코드 56, 필드 11


--equi join : 조인 대상이 되는 두테이블에서 공통적으로 존재하는 컬럼의 값이 일치하는 행을 연결하여 결과를 생성
select * from dept, emp where emp.deptno = dept.deptno;

-- 각 사원의 이름, 부서번호, 부서명, 지역 을 출력하세요
select ename, emp.deptno, dname, loc from emp, dept where emp.deptno = dept.deptno;
-- 조인되는 두테이블에서 이름이 같은 필드들에 한해서는 필드 명 앞에 테이블 명을 기술하여 필드의 소속을 명확히 해주어야 오류가 없습니다
-- 그 외 필드명들은 소속테이블의 이름을 써도 되고 안써도 무방합니다.

--이름이 SCOTT인 사원의 이름, 부서번호, 부서명, 위치 출력
select ename, emp.deptno, dname, loc from emp, dept 
where emp.deptno = dept.deptno and ename='SCOTT';
-- 조인 명령에 별도의 조건을 추가해서 필요한 정보만 따로 추출할 수도 있습니다.

-- 아래는 모든 필드의 앞에 소속테이블 이름을 쓴경우
select emp.ename, dept.dname, dept.loc, emp.deptno  from emp , dept
where emp.deptno = dept.deptno and emp.ename='SCOTT';



--테이블 명에 별칭을 부여한 후 컬럼앞에 소속테이블을 지정  
-- 테이블 명으로 소속을 기술할때는 한쪽에 만 있는 필드에 생략이 가능하지만 아래와 같이 
-- 별칭 부여시에는 모든 필드 앞에 반드시 별칭을 기술해야함
select a.ename as 이름, b.dname as 부서명, b.loc as 지역, a.deptno as 부서번호  from emp a, dept b
where a.deptno = b.deptno and a.ename='SCOTT';
-- 테이블에 별칭을 붙여놓고, 필드앞에 테이블별칭을 사용했습니다

-- equi 조인은  크로스조인에 필요한 정보가 일치하는 레코드를 골라서 보기위한 조인
-- A테이블에 없는 정보를 추가적으로 B테이블의 내용으로 참고해서 보고자 할때 사용합니다.



--non-equi join
--동일 컬럼이 없어서  다른 조건을 사용하여 조인
--조인 조건에 특정 범위내에 있는지를 조사하기 위해 조건절에 조인 조건을 '=' 연산자 이외의 비교
--연산자를 이용
select * from emp;
select * from salgrade;

select a.ename, a.sal, b.grade from emp a, salgrade b
where a.sal>=b.losal and a.sal<=b.hisal;


select a.ename, a.sal, b.grade from emp a, salgrade b
where  a.sal between b.losal and b.hisal;


--세개의 테이블을 하나로 JOIN(equi , nonequi 조인 의 조합)  emp, dept, salgrade
select  a.ename, a.sal, c.grade, b.dname   from emp a, dept b, salgrade c
where a.deptno = b.deptno and a.sal between c.losal and c.hisal;



-- 연습 문제
-- rentlist 테이블의 rentdate, booknum, membernum 을 조회하되,
-- booklist 와 memebrlist 테이블을 조인해서   책제목과 대여가격, 회원 이름과 사은 포인트를 출력하세요
-- 출력순서 -  대여일자, 도서제목, 회원이름, 포인트,  대여금액
-- 테이블의 별칭은  a,b,c 로 하세요


select a.rentdate as "대여 일자", a.booknum as "도서 코드", b.subject as "도서 제목", 
		b.rentprice - a.discount  as  "할인 후 대여 가격",
		c.membernum as "회원 번호", c.name as "회원 성명", c.bpoint as "사은포인트" 
from rentlist a, booklist b, memberlist c
where a.booknum = b.booknum and a.membernum = c.membernum;





--outer join
--조인 조건에 만족하지 못해서 해당 결과를 출력시에 누락이 되는 문제점이 발생할때 해당 레코드를출력하는 조인
select a.booknum, a.subject, b.rentdate from booklist a, rentlist b 
where a.booknum=b.booknum(+);

select * from booklist;


-- outer 조인으로  emp테이블의 인원에 대한 부서명을 출력하되 부서명이 없는 필드는 NULL 값으로 표시하세요
alter table emp drop constraint FK_DEPTNO;
update emp set deptno=50 where job='SALESMAN';
select * from emp;
select * from emp a, dept b where a.deptno=b.deptno(+);


--[3] ANSI join

--   (1) Ansi Cross join
select * from emp, dept  -- 일반크로스 조인 표현 
select * from emp cross join dept     -- ansi Cross join -> 일반 크로스 조인과 같은 효과


--  (2) Ansi inner join -- 일반 equi 조인과 같은 효과
select  ename, dname from emp a, dept b where a.deptno = b.deptno -- 일반 equi 조인 표현 방식

select  ename, dname from emp inner join dept on emp.deptno = dept.deptno;-- Ansi 이너 조인의 표현 방식

select  ename, dname from emp inner join dept on emp.deptno = dept.deptno 
where ename = 'SCOTT';  -- 바로 위 결과에서 SCOTT 만 따로 검색

select  ename, dname from emp inner join dept using (deptno); -- Ansi 이너 조인의  다른 표현 방식
-- 두테이블의 조인 기준이 되는 필드명이 똑같을때만 사용가능




-- (3) Ansi Outer Join  -- 기존 아우터 조인의 표현방식
select * from emp, dept where emp.deptno = dept.deptno(+);
select * from emp, dept where emp.deptno(+) = dept.deptno;

-- Ansi Outer Join 표현방식
select * from emp left outer join dept on  emp.deptno = dept.deptno;
select * from emp right outer join dept on  emp.deptno = dept.deptno;
-- 기준이 되는 필드명중 A 테이블의 필드에는 있으나 B테이블 필드에는 해당값이 없는 경우에 대한 표현여부결정



































