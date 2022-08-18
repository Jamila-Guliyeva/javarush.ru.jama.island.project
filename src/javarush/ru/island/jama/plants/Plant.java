package javarush.ru.island.jama.plants;
import javarush.ru.island.jama.animals.Inhabitant;
import javarush.ru.island.jama.animals.OrganismsList;
import javarush.ru.island.jama.animals.factories.Factories;
import javarush.ru.island.jama.location.Cell;
import javarush.ru.island.jama.settings.GameSettings;
import javarush.ru.island.jama.util.Randomizer;

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
            int newPlantsQuantity = this.getChildQuantity(area);
            if (newPlantsQuantity > 0) {
                for (int i = 0; i < newPlantsQuantity; i++) {
                    if (Randomizer.getProbability(5)) {
                        Inhabitant newPlant = Factories.createOrganismByType(OrganismsList.valueOf(this.getType().toString().toUpperCase(Locale.ROOT)));
                        area.addInhabitant(this.getType(), newPlant);
                    }
                }
            }
        } finally {
            area.getLock().unlock();
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
