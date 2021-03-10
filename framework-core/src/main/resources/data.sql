
INSERT INTO tb_role
(seq,created_at,updated_at,created_by,updated_by,del_yn,use_yn,role_nm)
VALUES
(1,sysdate(),sysdate(),1,1,'N','Y','ROLE_ANONYMOUS');
INSERT INTO tb_role
(seq,created_at,updated_at,created_by,updated_by,del_yn,use_yn,role_nm)
VALUES
(2,sysdate(),sysdate(),1,1,'N','Y','ROLE_USER');
INSERT INTO tb_role
(seq,created_at,updated_at,created_by,updated_by,del_yn,use_yn,role_nm)
VALUES
(3,sysdate(),sysdate(),1,1,'N','Y','ROLE_ADMIN');
-- UPDATE sq_tb_role SET NEXT_VAL = 4;

/**
 * 어드민 계정 등록
 */
INSERT INTO tb_user
(seq,created_at,updated_at,email,user_nm,pswd,username)
VALUES
(1,sysdate(),sysdate(),'admin@naver.com','admin','$2a$10$h5ishmj7TOeYxwiCgvwz7u9OosCorb0PtoimZ79MLzaBNFtgai09e','admin');

-- UPDATE sq_tb_user SET NEXT_VAL = 2;

INSERT INTO tb_user_role (user_seq,role_seq) VALUES (1,2);
INSERT INTO tb_user_role (user_seq,role_seq) VALUES (1,3);

INSERT INTO tb_menu
(seq, created_at, updated_at, created_by, updated_by, del_yn, use_yn, menu_nm, order_by, parent_seq, tag)
VALUES(1, sysdate(), sysdate(), 1, 1, 'N', 'Y', 'ADMIN', 1, null, '');

INSERT INTO tb_menu
(seq, created_at, updated_at, created_by, updated_by, del_yn, use_yn, menu_nm, order_by, parent_seq, tag)
VALUES(2, sysdate(), sysdate(), 1, 1, 'N', 'Y', '사용자관리', 2, 1, '');

-- UPDATE sq_tb_menu SET NEXT_VAL = 3;

INSERT INTO tb_program
(seq, created_at, updated_at, created_by, updated_by, del_yn, use_yn, prgm_nm, prgm_type, url)
VALUES(1, sysdate(), sysdate(), 1, 1, 'N', 'Y', '인증API', 'API', '/api/auth/*');
INSERT INTO tb_program
(seq, created_at, updated_at, created_by, updated_by, del_yn, use_yn, prgm_nm, prgm_type, url)
VALUES(2, sysdate(), sysdate(), 1, 1, 'N', 'Y', '사용자API', 'API', '/api/user/*');
INSERT INTO tb_program
(seq, created_at, updated_at, created_by, updated_by, del_yn, use_yn, prgm_nm, prgm_type, url)
VALUES(3, sysdate(), sysdate(), 1, 1, 'N', 'Y', '어드민API', 'API', '/api/admin/**/*');

INSERT INTO tb_program
(seq, created_at, updated_at, created_by, updated_by, del_yn, use_yn, prgm_nm, prgm_type, url)
VALUES(4, sysdate(), sysdate(), 1, 1, 'N', 'Y', '익명사용자API_001', 'API', '/api/user/checkUsernameAvailability');
INSERT INTO tb_program
(seq, created_at, updated_at, created_by, updated_by, del_yn, use_yn, prgm_nm, prgm_type, url)
VALUES(5, sysdate(), sysdate(), 1, 1, 'N', 'Y', '익명사용자API_002', 'API', '/api/user/checkEmailAvailability');


INSERT INTO tb_program
(seq, created_at, updated_at, created_by, updated_by, del_yn, use_yn, prgm_nm, prgm_type, url)
VALUES(101, sysdate(), sysdate(), 1, 1, 'N', 'Y', '사용자관리 화면', 'PRGM', '/admin/userManagement');

INSERT INTO tb_program
(seq, created_at, updated_at, created_by, updated_by, del_yn, use_yn, prgm_nm, prgm_type, url)
VALUES(102, sysdate(), sysdate(), 1, 1, 'N', 'Y', '사용자관리 조회', 'PRGM', '/admin/selectUser');
INSERT INTO tb_program
(seq, created_at, updated_at, created_by, updated_by, del_yn, use_yn, prgm_nm, prgm_type, url)
VALUES(103, sysdate(), sysdate(), 1, 1, 'N', 'Y', '테스트 Matcher', 'PRGM', '/admin/matcher/**/*');
INSERT INTO tb_program
(seq, created_at, updated_at, created_by, updated_by, del_yn, use_yn, prgm_nm, prgm_type, url)
VALUES(104, sysdate(), sysdate(), 1, 1, 'N', 'Y', 'H2 DB 콘솔', 'API', '/h2-console');

-- UPDATE sq_tb_program SET NEXT_VAL = 104;

INSERT INTO tb_role_program (role_seq, prgm_seq) VALUES(2, 101);
INSERT INTO tb_role_program (role_seq, prgm_seq) VALUES(2, 102);
INSERT INTO tb_role_program (role_seq, prgm_seq) VALUES(2, 103);

INSERT INTO tb_role_program (role_seq, prgm_seq) VALUES(1, 1);
INSERT INTO tb_role_program (role_seq, prgm_seq) VALUES(1, 4);
INSERT INTO tb_role_program (role_seq, prgm_seq) VALUES(1, 5);
INSERT INTO tb_role_program (role_seq, prgm_seq) VALUES(1, 104);

INSERT INTO tb_role_program (role_seq, prgm_seq) VALUES(2, 2);
INSERT INTO tb_role_program (role_seq, prgm_seq) VALUES(3, 3);


