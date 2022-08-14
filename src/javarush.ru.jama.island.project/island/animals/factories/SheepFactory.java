package javarush.ru.jama.island.project.island.animals.factories;
import javarush.ru.jama.island.project.island.animals.Inhabitant;
import javarush.ru.jama.island.project.island.animals.herbivores.Sheep;
public class SheepFactory implements InhabitantFactory {

    @Override
    public Inhabitant createOrganism() {
        return new Sheep();
    }
}
