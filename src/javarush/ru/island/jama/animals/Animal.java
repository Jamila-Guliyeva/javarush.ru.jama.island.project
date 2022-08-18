package javarush.ru.island.jama.animals;
import javarush.ru.island.jama.animals.factories.Factories;
import javarush.ru.island.jama.constants.Parameters;
import javarush.ru.island.jama.location.Cell;

import javarush.ru.island.jama.settings.GameSettings;
import javarush.ru.island.jama.util.Randomizer;


import java.util.*;


public abstract class Animal extends Inhabitant {

    public Animal() {
        super();
    }

    @Override
    public void multiply(Cell area) {
        safeMultiply(area);
    }

    private void safeMultiply(Cell area) {

        area.getLock().lock();
        try {
            int sameAnimalTypeQuantity = area.getInhabitants().get(this.getType()).toArray().length;
            int childrenQuantity = this.getChildQuantity(area);

            if (childrenQuantity > 0 && sameAnimalTypeQuantity > 1 && Randomizer.getProbability(70)) {
                for (int i = 0; i < childrenQuantity; i++) {
                    if (Randomizer.getProbability(90)) {
                        Inhabitant newAnimal = Factories.createOrganismByType(OrganismsList.valueOf(this.getType().toString().toUpperCase(Locale.ROOT)));
                        area.addInhabitant(this.getType(), newAnimal);
                    }
                }
            }

        } finally {
            area.getLock().unlock();
        }

    }

    public boolean eat(Cell area) {
        return safeEat(area);
    }

    private boolean safeEat(Cell area) {
        area.getLock().lock();
        boolean ate = false;

        try {
            GameSettings settings = GameSettings.get();
            Parameters animalCommonSpecs = settings.getOrganismParametersByType(this.getType());

            double weightDiff = animalCommonSpecs.getMaxWeight() - this.getWeight();
            double foodRequired = Math.min(weightDiff, animalCommonSpecs.getMaxFoodRequired());
            if (foodRequired > 0) {
                Map<OrganismsList, Integer> chanceToGetEatMap = settings.getChanceToGetEat().get(this.getType());
                Iterator<Map.Entry<OrganismsList, Integer>> chanceToGetEatIterator = chanceToGetEatMap.entrySet().iterator();
                while (foodRequired > 0 && chanceToGetEatIterator.hasNext()) {
                    Map.Entry<OrganismsList, Integer> chanceToGetEat = chanceToGetEatIterator.next();
                    OrganismsList foodType = chanceToGetEat.getKey();
                    Integer chanceToEat = chanceToGetEat.getValue();

                    Set<Inhabitant> foodSet = area.getInhabitants().get(foodType);
                    if (Randomizer.getProbability(chanceToEat) && foodSet != null && !foodSet.isEmpty()) {
                        Iterator<Inhabitant> foodIterator = foodSet.iterator();
                        if (foodIterator.hasNext()) {
                            Inhabitant food = foodIterator.next();
                            double initialFoodWeight = food.getWeight();
                            double mealWeight = Math.min(foodRequired, initialFoodWeight);
                            foodRequired -= mealWeight;
                            setWeight(getWeight() + mealWeight);
                            food.setWeight(food.getWeight() - mealWeight);

                            double currentFoodWeight = food.getWeight();
                            if (currentFoodWeight < initialFoodWeight / settings.getUnviableWeightPercent()) { // съели целиком или до нежизнеспособного состояния
                                foodIterator.remove();
                            }

                            ate = true;
                            if (foodRequired <= 0) {
                                break;
                            }
                        }
                    }
                }
            }
        } finally {
            area.getLock().unlock();
        }

        return ate;
    }

    public void growUp(Cell area) {
        safeGrowUp(area);
    }

    private void safeGrowUp(Cell area) {
        area.getLock().lock();
        try {
            int growUpPercent = GameSettings.get().getAnimalGrowUpPercent();
            double weightIncrement = this.getWeight() * growUpPercent / 100;
            this.setWeight(this.getWeight() + weightIncrement);
        } finally {
            area.getLock().unlock();
        }
    }

    public void move(Cell area) {
        safeMove(area);
    }

    private void safeMove(Cell currentArea) {
        currentArea.getLock().lock();
        try {
            int speed = getSpeed();
            if (speed > 0) {
                Cell destinationArea = getNextArea(currentArea, speed);
                Set<Inhabitant> currentAreaOrganisms = currentArea.getInhabitants().get(this.getType());
                currentAreaOrganisms.remove(this);

                Set<Inhabitant> destinationAreaOrganisms = destinationArea.getInhabitants().get(this.getType());
                destinationAreaOrganisms.add(this);
            }
        } finally {
            currentArea.getLock().unlock();
        }
    }

    private int getSpeed() {
        int maxSpeed = GameSettings.get().getOrganismParametersByType(this.getType()).getMaxSpeed();
        return Randomizer.getRandom(0, maxSpeed);
    }

    private Cell getNextArea(Cell currentArea, int currentSpeed) {
        List<Cell> nearestAreas = currentArea.getNearestAreas();
        if (currentSpeed > 0) {
            int nextAreaIndex = Randomizer.getRandom(0, nearestAreas.size());
            if (nextAreaIndex == 0) {
                return getNextArea(currentArea, currentSpeed - 1);
            } else {
                return getNextArea(nearestAreas.get(nextAreaIndex - 1), currentSpeed - 1);
            }
        } else {
            return currentArea;
        }
    }


}

