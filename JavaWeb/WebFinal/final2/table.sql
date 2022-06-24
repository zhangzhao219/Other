create table Tab_userinfo(
    ID CHAR(4),
    NAME CHAR(10),
    Address CHAR(15),
    isPaid CHAR(4)
);

INSERT INTO Tab_userinfo VALUES(01,'示例一','湖南长沙','是');
INSERT INTO Tab_userinfo VALUES(02,'示例二','湖南长沙','否');
INSERT INTO Tab_userinfo VALUES(03,'示例三','湖南长沙','是');
INSERT INTO Tab_userinfo VALUES(04,'示例四','湖南长沙','否');
INSERT INTO Tab_userinfo VALUES(05,'示例五','湖南长沙','是');
INSERT INTO Tab_userinfo VALUES(06,'示例六','湖南长沙','否');

SELECT * FROM Tab_userinfo;