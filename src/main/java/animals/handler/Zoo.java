package animals.handler;

import animals.model.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Zoo {

    private List<Animal> animals;

    public Zoo() {
         this.animals = new ArrayList<>();
    }

    public Zoo(List<Animal> animals) {
        this.animals = animals;
    }

    /**
     * Display all the animals and their friends.
     */
    public void printAllAnimals() {
        for (Animal animal : animals) {

            System.out.println(animal.toString());

            if (animal.getFriends().isEmpty()) {
                System.out.print("[Have no Friends]");
            } else {
                System.out.print("Friends: ");
                animal.printFriends(System.out);
            }

            System.out.println();
        }
    }

    /**
     * Make each animal lose a friend and get a new one
     */
    public void printLiveOneDay() {

        // Remove one friend of each animal if there is any
        removeOneFriendOfEachAnimalIfThereIsAny();

        System.out.println("------------------------------------------------------------");

        // Insert one friend for each animal
        insertOneFriendForEachAnimal();
    }

    private void addOneRandomFriend(Animal animal){
        do{
            Animal randomAnimal = animals.get(randomInt(animals.size()));
            if( animal.establishFriendship(randomAnimal) ){
                System.out.printf("%s now is friends with %s\n", animal.getName(), randomAnimal.getName());
                break;
            }
        } while(!animals.isEmpty());
    }

    private void insertOneFriendForEachAnimal(){
        animals.stream().forEach(this::addOneRandomFriend);
    }

    private void removeOneFriend(Animal animal){
        Optional<Animal> first = animal.getFriends().stream().findFirst();
        if(first.isPresent()){
            Animal friend = first.get();
            if(animal.loseFriendship(friend)){
                System.out.printf("%s has lost friendship with %s\n", animal.getName(), friend.getName());
            }
        }
    }

    private void removeOneFriendOfEachAnimalIfThereIsAny(){
        animals.stream().forEach(this::removeOneFriend);
    }

    /**
     * Generate a random Int value
     *
     * @param max
     * @return
     */
    public static int randomInt(int max) {
        return (int) Math.floor(Math.random() * max);
    }

}
