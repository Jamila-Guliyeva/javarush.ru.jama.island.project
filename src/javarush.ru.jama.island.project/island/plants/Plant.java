package javarush.ru.jama.island.project.island.plants;
import javarush.ru.jama.island.project.island.animals.Inhabitant;
import javarush.ru.jama.island.project.island.animals.OrganismsList;
import javarush.ru.jama.island.project.island.location.Cell;
import javarush.ru.jama.island.project.island.animals.factories.Factories;
import javarush.ru.jama.island.project.island.settings.GameSettings;
import javarush.ru.jama.island.project.island.util.Randomizer;

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
