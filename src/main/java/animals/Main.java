package animals;

import animals.handler.AnimalHandler;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {

    public static void main(String... args) throws IOException, ParseException {
        AnimalHandler animalHandler = new AnimalHandler();
        animalHandler.loadFromJsonFile("/animals.json");

        Menu menu = new Menu(animalHandler);
        menu.start();
    }
}