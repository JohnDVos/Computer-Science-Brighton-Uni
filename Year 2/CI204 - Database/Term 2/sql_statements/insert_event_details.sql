/*inserts 10 cells of data into event_details*/
INSERT INTO tbl_event_details(event_ID, event_name, start_time, event_address_1, event_address_2, event_post_code, event_type, number_of_covers)
VALUES 
(1, 'ABCD Road', '09:00:00', 'ABCD Road', 'Somewhere', 'UW8 9EP', 'OC', 200),
(2, 'Cliffe High St', '06:30:00', 'Cliffe High St', 'Lewes', 'BN7 2AP', 'DS', NULL),
(3, 'Brighton Grande Parade', '10:30:00', 'LOPK Street', 'Elsewhere', 'POO 1IK', 'DS', NULL),
(4, 'Lewes Farmers Market', '06:30:00', 'Cliffe High St', 'Lewes', 'BN7 2AP', 'DS', NULL),
(5, 'Carl Birthday Party', '11:00:00', 'QWERTY blv', 'Everywhere', 'KR3 ST5', 'OC', 25),
(6,'Boss - Wedding', '09:00:00', 'Wedding venue', 'Wonderland', 'H5T JN8', 'OC', 400),
(7, 'Susan Birthday Party', '11:00:00', 'Birthday Venue', 'LALALAND', 'LM0 4FR', 'OC', 50),
(8,'Lewes Farmers Market', '06:30:00', 'Cliffe High St', 'Lewes', 'BN7 2AP', 'DS', NULL),
(9,'Brighton Pier Easter', '14:00:00', ' Madeira DR', 'Brighton', 'BN2 1TW', 'DS', NULL),
(10,'Brighton Pier Halloween', '21:00:00', ' Madeira DR', 'Brighton', 'BN2 1TW', 'DS', NULL);
