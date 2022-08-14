package javarush.ru.jama.island.project.island.animals.factories;
import javarush.ru.jama.island.project.island.animals.Inhabitant;
import javarush.ru.jama.island.project.island.animals.herbivores.Horse;


public class HorseFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Horse();
    }
}
