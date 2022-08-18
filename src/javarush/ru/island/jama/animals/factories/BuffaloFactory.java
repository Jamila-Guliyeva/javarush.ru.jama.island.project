package javarush.ru.island.jama.animals.factories;
import javarush.ru.island.jama.animals.herbivores.Buffalo;
import javarush.ru.island.jama.animals.Inhabitant;


public class BuffaloFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Buffalo();
    }
}
