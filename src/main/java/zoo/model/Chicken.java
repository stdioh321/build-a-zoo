package zoo.model;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Objects;

public class Chicken extends Bird {

    @XmlAttribute
    private boolean broiler;

    public Chicken() {
    }

    public Chicken(String name, String favoriteFood, boolean broiler, Float wingLength) {
        super(name, favoriteFood, wingLength);
        this.broiler = broiler;
    }

    public boolean isBroiler() {
        return broiler;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("broiler: %b, ", broiler);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        Chicken chicken = (Chicken) o;
        return broiler == chicken.broiler;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), broiler);
    }
}
