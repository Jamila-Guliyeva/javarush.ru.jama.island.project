package ru.javarush.jama.island.settings;

import ru.javarush.jama.island.location.IslandMap;

public class Initializer {

    public IslandMap createIslandMap() {
        MapCreator worldCreator = new MapCreator();
        return worldCreator.createIslandMap();
    }
}
