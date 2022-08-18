package javarush.ru.island.jama.animals.factories;
import javarush.ru.island.jama.animals.predators.Boa;
import javarush.ru.island.jama.animals.Inhabitant;


public class BoaFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Boa();
    }
}
