CREATE TRIGGER food_hygiene_certificate
ON tbl_staff
FOR INSERT AS DECLARE @food_hygiene INTEGER
	SELECT @food_hygiene = food_hygiene_certificate
	FROM inserted
	IF @food_hygiene < 2
	BEGIN
		PRINT('a food hygiene certificate level 2 or higher is required')
		ROLLBACK TRANSACTION
	END
