package com.Island.Project.animals.herbivores;

import com.Island.Project.animals.Movable;
import com.Island.Project.constants.Parameters;

public class Goat extends Herbivore implements Movable {

    public int maxSpeed = 3;

    public Goat(Parameters parameters) {
        super(parameters);
    }

}
