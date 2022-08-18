package javarush.ru.island.jama.services;
import javarush.ru.island.jama.animals.Animal;
import javarush.ru.island.jama.animals.Inhabitant;
import javarush.ru.island.jama.location.Cell;

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
