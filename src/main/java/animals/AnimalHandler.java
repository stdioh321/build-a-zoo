package animals;

import java.util.ArrayList;
import java.util.StringJoiner;

public class AnimalHandler {

    private ArrayList<Animal> listAnimals = new ArrayList<>();


    public void startAnimals() {

        listAnimals.add(new Dog("Killian", "Meat", "Hunting dog"));
        listAnimals.add(new Dog("Rocky", "Fresh meat", "Working dog"));
        listAnimals.add(new Dog("Peter", "Pedigree", "Sport dog"));
        listAnimals.add(new Parrot("Parrote one", "Grain", false, 0.25f));
        listAnimals.add(new Parrot("Parrote two", "Corn", true, 0.5f));
        listAnimals.add(new Chicken("Chicken one", "Corn", true, 0.75f));
        listAnimals.add(new Chicken("Chicken two", "Corn", false, 0.75f));

    }

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


    public void liveOneDay(ArrayList<Animal> animals) {
        animals.forEach((currAnimal)->{
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
