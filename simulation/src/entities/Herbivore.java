package entities;

import logic.Coordinates;

public class Herbivore extends Creature {

    private static int herbivoreCount;

    public Herbivore() {
        herbivoreCount++;
    }

    public static int getHerbivoreCount() {
        return herbivoreCount;
    }

    public void decrementNumberOfHerbivore() {
        herbivoreCount--;
    }

    @Override
    public void makeMove() {

    }
}
