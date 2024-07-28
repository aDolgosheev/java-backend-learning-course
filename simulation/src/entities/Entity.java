package entities;

import logic.Coordinates;

public abstract class Entity {

    public Coordinates coordinates;
//    private String name;

    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

}
