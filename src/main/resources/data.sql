-- 15��: article ���� ������
-- 17��: article ���� �����Ϳ��� id ������ ����
INSERT INTO article(title, content) VALUES('��������', '1111');
INSERT INTO article(title, content) VALUES('��������', '2222');
INSERT INTO article(title, content) VALUES('�ٴٴٴ�', '3333');

-- 22��: article ���� ������
INSERT INTO article(title, content) VALUES('����� �λ� ��ȭ��?', '��� ��');
INSERT INTO article(title, content) VALUES('����� �ҿ� Ǫ���?', '��� ����');
INSERT INTO article(title, content) VALUES('����� ��̴�?', '��� ������');

-- 22��: comment ���� ������
---- 4�� �Խñ��� ��۵�
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Park', '�� �� ����');
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Kim', '���� �� ��');
INSERT INTO comment(article_id, nickname, body) VALUES(4, 'Choi', '���ũ�� Ż��');

---- 5�� �Խñ��� ��۵�
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Park', 'ġŲ');
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Kim', '�������');
INSERT INTO comment(article_id, nickname, body) VALUES(5, 'Choi', '�ʹ�');

---- 6�� �Խñ��� ��۵�
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Park', '����');
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Kim', '��Ʃ��');
INSERT INTO comment(article_id, nickname, body) VALUES(6, 'Choi', '����');