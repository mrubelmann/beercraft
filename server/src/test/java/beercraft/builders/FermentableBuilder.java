package beercraft.builders;

import beercraft.ingredients.Fermentable;
import beercraft.ingredients.FermentableType;

public class FermentableBuilder {
    Fermentable fermentable;

    public FermentableBuilder() {
        fermentable = new Fermentable();
        fermentable.setPartitionKey("ingredient");
        fermentable.setSortKey(RandomData.getString());
        fermentable.setName(RandomData.getString());
        fermentable.setNotes(RandomData.getString());
        fermentable.setColor(RandomData.getDouble());
        fermentable.setType(FermentableType.Grain);
        fermentable.setYield(RandomData.getDouble());
        fermentable.setLateBoilAddition(false);
        fermentable.setOrigin(RandomData.getString());
        fermentable.setSupplier(RandomData.getString());
        fermentable.setCoarseFineDiff(RandomData.getDouble());
        fermentable.setMoisture(RandomData.getDouble());
        fermentable.setDiastaticPower(RandomData.getDouble());
        fermentable.setProtein(RandomData.getDouble());
        fermentable.setMaxInBatch(RandomData.getDouble());
        fermentable.setRecommendMash(false);
        fermentable.setMashed(false);
    }

    public Fermentable build() {
        return fermentable;
    }
}
