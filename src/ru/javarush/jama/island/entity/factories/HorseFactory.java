package ru.javarush.jama.island.entity.factories;

import ru.javarush.jama.island.entity.Inhabitant;
import ru.javarush.jama.island.entity.herbivores.Horse;

public class HorseFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Horse();
    }
}
