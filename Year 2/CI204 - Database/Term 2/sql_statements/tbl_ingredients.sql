CREATE TABLE tbl_ingredients(
	ingredient_ID int NOT NULL,
	contains_allergen bit NOT NULL,
	ingredient varchar(200) NOT NULL,
	PRIMARY KEY (ingredient_ID)
);
