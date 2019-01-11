import animals.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

        ArrayList<Animal> allAnimals = new ArrayList<Animal>();
        allAnimals.add(new Dog("Killian", "Meat", "Hunting dog"));
        allAnimals.add(new Dog("Rocky", "Fresh meat", "Working dog"));
        allAnimals.add(new Dog("Peter", "Pedigree", "Sport dog"));
        allAnimals.add(new Parrot("Parrote one", "Grain", false, 0.25f));
        allAnimals.add(new Parrot("Parrote two", "Corn", true, 0.5f));
        allAnimals.add(new Chicken("Chicken one", "Corn", true, 0.75f));
        allAnimals.add(new Chicken("Chicken two", "Corn", false, 0.75f));

        Integer itemChoosed = 0;
//        System.out.println(((Dog)allAnimals.get(0)).getDogType());
        while (itemChoosed != 3) {
            System.out.println("1 - List All\t2 - Live one day\t3 - Exit");
            System.out.print("Choose your option: ");
            Scanner scanner = new Scanner(System.in);

            try {
                itemChoosed = scanner.nextInt();
            }catch (Exception exc){

            }

            if (itemChoosed == 1) {
                clearConsole();
                listaAllAnimals(allAnimals);
            } else if (itemChoosed == 2) {
                clearConsole();
                liveOneDay(allAnimals);
            } else if (itemChoosed == 3) {
                System.out.println("Leaving....");
            }
            System.out.println("\n");
        }

    }


    public static int randomInt(int max) {
        return (int) Math.floor(Math.random() * max);
    }


    public static void listaAllAnimals(ArrayList<Animal> animals) {
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

    public static void liveOneDay(ArrayList<Animal> animals) {
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


    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }
    }
}