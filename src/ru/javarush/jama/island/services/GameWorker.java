package ru.javarush.jama.island.services;

import ru.javarush.jama.island.entity.OrganismsType;
import ru.javarush.jama.island.settings.GameSettings;
import ru.javarush.jama.island.settings.Satistics;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameWorker extends Thread {

    private final Satistics game;

    private final long lifeCycleDuration = GameSettings.get().getCycleDuration();
    private final Boolean stopOnTimeout = GameSettings.get().getStopOnTimeout();
    private final int gameDuration = GameSettings.get().getGameDuration();

    public GameWorker(Satistics game) {
        this.game = game;
    }

    @Override
    public void run() {
        game.showStatistics();
        ScheduledExecutorService gameScheduledThreadPool = Executors.newScheduledThreadPool(4);
        gameScheduledThreadPool.scheduleWithFixedDelay(this::runAndWaitOrganismWorkers, lifeCycleDuration, lifeCycleDuration, TimeUnit.MILLISECONDS);

        if (stopOnTimeout) runTimer();
    }

    private void runAndWaitOrganismWorkers() {
        ArrayList<OrganismWorker> organismWorkers = new ArrayList<>();
        for (OrganismsType organismType : GameSettings.get().getOrganismsTypes()) {
            organismWorkers.add(new OrganismWorker(organismType, game.getIslandMap()));
        }
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
            System.out.println("The game is finished");
        }
    }

    private void runTimer() {
        try {
            Thread.sleep(gameDuration);
        } catch (InterruptedException e) {
            System.out.println("The game is already finished");
        }
        System.out.println("GAME OVER");
        System.exit(1);
    }

}
