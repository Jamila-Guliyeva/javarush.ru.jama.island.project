package javarush.ru.island.jama.animals.factories;
import javarush.ru.island.jama.animals.herbivores.Horse;
import javarush.ru.island.jama.animals.Inhabitant;


public class HorseFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Horse();
    }
}
