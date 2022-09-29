package ru.javarush.jama.island.entity.factories;

import ru.javarush.jama.island.entity.Inhabitant;
import ru.javarush.jama.island.entity.herbivores.Rabbit;


public class RabbitFactory implements InhabitantFactory
{
    @Override
    public Inhabitant createOrganism() {
        return new Rabbit();
    }
}
