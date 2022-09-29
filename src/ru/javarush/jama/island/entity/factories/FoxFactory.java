package ru.javarush.jama.island.entity.factories;

import ru.javarush.jama.island.entity.Inhabitant;
import ru.javarush.jama.island.entity.predators.Fox;


public class FoxFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Fox();
    }
}
