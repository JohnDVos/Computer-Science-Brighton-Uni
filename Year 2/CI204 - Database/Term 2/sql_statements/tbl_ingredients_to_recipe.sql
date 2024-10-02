CREATE TABLE tbl_ingredients_to_recipe(
	main_ingredient int FOREIGN KEY REFERENCES tbl_ingredients(ingredient_ID),
	sub_ingredient int FOREIGN KEY REFERENCES tbl_ingredients(ingredient_ID),
	quantity varchar(15) NOT NULL,
	PRIMARY KEY(main_ingredient, sub_ingredient)
);
