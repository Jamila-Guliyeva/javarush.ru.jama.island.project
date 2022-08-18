package javarush.ru.island.jama.animals.factories;
import javarush.ru.island.jama.animals.predators.Fox;
import javarush.ru.island.jama.animals.Inhabitant;

public class FoxFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Fox();
    }
}
