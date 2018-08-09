create table personJDBC
(
  id integer not null,
  name varchar(255) not null,
  location varchar(255),
  birth_date DATE,
  add_date TIMESTAMP ,
  primary key(id)
);

INSERT INTO PERSONJDBC (ID, NAME, LOCATION, BIRTH_DATE, ADD_DATE ) VALUES (10001, 'Name1', 'Location1','1997-02-03' ,sysdate());
INSERT INTO PERSONJDBC (ID, NAME, LOCATION, BIRTH_DATE, ADD_DATE ) VALUES (10002, 'Name2', 'Location2','1988-02-06' ,sysdate());
INSERT INTO PERSONJDBC (ID, NAME, LOCATION, BIRTH_DATE, ADD_DATE ) VALUES (10003, 'Name3', 'Location3','1975-04-06' ,sysdate());
INSERT INTO PERSONJDBC (ID, NAME, LOCATION, BIRTH_DATE, ADD_DATE ) VALUES (10004, 'Name4', 'Location4','1963-02-09' ,sysdate());
