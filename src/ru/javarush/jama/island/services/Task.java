package ru.javarush.jama.island.services;

import ru.javarush.jama.island.entity.Animal;
import ru.javarush.jama.island.entity.Inhabitant;
import ru.javarush.jama.island.location.Cell;

public class Task {

    private final Inhabitant organism;
    private final Cell cell;

    public Task(Inhabitant inhabitant, Cell cell) {
        this.organism = inhabitant;
        this.cell = cell;
    }

    public void perform() {
        if (organism instanceof Animal animal) {
            if (animal.eat(cell)) {
                animal.growUp(cell);
                animal.multiply(cell);
            }
            animal.move(cell);
        }

        else {
            organism.growUp(cell);
            organism.multiply(cell);
        }
        organism.starve(cell);
    }

}
