package animals;

import animals.handler.AnimalHandler;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Menu {

    private final AnimalHandler animalHandler;

    public Menu(AnimalHandler animalHandler){
        this.animalHandler = animalHandler;
    }
    
    /**
     * Display the menu cn the console
     *
     */
    public void start() {

        Scanner scanner = new Scanner(System.in);
        boolean done = false;
        do {
            // List the menu options
            System.out.println("1 - List All Animals\t2 - Live one day\t3 - Exit");
            System.out.print("Choose your option: ");

            switch (scanner.nextInt()) {
            // 1 - For display all the animals and their friends.
            case 1:
                clearConsole();
                animalHandler.listAllAnimals(animalHandler.getListAnimals());
                break;
            // 2 - For each animal stop being friend with one friend and be friends with
            // another animal
            case 2:
                clearConsole();
                animalHandler.liveOneDay(animalHandler.getListAnimals());
                break;
            // 3 - For exit the program.
            case 3:
                System.out.println("Leaving....");
                done = true;
                break;
            // Case a different option is chosen
            default:
                System.out.println("There is no such option.");
                break;
            }

        } while (!done);
    }

    /**
     * Method to clear the console.
     */
    public final void clearConsole() {
        IntStream.rangeClosed(0, 60).forEach(i -> System.out.println());
    }

}
