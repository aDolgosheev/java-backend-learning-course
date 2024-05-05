package entities;

public class Grass extends Entity {

    public Grass(int x, int y) {
        super(x, y);
        this.setName("Grass_" + getCount());
    }
}
