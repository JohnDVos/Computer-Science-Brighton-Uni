CREATE TRIGGER alcohol_license_present
ON tbl_staff_booking
FOR INSERT
AS
BEGIN
DECLARE
	@staff_ID int,
	@booking_ID int,
	@event_ID int,
	@license_needed bit,
	@alcohol_vending_license_present bit,
	@alcohol_staff_license_holder bit,
	@count int = 0

	SELECT @staff_ID = staff_ID FROM inserted
	SELECT @booking_ID = booking_ID FROM inserted
	SELECT @event_ID = event_ID FROM tbl_booking WHERE booking_ID = @booking_ID
	SELECT @alcohol_staff_license_holder = alcohol_vending_licence FROM inserted
	SELECT @license_needed = alcohol_present FROM tbl_event_details
	SELECT @alcohol_staff_license_holder = alcohol_vending_licence FROM tbl_staff
	SELECT @count = COUNT(alcohol_vending_licence) FROM tbl_staff_booking WHERE booking_ID = @booking_ID AND alcohol_vending_licence != NULL

	if @license_needed = 1 AND (@alcohol_staff_license_holder != 1 OR @alcohol_vending_license_present !=1) AND @count <1
		BEGIN
			PRINT('at least 1 alcohol license holder is needed for the event')
			ROLLBACK TRANSACTION
		END
END
