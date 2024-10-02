SELECT DISTINCT tbl_booking.booking_ID, event_name, booking_date
FROM tbl_booking
INNER JOIN tbl_event_details
ON tbl_booking.event_ID = tbl_event_details.event_ID
INNER JOIN tbl_truck_booking
ON tbl_truck_booking.booking_ID = tbl_booking.booking_ID
WHERE truck_ID = 'YUM2'
