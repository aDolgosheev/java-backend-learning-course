package entities;

public class Herbivore extends Creature {

    private Grass grass;

    public Herbivore(int speed, int hp, Grass grass) {
        super(speed, hp);
        this.grass = grass;
    }

    @Override
    public void makeMove() {

    }
}
