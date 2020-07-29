--> 사용자가 회원가입 요청시 실행해야되는 sql문
INSERT INTO MEMBER
VALUES(SEQ_USERNO.NEXTVAL,'xxxx','xxxxx','xxxx','x',xx,XXX,'xxxxx',xxxx,'xxx',sysdate);
-->사용자가 회원 전체 조회 요청시 실행야되는 sql문 --> 여러 행 조회 
SELECT * FROM MEMBER; 

--> 사용자가 "회원 아이디로 검색 요청" 시 실행해야되는 sql문 --> 한 행 만 조회 
SELECT * FROM MEMBER WHERE USERID = 'xxxx';

--> 사용자가 "회원 이름으로 키워드 검색 요청" 시 실행되야되는 SQL문
SELECT * FROM MEMBER WHERE USERNAME LIKE '%XXX%';

--> 사용자가 "회원 정보 변경 요청"시 실행해야되는 sql문
--비밀번호, 이메일, 전화번호, 주소
UPDATE MEMBER SET USERPWD = 'XX', EMAIL = 'XX', PHONE = 'XX', ADDRESS = 'XX' WHERE USERID = 'XX'; 

--> 회원 탈퇴 요청시 실행해야되는 sql문 
DELETE FROM MEMBER WHERE USERID = 'XXX';


-------------------------------------------------------------------------------------------------
--> 사용자가 회원가입 요청시 실행해야되는 sql문
INSERT INTO MEMBER
VALUES(SEQ_USERNO.NEXTVAL,?,?,?,?,?,?,?,?,?,sysdate);
-->사용자가 회원 전체 조회 요청시 실행야되는 sql문 --> 여러 행 조회 
SELECT * FROM MEMBER; 

--> 사용자가 "회원 아이디로 검색 요청" 시 실행해야되는 sql문 --> 한 행 만 조회 
SELECT * FROM MEMBER WHERE USERID = ?;

--> 사용자가 "회원 이름으로 키워드 검색 요청" 시 실행되야되는 SQL문
SELECT * FROM MEMBER WHERE USERNAME LIKE '%?%';

--> 사용자가 "회원 정보 변경 요청"시 실행해야되는 sql문
--비밀번호, 이메일, 전화번호, 주소
UPDATE MEMBER SET USERPWD = ?, EMAIL = ?, PHONE = ?, ADDRESS = ? WHERE USERID = ?; 

--> 회원 탈퇴 요청시 실행해야되는 sql문 
DELETE FROM MEMBER WHERE USERID = 'XXX';
