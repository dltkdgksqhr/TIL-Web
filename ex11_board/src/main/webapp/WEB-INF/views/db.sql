-- 게시판 DB 만들기 
create table board(
  board_idx number(4) primary key,
  board_name varchar2(20),
  board_title varchar2(100),
  board_content varchar2(300),
  board_date date default sysdate,
  board_hit number(4) default 0
);

create sequence board_seq;

insert into board(board_idx, board_name, board_title, board_content, board_date)
values (board_seq.nextval, '홍길동', '글 제목1', '글 내용', sysdate);
insert into board(board_idx, board_name, board_title, board_content, board_date)
values (board_seq.nextval, '빈사또', '글 제목2', '글 내용', sysdate);
insert into board(board_idx, board_name, board_title, board_content, board_date)
values (board_seq.nextval, '사임당', '글 제목3', '글 내용', sysdate);
commit;