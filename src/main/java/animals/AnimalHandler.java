package animals;

import json.JsonHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringJoiner;

public class AnimalHandler {

    private ArrayList<Animal> listAnimals = new ArrayList<>();


    // Add some animals objects to a list
    public void startAnimals() {
        try {
            // Object to handle the list of animals that are stored in a json file.
            JsonHandler jHandler = new JsonHandler();
            ArrayList<Dog> dogsList = jHandler.getDogs();
            ArrayList<Parrot> parrotsList = jHandler.getParrots();
            ArrayList<Chicken> chickensList = jHandler.getChicken();

            // Add dogs to the main list of animals
            dogsList.forEach((tmpDog) -> {
                listAnimals.add(tmpDog);
            });
            // Add parrots to the main list of animals
            parrotsList.forEach((tmpParrot) -> {
                listAnimals.add(tmpParrot);
            });
            // Add chickens to the main list of animals
            chickensList.forEach((tmpChicken) -> {
                listAnimals.add(tmpChicken);
            });
        } catch (Exception e) {

        }


    }

    // Display all the animals and their friends.
    public void listAllAnimals(ArrayList<Animal> animals) {
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

    // Make each animal lose a friend and get a new one
    public void liveOneDay(ArrayList<Animal> animals) {

        // Remove one friend of each animal if there is any
        animals.forEach((currAnimal) -> {
            try {
                if (currAnimal.getFriends().size() > 0) {
                    if (currAnimal.loseFriendship(currAnimal.getFriends().get(0))) {
                        System.out.println(currAnimal.getName() + " has lost friendship with " + currAnimal.getFriends().get(0).getName());
                    }
                }

            } catch (Exception exc) {

            }
        });
        System.out.println("------------------------------------------------------------");
        // Insert one friend for each animal
        for (Animal currAnimal : animals) {
            while (true) {
                Animal tmpAnimal = animals.get(randomInt(animals.size()));
                if (currAnimal.stablishFriendship(tmpAnimal)) {
                    System.out.println(currAnimal.getName() + " now is friends with " + tmpAnimal.getName());
                    break;
                }

            }

        }
    }

    // Generate a random Int value
    public static int randomInt(int max) {
        return (int) Math.floor(Math.random() * max);
    }

    public ArrayList<Animal> getListAnimals() {
        return listAnimals;
    }

    public void setListAnimals(ArrayList<Animal> listAnimals) {
        this.listAnimals = listAnimals;
    }
}
