package javarush.ru.jama.island.project.island.animals.factories;
import javarush.ru.jama.island.project.island.animals.Inhabitant;
import javarush.ru.jama.island.project.island.animals.herbivores.Rabbit;


public class RabbitFactory implements InhabitantFactory
{
    @Override
    public Inhabitant createOrganism() {
        return new Rabbit();
    }
}
