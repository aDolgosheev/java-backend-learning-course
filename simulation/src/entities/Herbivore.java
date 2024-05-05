package entities;

public class Herbivore extends Creature {

    private static int count;

    public Herbivore(int x, int y, int speed, int hp) {
        super(x, y, speed, hp);
        count++;
        this.setName("Herbivore_" + count);
    }

    @Override
    public void makeMove() {

    }
}
