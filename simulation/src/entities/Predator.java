package entities;

import logic.Coordinates;

public class Predator extends Creature {

    private int attackPower;

    public Predator(int speed, int hp, int attackPower) {
        super(speed, hp);
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
