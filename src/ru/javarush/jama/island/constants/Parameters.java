package ru.javarush.jama.island.constants;

public class Parameters {

    private String name;
    private String icon;
    private double maxWeight;
    private int maxQuantity;
    private int maxSpeed;
    private float maxFoodRequired;

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public float getMaxFoodRequired() {
        return maxFoodRequired;
    }

    public Parameters() {
    }

    public Parameters(String name, String icon, double maxWeight, int maxQuantity, int maxSpeed, float maxFoodRequired) {
        this.name = name;
        this.icon = icon;
        this.maxWeight = maxWeight;
        this.maxQuantity = maxQuantity;
        this.maxSpeed = maxSpeed;
        this.maxFoodRequired = maxFoodRequired;
    }
}
