package com.Island.Project.animals.herbivores;

import com.Island.Project.animals.Movable;
import com.Island.Project.constants.Parameters;

public class Horse extends Herbivore implements Movable {

    public int maxSpeed = 4;

    public Horse(Parameters parameters) {
        super(parameters);
    }


}
