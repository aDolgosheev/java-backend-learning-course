package logic;

import entities.Creature;
import entities.Entity;
import entities.Grass;
import entities.Herbivore;
import entities.Predator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathFinder {

    private final Map map;
    private Coordinates closestTarget;

    public PathFinder(Map map) {
        this.map = map;
    }

    public Coordinates[] findPath(Coordinates creatureCoordinate, Creature creature) {
        Queue<Coordinates> queue = new ArrayDeque<>();
        Coordinates[] paths = new Coordinates[map.horizontalSize * map.verticalSize];
        closestTarget = null;

        queue.add(creatureCoordinate);
        while (!queue.isEmpty()) {
            Coordinates currentCoordinate = queue.remove();
            if (checkCurrentTarget(currentCoordinate, creature)) {
                closestTarget = currentCoordinate;
                break;
            }
            List<Coordinates> availableNeighbours = getAvailableNeighbours(currentCoordinate, creature);
            for (Coordinates neighbour : availableNeighbours) {
                int neighbourIndex = getIndexOfCoordinate(neighbour);
                if (paths[neighbourIndex] == null) {
                    queue.add(neighbour);
                    paths[neighbourIndex] = currentCoordinate;
                }
            }
        }
        return paths;
    }

    private boolean checkCurrentTarget(Coordinates currentCoordinate, Creature creature) {
        if (creature instanceof Herbivore &&
                map.getEntity(currentCoordinate) instanceof Grass) {
            return true;
        } else if (creature instanceof Predator &&
                map.getEntity(currentCoordinate) instanceof Herbivore) {
            return true;
        }
        return false;
    }

    private List<Coordinates> getAvailableNeighbours(Coordinates current, Creature creature) {
        List<Coordinates> neighbours = getNeighbours(current);
        List<Coordinates> availableNeighbours = new ArrayList<>();
        for (Coordinates neighbour : neighbours) {
            if (checkSpecifiedNeighbour(neighbour, creature)) {
                availableNeighbours.add(neighbour);
            }
        }
        return availableNeighbours;
    }

    private boolean checkSpecifiedNeighbour(Coordinates neighbour, Creature creature) {
        Entity entity = map.getEntity(neighbour);
        int x = neighbour.getHorizontalLine();
        int y = neighbour.getVerticalLine();
        if (x >= 0 && x < map.horizontalSize && y >= 0 && y < map.verticalSize) {
            if (entity == null) {
                return true;
            } else if (creature instanceof Predator && entity instanceof Herbivore) {
                return true;
            } else if (creature instanceof Herbivore && entity instanceof Grass) {
                return true;
            }
        }
        return false;
    }

    private List<Coordinates> getNeighbours(Coordinates current) {
        LinkedList<Coordinates> set = new LinkedList<>();
        int x = current.getHorizontalLine();
        int y = current.getVerticalLine();
        for (int i = y - 1; i <= y + 1; i++) {
            for (int j = x - 1; j <= x + 1; j++) {
                Coordinates neighbour = new Coordinates(i, j);
                if (!neighbour.equals(current)) {
                    if (x == j || y == i) {
                        set.addFirst(neighbour);
                    } else {
                        set.addLast(neighbour);
                    }
                }
            }
        }
        return set;
    }

    public int getIndexOfCoordinate(Coordinates coordinates) {
        return coordinates.getVerticalLine() * map.verticalSize + coordinates.getHorizontalLine();
    }

    public Coordinates findNextMove(Coordinates[] path, Coordinates current) {
        Coordinates toFind = closestTarget;
        if (closestTarget == null)
            return current;
        Coordinates prev = null;
        while (toFind != current) {
            prev = toFind;
            toFind = path[getIndexOfCoordinate(toFind)];
        }
        return prev;
    }
}
