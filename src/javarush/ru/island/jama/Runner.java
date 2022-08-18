package javarush.ru.island.jama;
import javarush.ru.island.jama.location.IslandMap;
import javarush.ru.island.jama.services.GameWorker;
import javarush.ru.island.jama.settings.Initializer;
import javarush.ru.island.jama.settings.Satistics;

public class Runner {
    public static void main(String[] args) {

        Initializer initializer = new Initializer();
        IslandMap map = initializer.createIslandMap();
        Satistics statistics = new Satistics(map);
        GameWorker gameWorker = new GameWorker(statistics);
        gameWorker.start();

    }
}


