package ru.javarush.jama.island.entity.factories;

import ru.javarush.jama.island.entity.Inhabitant;
import ru.javarush.jama.island.entity.herbivores.Buffalo;


public class BuffaloFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Buffalo();
    }
}
