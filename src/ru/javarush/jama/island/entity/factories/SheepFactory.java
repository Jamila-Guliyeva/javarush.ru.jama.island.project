package ru.javarush.jama.island.entity.factories;

import ru.javarush.jama.island.entity.Inhabitant;
import ru.javarush.jama.island.entity.herbivores.Sheep;

public class SheepFactory implements InhabitantFactory {

    @Override
    public Inhabitant createOrganism() {
        return new Sheep();
    }
}
