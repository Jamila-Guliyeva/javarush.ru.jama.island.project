package javarush.ru.jama.island.project.island.animals.factories;
import javarush.ru.jama.island.project.island.animals.Inhabitant;
import javarush.ru.jama.island.project.island.animals.herbivores.Duck;


public class DuckFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Duck();
    }
}
