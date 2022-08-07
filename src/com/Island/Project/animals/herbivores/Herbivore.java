package com.Island.Project.animals.herbivores;
import com.Island.Project.animals.Animal;
import com.Island.Project.animals.Inhabitant;
import com.Island.Project.animals.OrganismsList;
import com.Island.Project.constants.Parameters;
import com.Island.Project.plants.Plant;
import com.Island.Project.settings.Cell;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Herbivore extends Animal {
    public Herbivore(Parameters parameters) {
        super(parameters);
    }

    public void eat(Cell cell) {
        int boarFood = ThreadLocalRandom.current().nextInt(0, 100);
        Iterator<Map.Entry<OrganismsList, Set<Inhabitant>>> organismsListSetIterator = cell.organismsMap.entrySet().iterator();
        while (organismsListSetIterator.hasNext()) {
            Map.Entry<OrganismsList, Set<Inhabitant>> temp = organismsListSetIterator.next();
            Set<Inhabitant> animalSet = temp.getValue();
            Iterator<Inhabitant> iterator = animalSet.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() instanceof Plant && boarFood <= 100) {
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
