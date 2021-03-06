/*
INSERT INTO COURSE(ID, NAME) VALUES(10001, 'Some course no 1 name');
INSERT INTO COURSE(ID, NAME) VALUES(10002, 'Some course no 2 name');
INSERT INTO COURSE(ID, NAME) VALUES(10003, 'Some course no 3 name');
INSERT INTO COURSE(ID, NAME) VALUES(10004, 'Some course no 4 name');
*/
INSERT INTO COURSE(ID, NAME, created_date, last_updated_date) VALUES(10001, 'Some course no 1 name', sysdate(), sysdate());
INSERT INTO COURSE(ID, NAME, created_date, last_updated_date) VALUES(10002, 'Some course no 2 name', sysdate(), sysdate());
INSERT INTO COURSE(ID, NAME, created_date, last_updated_date) VALUES(10003, 'Some course no 3 name', sysdate(), sysdate());
INSERT INTO COURSE(ID, NAME, created_date, last_updated_date) VALUES(10004, 'Some course no 4 name', sysdate(), sysdate());

INSERT INTO PASSPORT (ID, NUMBER) Values (40001, 'E1111111');
INSERT INTO PASSPORT (ID, NUMBER) Values (40002, 'E2222222');
INSERT INTO PASSPORT (ID, NUMBER) Values (40003, 'E3333333');
INSERT INTO PASSPORT (ID, NUMBER) Values (40004, 'E4444444');

INSERT INTO STUDENT (ID, NAME, PASSPORT_ID) Values (20001, 'Student1', 40001);
INSERT INTO STUDENT (ID, NAME, PASSPORT_ID) Values (20002, 'Student2', 40002);
INSERT INTO STUDENT (ID, NAME, PASSPORT_ID) Values (20003, 'Student3', 40003);
INSERT INTO STUDENT (ID, NAME, PASSPORT_ID) Values (20004, 'Student4', 40004);

INSERT INTO REVIEW (ID, RATING, DESCRIPTION, COURSE_ID, STUDENT_ID) Values (50001, '1', 'Description 1 for course', 10001, 20001);
INSERT INTO REVIEW (ID, RATING, DESCRIPTION, COURSE_ID, STUDENT_ID) Values (50002, '2', 'Description 2 for course', 10001, 20002);
INSERT INTO REVIEW (ID, RATING, DESCRIPTION, COURSE_ID, STUDENT_ID) Values (50003, '3', 'Description 3 for course', 10002, 20001);
INSERT INTO REVIEW (ID, RATING, DESCRIPTION, COURSE_ID, STUDENT_ID) Values (50004, '4', 'Description 4 for course', 10004, 20004);

INSERT INTO STUDENT_COURSE (STUDENT_ID, COURSE_ID) Values (20001, 10001);
INSERT INTO STUDENT_COURSE (STUDENT_ID, COURSE_ID) Values (20001, 10002);
INSERT INTO STUDENT_COURSE (STUDENT_ID, COURSE_ID) Values (20002, 10001);
INSERT INTO STUDENT_COURSE (STUDENT_ID, COURSE_ID) Values (20004, 10004);

