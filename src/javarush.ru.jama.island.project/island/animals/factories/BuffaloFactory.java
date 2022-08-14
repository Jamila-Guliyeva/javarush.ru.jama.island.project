package javarush.ru.jama.island.project.island.animals.factories;
import javarush.ru.jama.island.project.island.animals.Inhabitant;
import javarush.ru.jama.island.project.island.animals.factories.InhabitantFactory;
import javarush.ru.jama.island.project.island.animals.herbivores.Buffalo;


public class BuffaloFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Buffalo();
    }
}
