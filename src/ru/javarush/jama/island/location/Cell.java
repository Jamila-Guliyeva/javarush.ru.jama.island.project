package ru.javarush.jama.island.location;

import ru.javarush.jama.island.entity.Inhabitant;
import ru.javarush.jama.island.entity.OrganismsType;
import ru.javarush.jama.island.constants.Parameters;
import ru.javarush.jama.island.settings.GameSettings;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cell {

    private Map<OrganismsType, Set<Inhabitant>> inhabitants;
    private List<Cell> nearestCells;
    private final Lock lock = new ReentrantLock(true);

    public Map<OrganismsType, Set<Inhabitant>> getInhabitants() {
        return inhabitants;
    }

    public void setInhabitants(Map<OrganismsType, Set<Inhabitant>> inhabitants) {
        this.inhabitants = inhabitants;
    }

    public List<Cell> getNearestAreas() {
        return nearestCells;
    }

    public void setNearestAreas(List<Cell> nearestAreas) {
        this.nearestCells = nearestAreas;
    }

    public Lock getLock() {
        return lock;
    }

    @Override
    public String toString() {
        HashMap<String, Long> areaStatistics = new HashMap<>();


        inhabitants.entrySet()
                .forEach(entry -> {
                    Parameters organismCommonSpecs = GameSettings.get().getOrganismParametersByType(entry.getKey());
                    String icon = organismCommonSpecs.getIcon();
                    long count = entry.getValue().size();
                    areaStatistics.put(icon, count);
                });
        return areaStatistics.toString();
    }

    public void addInhabitant(OrganismsType organismType, Inhabitant newPlant) {
        inhabitants.get(organismType).add(newPlant);
    }

}
