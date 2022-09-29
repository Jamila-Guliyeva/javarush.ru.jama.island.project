package ru.javarush.jama.island;

import ru.javarush.jama.island.location.IslandMap;
import ru.javarush.jama.island.services.GameWorker;
import ru.javarush.jama.island.settings.Initializer;
import ru.javarush.jama.island.settings.Satistics;

public class Runner {
    public static void main(String[] args) {
        Initializer initializer = new Initializer();
        IslandMap map = initializer.createIslandMap();
        Satistics statistics = new Satistics(map);
        GameWorker gameWorker = new GameWorker(statistics);
        gameWorker.start();
    }
}


