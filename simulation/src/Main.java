import entities.Grass;
import entities.Predator;
import entities.TestClass;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Predator predator1 = new Predator(10, 8, 3, 100);
        System.out.println(predator1.getName());
        Predator predator2 = new Predator(10, 8, 3, 100);
        System.out.println(predator2.getName());
        Predator predator3 = new Predator(10, 8, 3, 100);
        System.out.println(predator3.getName());

        Grass grass1 = new Grass(9, 10);
        System.out.println(grass1.getName());
        Grass grass2 = new Grass(9, 10);
        System.out.println(grass2.getName());
        Grass grass3 = new Grass(9, 10);
        System.out.println(grass3.getName());

    }
}