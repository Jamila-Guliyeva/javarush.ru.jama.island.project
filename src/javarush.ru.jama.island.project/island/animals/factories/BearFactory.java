package javarush.ru.jama.island.project.island.animals.factories;
import javarush.ru.jama.island.project.island.animals.Inhabitant;
import javarush.ru.jama.island.project.island.animals.predators.Bear;

public class BearFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Bear();
    }
}
