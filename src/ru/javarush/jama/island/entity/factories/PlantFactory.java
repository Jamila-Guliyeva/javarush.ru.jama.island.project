package ru.javarush.jama.island.entity.factories;

import ru.javarush.jama.island.entity.Inhabitant;
import ru.javarush.jama.island.plants.Plant;

public class PlantFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Plant();
    }
}
