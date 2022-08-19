------------------------------User Details-----------------------------------------------------------------------------------
create table satya.user(id int primary key auto_increment,name varchar(50) not null,email varchar(100) not null unique,password varchar(50)not null,gender varchar(10) not null);

--------------------------------Admin Details----------------------------------------------------------------------------------
create table satya.admin(id int primary key auto_increment,name varchar(50) not null,email varchar(100) not null unique,password varchar(50)not null,gender varchar(10) not null);
insert into satya.admin(name,email,password,gender)values('satya','sat12@gmail.com','Satya23@','Male');


--------------------------------------Book Details--------------------------------------------------------------------
create table satya.book(id int primary key auto_increment,name varchar(40)not null,author varchar(50)not null,price int not null,status int not null default 1);
create table satya.issuebook(issueid int primary key auto_increment,bookid int not null,bookname varchar(40) not null,userid int not null,username varchar(50)not null,

period varchar(10) not null,issuedate date not null,returndate varchar(10) not null default '1 week');

select * from satya.issuebook;
drop table satya.issuebook;