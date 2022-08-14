package javarush.ru.jama.island.project.island.animals.factories;

import javarush.ru.jama.island.project.island.animals.Inhabitant;
import javarush.ru.jama.island.project.island.plants.Plant;

public class PlantFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Plant();
    }
}
