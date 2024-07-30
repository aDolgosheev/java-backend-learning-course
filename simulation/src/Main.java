import logic.Coordinates;
import logic.Map;
import logic.MapRenderer;

import java.util.HashMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Map map = new Map(10, 10);
        MapRenderer mapRenderer = new MapRenderer();
        mapRenderer.render(map);

//        Main main = new Main();
//        System.out.println(main.convertWithStream(map.entities));

    }

//    public String convertWithStream(HashMap<Coordinates, ?> map) {
//        return map.keySet().stream()
//                .map(key -> key + " = " + map.get(key))
//                .collect(Collectors.joining(",\n", "{", "}"));
//    }
}