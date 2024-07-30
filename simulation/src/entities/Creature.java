package entities;

import logic.Coordinates;

public abstract class Creature extends Entity {

    private int speed;

    private int hp;

    public Creature() {
        this.speed = (int) (Math.random() * 3);
        this.hp = (int) (Math.random() * 2);
    }

    public int getSpeed() {
        return speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public abstract void makeMove();
}
