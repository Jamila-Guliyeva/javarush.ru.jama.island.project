package com.Island.Project.plants;
import com.Island.Project.animals.Inhabitant;
import com.Island.Project.constants.Parameters;
import com.Island.Project.settings.Cell;

public class Plant extends Inhabitant {

    public Plant(Parameters parameters) {
        super(parameters);
    }

    public Cell findNextPosition(Cell cell) {
        return cell;
    }

}
