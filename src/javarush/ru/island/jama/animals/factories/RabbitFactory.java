package javarush.ru.island.jama.animals.factories;
import javarush.ru.island.jama.animals.herbivores.Rabbit;
import javarush.ru.island.jama.animals.Inhabitant;


public class RabbitFactory implements InhabitantFactory
{
    @Override
    public Inhabitant createOrganism() {
        return new Rabbit();
    }
}
