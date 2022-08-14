package javarush.ru.jama.island.project.island.animals.factories;
import javarush.ru.jama.island.project.island.animals.Inhabitant;
import javarush.ru.jama.island.project.island.animals.predators.Boa;


public class BoaFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Boa();
    }
}
