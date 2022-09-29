package ru.javarush.jama.island.entity.factories;

import ru.javarush.jama.island.entity.Inhabitant;
import ru.javarush.jama.island.entity.herbivores.Caterpillar;

public class CaterpillarFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Caterpillar();
    }
}
