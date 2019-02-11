package zoo.model;

import zoo.Util;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@XmlRootElement
public class Zoo implements Serializable {

    @XmlElementWrapper
    @XmlElements({ @XmlElement(name = "bird", type = Bird.class),
            @XmlElement(name = "chicken", type = Chicken.class),
            @XmlElement(name = "dog", type = Dog.class),
            @XmlElement(name = "parrot", type = Parrot.class) })
    private List<Animal> animals;

    public Zoo() {
        this.animals = new ArrayList<>();
    }

    public Zoo(List<Animal> animals) {
        this.animals = animals;
    }

    /**
     * Display all the zoo and their friends.
     */
    public void printAllAnimals() {
        for (Animal animal : animals) {

            System.out.println(animal.toString());

            if (animal.getFriends().isEmpty()) {
                System.out.print("[Have no Friends]");
            } else {
                animal.printFriends(System.out);
            }

            System.out.println();
        }
    }

    /**
     * Make each animal lose a friend and get a new one
     **/
    public void printLiveOneDay() {

        removeOneFriendOfEachAnimalIfThereIsAny();

        System.out.println("------------------------------------------------------------");

        insertOneFriendForEachAnimal();
    }

    private void addNRandomFriend(Animal animal, int nFriends) {
        int amountOfFriends = animal.getFriends().size() + nFriends;
        while (animal.getFriends().size() < amountOfFriends) {
            Animal randomAnimal = pickRandomAnimal();
            if (animal.establishFriendship(randomAnimal)) {
                System.out.printf("%s now is friends with %s%n", animal.getName(),
                        randomAnimal.getName());
            }
        }
    }

    private void addOneRandomFriend(Animal animal) {
        addNRandomFriend(animal, 1);
    }

    public Animal pickRandomAnimal() {
        return animals.get(Util.randomInt(animals.size()));
    }

    private void insertOneFriendForEachAnimal() {
        animals.stream().forEach(this::addOneRandomFriend);
    }

    private void removeOneFriend(Animal animal) {
        Optional<Animal> first = animal.getFriends().stream().findFirst();
        if (first.isPresent()) {
            Animal friend = first.get();
            if (animal.loseFriendship(friend)) {
                System.out.printf("%s has lost friendship with %s%n", animal.getName(),
                        friend.getName());
            }
        }
    }

    private void removeOneFriendOfEachAnimalIfThereIsAny() {
        animals.stream().forEach(this::removeOneFriend);
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
