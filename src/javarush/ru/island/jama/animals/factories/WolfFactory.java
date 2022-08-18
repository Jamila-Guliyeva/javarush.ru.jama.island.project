package javarush.ru.island.jama.animals.factories;
import javarush.ru.island.jama.animals.predators.Wolf;
import javarush.ru.island.jama.animals.Inhabitant;

public class WolfFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Wolf();
    }
}
