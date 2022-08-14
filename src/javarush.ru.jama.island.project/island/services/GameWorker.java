package javarush.ru.jama.island.project.island.services;
import javarush.ru.jama.island.project.island.animals.OrganismsList;
import javarush.ru.jama.island.project.island.settings.GameSettings;
import javarush.ru.jama.island.project.island.settings.Satistics;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameWorker extends Thread {

    private final Satistics game;

    private final long LIFE_CYCLE_DURATION = GameSettings.get().getCycleDuration();
    private final Boolean STOP_ON_TIMEOUT = GameSettings.get().getStopOnTimeout();
    private final int GAME_DURATION = GameSettings.get().getGameDuration();

    public GameWorker(Satistics game) {
        this.game = game;
    }

    @Override
    public void run() {
        game.showStatistics();
        //
        ScheduledExecutorService gameScheduledThreadPool = Executors.newScheduledThreadPool(4);
        gameScheduledThreadPool.scheduleWithFixedDelay(this::runAndWaitOrganismWorkers, LIFE_CYCLE_DURATION, LIFE_CYCLE_DURATION, TimeUnit.MILLISECONDS);

        if (STOP_ON_TIMEOUT) runTimer();
    }

    private void runAndWaitOrganismWorkers() {
        ArrayList<OrganismWorker> organismWorkers = new ArrayList<>();
        for (OrganismsList organismType : GameSettings.get().getOrganismsTypes()) {
            organismWorkers.add(new OrganismWorker(organismType, game.getIslandMap()));
        }
        //
        int poolSize = 4;
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(poolSize);
        for (OrganismWorker organismWorker : organismWorkers) {
            fixedThreadPool.submit(organismWorker);
        }
        fixedThreadPool.shutdown();

        try {
            if (fixedThreadPool.awaitTermination(Integer.MAX_VALUE, TimeUnit.DAYS)) {
                game.showStatistics();
            }
        } catch (InterruptedException e) {
            //
            System.out.println("The game is finished");
        }
    }

    private void runTimer() {
        try {
            Thread.sleep(GAME_DURATION);
        } catch (InterruptedException e) {
            System.out.println("The game is already finished");
        }
        //
        System.out.println("GAME OVER");
        System.exit(1);
    }

}
