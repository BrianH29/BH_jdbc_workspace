--> ����ڰ� ȸ������ ��û�� �����ؾߵǴ� sql��
INSERT INTO MEMBER
VALUES(SEQ_USERNO.NEXTVAL,'xxxx','xxxxx','xxxx','x',xx,XXX,'xxxxx',xxxx,'xxx',sysdate);
-->����ڰ� ȸ�� ��ü ��ȸ ��û�� ����ߵǴ� sql�� --> ���� �� ��ȸ 
SELECT * FROM MEMBER; 

--> ����ڰ� "ȸ�� ���̵�� �˻� ��û" �� �����ؾߵǴ� sql�� --> �� �� �� ��ȸ 
SELECT * FROM MEMBER WHERE USERID = 'xxxx';

--> ����ڰ� "ȸ�� �̸����� Ű���� �˻� ��û" �� ����ǾߵǴ� SQL��
SELECT * FROM MEMBER WHERE USERNAME LIKE '%XXX%';

--> ����ڰ� "ȸ�� ���� ���� ��û"�� �����ؾߵǴ� sql��
--��й�ȣ, �̸���, ��ȭ��ȣ, �ּ�
UPDATE MEMBER SET USERPWD = 'XX', EMAIL = 'XX', PHONE = 'XX', ADDRESS = 'XX' WHERE USERID = 'XX'; 

--> ȸ�� Ż�� ��û�� �����ؾߵǴ� sql�� 
DELETE FROM MEMBER WHERE USERID = 'XXX';


-------------------------------------------------------------------------------------------------
--> ����ڰ� ȸ������ ��û�� �����ؾߵǴ� sql��
INSERT INTO MEMBER
VALUES(SEQ_USERNO.NEXTVAL,?,?,?,?,?,?,?,?,?,sysdate);
-->����ڰ� ȸ�� ��ü ��ȸ ��û�� ����ߵǴ� sql�� --> ���� �� ��ȸ 
SELECT * FROM MEMBER; 

--> ����ڰ� "ȸ�� ���̵�� �˻� ��û" �� �����ؾߵǴ� sql�� --> �� �� �� ��ȸ 
SELECT * FROM MEMBER WHERE USERID = ?;

--> ����ڰ� "ȸ�� �̸����� Ű���� �˻� ��û" �� ����ǾߵǴ� SQL��
SELECT * FROM MEMBER WHERE USERNAME LIKE '%?%';

--> ����ڰ� "ȸ�� ���� ���� ��û"�� �����ؾߵǴ� sql��
--��й�ȣ, �̸���, ��ȭ��ȣ, �ּ�
UPDATE MEMBER SET USERPWD = ?, EMAIL = ?, PHONE = ?, ADDRESS = ? WHERE USERID = ?; 

--> ȸ�� Ż�� ��û�� �����ؾߵǴ� sql�� 
DELETE FROM MEMBER WHERE USERID = 'XXX';
