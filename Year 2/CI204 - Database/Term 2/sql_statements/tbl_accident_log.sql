CREATE TABLE tbl_accident_log(
	accident_ID int NOT NULL,
	booking_ID int NOT NULL,
	staff_ID int NOT NULL,
	date_of_incident date NOT NULL,
	date_reported date NOT NULL,
	comments varchar(200) NOT NULL,
	PRIMARY KEY (accident_ID),
	FOREIGN KEY (booking_ID) REFERENCES tbl_booking(booking_ID),
	FOREIGN KEY (staff_ID) REFERENCES tbl_staff(staff_ID)
);
