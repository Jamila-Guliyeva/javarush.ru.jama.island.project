package ru.javarush.jama.island.settings;

import ru.javarush.jama.island.location.Cell;
import ru.javarush.jama.island.location.IslandMap;

public class Satistics {
    private final IslandMap world;
    public Satistics(IslandMap world) {
        this.world = world;
    }
    public IslandMap getIslandMap() {
        return world;
    }

    public void showStatistics() {
        Cell[][] areas = world.getCells();
        for (int i = 0; i < areas.length; i++) {
            for (int j = 0; j < areas[i].length; j++) {
                int rowNumber = String.valueOf(GameSettings.get().getMapRows()).length();
                int colNumber = String.valueOf(GameSettings.get().getMapCols()).length();
                System.out.printf("%0" + rowNumber + "d/%0" + colNumber + "d    %s\n", i + 1, j + 1, areas[i][j]);
            }
        }
        System.out.println(".=.".repeat(37));
    }
}
