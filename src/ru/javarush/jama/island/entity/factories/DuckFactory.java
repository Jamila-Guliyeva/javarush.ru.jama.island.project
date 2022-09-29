package ru.javarush.jama.island.entity.factories;

import ru.javarush.jama.island.entity.Inhabitant;
import ru.javarush.jama.island.entity.herbivores.Duck;


public class DuckFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Duck();
    }
}
