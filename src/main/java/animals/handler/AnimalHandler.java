package animals.handler;

import animals.model.Animal;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class AnimalHandler {

    private List<Animal> animals = new ArrayList<>();

    /**
     * Add some animals objects to a list
     * 
     * @param jsonResourcePath
     * @throws IOException
     * @throws ParseException
     */
    public void loadFromJsonFile(String jsonResourcePath) throws IOException, ParseException {
        // Object to handle the list of animals that are stored in a handler file.
        JsonHandler jHandler = new JsonHandler(jsonResourcePath);
        animals.addAll(jHandler.getAnimals());
    }

    /**
     * Display all the animals and their friends.
     * 
     */
    public void printAllAnimals() {
        for (Animal animal : animals) {
            System.out.println(animal.toString());
            if (animal.getFriends().size() < 1) {
                System.out.print("[Have no Friends]");
            } else {
                System.out.print("Friends: ");
                StringJoiner joiner = new StringJoiner(", ");
                for (Animal friend : animal.getFriends()) {
                    joiner.add(friend.getName());
                }
                String strFriends = joiner.toString();
                System.out.print(strFriends);
            }

            System.out.println();
        }
    }

    /**
     * Make each animal lose a friend and get a new one
     * 
     */
    public void printLiveOneDay() {

        // Remove one friend of each animal if there is any
        animals.forEach(currAnimal -> {
            if (currAnimal.getFriends().size() > 0) {
                if (currAnimal.loseFriendship(currAnimal.getFriends().get(0))) {
                    System.out.printf("%s has lost friendship with %s\n", currAnimal.getName(),
                            currAnimal.getFriends().get(0).getName());
                }
            }

        });
        System.out.println("------------------------------------------------------------");

        // Insert one friend for each animal
        for (Animal currAnimal : animals) {
            while (true) {
                Animal randomAnimal = animals.get(randomInt(animals.size()));
                if (currAnimal.establishFriendship(randomAnimal)) {
                    System.out.printf("%s now is friends with %s\n", currAnimal.getName(),
                            randomAnimal.getName());
                    break;
                }

            }
        }
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

    public List<Animal> getAnimals() {
        return animals;
    }

}
