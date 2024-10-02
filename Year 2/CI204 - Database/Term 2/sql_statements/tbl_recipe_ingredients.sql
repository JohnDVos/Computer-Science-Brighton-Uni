CREATE TABLE tbl_recipe_ingredients(
	ingredient_ID int NOT NULL,
	recipe_ID varchar(3) NOT NULL,
	quantity varchar(15)  NOT NULL,
	PRIMARY KEY (ingredient_ID, recipe_ID),
	FOREIGN KEY (ingredient_ID) REFERENCES tbl_ingredients(ingredient_ID),
	FOREIGN KEY (recipe_ID) REFERENCES tbl_recipe(recipe_ID)
);
