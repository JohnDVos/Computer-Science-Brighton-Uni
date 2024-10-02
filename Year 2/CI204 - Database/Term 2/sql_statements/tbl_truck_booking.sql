CREATE TABLE tbl_truck_booking(
	truck_ID varchar(4) NOT NULL,
	booking_ID int NOT NULL,
	recipe_ID VARCHAR(3) NOT NULL,
	PRIMARY KEY (truck_ID, booking_ID, recipe_ID),
);
