package ru.javarush.jama.island.plants;

import ru.javarush.jama.island.entity.Inhabitant;
import ru.javarush.jama.island.entity.OrganismsType;
import ru.javarush.jama.island.entity.factories.Factories;
import ru.javarush.jama.island.location.Cell;
import ru.javarush.jama.island.settings.GameSettings;
import ru.javarush.jama.island.util.Randomizer;
import java.util.Locale;

public class Plant extends Inhabitant {

    public Plant() {
        super();
    }

    @Override
    public void multiply(Cell area) {
        safeMultiply(area);
    }

    private void safeMultiply(Cell area) {
        area.getLock().lock();
        try {
        newPlant(area);
        } finally {
            area.getLock().unlock();
        }
    }

    private void newPlant(Cell area){
        int newPlantsQuantity = this.getChildQuantity(area);
        if (newPlantsQuantity > 0) {
            for (int i = 0; i < newPlantsQuantity; i++) {
                if (Randomizer.getProbability(5)) {
                    Inhabitant newPlant = Factories.createOrganismByType(OrganismsType.valueOf(this.getType().toString().toUpperCase(Locale.ROOT)));
                    area.addInhabitant(this.getType(), newPlant);
                }
            }
        }
    }

    public void growUp(Cell area) {
        safeGrowUp(area);
    }

    private void safeGrowUp(Cell area) {
        area.getLock().lock();
        try {
            int growUpPercent = GameSettings.get().getPlantGrowUpPercent();
            double weightIncrement = this.getWeight() * growUpPercent / 100;
            this.setWeight(this.getWeight() + weightIncrement);
        } finally {
            area.getLock().unlock();
        }
    }
}
