package com.Island.Project.settings;

import com.Island.Project.animals.Animal;
import com.Island.Project.animals.Inhabitant;
import com.Island.Project.animals.herbivores.*;
import com.Island.Project.animals.OrganismsList;
import com.Island.Project.animals.predators.*;
import com.Island.Project.constants.GameSettings;
import com.Island.Project.constants.Parameters;

import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.prefs.Preferences;

public class IslandMap {
    Coordinates coordinates;
    //public static Cell cell;
    public Cell[][] map = new Cell[5][5];

    public void initialize(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = new Cell(i, j);
            }

        }
    }

    public void setLife(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int number = ThreadLocalRandom.current().nextInt
                        (0, GameSettings.getInstance().getParameters().get(OrganismsList.BEAR).getMaxNumber());
                List<Inhabitant> set = new ArrayList<>();
                for (int k = 0; k < number; k++) {
                set.add(new Bear(GameSettings.getInstance().getParameters().get(OrganismsList.BEAR)));
                }
                map[i][j].organismsMap.put(OrganismsList.BEAR, set);


                number = ThreadLocalRandom.current().nextInt
                        (0, GameSettings.getInstance().getParameters().get(OrganismsList.BOA).getMaxNumber());
                set = new ArrayList<>();
                for (int k = 0; k < number; k++) {
                    set.add(new Boa(GameSettings.getInstance().getParameters().get(OrganismsList.BOA)));
                }
                map[i][j].organismsMap.put(OrganismsList.BOA, set);

                number = ThreadLocalRandom.current().nextInt
                        (0, GameSettings.getInstance().getParameters().get(OrganismsList.EAGLE).getMaxNumber());
                set = new ArrayList<>();
                for (int k = 0; k < number; k++) {
                    set.add(new Eagle(GameSettings.getInstance().getParameters().get(OrganismsList.EAGLE)));
                }
                map[i][j].organismsMap.put(OrganismsList.EAGLE, set);

                number = ThreadLocalRandom.current().nextInt
                        (0, GameSettings.getInstance().getParameters().get(OrganismsList.FOX).getMaxNumber());
                set = new ArrayList<>();
                for (int k = 0; k < number; k++) {
                    set.add(new Fox(GameSettings.getInstance().getParameters().get(OrganismsList.FOX)));
                }
                map[i][j].organismsMap.put(OrganismsList.FOX, set);

                number = ThreadLocalRandom.current().nextInt
                        (0, GameSettings.getInstance().getParameters().get(OrganismsList.WOLF).getMaxNumber());
                set = new ArrayList<>();                for (int k = 0; k < number; k++) {
                    set.add(new Wolf(GameSettings.getInstance().getParameters().get(OrganismsList.WOLF)));
                }
                map[i][j].organismsMap.put(OrganismsList.WOLF, set);

                number = ThreadLocalRandom.current().nextInt
                        (0, GameSettings.getInstance().getParameters().get(OrganismsList.BOAR).getMaxNumber());
                set = new ArrayList<>();
                for (int k = 0; k < number; k++) {
                    set.add(new Bear(GameSettings.getInstance().getParameters().get(OrganismsList.BOAR)));
                }
                map[i][j].organismsMap.put(OrganismsList.BOAR, set);

                number = ThreadLocalRandom.current().nextInt
                        (0, GameSettings.getInstance().getParameters().get(OrganismsList.BUFFALO).getMaxNumber());
                set = new ArrayList<>();
                for (int k = 0; k < number; k++) {
                    set.add(new Buffalo(GameSettings.getInstance().getParameters().get(OrganismsList.BUFFALO)));
                }
                map[i][j].organismsMap.put(OrganismsList.BUFFALO, set);


                number = ThreadLocalRandom.current().nextInt
                        (0, GameSettings.getInstance().getParameters().get(OrganismsList.CATERPILLAR).getMaxNumber());
                set = new ArrayList<>();
                for (int k = 0; k < number; k++) {
                    set.add(new Caterpillar(GameSettings.getInstance().getParameters().get(OrganismsList.CATERPILLAR)));
                }
                map[i][j].organismsMap.put(OrganismsList.CATERPILLAR, set);


                number = ThreadLocalRandom.current().nextInt
                        (0, GameSettings.getInstance().getParameters().get(OrganismsList.DEER).getMaxNumber());
                set = new ArrayList<>();
                for (int k = 0; k < number; k++) {
                    set.add(new Deer(GameSettings.getInstance().getParameters().get(OrganismsList.DEER)));
                }
                map[i][j].organismsMap.put(OrganismsList.DEER, set);

                number = ThreadLocalRandom.current().nextInt
                        (0, GameSettings.getInstance().getParameters().get(OrganismsList.DUCK).getMaxNumber());
                set = new ArrayList<>();
                for (int k = 0; k < number; k++) {
                    set.add(new Duck(GameSettings.getInstance().getParameters().get(OrganismsList.DUCK)));
                }
                map[i][j].organismsMap.put(OrganismsList.DUCK, set);

                number = ThreadLocalRandom.current().nextInt
                        (0, GameSettings.getInstance().getParameters().get(OrganismsList.GOAT).getMaxNumber());
                set = new ArrayList<>();
                for (int k = 0; k < number; k++) {
                    set.add(new Goat(GameSettings.getInstance().getParameters().get(OrganismsList.GOAT)));
                }
                map[i][j].organismsMap.put(OrganismsList.GOAT, set);

                number = ThreadLocalRandom.current().nextInt
                        (0, GameSettings.getInstance().getParameters().get(OrganismsList.HORSE).getMaxNumber());
                set = new ArrayList<>();
                for (int k = 0; k < number; k++) {
                    set.add(new Horse(GameSettings.getInstance().getParameters().get(OrganismsList.HORSE)));
                }
                map[i][j].organismsMap.put(OrganismsList.HORSE, set);

                number = ThreadLocalRandom.current().nextInt
                        (0, GameSettings.getInstance().getParameters().get(OrganismsList.MOUSE).getMaxNumber());
                set = new ArrayList<>();
                for (int k = 0; k < number; k++) {
                    set.add(new Mouse(GameSettings.getInstance().getParameters().get(OrganismsList.MOUSE)));
                }
                map[i][j].organismsMap.put(OrganismsList.MOUSE, set);

                number = ThreadLocalRandom.current().nextInt
                        (0, GameSettings.getInstance().getParameters().get(OrganismsList.RABBIT).getMaxNumber());
                set = new ArrayList<>();
                for (int k = 0; k < number; k++) {
                    set.add(new Rabbit(GameSettings.getInstance().getParameters().get(OrganismsList.RABBIT)));
                }
                map[i][j].organismsMap.put(OrganismsList.RABBIT, set);

                number = ThreadLocalRandom.current().nextInt
                        (0, GameSettings.getInstance().getParameters().get(OrganismsList.SHEEP).getMaxNumber());
                set = new ArrayList<>();
                for (int k = 0; k < number; k++) {
                    set.add(new Sheep(GameSettings.getInstance().getParameters().get(OrganismsList.SHEEP)));
                }
                map[i][j].organismsMap.put(OrganismsList.SHEEP, set);
            }
        }

    }
    public void print(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public void printInfo() {
        Map<String, Integer> set = new HashMap<>();
        for (Cell[] row : map) {
            for (Cell cell : row) {
                System.out.print("|\t");
                Map<OrganismsList, List<? extends Inhabitant>> organismsMap = cell.organismsMap;
                organismsMap.values()
                        .stream()
                        .filter(s -> s.size() > 0)
                        .forEach(s -> set.put(s.stream().findFirst().get().toString(), s.size()));
                System.out.print(set);
                System.out.print("|\t");
            }
            System.out.println();
        }
    }

    public void countOrganisms() {

        Map<OrganismsList, Integer> organismQuantities = new HashMap<>();

        Map<OrganismsList, Parameters> preferencesMap = GameSettings.getInstance().getParameters();
        for (OrganismsList organismsList: preferencesMap.keySet()) {
            organismQuantities.put(organismsList, 0);
        }

        for (Cell[] row : map) {
            for (Cell cell : row) {
                Map<OrganismsList, List<? extends Inhabitant>> organisms = cell.organismsMap;
                for (Map.Entry<OrganismsList, List<? extends Inhabitant>> organism : organisms.entrySet()) {
                    organismQuantities.put(organism.getKey(), organism.getValue().size());
                }
            }
        }
        System.out.println("Total Statistics fot Island is: " + organismQuantities);
    }

//    public void actions() {
//
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[i].length; j++) {
//                Map<OrganismsList, Set<Inhabitant>> inhabitants = map[i][j].organismsMap;
//                Map<OrganismsList, Set<Inhabitant>> inhabitantsCopy = new HashMap<>(inhabitants);
//                Iterator<Map.Entry<OrganismsList, Set<Inhabitant>>> organismsListSetIterator = inhabitantsCopy.entrySet().iterator();
//                while (organismsListSetIterator.hasNext()) {
//                    Map.Entry<OrganismsList, Set<Inhabitant>> temp = organismsListSetIterator.next();
//                    Iterator<Inhabitant> iterator = temp.getValue().iterator();
//                    while (iterator.hasNext()) {
//                        System.out.println(iterator.next().getMaxSpeed());
//                    }
//                }
//            }
//        }
//    }

}
