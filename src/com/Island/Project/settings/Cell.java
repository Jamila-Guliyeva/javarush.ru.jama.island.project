package com.Island.Project.settings;

import com.Island.Project.animals.Animal;
import com.Island.Project.animals.Inhabitant;
import com.Island.Project.animals.OrganismsList;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Cell {
    private int row;
    private int column;

    public Map<OrganismsList, Set<Inhabitant>> organismsMap = new HashMap<>();

    public void calculate(){
//
    }
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }


    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }



    @Override
    public String toString() {
        return "\t|" + row + "/" + column + "|\t";

    }
}
