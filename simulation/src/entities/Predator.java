package entities;

public class Predator extends Creature {

    private static int count;

    private int attackPower;

    public Predator(int x, int y, int speed, int hp) {
        super(x, y, speed, hp);
        count++;
        this.setName("Predator_" + count);
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
