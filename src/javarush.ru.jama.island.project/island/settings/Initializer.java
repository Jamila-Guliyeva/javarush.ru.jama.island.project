package javarush.ru.jama.island.project.island.settings;
import javarush.ru.jama.island.project.island.location.IslandMap;

public class Initializer {

    public IslandMap createIslandMap() {
        MapCreator worldCreator = new MapCreator();
        return worldCreator.createIslandMap();
    }

}
