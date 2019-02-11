package zoo.model;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Objects;

public class Bird extends Animal {

    @XmlAttribute
    private Float wingLength;

    public Bird() {
    }

    public Bird(String name, String favoriteFood, Float wingLength) {
        super(name, favoriteFood);
        this.wingLength = wingLength;
    }

    public Float getWingLength() {
        return wingLength;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("wingLength: %.2f, ", wingLength);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        Bird bird = (Bird) o;
        return Objects.equals(wingLength, bird.wingLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wingLength);
    }
}
