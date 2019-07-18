create table employees (

	eid int primary key auto_increment,
	fname varchar(30),
	lname varchar(30),
	age int,
	salary double
);

create table departments (
	id int primary key auto_increment,
	name varchar(30)
);

create table empdept (

	eid int,
	did int,

	constraint fk_eid foreign key (eid) references employees(eid),
	constraint fk_did foreign key (did) references departments(id)
);
