package animals;

import java.util.ArrayList;

public class AnimalHandler {

    private ArrayList<Animal> listAnimals = new ArrayList<Animal>();

    public ArrayList<Animal> getListAnimals() {
        return listAnimals;
    }

    public void setListAnimals(ArrayList<Animal> listAnimals) {
        this.listAnimals = listAnimals;
    }

    public void startAnimals(){

        this.getListAnimals().add(new Dog("Killian", "Meat", "Hunting dog"));
        this.getListAnimals().add(new Dog("Rocky", "Fresh meat", "Working dog"));
        this.getListAnimals().add(new Dog("Peter", "Pedigree", "Sport dog"));
        this.getListAnimals().add(new Parrot("Parrote one", "Grain", false, 0.25f));
        this.getListAnimals().add(new Parrot("Parrote two", "Corn", true, 0.5f));
        this.getListAnimals().add(new Chicken("Chicken one", "Corn", true, 0.75f));
        this.getListAnimals().add(new Chicken("Chicken two", "Corn", false, 0.75f));

    }

    public void listaAllAnimals(ArrayList<Animal> animals) {
        for (Animal a : animals) {
            System.out.println(a.toString());
            if (a.getFriends().size() < 1) {
                System.out.print("[Have no Friends]");

            } else {
                System.out.print("Friends: ");
                for (Animal a2 : a.getFriends()) {
                    System.out.print(a2.getName() + ", ");
                }
            }

            System.out.println();
        }
    }


    public void liveOneDay(ArrayList<Animal> animals) {
        for (Animal a2 : animals) {
//            System.out.println(a.getName() + " - " + a.getFriends().size());
            try {
                if (a2.getFriends().size() > 0) {
                    if (a2.loseFriendship(a2.getFriends().get(0))) {
                        System.out.println(a2.getName() + " has lost friendship with " + a2.getFriends().get(0).getName());
                    }
                }

            } catch (Exception exc) {

            }
        }
        for (Animal a2 : animals) {
            boolean valid = false;
            while (valid == false) {
                if (a2.stablishFriendship(animals.get(randomInt(animals.size())))) {
                    valid = true;
                }

            }

        }
    }

    public static int randomInt(int max) {
        return (int) Math.floor(Math.random() * max);
    }

}
