package com.Island.Project.animals;

import com.Island.Project.constants.Parameters;
import com.Island.Project.settings.Cell;

public abstract class Inhabitant {

        private String name;
        private double minWeight;
        private double currentWeight;
        private double maxWeight;
        private int maxNumber;
        private double maxFoodAmount;
        private int maxSpeed;
        private String icon;

        public void eat(Cell cell) {
        }

        public void move(Cell cell){}

        public Inhabitant(Parameters parameters) {
            this.name = parameters.getName();
            this.minWeight = parameters.getMinWeight();
            this.currentWeight = parameters.getCurrentWeight();
            this.maxWeight = parameters.getMaxWeight();
            this.maxNumber = parameters.getMaxNumber();
            this.maxFoodAmount = parameters.getMaxFoodAmount();
            this.maxSpeed = parameters.getMaxSpeed();
            this.icon = parameters.getIcon();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getMinWeight() {
            return minWeight;
        }

        public void setMinWeight(double minWeight) {
            this.minWeight = minWeight;
        }

        public double getMaxWeight() {
            return maxWeight;
        }

        public double getCurrentWeight() {
            return currentWeight;
        }

        public String getIcon() {
            return icon;
        }

        public void setCurrentWeight(double currentWeight) {
            this.currentWeight = currentWeight;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public void setMaxWeight(double maxWeight) {
            this.maxWeight = maxWeight;
        }

        public int getMaxNumber() {
            return maxNumber;
        }

        public void setMaxNumber(int maxNumber) {
            this.maxNumber = maxNumber;
        }

        public double getMaxFoodAmount() {
            return maxFoodAmount;
        }

        public void setMaxFoodAmount(double maxFoodAmount) {
            this.maxFoodAmount = maxFoodAmount;
        }

        public int getMaxSpeed() {
            return maxSpeed;
        }

        public void setMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
        }

        @Override
        public String toString() {
            return icon;
        }


         public abstract Cell findNextPosition(Cell cell);
}

