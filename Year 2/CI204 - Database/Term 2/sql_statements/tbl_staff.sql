CREATE TABLE tbl_staff(
	staff_ID int NOT NULL,
	staff_first_name varchar(50) NOT NULL,
	staff_second_name varchar(50) NOT NULL,
	staff_email varchar(50) NOT NULL,
	comments varchar(50),
	alcohol_vending_licence bit NOT NULL,
	food_hygiene_certificate bit NOT NULL,
	food_hygiene_certificate_level int NOT NULL,
	PRIMARY KEY (staff_ID),
);
