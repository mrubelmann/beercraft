package beercraft.ingredients;

import java.util.Map;

public class FermentableFactory {
    /**
     * Creates a Fermentable object from the set of attributes in the database.
     * @param attributes The attributes
     * @return The Fermentable
     */
    public static Fermentable createFromAttributes(Map<String, Object> attributes) {
        Fermentable f = new Fermentable();
        f.setPartitionKey((String)attributes.get("PK"));
        f.setSortKey((String)attributes.get("SK"));
        f.setName((String)attributes.get("Name"));
        f.setNotes((String)attributes.get("Notes"));
        f.setColor((double)attributes.get("Color"));
        f.setType((FermentableType) attributes.get("Type"));
        f.setYield((double)attributes.get("Yield"));
        f.setLateBoilAddition((boolean)attributes.get("LateBoilAddition"));
        f.setOrigin((String)attributes.get("Origin"));
        f.setSupplier((String)attributes.get("Supplier"));
        f.setCoarseFineDiff((double)attributes.get("CoarseFineDiff"));
        f.setMoisture((double)attributes.get("Moisture"));
        f.setDiastaticPower((double)attributes.get("DiastaticPower"));
        f.setProtein((double)attributes.get("Protein"));
        f.setMaxInBatch((double)attributes.get("MaxInBatch"));
        f.setRecommendMash((boolean)attributes.get("RecommendMash"));
        f.setMashed((boolean)attributes.get("Mashed"));
        return f;
    }
}
