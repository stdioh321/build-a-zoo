package animals.handler;

import animals.model.Animal;
import animals.model.Chicken;
import animals.model.Dog;
import animals.model.Parrot;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class AnimalHandler {

    private List<Animal> listAnimals = new ArrayList<>();

    /**
     * Add some animals objects to a list
     * @param jsonResourcePath
     * @throws IOException
     * @throws ParseException
     */
    public void startAnimals(String jsonResourcePath) throws IOException, ParseException {
        // Object to handle the list of animals that are stored in a handler file.
        JsonHandler jHandler = new JsonHandler(jsonResourcePath);
        List<Dog> dogsList = jHandler.getDogs();
        List<Parrot> parrotsList = jHandler.getParrots();
        List<Chicken> chickensList = jHandler.getChicken();

        // Add dogs to the main list of animals
        dogsList.forEach(tmpDog -> listAnimals.add(tmpDog));
        // Add parrots to the main list of animals
        parrotsList.forEach(tmpParrot -> listAnimals.add(tmpParrot));
        // Add chickens to the main list of animals
        chickensList.forEach(tmpChicken -> listAnimals.add(tmpChicken));

    }

    /**
     * Display all the animals and their friends.
     * @param animals
     */
    public void listAllAnimals(List<Animal> animals) {
        for (Animal a : animals) {
            System.out.println(a.toString());
            if (a.getFriends().size() < 1) {
                System.out.print("[Have no Friends]");
            } else {
                System.out.print("Friends: ");
                StringJoiner joiner = new StringJoiner(", ");
                for (Animal tmpAnimal : a.getFriends()) {
                    String name = tmpAnimal.getName();
                    joiner.add(name);
                }
                String strFriends = joiner.toString();
                System.out.print(strFriends);
            }

            System.out.println();
        }
    }

    /**
     * Make each animal lose a friend and get a new one
     * @param animals
     */
    public void liveOneDay(List<Animal> animals) {

        // Remove one friend of each animal if there is any
        animals.forEach(currAnimal -> {
            if (currAnimal.getFriends().size() > 0) {
                if (currAnimal.loseFriendship(currAnimal.getFriends().get(0))) {
                    System.out.println(currAnimal.getName() + " has lost friendship with "
                            + currAnimal.getFriends().get(0).getName());
                }
            }

        });
        System.out.println("------------------------------------------------------------");

        // Insert one friend for each animal
        for (Animal currAnimal : animals) {
            while (true) {
                Animal tmpAnimal = animals.get(randomInt(animals.size()));
                if (currAnimal.establishFriendship(tmpAnimal)) {
                    System.out.println(
                            currAnimal.getName() + " now is friends with " + tmpAnimal.getName());
                    break;
                }

            }
        }
    }

    /**
     * Generate a random Int value
     * @param max
     * @return
     */
    public static int randomInt(int max) {
        return (int) Math.floor(Math.random() * max);
    }

    public List<Animal> getListAnimals() {
        return listAnimals;
    }

}
