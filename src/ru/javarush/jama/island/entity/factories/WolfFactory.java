package ru.javarush.jama.island.entity.factories;

import ru.javarush.jama.island.entity.Inhabitant;
import ru.javarush.jama.island.entity.predators.Wolf;

public class WolfFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Wolf();
    }
}
