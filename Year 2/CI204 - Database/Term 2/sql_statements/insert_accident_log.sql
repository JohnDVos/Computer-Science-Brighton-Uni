/* inserts 5 cells of data into accident log*/
INSERT INTO tbl_accident_log(accident_ID, booking_ID, staff_ID, date_of_incident, date_reported, comments)
VALUES
(1, 3, 1, '2019-03-15', '2019-04-22', 'Reversed into pole – dent in back right side bumper'),
(3, 2, 3, '2019-04-22', '2019-04-23', 'Door was damaged on left interior whilst unloading tables for event'),
(4, 9, 2, '2019-04-01', '2019-04-02', 'Van needs servicing – service due warning came up'),
(2, 7, 1, '2019-03-01', '2019-03-03', 'Right front tire flat – currently on spare tire'),
(5, 6, 4, '2019-05-16', '2019-05-16', 'Wind screen washer fluid needs to be refiled');
