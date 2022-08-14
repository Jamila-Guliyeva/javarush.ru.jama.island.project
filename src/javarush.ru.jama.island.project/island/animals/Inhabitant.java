package javarush.ru.jama.island.project.island.animals;
import javarush.ru.jama.island.project.island.constants.Parameters;
import javarush.ru.jama.island.project.island.location.Cell;
import javarush.ru.jama.island.project.island.settings.GameSettings;
import javarush.ru.jama.island.project.island.util.Randomizer;


import java.util.Locale;

public abstract class Inhabitant {
    private final OrganismsList type = OrganismsList.valueOf(this.getClass().getSimpleName().toUpperCase(Locale.ROOT));

    private double weight;

    public abstract void multiply(Cell area);

    public abstract void growUp(Cell area);

    protected Inhabitant() {
        Parameters parameters = GameSettings.get().getOrganismParametersByType(this.type);
        this.weight = Randomizer.getRandom(parameters.getMaxWeight() / 2.0D, parameters.getMaxWeight());
    }

    public OrganismsList getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getChildQuantity(Cell area) {
        GameSettings settings = GameSettings.get();
        Integer childrenQuantity = settings.getOrganismsChildrenQuantity().get(getType());
        int maxQuantityInArea = settings.getOrganismParametersByType(getType()).getMaxQuantity();
        int newBornQuantity = Randomizer.getRandom(0, Math.min(childrenQuantity, maxQuantityInArea));
        int sameOrganismTypeQuantity = area.getInhabitants().get(this.getType()).toArray().length;

        return Math.min(maxQuantityInArea - sameOrganismTypeQuantity, newBornQuantity);
    }

    public void starve(Cell area) {
        area.getLock().lock();
        try {
            Parameters organismsCommonSpecs = GameSettings.get().getOrganismParametersByType(this.getType());
            int weightLossPercent;
            if (this instanceof Animal) {
                weightLossPercent = 20;
            }
            else {
                weightLossPercent = 1;
            }

            double weightLoss = organismsCommonSpecs.getMaxWeight() * weightLossPercent / 100;
            this.setWeight(this.getWeight() - weightLoss);

            if (this.getWeight() < organismsCommonSpecs.getMaxWeight() * 0.3) {
                area.getInhabitants().get(this.getType()).remove(this);
            }
        } finally {
            area.getLock().unlock();
        }
    }

}

