package animals.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class Dog extends Animal {

    @XmlAttribute
    private String dogType;

    public Dog() {
    }

    @Override
    public String toString(){
        return super.toString() + String.format("dogType: %s, ", dogType);
    }

    public Dog(String name, String favoriteFood, String dogType) {
        super(name, favoriteFood);
        this.dogType = dogType;
    }

    public String getDogType() {
        return dogType;
    }

}
