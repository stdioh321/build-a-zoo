package animals.model;

import javax.xml.bind.annotation.XmlAttribute;

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
    public String toString(){
        return super.toString() + String.format("broiler: %b, ", broiler);
    }

}
