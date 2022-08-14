package javarush.ru.jama.island.project.island.settings;
import javarush.ru.jama.island.project.island.animals.Inhabitant;
import javarush.ru.jama.island.project.island.animals.OrganismsList;
import javarush.ru.jama.island.project.island.location.Cell;
import javarush.ru.jama.island.project.island.location.IslandMap;
import javarush.ru.jama.island.project.island.animals.factories.Factories;
import javarush.ru.jama.island.project.island.util.Randomizer;

import java.util.*;

public class MapCreator {
    public IslandMap createIslandMap() {
        IslandMap world = new IslandMap(GameSettings.get().getMapRows(), GameSettings.get().getMapCols());
        createAreas(world);
        findNearestAreas(world);

        return world;
    }

    private void createAreas(IslandMap world) {
        Cell[][] areas = world.getCells();

        for (int row = 0; row < areas.length; row++) {
            for (int col = 0; col < areas[row].length; col++) {
                areas[row][col] = createRandomArea();
            }
        }
    }

    private Cell createRandomArea() {
        GameSettings settings = GameSettings.get();
        Map<OrganismsList, Integer> organismsInitialQuantityMap = settings.getOrganismsInitialQuantity();
        int initialBirthPercent = settings.getInitialBirthPercent();
        Map<OrganismsList, Set<Inhabitant>> inhabitants = new HashMap<>();

        for (Map.Entry<OrganismsList, Integer> entry : organismsInitialQuantityMap.entrySet()) {
            OrganismsList organismType = entry.getKey();
            Integer organismQuantity = entry.getValue();

            Set<Inhabitant> organismSet = new HashSet<>();
            for (int i = 0; i < organismQuantity; i++) {
                if (Randomizer.getProbability(initialBirthPercent)) {
                    organismSet.add(Factories.createOrganismByType(OrganismsList.valueOf(organismType.toString().toUpperCase(Locale.ROOT))));
                }
            }
            inhabitants.put(organismType, organismSet);
        }

        Cell newArea = new Cell();
        newArea.setInhabitants(inhabitants);

        return newArea;
    }

    private void findNearestAreas(IslandMap world) {
        Cell[][] areas = world.getCells();

        for (int row = 0; row < areas.length; row++) {
            for (int col = 0; col < areas[row].length; col++) {
                List<Cell> nearestAreas = new ArrayList<>();

                if (row > 0) {
                    nearestAreas.add(areas[row - 1][col]);
                }
                if (col > 0) {
                    nearestAreas.add(areas[row][col - 1]);
                }
                if (row < areas.length - 1) {
                    nearestAreas.add(areas[row + 1][col]);
                }
                if (col < areas[row].length - 1) {
                    nearestAreas.add(areas[row][col + 1]);
                }

                areas[row][col].setNearestAreas(nearestAreas);
            }
        }
    }


}
