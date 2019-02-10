package animals;

import animals.model.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class Util {

    /**
     * Generate a random Int value
     *
     * @param max
     * @return
     */
    public static int randomInt(int max) {
        return (int) Math.floor(Math.random() * max);
    }

    public static Animal randomAnimal() {
        String name = String.format("Dog %d", randomInt(100));
        String favoriteFood = String.format("Food %d", randomInt(100));
        String dogType = String.format("DogType %d", randomInt(100));

        return new Dog(name, favoriteFood, dogType);
    }

    public static Animal randomAnimalWithFriends() {
        Animal animal = randomAnimal();
        animal.establishFriendship(randomAnimal());
        return animal;
    }

    public static Object getResourceUnMarshall(String resourcePath, Class clazz)
            throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = jc.createUnmarshaller();

        InputStream resourceAsStream = Main.class.getResourceAsStream(resourcePath);
        return unmarshaller.unmarshal(resourceAsStream);
    }

    public static void marshallObject(String resourcePath, Class clazz, Object object)
            throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(clazz);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        File file = new File(resourcePath);
        marshaller.marshal(object, file);
    }

    public static List<Animal> initialAnimals() {
        List<Animal> animals = new ArrayList<>();

        animals.add(new Dog("Killian", "Meat", "Hunting dog"));
        animals.add(new Parrot("Parrot one", "Grain", false, 0.25f));
        animals.add(new Chicken("Chicken one", "Corn", true, 0.75f));
        animals.add(new Dog("Rocky", "“Fresh meat", "Working dog"));
        animals.add(new Parrot("Parrot two", "Corn", true, 0.5f));
        animals.add(new Dog("Peter", "“Pedigree", "Sport dog"));
        animals.add(new Chicken("Rocky", "Corn", false, 0.75f));

        return animals;
    }

    public static Zoo initialZoo(){
        return new Zoo(initialAnimals());
    }

    public static void writeAnimalsXML(String filePath) throws JAXBException {
        marshallObject(filePath, Zoo.class, initialZoo());
    }

}
