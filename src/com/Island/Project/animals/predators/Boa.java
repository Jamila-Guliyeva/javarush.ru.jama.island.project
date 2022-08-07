package com.Island.Project.animals.predators;

import com.Island.Project.animals.Animal;
import com.Island.Project.animals.Inhabitant;
import com.Island.Project.animals.Movable;
import com.Island.Project.animals.herbivores.Duck;
import com.Island.Project.animals.herbivores.Mouse;
import com.Island.Project.animals.herbivores.Rabbit;
import com.Island.Project.animals.OrganismsList;
import com.Island.Project.constants.Parameters;
import com.Island.Project.settings.Cell;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Boa extends Predator implements Movable {

    public int maxSpeed = 1;

    public Boa(Parameters parameters) {
        super(parameters);
    }

    @Override
    public void eat(Cell cell) {
        int boaFood = ThreadLocalRandom.current().nextInt(0, 100);
        Iterator<Map.Entry<OrganismsList, Set<Inhabitant>>> organismsListSetIterator = cell.organismsMap.entrySet().iterator();
        while (organismsListSetIterator.hasNext()) {
            Map.Entry<OrganismsList, Set<Inhabitant>> temp = organismsListSetIterator.next();
            Set<Inhabitant> animalSet = temp.getValue();
            Iterator<Inhabitant> iterator = animalSet.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() instanceof Mouse && boaFood <= 40) {
                    if ((this.getCurrentWeight() + iterator.next().getCurrentWeight()) <= this.getMaxWeight()) {
                        iterator.remove();
                        this.setCurrentWeight(this.getCurrentWeight() + iterator.next().getCurrentWeight());
                    }
                }

                if (iterator.next() instanceof Rabbit && boaFood <= 20) {
                    if ((this.getCurrentWeight() + iterator.next().getCurrentWeight()) <= this.getMaxWeight()) {
                        iterator.remove();
                        this.setCurrentWeight(this.getCurrentWeight() + iterator.next().getCurrentWeight());
                    }
                }

                if (iterator.next() instanceof Fox && boaFood <= 15) {
                    if ((this.getCurrentWeight() + iterator.next().getCurrentWeight()) <= this.getMaxWeight()) {
                        iterator.remove();
                        this.setCurrentWeight(this.getCurrentWeight() + iterator.next().getCurrentWeight());
                    }
                }

                if (iterator.next() instanceof Duck && boaFood <= 10) {
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
