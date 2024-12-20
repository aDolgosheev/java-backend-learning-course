package logic;

import entities.Entity;

import java.util.Collections;
import java.util.Set;

public class MapRenderer {

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";

    public static final String ANSI_BLACK_SQUARE_BACKGROUND = "\u001B[0;100m";

    public void render(Map map) {

        for (int verticalLine = map.verticalSize; verticalLine >= 1; verticalLine--) {
            String line = "";
            for (int horizontalLine = 0; horizontalLine < map.horizontalSize; horizontalLine++) {
                Coordinates coordinates = new Coordinates(verticalLine, horizontalLine);
                if (map.isSquareEmpty(coordinates)) {
                    line += getSpriteForEmptySquare(coordinates);
                } else {
                    line += getEntitySprite(map.getEntity(coordinates));
                }
            }
            line += ANSI_RESET;
            System.out.println(line);
        }
    }

    private String colorizeSprite(String sprite, boolean isSquareDark) {
        String result = sprite;

        if (isSquareDark) {
            result = ANSI_BLACK_SQUARE_BACKGROUND + result;
        } else {
            result = ANSI_WHITE_SQUARE_BACKGROUND + result;
        }

        return result;
    }

    private String getSpriteForEmptySquare(Coordinates coordinates) {
//        return colorizeSprite("\u2003\u2003\u2003", Color.WHITE, isSquareDark(coordinates));
        return colorizeSprite("...", isSquareDark(coordinates));
    }

    public static boolean isSquareDark(Coordinates coordinates) {
        return (((coordinates.getHorizontalLine() + 1) + coordinates.getVerticalLine()) % 2) == 0;
    }

    private String selectUnicodeSpriteForEntity(Entity entity) {
        return switch (entity.getClass().getSimpleName()) {
            case "Rock" -> "R";
            case "Tree" -> "T";
            case "Grass" -> "G";
            case "Herbivore" -> "H";
            case "Predator" -> "P";
            default -> "";
        };
    }

    private String getEntitySprite(Entity entity) {
        return colorizeSprite("\u2003" + selectUnicodeSpriteForEntity(entity) + "\u2003",
                isSquareDark(entity.getCoordinates()));
    }
}
