package com.Island.Project.animals.herbivores;

import com.Island.Project.animals.Movable;
import com.Island.Project.constants.Parameters;

public class Rabbit extends Herbivore implements Movable {

    public int maxSpeed = 2;

    public Rabbit(Parameters parameters) {
        super(parameters);
    }

}
