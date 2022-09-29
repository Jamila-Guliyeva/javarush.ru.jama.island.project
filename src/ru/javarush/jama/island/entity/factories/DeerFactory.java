package ru.javarush.jama.island.entity.factories;

import ru.javarush.jama.island.entity.Inhabitant;
import ru.javarush.jama.island.entity.herbivores.Deer;


public class DeerFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Deer();
    }
}
