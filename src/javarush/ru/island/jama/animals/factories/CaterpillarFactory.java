package javarush.ru.island.jama.animals.factories;


import javarush.ru.island.jama.animals.herbivores.Caterpillar;
import javarush.ru.island.jama.animals.Inhabitant;

public class CaterpillarFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Caterpillar();
    }
}
