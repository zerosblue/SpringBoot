-- 테이블이 존재하면 삭제
DROP TABLE IF EXISTS todos;
DROP TABLE IF EXISTS authentications;
DROP TYPE IF EXISTS role;   -- 예제 A.21


-- 테이블 만들기
CREATE TABLE todos (
    -- id(할일 ID): 기본키
    id serial PRIMARY KEY,
    -- todo(할일): NULL 허용하지 않음
    todo varchar(255) NOT NULL,
    -- detail(설명)
    detail text,
    -- created_at(작성 일자)
    created_at timestamp without time zone,
    -- updated_at(업데이트 일자)
    updated_at timestamp without time zone
);

-- 권한용 ENUM 타입
CREATE TYPE role AS ENUM ('ADMIN', 'USER');

-- 인증 정보를 저장하는 테이블
CREATE TABLE authentications (
	-- 사용자명: 기본키
	username VARCHAR(50) PRIMARY KEY,
	-- 비밀번호
	password VARCHAR(255) NOT NULL,
	-- 권한
	authority role NOT NULL,
	-- 표시명
	displayname VARCHAR(50) NOT NULL
);
