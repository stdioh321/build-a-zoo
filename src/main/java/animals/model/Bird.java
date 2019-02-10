package animals.model;

public class Bird extends Animal {

    private Float wingLength;

    public Bird(String name, String favoriteFood, Float wingLength) {
        super(name, favoriteFood);
        this.wingLength = wingLength;
    }

    public Float getWingLength() {
        return wingLength;
    }

    public void setWingLength(Float wingLength) {
        this.wingLength = wingLength;
    }
}
