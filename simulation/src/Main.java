import entities.TestClass;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        TestClass testClass1 = new TestClass();
        TestClass testClass2 = new TestClass();
        TestClass testClass3 = new TestClass();
        TestClass testClass4 = new TestClass();

        System.out.println(testClass1.getName());
        System.out.println(testClass2.getName());
        System.out.println(testClass3.getName());
        System.out.println(testClass4.getName());
    }
}