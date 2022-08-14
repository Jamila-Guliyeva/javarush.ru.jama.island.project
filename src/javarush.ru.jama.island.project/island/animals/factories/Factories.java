package javarush.ru.jama.island.project.island.animals.factories;
import javarush.ru.jama.island.project.island.animals.Inhabitant;
import javarush.ru.jama.island.project.island.animals.OrganismsList;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Factories {

    private static volatile Factories FACTORIES;
    private final Map<OrganismsList, InhabitantFactory> factoriesMap;

    private Factories() {
        factoriesMap = new HashMap<>();
        factoriesMap.put(OrganismsList.BEAR, new BearFactory());
        factoriesMap.put(OrganismsList.BOA, new BoaFactory());
        factoriesMap.put(OrganismsList.EAGLE, new EagleFactory());
        factoriesMap.put(OrganismsList.FOX, new FoxFactory());
        factoriesMap.put(OrganismsList.WOLF, new WolfFactory());
        factoriesMap.put(OrganismsList.BOAR, new BoarFactory());
        factoriesMap.put(OrganismsList.BUFFALO, new BuffaloFactory());
        factoriesMap.put(OrganismsList.CATERPILLAR, new CaterpillarFactory());
        factoriesMap.put(OrganismsList.DEER, new DeerFactory());
        factoriesMap.put(OrganismsList.DUCK, new DuckFactory());
        factoriesMap.put(OrganismsList.GOAT, new GoatFactory());
        factoriesMap.put(OrganismsList.HORSE, new HorseFactory());
        factoriesMap.put(OrganismsList.MOUSE, new MouseFactory());
        factoriesMap.put(OrganismsList.RABBIT, new RabbitFactory());
        factoriesMap.put(OrganismsList.SHEEP, new SheepFactory());
        factoriesMap.put(OrganismsList.PLANT, new PlantFactory());
    }

    private static Map<OrganismsList, InhabitantFactory> getFactoriesMap() {
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

    public static Inhabitant createOrganismByType(OrganismsList organismType) {
        return getFactoriesMap().get(organismType).createOrganism();
    }

}
