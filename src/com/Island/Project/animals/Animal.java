package com.Island.Project.animals;

import com.Island.Project.animals.herbivores.*;
import com.Island.Project.animals.predators.*;
import com.Island.Project.constants.Parameters;
import com.Island.Project.settings.Cell;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Animal extends Inhabitant {

    private String name;
    private double minWeight;
    private double currentWeight;
    private double maxWeight;
    private int maxNumber;
    private double maxFoodAmount;
    private int maxSpeed;
    private String icon;

    public Animal(Parameters parameters) {
        super(parameters);
    }


//    public Animal breed(Cell cell){
//
//        Map<OrganismsList, List<? extends Inhabitant>> map = cell.organismsMap;
//        int counter;
//        List<? extends Inhabitant> copyList = map.get(OrganismsList.FOX);
//        if (copyList.size() >= 2){
//            int posibility = ThreadLocalRandom.current().nextInt(0, 1);
//            int temp = copyList.size() / 2;
//            if ((temp >=1) && (posibility == 1)){
//
//            }
//        }
//
//    }

    public Cell findNextPosition(Cell cell) {
        Cell newCell = cell;
        if (this instanceof Caterpillar) {
            return cell;
        } else {
            int direction = ThreadLocalRandom.current().nextInt(0, 4);

            int nextRow = cell.getRow();
            int nextColumn = cell.getColumn();

            if (direction == 1) { // UP
                nextRow = cell.getRow() + ThreadLocalRandom.current().nextInt(0, this.getMaxSpeed());

            }
            if (direction == 2) { // RIGHT
                nextColumn = cell.getColumn() + ThreadLocalRandom.current().nextInt(0, this.getMaxSpeed());
            }

            if (direction == 3) { // LEFT
                nextRow = cell.getRow() - ThreadLocalRandom.current().nextInt(0, this.getMaxSpeed());
            }

            if (direction == 4) { //DOWN
                nextColumn = cell.getColumn() - ThreadLocalRandom.current().nextInt(0, this.getMaxSpeed());
            }

            if (nextRow > cell.getRow() || nextColumn > cell.getColumn() || nextRow < 0 || nextColumn < 0) {
                if (this instanceof Boar) {
                    cell.organismsMap.get(OrganismsList.BOAR).remove(this);
                }                                       // нужно удалить животное из списка, вопрос как???
                if (this instanceof Buffalo) {
                    cell.organismsMap.get(OrganismsList.BUFFALO).remove(this);
                }
                if (this instanceof Deer) {
                    cell.organismsMap.get(OrganismsList.DEER).remove(this);
                }
                if (this instanceof Duck) {
                    cell.organismsMap.get(OrganismsList.DUCK).remove(this);
                }
                if (this instanceof Goat) {
                    cell.organismsMap.get(OrganismsList.GOAT).remove(this);
                }
                if (this instanceof Horse) {
                    cell.organismsMap.get(OrganismsList.HORSE).remove(this);
                }
                if (this instanceof Mouse) {
                    cell.organismsMap.get(OrganismsList.MOUSE).remove(this);
                }
                if (this instanceof Rabbit) {
                    cell.organismsMap.get(OrganismsList.RABBIT).remove(this);
                }
                if (this instanceof Sheep) {
                    cell.organismsMap.get(OrganismsList.SHEEP).remove(this);
                }
                if (this instanceof Bear) {
                    cell.organismsMap.get(OrganismsList.BEAR).remove(this);
                }
                if (this instanceof Boa) {
                    cell.organismsMap.get(OrganismsList.BOA).remove(this);
                }
                if (this instanceof Eagle) {
                    cell.organismsMap.get(OrganismsList.EAGLE).remove(this);
                }
                if (this instanceof Fox) {
                    cell.organismsMap.get(OrganismsList.FOX).remove(this);
                }
                if (this instanceof Wolf) {
                    cell.organismsMap.get(OrganismsList.WOLF).remove(this);
                }

            }

            newCell.setColumn(nextColumn);
            newCell.setRow(nextRow);
            return newCell;


        }
    }


    public void move(Cell cell){

    Cell newCell = findNextPosition(cell);

    if (this instanceof Boar) {
        cell.organismsMap.get(OrganismsList.BOAR).remove(this);
        List<Animal> animals = (List<Animal>)newCell.organismsMap.get(OrganismsList.BEAR);
        animals.add(this);
    }
        if (this instanceof Buffalo) {
            cell.organismsMap.get(OrganismsList.BUFFALO).remove(this);
            List<Animal> animals = (List<Animal>)newCell.organismsMap.get(OrganismsList.BUFFALO);
            animals.add(this);
        }
        if (this instanceof Caterpillar) {
            cell.organismsMap.get(OrganismsList.CATERPILLAR).remove(this);
            List<Animal> animals = (List<Animal>)newCell.organismsMap.get(OrganismsList.CATERPILLAR);
            animals.add(this);
        }
        if (this instanceof Deer) {
            cell.organismsMap.get(OrganismsList.DEER).remove(this);
            List<Animal> animals = (List<Animal>)newCell.organismsMap.get(OrganismsList.DEER);
            animals.add(this);
        }
        if (this instanceof Duck) {
            cell.organismsMap.get(OrganismsList.DUCK).remove(this);
            List<Animal> animals = (List<Animal>)newCell.organismsMap.get(OrganismsList.DUCK);
            animals.add(this);
        }
        if (this instanceof Goat) {
            cell.organismsMap.get(OrganismsList.GOAT).remove(this);
            List<Animal> animals = (List<Animal>)newCell.organismsMap.get(OrganismsList.GOAT);
            animals.add(this);
        }
        if (this instanceof Horse) {
            cell.organismsMap.get(OrganismsList.HORSE).remove(this);
            List<Animal> animals = (List<Animal>)newCell.organismsMap.get(OrganismsList.HORSE);
            animals.add(this);
        }
        if (this instanceof Mouse) {
            cell.organismsMap.get(OrganismsList.MOUSE).remove(this);
            List<Animal> animals = (List<Animal>)newCell.organismsMap.get(OrganismsList.MOUSE);
            animals.add(this);
        }
        if (this instanceof Rabbit) {
            cell.organismsMap.get(OrganismsList.RABBIT).remove(this);
            List<Animal> animals = (List<Animal>)newCell.organismsMap.get(OrganismsList.RABBIT);
            animals.add(this);
        }
        if (this instanceof Sheep) {
            cell.organismsMap.get(OrganismsList.SHEEP).remove(this);
            List<Animal> animals = (List<Animal>)newCell.organismsMap.get(OrganismsList.SHEEP);
            animals.add(this);
        }
        if (this instanceof Bear) {
            cell.organismsMap.get(OrganismsList.BEAR).remove(this);
            List<Animal> animals = (List<Animal>)newCell.organismsMap.get(OrganismsList.BEAR);
            animals.add(this);
        }
        if (this instanceof Boa) {
            cell.organismsMap.get(OrganismsList.BOA).remove(this);
            List<Animal> animals = (List<Animal>)newCell.organismsMap.get(OrganismsList.BOA);
            animals.add(this);
        }
        if (this instanceof Eagle) {
            cell.organismsMap.get(OrganismsList.EAGLE).remove(this);
            List<Animal> animals = (List<Animal>)newCell.organismsMap.get(OrganismsList.EAGLE);
            animals.add(this);
        }
        if (this instanceof Fox) {
            cell.organismsMap.get(OrganismsList.FOX).remove(this);
            List<Animal> animals = (List<Animal>)newCell.organismsMap.get(OrganismsList.FOX);
            animals.add(this);
        }
        if (this instanceof Wolf) {
            cell.organismsMap.get(OrganismsList.WOLF).remove(this);
            List<Animal> animals = (List<Animal>)newCell.organismsMap.get(OrganismsList.WOLF);
            animals.add(this);
        }
        else return;

    }
}



    //private Parameters parameters;


//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public double getMinWeight() {
//        return minWeight;
//    }
//
//    public void setMinWeight(double minWeight) {
//        this.minWeight = minWeight;
//    }
//
//    public double getMaxWeight() {
//        return maxWeight;
//    }
//
//    public double getCurrentWeight() {
//        return currentWeight;
//    }
//
//    public String getIcon() {
//        return icon;
//    }
//
//    public void setCurrentWeight(double currentWeight) {
//        this.currentWeight = currentWeight;
//    }
//
//    public void setIcon(String icon) {
//        this.icon = icon;
//    }
//
//    public void setMaxWeight(double maxWeight) {
//        this.maxWeight = maxWeight;
//    }
//
//    public int getMaxNumber() {
//        return maxNumber;
//    }
//
//    public void setMaxNumber(int maxNumber) {
//        this.maxNumber = maxNumber;
//    }
//
//    public double getMaxFoodAmount() {
//        return maxFoodAmount;
//    }
//
//    public void setMaxFoodAmount(double maxFoodAmount) {
//        this.maxFoodAmount = maxFoodAmount;
//    }
//
//    public int getMaxSpeed() {
//        return maxSpeed;
//    }
//
//    public void setMaxSpeed(int maxSpeed) {
//        this.maxSpeed = maxSpeed;
//    }

//    @Override
//    public String toString() {
//        return icon;
//    }



