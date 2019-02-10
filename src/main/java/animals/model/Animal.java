package animals.model;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public abstract class Animal {
    private String name;
    private String favoriteFood;
    private Set<Animal> friends = new HashSet<>();

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
        return this.friends.add(newFriend);
    }

    public boolean loseFriendship(Animal oldFriend) {
        return this.friends.remove(oldFriend);
    }

    @Override
    public String toString() {
        return "Animal{" + "name='" + name + '\'' + ", favoriteFood='" + favoriteFood + '\'' + '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name) &&
                Objects.equals(favoriteFood, animal.favoriteFood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, favoriteFood);
    }

    public void printFriends(PrintStream out){
        StringJoiner joiner = new StringJoiner(", ");
        for (Animal friend : friends) {
            joiner.add(friend.getName());
        }
        String strFriends = joiner.toString();
        out.print(strFriends);
    }

}
