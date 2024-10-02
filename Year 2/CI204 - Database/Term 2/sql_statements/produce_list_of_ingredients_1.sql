SELECT tbl_ingredients.ingredient_ID, contains_allergen, ingredient 
FROM tbl_recipe
INNER JOIN tbl_recipe_ingredients
ON tbl_recipe.recipe_ID = tbl_recipe_ingredients.recipe_ID
INNER JOIN tbl_ingredients
ON tbl_ingredients.ingredient_ID = tbl_recipe_ingredients.ingredient_ID
WHERE
tbl_recipe.recipe_ID = 'HF1'
