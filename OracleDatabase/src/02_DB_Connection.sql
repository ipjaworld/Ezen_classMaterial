-- 프로그램을 다운 받습니다.  오라클 XE 11g R2
-- https://www.oracle.com/database/technologies/xe-prior-release-downloads.html

-- 압축을 푸고 프로그램을 설치합니다
-- 이때 system 계정의 password 는 adminuser 로 설정합니다

-- 설치가 끝나면 command 창을 열고... 오라클에 접속합니다

-- c:users>sqlplus system/adminuser;  -- 방법1


--c:users>sqlplus  --방법2
--사용자명 입력 : system
--암호입력 : (adminuser) -- 입력 내용 보이지 않음

-- 간혹 오랫동안 로그인을 안한 계정 또는 시스템상 오류를 포함한 계정 등은 lock 이 걸려서 로그인이 안되는 경우가 있습니다
-- 그때 표시도는 메세지
-- ORA-28000:the account is locked

--system 계정 또는 관리자 권한이 있는 계정으로 접속해서 
-- 최고 관리자로 접속하여 해당 사용자 계정 롹을 풀어줌
-- SQL>alter user 사용자계정명 account unlock;

-- 사용자 생성
SQL>create user scott identified by tiger;
-- 암호 변경
SQL>alter user scott identified by 변경할암호;
-- 권한 부여
SQL>grant dba to scott;

-- 접속하고 잇는 계정 변경
-- SQL>conn scott/tiger

-- 현재 접속하고 있는 계정 확인
SQL>show user;

-- 조회 검색명령어
select * from tab; -- scott 계정 테이블 목록
select * from dept;
select * from emp;

