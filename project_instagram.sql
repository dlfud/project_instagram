DROP DATABASE IF EXISTS project_instagram;
CREATE DATABASE project_instagram;
USE project_instagram;

CREATE TABLE board(
    id INT(11) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    content TEXT NOT NULL,
    create_date DATETIME NOT NULL,
    modify_date DATETIME NOT NULL,
    on_off TINYINT DEFAULT 0
);

INSERT INTO board SET
create_date = NOW(),
modify_date = NOW(),
title = '질문 1',
content = '질문내용 1';

INSERT INTO board SET
create_date = NOW(),
modify_date = NOW(),
title = '질문 2',
content = '질문내용 2';

INSERT INTO board SET
create_date = NOW(),
modify_date = NOW(),
title = '질문 3',
content = '질문내용 3';

SELECT * FROM board;


CREATE TABLE Answer (
    id INT(11) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    content TEXT NOT NULL,
    create_date DATETIME NOT NULL,
    board_id INT(11) UNSIGNED NOT NULL
);

INSERT INTO Answer SET
create_date = NOW(),
content = '답변내용 1',
board_id = 1;

INSERT INTO Answer SET
create_date = NOW(),
content = '답변내용 2',
board_id = 2;

INSERT INTO Answer SET
create_date = NOW(),
content = '답변내용 3',
board_id = 3; 

SELECT * FROM Answer;