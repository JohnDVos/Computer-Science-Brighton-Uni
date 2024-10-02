CREATE TABLE tbl_staff_booking(
	staff_ID int NOT NULL,
	booking_ID int NOT NULL,
	staff_hours int NOT NULL,
	staff_role varchar(15) FOREIGN KEY REFERENCES tbl_rate_of_pay(staff_role) NOT NULL, alcohol_vending_licence bit,
	PRIMARY KEY (staff_ID, booking_ID),
);
