package entities;

import logic.Coordinates;

public class Predator extends Creature {

    private int attackPower;

    public Predator(Coordinates coordinates, int speed, int hp, int attackPower) {
        super(coordinates, speed, hp);
        this.attackPower = attackPower;
    }


    @Override
    public void makeMove() {

    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
}
