CREATE TRIGGER booking_cancelation_prompt
ON tbl_booking
INSTEAD OF DELETE
AS
DECLARE
	@deleted_booking_ID int

	SELECT @deleted_booking_ID = booking_ID FROM deleted

	BEGIN
		SELECT staff_first_name, staff_second_name, staff_email
		FROM tbl_staff
		INNER JOIN tbl_staff_booking
		ON tbl_staff_Booking.staff_ID = tbl_staff.staff_ID
		WHERE booking_ID = @deleted_booking_ID

		DELETE FROM tbl_truck_booking
		WHERE booking_ID = @deleted_booking_ID

		DELETE FROM tbl_staff_booking
		WHERE booking_ID = @deleted_booking_ID

		DELETE FROM tbl_booking
		WHERE booking_ID = @deleted_booking_ID
END