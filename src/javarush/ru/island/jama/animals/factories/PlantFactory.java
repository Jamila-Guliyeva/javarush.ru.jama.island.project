package javarush.ru.island.jama.animals.factories;

import javarush.ru.island.jama.animals.Inhabitant;
import javarush.ru.island.jama.plants.Plant;

public class PlantFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Plant();
    }
}
