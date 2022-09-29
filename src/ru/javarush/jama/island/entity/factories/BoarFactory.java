package ru.javarush.jama.island.entity.factories;

import ru.javarush.jama.island.entity.Inhabitant;
import ru.javarush.jama.island.entity.herbivores.Boar;


public class BoarFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Boar();
    }
}
