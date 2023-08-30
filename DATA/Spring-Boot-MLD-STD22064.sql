DROP DATABASE IF EXISTS absences_management;
CREATE DATABASE absences_management;
\c absences_management

CREATE TABLE subjects (
	id_subject VARCHAR(10) PRIMARY KEY,
	name VArCHAR(50)
);

CREATE TABLE courses (
	id_course SERIAL PRIMARY KEY, 
	date_course DATE,
	id_subject VARCHAR(10) REFERENCES subjects(id_subject) ON DELETE CASCADE
);

CREATE TABLE "group" (
		id_group SERIAL PRIMARY KEY,
        code_group VARCHAR(2)
);


CREATE TABLE students (
	std VARCHAR(8) PRIMARY KEY, 
	first_name VARCHAR(255), 
	last_name VARCHAR(255),
	email VARCHAR(255),
	id_group Int REFERENCES "group"(id_group) ON DELETE CASCADE
);

CREATE TABLE present (
    idPresence serial PRIMARY KEY,
    isPresent boolean DEFAULT true,
    jusifiy boolean DEFAULT false,
    id_course INT REFERENCES courses(id_course) ON DELETE CASCADE,
    std VARCHAR(8) REFERENCES students(std) ON DELETE CASCADE
);

