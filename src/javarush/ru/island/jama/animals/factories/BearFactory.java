package javarush.ru.island.jama.animals.factories;
import javarush.ru.island.jama.animals.predators.Bear;
import javarush.ru.island.jama.animals.Inhabitant;

public class BearFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Bear();
    }
}
