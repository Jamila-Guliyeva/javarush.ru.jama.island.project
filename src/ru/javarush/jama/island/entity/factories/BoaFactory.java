package ru.javarush.jama.island.entity.factories;

import ru.javarush.jama.island.entity.Inhabitant;
import ru.javarush.jama.island.entity.predators.Boa;

public class BoaFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Boa();
    }
}
