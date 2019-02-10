package animals.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Animal {
    private String name;
    private String favoriteFood;
    private List<Animal> friends = new ArrayList<>();

    public Animal(String name, String favoriteFood) {
        this.name = name;
        this.favoriteFood = favoriteFood;
    }

    public List<Animal> getFriends() {
        return friends;
    }

    public String getName() {
        return name;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public boolean establishFriendship(Animal newFriend) {
        if (this.getFriends().contains(newFriend) || newFriend.getFriends().contains(this)
                || this.equals(newFriend)) {
            return false;
        }
        this.getFriends().add(newFriend);
        newFriend.getFriends().add(this);

        return true;
    }

    public boolean loseFriendship(Animal oldFriend) {
        if (!this.getFriends().contains(oldFriend) || !oldFriend.getFriends().contains(this)) {
            return false;
        }

        this.getFriends().remove(oldFriend);
        oldFriend.getFriends().remove(this);
        return true;
    }

    @Override
    public String toString() {
        return "Animal{" + "name='" + name + '\'' + ", favoriteFood='" + favoriteFood + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name)
                && Objects.equals(favoriteFood, animal.favoriteFood)
                && Objects.equals(friends, animal.friends);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, favoriteFood, friends);
    }

}
