package com.Island.Project.constants;

public class Parameters {
    private final String name;
    private final double minWeight;
    private double currentWeight;
    private final double maxWeight;
    private final int maxNumber;
    private final double maxFoodAmount;
    private final int maxSpeed;
    private final String icon;

    public Parameters(String name, double minWeight, double currentWeight, double maxWeight, int maxNumber, int maxSpeed, double maxFoodAmount, String icon) {
        this.name = name;
        this.minWeight = minWeight;
        this.currentWeight = currentWeight;
        this.maxWeight = maxWeight;
        this.maxNumber = maxNumber;
        this.maxSpeed = maxSpeed;
        this.maxFoodAmount = maxFoodAmount;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public double getMinWeight() {
        return minWeight;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public double getMaxFoodAmount() {
        return maxFoodAmount;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getIcon() {
        return icon;
    }
}
