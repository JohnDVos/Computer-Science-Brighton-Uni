CREATE TABLE tbl_event_details(
	event_ID int NOT NULL,
	event_name varchar(50) NOT NULL,
	start_time time NOT NULL,
	event_address_1 nvarchar(50) NOT NULL,
	event_address_2 nvarchar(50),
	event_post_code nvarchar(8) NOT NULL,
	event_type varchar(2) NOT NULL,
	number_of_covers int,
	alcohol_present bit,
	PRIMARY KEY (event_ID),
);
