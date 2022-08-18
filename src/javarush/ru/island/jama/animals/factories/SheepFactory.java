package javarush.ru.island.jama.animals.factories;
import javarush.ru.island.jama.animals.herbivores.Sheep;
import javarush.ru.island.jama.animals.Inhabitant;

public class SheepFactory implements InhabitantFactory {

    @Override
    public Inhabitant createOrganism() {
        return new Sheep();
    }
}
