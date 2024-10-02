CREATE TABLE tbl_event_contact_details(
	event_ID int NOT NULL,
	event_contact_name varchar(50) NOT NULL,
	event_contact_tel_numb char(10) NOT NULL,
	event_contact_email varchar(40) NOT NULL,
	PRIMARY KEY (event_ID),
);
