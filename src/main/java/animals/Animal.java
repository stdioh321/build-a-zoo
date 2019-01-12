package animals;

import java.util.ArrayList;
import java.util.Objects;

public class Animal {
    private String name;
    private String favoriteFood;
    private ArrayList<Animal> friends = new ArrayList<Animal>();


    public Animal(String name, String favoriteFood) {
        this.name = name;
        this.favoriteFood = favoriteFood;

    }

    public Animal(String name, String favoriteFood, ArrayList<Animal> friends) {
        this.name = name;
        this.favoriteFood = favoriteFood;
        this.friends = friends;
    }

    public ArrayList<Animal> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<Animal> friends) {
        this.friends = friends;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public boolean stablishFriendship(Animal newFriend) {
        if (this.getFriends().contains(newFriend) || newFriend.getFriends().contains(this) || this.equals(newFriend)) {
            return false;
        }
        this.getFriends().add(newFriend);
        newFriend.getFriends().add(this);

        return true;
    }

    public boolean loseFriendship(Animal oldFriend) {
        try {
            if (!this.getFriends().contains(oldFriend) || !oldFriend.getFriends().contains(this)) {
                return false;
            }
        } catch (Exception exc) {

        }

        this.getFriends().remove(oldFriend);
        oldFriend.getFriends().remove(this);
        return true;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", favoriteFood='" + favoriteFood + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name) &&
                Objects.equals(favoriteFood, animal.favoriteFood) &&
                Objects.equals(friends, animal.friends);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, favoriteFood, friends);
    }
}
