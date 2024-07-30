import logic.Map;
import logic.MapRenderer;

public class Main {
    public static void main(String[] args) {
        Map map = new Map(10, 10);
        MapRenderer mapRenderer = new MapRenderer();
        mapRenderer.render(map);
    }
}