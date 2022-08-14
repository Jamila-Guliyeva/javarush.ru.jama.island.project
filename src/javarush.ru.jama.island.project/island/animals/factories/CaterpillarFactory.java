package javarush.ru.jama.island.project.island.animals.factories;


import javarush.ru.jama.island.project.island.animals.Inhabitant;
import javarush.ru.jama.island.project.island.animals.herbivores.Caterpillar;

public class CaterpillarFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Caterpillar();
    }
}
