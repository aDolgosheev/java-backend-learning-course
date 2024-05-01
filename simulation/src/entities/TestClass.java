package entities;

public class TestClass {

    private static int count;

    private String name;

    public TestClass() {
        count++;
        name = "TestClassName - " + count;
    }

    public String getName() {
        return name;
    }
}
