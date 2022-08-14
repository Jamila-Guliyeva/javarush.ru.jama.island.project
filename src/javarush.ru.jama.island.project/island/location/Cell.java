package javarush.ru.jama.island.project.island.location;
import javarush.ru.jama.island.project.island.animals.Inhabitant;
import javarush.ru.jama.island.project.island.animals.OrganismsList;
import javarush.ru.jama.island.project.island.constants.Parameters;
import javarush.ru.jama.island.project.island.settings.GameSettings;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cell {

    private Map<OrganismsList, Set<Inhabitant>> inhabitants;
    private List<Cell> nearestCells;
    private final Lock lock = new ReentrantLock(true);

    public Map<OrganismsList, Set<Inhabitant>> getInhabitants() {
        return inhabitants;
    }

    public void setInhabitants(Map<OrganismsList, Set<Inhabitant>> inhabitants) {
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

    public void addInhabitant(OrganismsList organismType, Inhabitant newPlant) {
        inhabitants.get(organismType).add(newPlant);
    }

}
