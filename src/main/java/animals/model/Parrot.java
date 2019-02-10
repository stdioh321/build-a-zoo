package animals.model;

import javax.xml.bind.annotation.XmlAttribute;

public class Parrot extends Bird {
    @XmlAttribute
    private boolean speak;

    public Parrot() {
    }

    public Parrot(String name, String favoriteFood, boolean speak, Float wingLength) {
        super(name, favoriteFood, wingLength);
        this.speak = speak;
    }

    public boolean isSpeak() {
        return speak;
    }

    @Override
    public String toString() {
        return "Parrot{" + "Name='" + this.getName() + '\'' + ", Favorite Food='"
                + this.getFavoriteFood() + '\'' + ", Speak='" + speak + '\'' + ", Wings Length='"
                + this.getWingLength() + '\'' + '}';
    }
}
