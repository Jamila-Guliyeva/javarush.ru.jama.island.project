package javarush.ru.island.jama.animals.factories;


import javarush.ru.island.jama.animals.herbivores.Boar;
import javarush.ru.island.jama.animals.Inhabitant;

public class BoarFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Boar();
    }
}
