package javarush.ru.island.jama.animals.factories;
import javarush.ru.island.jama.animals.herbivores.Goat;
import javarush.ru.island.jama.animals.Inhabitant;


public class GoatFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Goat();
    }
}
