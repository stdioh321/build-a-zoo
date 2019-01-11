package animals;

import java.util.ArrayList;

public class Dog extends Animal {
    private String dogType;

    @Override
    public String toString() {
        return "Dog{" +
                "Name='" + this.getName() + '\'' +
                ", Favorite Food='" + this.getFavoriteFood()+ '\'' +
                ", Dog Type='" + dogType + '\'' +
                '}';
    }

    public Dog(String name, String favoriteFood, String dogType) {
        super(name, favoriteFood);
        this.dogType = dogType;
    }

    public String getDogType() {
        return dogType;
    }

    public void setDogType(String dogType) {
        this.dogType = dogType;
    }
}
