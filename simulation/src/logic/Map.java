package logic;

import entities.Entity;
import entities.Grass;
import entities.Herbivore;
import entities.Predator;
import entities.Rock;
import entities.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Map {

    public final Integer horizontalSize;
    public final Integer verticalSize;
    public HashMap<Coordinates, Entity> entities = new HashMap<>();

    public List<Move> moves = new ArrayList<>();

    public Map(Integer horizontalSize, Integer verticalSize) {
        this.horizontalSize = horizontalSize;
        this.verticalSize = verticalSize;
        setupStartCreaturesPositions();
    }

    public void createEntity(Entity entity) {
        Coordinates coordinates = new Coordinates((int) (Math.random() * 11), (int) (Math.random() * 11));
        while (!isSquareEmpty(coordinates)) {
            coordinates = new Coordinates((int) (Math.random() * 11), (int) (Math.random() * 11));
        }
        entity.setCoordinates(coordinates);
        entities.put(coordinates, entity);
    }

    public Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public void removeEntity(Coordinates coordinates) {
        entities.remove(coordinates);
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }

    public void setupStartCreaturesPositions() {
        // create Rocks (6 - 9 items)
        for (int i = 0; i < ((int) (Math.random() * 4) + 6); i++) {
            createEntity(new Rock());
        }

        // create Trees (8 - 12 items)
        for (int i = 0; i < ((int) (Math.random() * 5) + 8); i++) {
            createEntity(new Tree());
        }

        // create Grasses (18 - 26 items)
        for (int i = 0; i < ((int) (Math.random() * 9) + 18); i++) {
            createEntity(new Grass());
        }

        // create Herbivores (10 - 14 items)
        for (int i = 0; i < ((int) (Math.random() * 5) + 10); i++) {
            createEntity(new Herbivore());
        }

        // create Predators (4 - 8 items)
        for (int i = 0; i < ((int) (Math.random() * 5) + 4); i++) {
            createEntity(new Predator());
        }
    }
}
