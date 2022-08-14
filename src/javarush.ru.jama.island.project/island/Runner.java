package javarush.ru.jama.island.project.island;
import javarush.ru.jama.island.project.island.location.IslandMap;
import javarush.ru.jama.island.project.island.services.GameWorker;
import javarush.ru.jama.island.project.island.settings.Initializer;
import javarush.ru.jama.island.project.island.settings.Satistics;

public class Runner {
    public static void main(String[] args) {

        Initializer initializer = new Initializer();
        IslandMap world = initializer.createIslandMap();
        Satistics game = new Satistics(world);
        GameWorker gameWorker = new GameWorker(game);
        gameWorker.start();

    }
}


