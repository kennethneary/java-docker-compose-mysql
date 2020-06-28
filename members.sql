--create DATABASE IF NOT EXISTS MEMBERS;
--USE MEMBERS;

drop table IF EXISTS MEMBERS;

create TABLE MEMBERS (
  member_id int(11) NOT NULL,
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  PRIMARY KEY (member_id)
);
--
--insert into MEMBERS values
--	(1,'David','Adams','david@gmail.com'),
--	(2,'John','Doe','john@gmail.com'),
--	(3,'Ajay','Rao','ajay@gmail.com'),
--	(4,'Mary','Public','mary@gmail.com'),
--	(5,'Maxwell','Dixon','max@gmail.com');
