create database ems;
use ems;
create table adminlogin(username varchar(21),password varchar(21));
create table emplogin(empId varchar(21) primary key,password varchar(21));
create table employee(empId varchar(21) primary key,fname varchar(21),lname varchar(21),dob varchar(30),salary varchar(21),address varchar(100),phone varchar(21),email varchar(40),education varchar(21),designation varchar(21),aadhar varchar(30));
create table leaves(empId varchar(21),from_date varchar(21),to_date varchar(21),category varchar(21),status varchar(21));
create table attendence(empId varchar(21),checkin_time varchar(21),checkin_date varchar(21));
create table description(empId varchar(21),description varchar(100));
insert into adminlogin value("admin",'12345');