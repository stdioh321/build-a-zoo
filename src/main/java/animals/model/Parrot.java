package animals.model;

public class Parrot extends Bird {
    private boolean speak;

    public Parrot(String name, String favoriteFood, boolean speak, Float wingLength) {
        super(name, favoriteFood, wingLength);
        this.speak = speak;
    }

    public boolean isSpeak() {
        return speak;
    }

    public void setSpeak(boolean speak) {
        this.speak = speak;
    }

    @Override
    public String toString() {
        return "Parrot{" + "Name='" + this.getName() + '\'' + ", Favorite Food='"
                + this.getFavoriteFood() + '\'' + ", Speak='" + speak + '\'' + ", Wings Length='"
                + this.getWingLength() + '\'' + '}';
    }
}
