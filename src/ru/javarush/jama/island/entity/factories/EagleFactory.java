package ru.javarush.jama.island.entity.factories;

import ru.javarush.jama.island.entity.Inhabitant;
import ru.javarush.jama.island.entity.predators.Eagle;


public class EagleFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Eagle();
    }
}
