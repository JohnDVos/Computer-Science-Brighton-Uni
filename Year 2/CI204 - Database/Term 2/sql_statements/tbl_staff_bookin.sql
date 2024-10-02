CREATE TABLE tbl_staff_booking(
	staff_ID int NOT NULL,
	booking_ID int NOT NULL,
	staff_hours int NOT NULL,
	staff_role varchar(15), 
	alcohol_vending_licence bit,
	PRIMARY KEY (staff_ID, booking_ID),
	FOREIGN KEY (staff_role) REFERENCES tbl_staff_pay(staff_role)
);
