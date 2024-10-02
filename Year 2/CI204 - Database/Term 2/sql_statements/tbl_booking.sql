CREATE TABLE tbl_booking(
	booking_ID int NOT NULL,
	event_ID int NOT NULL,
	booking_name varchar(50) NOT NULL,
	booking_date date NOT NULL,
	booking_duration int NOT NULL,
	repeat_event bit,
	PRIMARY KEY (booking_ID),
	FOREIGN KEY (event_ID) REFERENCES tbl_event_details(event_ID)
);
