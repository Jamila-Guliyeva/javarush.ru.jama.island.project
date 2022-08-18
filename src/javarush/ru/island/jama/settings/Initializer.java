package javarush.ru.island.jama.settings;
import javarush.ru.island.jama.location.IslandMap;

public class Initializer {

    public IslandMap createIslandMap() {
        MapCreator worldCreator = new MapCreator();
        return worldCreator.createIslandMap();
    }

}
