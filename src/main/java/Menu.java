import animals.AnimalHandler;

import java.util.Scanner;

public class Menu {
    // Display the menu cn the console
    public void start() {

        AnimalHandler animalH = new AnimalHandler();

        animalH.startAnimals();

        Integer itemChoosed = 0;
        while (itemChoosed != 3) {
            // List the menu options
            System.out.println("1 - List All Animals\t2 - Live one day\t3 - Exit");
            System.out.print("Choose your option: ");
            Scanner scanner = new Scanner(System.in);

            try {
                itemChoosed = scanner.nextInt();
                switch (itemChoosed) {
                    // 1 - For display all the animals and their friends.
                    case 1:
                        clearConsole();
                        animalH.listAllAnimals((animalH.getListAnimals()));
                        break;
                    // 2 - For each animal stop being friend with one friend and be friends with another animal
                    case 2:
                        clearConsole();
                        animalH.liveOneDay(animalH.getListAnimals());
                        break;
                    // 3 - For exit the program.
                    case 3:
                        System.out.println("Leaving....");
                        break;
                    // Case a different option is chosen
                    default:
                        System.out.println("There is no such option.");
                        break;
                }
            } catch (Exception exc) {
                System.out.println("Incorrect option.");
            }


            System.out.println();
        }
    }

    // Method to clear the console.
    public final void clearConsole() {
//        System.out.print("\033[H\033[2J");
//        System.out.flush();
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
        }
    }

}
