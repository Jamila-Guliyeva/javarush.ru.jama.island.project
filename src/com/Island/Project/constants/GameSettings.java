package com.Island.Project.constants;

import com.Island.Project.animals.OrganismsList;

import java.util.HashMap;
import java.util.Map;

public class GameSettings {
    private Map<OrganismsList, Parameters> parameters = new HashMap<OrganismsList, Parameters>();
    private GameSettings() {
        initialize();
    }
    private static final GameSettings instance = new GameSettings();
    public Map<OrganismsList, Parameters> getParameters() {
        return parameters;
    }

    public void initialize() {
        // инициализируем список хищников по умолчанию
        parameters.put(OrganismsList.BEAR, new Parameters("Bear", 500, 510, 580, 5, 2, 80, "\uD83D\uDC3B"));
        parameters.put(OrganismsList.BOA, new Parameters("Boa", 15, 16,18, 30, 1, 2, "\uD83D\uDC0D"));
        parameters.put(OrganismsList.EAGLE, new Parameters("Eagle", 6, 6.5,7, 20, 3, 1, "\uD83E\uDD85"));
        parameters.put(OrganismsList.FOX, new Parameters("Fox", 8, 9, 10, 30, 2, 2, "\uD83E\uDD8A"));
        parameters.put(OrganismsList.WOLF, new Parameters("Wolf", 50, 53, 58, 30, 3, 8, "\uD83D\uDC3A"));
        parameters.put(OrganismsList.BOAR, new Parameters("Boar", 400, 410,  450, 3, 2, 50,  "\uD83D\uDC17"));
        parameters.put(OrganismsList.BUFFALO, new Parameters("Buffalo", 700, 750, 800, 10, 3, 100, "\uD83D\uDC03"));
        parameters.put(OrganismsList.CATERPILLAR, new Parameters("Caterpillar", 0.01, 0.1, 0.01, 1000, 0, 0, "\uD83D\uDC1B"));
        parameters.put(OrganismsList.DEER, new Parameters("Deer", 300, 320,  350, 20, 4, 50, "\uD83E\uDD8C"));
        parameters.put(OrganismsList.DUCK, new Parameters("Duck", 1, 1.05, 1.15, 200, 4, 0.15, "\uD83E\uDD86"));
        parameters.put(OrganismsList.GOAT, new Parameters("Goat", 60, 65,  70, 140, 3, 10, "\uD83D\uDC10"));
        parameters.put(OrganismsList.HORSE, new Parameters("Horse", 400, 420, 460, 20, 4, 60,"\uD83D\uDC0E"));
        parameters.put(OrganismsList.MOUSE, new Parameters("Mouse", 0.05, 0.055, 0.06, 500, 1, 0.01, "\uD83D\uDC01"));
        parameters.put(OrganismsList.RABBIT, new Parameters("Rabbit", 2, 2.1, 2.45, 150, 2, 0.45, "\uD83D\uDC07"));
        parameters.put(OrganismsList.SHEEP, new Parameters("Sheep", 70, 75, 85, 140, 3, 15, "\uD83D\uDC11"));
        parameters.put(OrganismsList.PLANT, new Parameters("Plant", 1, 1, 1, 200, 0, 0, "U+1F335"));

    }


    public static GameSettings getInstance(){
        return instance;
    }
}
