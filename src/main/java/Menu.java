import animals.AnimalHandler;

import java.util.Scanner;

public class Menu {

    public void start() {
        AnimalHandler animalH = new AnimalHandler();
        animalH.startAnimals();

        Integer itemChoosed = 0;
        while (itemChoosed != 3) {
            System.out.println("1 - List All Animals\t2 - Live one day\t3 - Exit");
            System.out.print("Choose your option: ");
            Scanner scanner = new Scanner(System.in);

            try {
                itemChoosed = scanner.nextInt();
                switch (itemChoosed) {
                    case 1:
                        clearConsole();
                        animalH.listAllAnimals((animalH.getListAnimals()));
                        break;
                    case 2:
                        clearConsole();
                        animalH.liveOneDay(animalH.getListAnimals());
                        break;
                    case 3:
                        System.out.println("Leaving....");
                        break;
                    default:
                        System.out.println("There is no such option.");
                        break;
                }
            } catch (Exception exc) {
                System.out.println("Incorrect option.");
            }


            System.out.println("\n");
        }
    }

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
