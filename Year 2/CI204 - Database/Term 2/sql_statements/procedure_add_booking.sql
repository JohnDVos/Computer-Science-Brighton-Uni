CREATE PROCEDURE add_booking
	@booking_ID			int,
	@event_ID			int,
	@booking_name		varchar(50),
	@booking_date		date,
	@booking_duration	int,	
	@repeat_event		bit

AS
DECLARE @errors int
	INSERT INTO tbl_booking(booking_ID, event_ID, booking_name, booking_date, booking_duration, repeat_event)
	VALUES
	(@booking_ID, @event_id, @booking_name, @booking_date, @booking_duration, @repeat_event)
	SET @errors = @@ERROR
	IF @errors <> 0
		RETURN 99
	ELSE
		RETURN 00
	GO