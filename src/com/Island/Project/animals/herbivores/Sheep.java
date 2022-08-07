package com.Island.Project.animals.herbivores;

import com.Island.Project.animals.Movable;
import com.Island.Project.constants.Parameters;

public class Sheep extends Herbivore implements Movable {

    public int maxSpeed = 3;

    public Sheep(Parameters parameters) {
        super(parameters);
    }

}
