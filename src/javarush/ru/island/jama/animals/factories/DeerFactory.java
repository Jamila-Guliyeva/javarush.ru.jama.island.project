package javarush.ru.island.jama.animals.factories;
import javarush.ru.island.jama.animals.herbivores.Deer;
import javarush.ru.island.jama.animals.Inhabitant;


public class DeerFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Deer();
    }
}
