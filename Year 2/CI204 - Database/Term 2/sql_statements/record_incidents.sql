SELECT date_of_incident, tbl_staff.staff_ID, tbl_staff.staff_first_name + ' ' + tbl_staff.staff_second_name AS staff_name, event_name, tbl_staff.comments
FROM tbl_accident_log
INNER JOIN tbl_staff
ON tbl_accident_log.staff_ID = tbl_staff.staff_ID
INNER JOIN tbl_booking
ON tbl_accident_log.booking_ID = tbl_booking.booking_ID
INNER JOIN tbl_event_details
ON tbl_booking.event_ID = tbl_event_details.event_ID