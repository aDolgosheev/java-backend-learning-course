package entities;

import logic.Coordinates;

public class Predator extends Creature {

    private int attackPower;

    public Predator() {
        this.attackPower = (int) (Math.random() * 2);
    }

    @Override
    public void makeMove() {
    }

    public int getAttackPower() {
        return attackPower;
    }
}
