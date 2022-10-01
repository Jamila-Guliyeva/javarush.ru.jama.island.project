package ru.javarush.jama.island.entity.factories;

import ru.javarush.jama.island.entity.Inhabitant;
import ru.javarush.jama.island.entity.OrganismsType;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Factories {

    private static volatile Factories FACTORIES;
    private final Map<OrganismsType, InhabitantFactory> factoriesMap;

    private Factories() {
        factoriesMap = new HashMap<>();
        factoriesMap.put(OrganismsType.BEAR, new BearFactory());
        factoriesMap.put(OrganismsType.BOA, new BoaFactory());
        factoriesMap.put(OrganismsType.EAGLE, new EagleFactory());
        factoriesMap.put(OrganismsType.FOX, new FoxFactory());
        factoriesMap.put(OrganismsType.WOLF, new WolfFactory());
        factoriesMap.put(OrganismsType.BOAR, new BoarFactory());
        factoriesMap.put(OrganismsType.BUFFALO, new BuffaloFactory());
        factoriesMap.put(OrganismsType.CATERPILLAR, new CaterpillarFactory());
        factoriesMap.put(OrganismsType.DEER, new DeerFactory());
        factoriesMap.put(OrganismsType.DUCK, new DuckFactory());
        factoriesMap.put(OrganismsType.GOAT, new GoatFactory());
        factoriesMap.put(OrganismsType.HORSE, new HorseFactory());
        factoriesMap.put(OrganismsType.MOUSE, new MouseFactory());
        factoriesMap.put(OrganismsType.RABBIT, new RabbitFactory());
        factoriesMap.put(OrganismsType.SHEEP, new SheepFactory());
        factoriesMap.put(OrganismsType.PLANT, new PlantFactory());
    }

    private static Map<OrganismsType, InhabitantFactory> getFactoriesMap() {
        Factories factories = FACTORIES;
        if (Objects.isNull(factories)) {
            synchronized (Factories.class) {
                if (Objects.isNull(factories = FACTORIES)) {
                    factories = FACTORIES = new Factories();
                }
            }
        }
        return factories.factoriesMap;
    }

    public static Inhabitant createOrganismByType(OrganismsType organismType) {
        return getFactoriesMap().get(organismType).createOrganism();
    }

}
