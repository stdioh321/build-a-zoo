package animals;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AnimalHandler {

    private ArrayList<Animal> listAnimals = new ArrayList<Animal>();


    public void startAnimals() {

        this.getListAnimals().add(new Dog("Killian", "Meat", "Hunting dog"));
        this.getListAnimals().add(new Dog("Rocky", "Fresh meat", "Working dog"));
        this.getListAnimals().add(new Dog("Peter", "Pedigree", "Sport dog"));
        this.getListAnimals().add(new Parrot("Parrote one", "Grain", false, 0.25f));
        this.getListAnimals().add(new Parrot("Parrote two", "Corn", true, 0.5f));
        this.getListAnimals().add(new Chicken("Chicken one", "Corn", true, 0.75f));
        this.getListAnimals().add(new Chicken("Chicken two", "Corn", false, 0.75f));

    }

    public void listAllAnimals(ArrayList<Animal> animals) {
        for (Animal a : animals) {
            System.out.println(a.toString());
            if (a.getFriends().size() < 1) {
                System.out.print("[Have no Friends]");
            } else {
                System.out.print("Friends: ");
//                String listString = list.stream().map(Object::toString).collect(Collectors.joining(", "));
                String strFriends = a.getFriends().stream().map((tmpAnimal) -> {
                    return tmpAnimal.getName();
                }).collect(Collectors.joining(", "));
                System.out.print(strFriends);

            }

            System.out.println();
        }
    }


    public void liveOneDay(ArrayList<Animal> animals) {
        for (Animal currAnimal : animals) {
            try {
                if (currAnimal.getFriends().size() > 0) {
                    if (currAnimal.loseFriendship(currAnimal.getFriends().get(0))) {
                        System.out.println(currAnimal.getName() + " has lost friendship with " + currAnimal.getFriends().get(0).getName());
                    }
                }

            } catch (Exception exc) {

            }
        }
        System.out.println("------------------------------------------------------------");
        for (Animal currAnimal : animals) {
            boolean valid = false;
            while (valid == false) {
                Animal tmpAnimal = animals.get(randomInt(animals.size()));
                if (currAnimal.stablishFriendship(tmpAnimal)) {
                    valid = true;
                    System.out.println(currAnimal.getName() + " now is friends with " + tmpAnimal.getName());
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
