
-- LIMIT
-- select 로 데이터 조회할 때 조회할 레코드의 갯수를 조절 제한 할 수 있습니다
select * from memberlist order by membernum desc limit 5;
-- 회원 정보 조회하여 5개의 레코드만 리턴


-- OFFSET
-- select로 데이터 조회할 때, 맨 위에서부터 offset 에 지정한 번째까지는 뛰어 넘고 그 다음부터 리턴
select * from memberlist order by membernum desc limit 3 offset 5;
-- 6번째 데이터 부터 10개의 레코드 리턴 - 개수가 모자르면 있는 곳까지 리턴









-- command 창에서 운영되는 mysql 프로그램 접속

-- mysql -h localhost -u root -p adminuser
--		-h는 호스트, -u는 사용자 -p는 비밀번호 의미

-- mysql 종료는 quit 또는 exit


-- Schema 생성
create schema scott default chracter set utf8mb4;

-- 사용하려는 스키마로 이동
use scott;


-- 현재 스키마의 테이블들 보기
show tables;

-- 테이블의 구조 보기
desc 테이블이름;





