package com.Island.Project.settings;


import com.Island.Project.animals.Animal;
import com.Island.Project.animals.Inhabitant;
import com.Island.Project.animals.OrganismsList;
import com.Island.Project.animals.herbivores.Herbivore;
import com.Island.Project.animals.predators.Fox;
import com.Island.Project.animals.predators.Predator;

import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        IslandMap islandMap = new IslandMap();
        islandMap.initialize();
        islandMap.setLife();
        islandMap.printInfo();

        List<? extends Inhabitant> set = islandMap.map[1][1].organismsMap.get(OrganismsList.FOX);

        for (int i = 0; i < set.size(); i++) {
            set.get(i).eat(islandMap.map[1][1]);

        }
        //System.out.println(set.get(1) instanceof Predator);
    }
    }

