package zoo.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlType
public class Dog extends Animal {

    @XmlAttribute
    private String dogType;

    public Dog() {
    }

    @Override
    public String toString() {
        return super.toString() + String.format("dogType: %s, ", dogType);
    }

    public Dog(String name, String favoriteFood, String dogType) {
        super(name, favoriteFood);
        this.dogType = dogType;
    }

    public String getDogType() {
        return dogType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        Dog dog = (Dog) o;
        return Objects.equals(dogType, dog.dogType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dogType);
    }
}
