package ru.javarush.jama.island.location;

public class IslandMap {
    private final Cell[][] areas;

    public IslandMap(int rows, int cols) {
        areas = new Cell[rows][cols];
    }

    public Cell[][] getCells() {
        return areas;
    }
}

