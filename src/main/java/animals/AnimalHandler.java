package animals;

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
        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader("animals.json"));
            JSONObject jsonObject = (JSONObject) obj;




            // Adding dogs to the list
            JSONArray dogs = (JSONArray) jsonObject.get("dog");
            Iterator itDog = dogs.iterator();
            while (itDog.hasNext()) {
                JSONObject tmpDog = (JSONObject) itDog.next();
                listAnimals.add(new Dog((String) tmpDog.get("name"),
                        (String) tmpDog.get("favoriteFood"),
                        (String) tmpDog.get("dogType")));
            }



            // Adding  parrots to the list

            JSONArray parrot = (JSONArray) jsonObject.get("parrot");
            Iterator itParrot = parrot.iterator();
            while (itParrot.hasNext()) {
                JSONObject tmpParrot = (JSONObject) itParrot.next();
                String tmpName = (String) tmpParrot.get("name");
                String tmpFavFood = (String) tmpParrot.get("favoriteFood");
                Boolean tmpSpeak = (Boolean) tmpParrot.get("speak");
                Float tmpWingLength = Float.parseFloat(((String) tmpParrot.get("wingLength")));

                listAnimals.add(new Parrot(tmpName,tmpFavFood,tmpSpeak,tmpWingLength));
            }


            // Adding  chickens to the list
            JSONArray chickens = (JSONArray) jsonObject.get("chicken");
            Iterator itChicken = chickens.iterator();
            while (itChicken.hasNext()) {
                JSONObject tmpChicken = (JSONObject) itChicken.next();
                listAnimals.add(new Chicken((String) tmpChicken.get("name"),
                        (String) tmpChicken.get("favoriteFood"),
                        (boolean) tmpChicken.get("broiler"),
                        Float.parseFloat(((String) tmpChicken.get("wingLength")))));
            }


        } catch (Exception e) {

        }
//        listAnimals.add(new Dog("Killian", "Meat", "Hunting dog"));
//        listAnimals.add(new Dog("Rocky", "Fresh meat", "Working dog"));
//        listAnimals.add(new Dog("Peter", "Pedigree", "Sport dog"));
//        listAnimals.add(new Parrot("Parrote one", "Grain", false, 0.25f));
//        listAnimals.add(new Parrot("Parrote two", "Corn", true, 0.5f));
//        listAnimals.add(new Chicken("Chicken one", "Corn", true, 0.75f));
//        listAnimals.add(new Chicken("Chicken two", "Corn", false, 0.75f));

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
