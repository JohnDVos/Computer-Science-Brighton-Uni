CREATE PROCEDURE bookings_per_month
AS
BEGIN
	SELECT tbl_booking.booking_ID, booking_date, staff_first_name, staff_second_name, staff_role
	FROM tbl_booking
	INNER JOIN tbl_staff_booking
	ON tbl_staff_booking.booking_ID = tbl_booking.booking_ID
	INNER JOIN tbl_staff
	ON tbl_staff_booking.staff_ID = tbl_staff.staff_ID
	WHERE booking_date BETWEEN GETDATE() AND DATEADD(MONTH, 1, GETDATE())
END
GO
RETURN