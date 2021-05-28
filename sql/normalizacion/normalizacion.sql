create table if not exists dojos(
	id int primary key auto_increment,
    location varchar(250),    
    name varchar(45),
    created_at datetime,
    updated_at datetime
);

create table interests (
	id int primary key auto_increment,
    name varchar(45),
    descripcion text,
	created_at datetime,
    updated_at datetime
);

create table if not exists students (
	id int primary key auto_increment,
    dojo_id int not null,
	foreign key (dojo_id) references dojos(id),
	created_at datetime,
    updated_at datetime
);

create table students_has_interests (
	id int primary key auto_increment,
	student_id int not null,
    interest_id int not null,
	foreign key (student_id) references students(id),
	foreign key (interest_id) references interests(id),
	created_at datetime,
    updated_at datetime
);

create table addresses (
	id int primary key auto_increment,
    student_id int not null,
    foreign key (student_id) references students(id),
	created_at datetime,
    updated_at datetime
);

