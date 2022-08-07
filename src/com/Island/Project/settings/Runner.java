package com.Island.Project.settings;

import com.Island.Project.animals.Animal;
import com.Island.Project.animals.Inhabitant;
import com.Island.Project.animals.OrganismsList;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        IslandMap islandMap = new IslandMap();
        islandMap.initialize();
        islandMap.setLife();
        islandMap.printInfo();
        }
    }

