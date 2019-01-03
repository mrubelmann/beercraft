package beercraft.builders;

import beercraft.recipes.Recipe;
import beercraft.recipes.Style;

public class RecipeBuilder {
    private Recipe recipe;

    public RecipeBuilder() {
        recipe = new Recipe();
        recipe.setPK(RandomData.getString());
        recipe.setSK(RandomData.getString());
        recipe.setName(RandomData.getString());
        recipe.setDescription(RandomData.getString());
        recipe.setFermentables(null);
        recipe.setHops(null);
        recipe.setExtras(null);
        recipe.setYeast(null);
        recipe.setVolume(RandomData.getDouble());
        recipe.setBoilTime(RandomData.getDouble());
        recipe.setStyle(Style.Ipa);
    }

    public Recipe build() {
        return recipe;
    }
}
