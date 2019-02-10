package animals;

import animals.handler.JsonHandler;
import animals.handler.Zoo;
import animals.model.Dog;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String... args) throws IOException, ParseException {

        JsonHandler jsonHandler = new JsonHandler("/animals.json");
        Zoo animalHandler = new Zoo(jsonHandler.getAnimals());

        Menu menu = new Menu(animalHandler);
        menu.start();
    }

    public static void main1(String[] args) {
        // name, String favoriteFood, String dogType
        Dog dog1 = new Dog("dog1", "carne", "t1");
        Dog dog2 = new Dog("dog2", "carne", "t2");
        Dog dog3 = new Dog("dog1", "carne", "t1");
        Set set = new HashSet<Dog>();
        set.add(dog1);
        set.add(dog2);
        set.add(dog3);
        System.out.println(set.size());

    }
}