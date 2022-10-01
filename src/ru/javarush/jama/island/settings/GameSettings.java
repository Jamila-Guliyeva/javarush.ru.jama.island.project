package ru.javarush.jama.island.settings;

import ru.javarush.jama.island.constants.Parameters;
import ru.javarush.jama.island.entity.OrganismsType;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class GameSettings {

    private static final String INIT_FILE = "ru/javarush/jama/island/file.yml";
    private static volatile GameSettings SETTINGS;
    private int mapRows;
    private int mapCols;
    private int cycleDuration;
    private Map<OrganismsType, Integer> organismsInitialQuantity;
    private Boolean stopOnTimeout;
    private int gameDuration;
    private Map<OrganismsType, Integer> organismsChildrenQuantity;
    private Map<OrganismsType, Map<OrganismsType, Integer>> chanceToGetEat;
    private Map<OrganismsType, Parameters> organismsParameters;
    private List<OrganismsType> organismsTypes;
    private int initialBirthPercent;
    private int unviableWeightPercent;
    private int animalGrowUpPercent;
    private int plantGrowUpPercent;

    private GameSettings() {
        try {
            URL resource = GameSettings.class.getClassLoader().getResource(INIT_FILE);
            ObjectReader objectReader = new YAMLMapper().readerForUpdating(this);
            if (Objects.nonNull(resource)) {
                objectReader.readValue(resource.openStream());
            }

            organismsTypes = new ArrayList<>(organismsParameters.keySet());
        } catch (IOException e) {
            System.out.printf("File access error: %s", e);
        }
    }

    public int getMapRows() {
        return mapRows;
    }

    public int getMapCols() {
        return mapCols;
    }

    public Map<OrganismsType, Integer> getOrganismsInitialQuantity() {
        return organismsInitialQuantity;
    }

    public int getCycleDuration() {
        return cycleDuration;
    }

    public Boolean getStopOnTimeout() {
        return stopOnTimeout;
    }

    public int getGameDuration() {
        return gameDuration;
    }

    public Map<OrganismsType, Integer> getOrganismsChildrenQuantity() {
        return organismsChildrenQuantity;
    }

    public Map<OrganismsType, Map<OrganismsType, Integer>> getChanceToGetEat() {
        return chanceToGetEat;
    }

    public Map<OrganismsType, Parameters> getOrganismsParameters() {
        return organismsParameters;
    }

    public List<OrganismsType> getOrganismsTypes() {
        return organismsTypes;
    }

    public Parameters getOrganismParametersByType(OrganismsType organismType) {
        return organismsParameters.get(organismType);
    }

    public int getInitialBirthPercent() {
        return initialBirthPercent;
    }

    public int getUnviableWeightPercent() {
        return unviableWeightPercent;
    }

    public int getAnimalGrowUpPercent() {
        return animalGrowUpPercent;
    }

    public int getPlantGrowUpPercent() {
        return plantGrowUpPercent;
    }

    public static GameSettings get() {
        GameSettings settings = SETTINGS;

        if (Objects.isNull(settings)) {
            synchronized (GameSettings.class) {
                if (Objects.isNull(settings = SETTINGS)) {
                    settings = SETTINGS = new GameSettings();
                }
            }
        }

        return settings;
    }


}
