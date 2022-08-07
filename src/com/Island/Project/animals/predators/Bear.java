package com.Island.Project.animals.predators;

import com.Island.Project.animals.Animal;
import com.Island.Project.animals.Inhabitant;
import com.Island.Project.animals.Movable;
import com.Island.Project.animals.herbivores.*;
import com.Island.Project.animals.OrganismsList;
import com.Island.Project.constants.Parameters;
import com.Island.Project.settings.Cell;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Bear extends Predator implements Movable {

    public int maxSpeed = 2;

    public Bear(Parameters parameters) {
        super(parameters);
    }

    public void eat(Cell cell) {
        int bearFood = ThreadLocalRandom.current().nextInt(0, 100);
        Iterator<Map.Entry<OrganismsList, Set<Inhabitant>>> organismsListSetIterator = cell.organismsMap.entrySet().iterator();
        while (organismsListSetIterator.hasNext()) {
            Map.Entry<OrganismsList, Set<Inhabitant>> temp = organismsListSetIterator.next();
            Set<Inhabitant> animalSet = temp.getValue();
            Iterator<Inhabitant> iterator = animalSet.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() instanceof Mouse && bearFood >= 90) {
                    if ((this.getCurrentWeight() + iterator.next().getCurrentWeight()) <= this.getMaxWeight()) {
                        iterator.remove();
                        this.setCurrentWeight(this.getCurrentWeight() + iterator.next().getCurrentWeight());
                    }
                }

                if ((iterator.next() instanceof Rabbit || iterator.next() instanceof Deer
                        || iterator.next() instanceof Boa) && bearFood <= 80) {
                    if ((this.getCurrentWeight() + iterator.next().getCurrentWeight()) <= this.getMaxWeight()) {
                        iterator.remove();
                        this.setCurrentWeight(this.getCurrentWeight() + iterator.next().getCurrentWeight());
                    }
                }

                if ((iterator.next() instanceof Goat || iterator.next() instanceof Sheep)&& bearFood <= 70) {
                    if ((this.getCurrentWeight() + iterator.next().getCurrentWeight()) <= this.getMaxWeight()) {
                        iterator.remove();
                        this.setCurrentWeight(this.getCurrentWeight() + iterator.next().getCurrentWeight());
                    }
                }

                if (iterator.next() instanceof Boa && bearFood <= 50) {
                    if ((this.getCurrentWeight() + iterator.next().getCurrentWeight()) <= this.getMaxWeight()) {
                        iterator.remove();
                        this.setCurrentWeight(this.getCurrentWeight() + iterator.next().getCurrentWeight());
                    }
                }

                if (iterator.next() instanceof Horse && bearFood <= 40) {
                    if ((this.getCurrentWeight() + iterator.next().getCurrentWeight()) <= this.getMaxWeight()) {
                        iterator.remove();
                        this.setCurrentWeight(this.getCurrentWeight() + iterator.next().getCurrentWeight());
                    }
                }

                if (iterator.next() instanceof Buffalo && bearFood <= 20) {
                    if ((this.getCurrentWeight() + iterator.next().getCurrentWeight()) <= this.getMaxWeight()) {
                        iterator.remove();
                        this.setCurrentWeight(this.getCurrentWeight() + iterator.next().getCurrentWeight());
                    }
                }

                if (iterator.next() instanceof Duck && bearFood <= 10) {
                    if ((this.getCurrentWeight() + iterator.next().getCurrentWeight()) <= this.getMaxWeight()) {
                        iterator.remove();
                        this.setCurrentWeight(this.getCurrentWeight() + iterator.next().getCurrentWeight());
                    }
                }
                else return;
            }
        }
    }
}
