package ru.javarush.jama.island.services;

import ru.javarush.jama.island.entity.Inhabitant;
import ru.javarush.jama.island.entity.OrganismsList;
import ru.javarush.jama.island.location.Cell;
import ru.javarush.jama.island.location.IslandMap;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class OrganismWorker implements Runnable {

    private final OrganismsList organismType;
    private final IslandMap islandMap;
    private final Queue<Task> tasks = new ConcurrentLinkedQueue<>();

    public OrganismWorker(OrganismsList organismType, IslandMap islandMap) {
        this.organismType = organismType;
        this.islandMap = islandMap;
    }

    @Override
    public void run() {
        Cell[][] areas = islandMap.getCells();
        for (Cell[] rows : areas) {
            for (Cell area : rows) {
                createTasksForArea(area);
            }
        }
    }

    private void createTasksForArea(Cell cell) {
        Set<Inhabitant> organisms = cell.getInhabitants().get(organismType);
        if (organisms != null) {
            cell.getLock().lock();
            try {
                for (Inhabitant organism : organisms) {
                    tasks.add(new Task(organism, cell));
                }
            } finally {
                cell.getLock().unlock();
            }
        }

        tasks.forEach(Task::perform);
        tasks.clear();
    }
}
