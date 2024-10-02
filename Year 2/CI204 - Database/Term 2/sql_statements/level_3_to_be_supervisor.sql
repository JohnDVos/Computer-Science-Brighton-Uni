CREATE TRIGGER supervisors_hygiene_cert
ON tbl_staff_booking
FOR 
INSERT
AS
DECLARE
	@supervisor_hygiene int,
	@staff_role varchar(10),
	@staff_ID int

	SELECT @staff_ID = staff_ID FROM inserted
	SELECT @staff_role = staff_role FROM inserted
	SELECT @supervisor_hygiene = food_hygiene_certificate FROM tbl_staff
	WHERE staff_ID =  @staff_ID

	IF @staff_role LIKE 'supervisor' AND @supervisor_hygiene != 3
	BEGIN
		PRINT('food hygiene certificate level 3 is needed to be a supervisor')
		ROLLBACK TRANSACTION
	END