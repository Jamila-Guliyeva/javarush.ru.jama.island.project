package ru.javarush.jama.island.entity.factories;

import ru.javarush.jama.island.entity.Inhabitant;
import ru.javarush.jama.island.entity.predators.Bear;

public class BearFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Bear();
    }
}
