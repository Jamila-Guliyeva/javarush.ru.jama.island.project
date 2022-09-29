package ru.javarush.jama.island.entity.factories;

import ru.javarush.jama.island.entity.herbivores.Mouse;
import ru.javarush.jama.island.entity.Inhabitant;

public class MouseFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Mouse();
    }
}
