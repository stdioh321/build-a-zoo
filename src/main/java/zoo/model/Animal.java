package zoo.model;

import javax.xml.bind.annotation.*;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.Predicate;

@XmlType
public abstract class Animal implements Serializable {

    @XmlAttribute
    private String name;

    @XmlAttribute
    private String favoriteFood;

    @Override
    public String toString() {
        return String.format("Name: %s, FavoriteFood: %s, ", name, favoriteFood);
    }

    @XmlElementWrapper()
    @XmlElements({ @XmlElement(name = "bird", type = Bird.class),
            @XmlElement(name = "chicken", type = Chicken.class),
            @XmlElement(name = "dog", type = Dog.class),
            @XmlElement(name = "parrot", type = Parrot.class) })
    private Set<Animal> friends = new HashSet<>();

    public Animal() {
    }

    public Animal(String name, String favoriteFood) {
        this.name = name;
        this.favoriteFood = favoriteFood;
    }

    public Set<Animal> getFriends() {
        return friends;
    }

    public String getName() {
        return name;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public boolean establishFriendship(Animal newFriend) {
        if(equals(newFriend)) return false;
        else {
            newFriend.friends.add(this);
            return this.friends.add(newFriend);
        }
    }

    public boolean loseFriendship(Animal oldFriend) {
        oldFriend.friends.remove(this);
        return this.friends.remove(oldFriend);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name)
                && Objects.equals(favoriteFood, animal.favoriteFood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, favoriteFood);
    }

    public void printFriends(PrintStream out) {
        StringJoiner joiner = new StringJoiner(", ");
        for (Animal friend : friends) {
            joiner.add(friend.getName());
        }
        out.print("Friends: ");
        out.print(joiner.toString());
    }

    public static Predicate<Animal> isAnimalByClass(Class clazz) {
        return animal -> animal.getClass().equals(clazz);
    }

}
