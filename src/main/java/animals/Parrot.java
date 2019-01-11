package animals;

public class Parrot extends Animal {
    private boolean speak;
    private Float wingLength;

    public Parrot(String name, String favoriteFood, boolean speak, Float wingLength) {
        super(name, favoriteFood);
        this.speak = speak;
        this.wingLength = wingLength;
    }

    public boolean isSpeak() {
        return speak;
    }

    public void setSpeak(boolean speak) {
        this.speak = speak;
    }

    public Float getWingLength() {
        return wingLength;
    }

    public void setWingLength(Float wingLength) {
        this.wingLength = wingLength;
    }

    @Override
    public String toString() {
        return "Parrot{" +
                "Name='" + this.getName()  + '\'' +
                ", Favorite Food='" + this.getFavoriteFood()  + '\'' +
                ", Speak='" + speak  + '\'' +
                ", Wings Length='" + wingLength  + '\'' +
                '}';
    }
}
