package javarush.ru.island.jama.animals.factories;
import javarush.ru.island.jama.animals.predators.Eagle;
import javarush.ru.island.jama.animals.Inhabitant;


public class EagleFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Eagle();
    }
}
