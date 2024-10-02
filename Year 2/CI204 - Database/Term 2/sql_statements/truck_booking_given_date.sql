SELECT tbl_truck.truck_ID, truck_VIN, tbl_booking.booking_name, tbl_event_details.event_name
FROM tbl_truck
INNER JOIN tbl_truck_booking
ON tbl_truck.truck_ID = tbl_truck_booking.truck_ID
INNER JOIN tbl_booking
ON tbl_booking.booking_ID = tbl_truck_booking.booking_ID
INNER JOIN tbl_event_details
ON tbl_booking.event_ID = tbl_event_details.event_ID
WHERE booking_date = '2019-03-01'
