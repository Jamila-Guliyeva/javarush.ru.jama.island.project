package com.Island.Project.animals.herbivores;

import com.Island.Project.animals.Animal;
import com.Island.Project.animals.Inhabitant;
import com.Island.Project.animals.Movable;
import com.Island.Project.animals.OrganismsList;
import com.Island.Project.constants.Parameters;
import com.Island.Project.plants.Plant;
import com.Island.Project.settings.Cell;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Boar extends Herbivore implements Movable {
    public int maxSpeed = 2;

    public Boar(Parameters parameters) {
        super(parameters);
    }

    public void eat(Cell cell) {
        int boarFood = ThreadLocalRandom.current().nextInt(0, 100);
        Iterator<Map.Entry<OrganismsList, List<? extends Inhabitant>>> organismsListSetIterator = cell.organismsMap.entrySet().iterator();
        while (organismsListSetIterator.hasNext()) {
            Map.Entry<OrganismsList, List<? extends Inhabitant>> temp = organismsListSetIterator.next();
            List<? extends Inhabitant> animalSet = temp.getValue();
            Iterator<? extends Inhabitant> iterator = animalSet.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() instanceof Plant && boarFood <= 100) {
                    if ((this.getCurrentWeight() + iterator.next().getCurrentWeight()) <= this.getMaxWeight()) {
                        iterator.remove();
                        this.setCurrentWeight(this.getCurrentWeight() + iterator.next().getCurrentWeight());
                    }
                }

                if (iterator.next() instanceof Caterpillar && boarFood <= 90) {
                    if ((this.getCurrentWeight() + iterator.next().getCurrentWeight()) <= this.getMaxWeight()) {
                        iterator.remove();
                        this.setCurrentWeight(this.getCurrentWeight() + iterator.next().getCurrentWeight());
                    }
                }

                if (iterator.next() instanceof Mouse && boarFood <= 50) {
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
