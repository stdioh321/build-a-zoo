package animals;

import java.util.ArrayList;

public class Chicken extends Animal{
    private boolean broiler;
    private Float wingLength;


    public Chicken(String name, String favoriteFood, boolean broiler, Float wingLength) {
        super(name, favoriteFood);
        this.broiler = broiler;
        this.wingLength = wingLength;
    }

    public boolean isBroiler() {
        return broiler;
    }

    public void setBroiler(boolean broiler) {
        this.broiler = broiler;
    }

    public Float getWingLength() {
        return wingLength;
    }

    public void setWingLength(Float wingLength) {
        this.wingLength = wingLength;
    }

    @Override
    public String toString() {
        return "Chicken{" +
                "Name='" + this.getName()  + '\'' +
                ", Favorite Food='" + this.getFavoriteFood()  + '\''+
                ", Broiler='" + broiler   + '\'' +
                ", Wing Length='" + wingLength   + '\'' +
                '}';
    }
}
