package beercraft.ingredients;

public interface Measurement {
    /**
     * @return The value of the measurement
     */
    double getValue();

    /**
     * @param value The value of the measurement
     */
    void setValue(double value);

    /**
     * @return The type of measurement
     */
    UnitType getUnitType();

    /**
     * @param unitType The type of measurement
     */
    void setUnitType(UnitType unitType);
}
