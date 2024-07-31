package entities;

import logic.Coordinates;

public class Grass extends Entity {
    private static int grassCount;

    public Grass() {
        grassCount++;
    }

    public static int getGrassCount() {
        return grassCount;
    }

    public void decrementNumberOfGrass() {
        grassCount--;
    }
}
