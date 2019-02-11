package animals.model;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Objects;

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
    public String toString(){
        return super.toString() + String.format("speak: %b, ", speak);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Parrot parrot = (Parrot) o;
        return speak == parrot.speak;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), speak);
    }
}
