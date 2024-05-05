package entities;

public abstract class Creature extends Entity {

    private int speed;

    private int hp;

    public Creature(int x, int y, int speed, int hp) {
        super(x, y);
        this.speed = speed;
        this.hp = hp;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public abstract void makeMove();
}
