package animals.model;

import javax.xml.bind.annotation.XmlAttribute;

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
    public String toString(){
        return super.toString() + String.format("wingLength: %.2f, ", wingLength);
    }


}
