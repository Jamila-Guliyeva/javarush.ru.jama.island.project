package ru.javarush.jama.island.entity.factories;

import ru.javarush.jama.island.entity.Inhabitant;
import ru.javarush.jama.island.entity.herbivores.Goat;

public class GoatFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Goat();
    }
}
