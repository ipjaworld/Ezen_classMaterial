CREATE TABLE `scott`.`booklist` (
  `booknum` INT NOT NULL AUTO_INCREMENT,
  `subject` VARCHAR(45) NOT NULL,
  `makeyear` INT NULL,
  `inprice` INT NULL,
  `rentprice` INT NULL,
  `grade` VARCHAR(6) NULL DEFAULT 'all',
  PRIMARY KEY (`booknum`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = '도서목록';

SELECT * FROM scott.booklist;



-- AUTO_INCREMENT : 오라클의 sequence 를 대신하는 자동 숫자 증가 옵션
-- VARCHAR2 는 없고, VARCHAR 가 가변 길이 문자를 나타냅니다.
-- CONSTRANT 없이 제약 사항을 표시합니다.
-- 테이블 이름 앞에 스키마이름. 을 반드시 붙여서 사용합니다.

-- 자주 쓰는 자료형
-- INT : 정수 자료형(FLOAT, DOUBLE은 실수)
-- VARCHAR : 문자열 자료형, 가변길이(CHAR는 고정 길이)
-- TEXT : 긴 문자열은 TEXT로 별도 저장
-- DATETIME : 날짜 자료형 저장
-- TINYINT : -128에서 127까지 저장하지만 여기서는 1 또는 0만 저장해 불값 표현

-- 자주쓰는 제약 조건
-- NOT NULL : 빈 값은 받지 않는다는 뜻(NULL은 빈 값 허용)
-- AUTO_INCREMENT : 숫자 자료형인 경우 다음 로우가 저장될 때 자동으로 1 증가
-- UNSIGNED : 0과 양수만 허용
-- ZEROFILL : 숫자의 자리 수가 고정된 경우 빈 자리에 0을 넣음
-- DEFAULT now() : 날짜 컬럼의 기본값을 현재 시간으로





