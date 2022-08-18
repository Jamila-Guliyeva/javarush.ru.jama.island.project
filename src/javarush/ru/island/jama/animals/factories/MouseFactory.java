package javarush.ru.island.jama.animals.factories;
import javarush.ru.island.jama.animals.herbivores.Mouse;
import javarush.ru.island.jama.animals.Inhabitant;

public class MouseFactory implements InhabitantFactory {
    @Override
    public Inhabitant createOrganism() {
        return new Mouse();
    }
}
