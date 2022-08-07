package com.Island.Project.animals.predators;
import com.Island.Project.animals.Inhabitant;
import com.Island.Project.animals.Movable;
import com.Island.Project.animals.herbivores.*;
import com.Island.Project.animals.OrganismsList;
import com.Island.Project.constants.Parameters;
import com.Island.Project.settings.Cell;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Wolf extends Predator implements Movable {

    public int maxSpeed = 2;

    public Wolf(Parameters parameters) {
        super(parameters);
    }

    @Override
    public void eat(Cell cell) {
        int wolfFood = ThreadLocalRandom.current().nextInt(0, 100);
        Iterator<Map.Entry<OrganismsList, List<? extends Inhabitant>>> organismsListSetIterator = cell.organismsMap.entrySet().iterator();
        while (organismsListSetIterator.hasNext()) {
            Map.Entry<OrganismsList, List<? extends Inhabitant>> temp = organismsListSetIterator.next();
            List<? extends Inhabitant> animalSet = temp.getValue();
            Iterator<? extends Inhabitant> iterator = animalSet.iterator();
            while (iterator.hasNext()) {
                if ((iterator.next() instanceof Mouse && wolfFood <= 80)) {
                    if ((this.getCurrentWeight() + iterator.next().getCurrentWeight()) <= this.getMaxWeight()) {
                        iterator.remove();
                        this.setCurrentWeight(this.getCurrentWeight() + iterator.next().getCurrentWeight());
                    }
                }

                if ((iterator.next() instanceof Sheep && wolfFood <= 70)) {
                    if ((this.getCurrentWeight() + iterator.next().getCurrentWeight()) <= this.getMaxWeight()) {
                        iterator.remove();
                        this.setCurrentWeight(this.getCurrentWeight() + iterator.next().getCurrentWeight());
                    }
                }


                if (((iterator.next() instanceof Rabbit) || iterator.next() instanceof Goat) && wolfFood <= 60) {
                    if ((this.getCurrentWeight() + iterator.next().getCurrentWeight()) <= this.getMaxWeight()) {
                        iterator.remove();
                        this.setCurrentWeight(this.getCurrentWeight() + iterator.next().getCurrentWeight());
                    }
                }

                if ((iterator.next() instanceof Duck && wolfFood <= 40)) {
                    if ((this.getCurrentWeight() + iterator.next().getCurrentWeight()) <= this.getMaxWeight()) {
                        iterator.remove();
                        this.setCurrentWeight(this.getCurrentWeight() + iterator.next().getCurrentWeight());
                    }
                }

                if ((iterator.next() instanceof Deer || iterator.next() instanceof Boar) && wolfFood <= 15) {
                    if ((this.getCurrentWeight() + iterator.next().getCurrentWeight()) <= this.getMaxWeight()) {
                        iterator.remove();
                        this.setCurrentWeight(this.getCurrentWeight() + iterator.next().getCurrentWeight());
                    }
                }

                if ((iterator.next() instanceof Horse || iterator.next() instanceof Buffalo) && wolfFood <= 10) {
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
