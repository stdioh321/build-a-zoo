package zoo;

import org.eclipse.persistence.jaxb.JAXBContextProperties;
import zoo.model.*;

import javax.activation.MimeType;
import javax.xml.bind.*;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Util {

    private static Random random = new Random();

    private Util() {
    }

    public static int randomInt(int max) {
        return random.nextInt(max);
    }

    public static int randomInt() {
        return random.nextInt();
    }

    public static Animal randomAnimal() {
        String name = String.format("Dog %d", randomInt());
        String favoriteFood = String.format("Food %d", randomInt());
        String dogType = String.format("DogType %d", randomInt());

        return new Dog(name, favoriteFood, dogType);
    }

    public static Animal randomAnimalWithFriends() {
        Animal animal = randomAnimal();
        animal.establishFriendship(randomAnimal());
        return animal;
    }

    static{
        System.getProperties().setProperty("javax.xml.bind.context.factory","org.eclipse.persistence.jaxb.JAXBContextFactory");
    }

    public static Unmarshaller getUnmarshaller(Class clazz) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(clazz);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        unmarshaller.setProperty(JAXBContextProperties.MEDIA_TYPE, "application/json");

        return unmarshaller;
    }

    public static Marshaller getMarshaller(Class clazz) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(clazz);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(JAXBContextProperties.MEDIA_TYPE, "application/json");

        return marshaller;
    }

    public static Object getResourceUnMarshall(String resourcePath, Class clazz)
            throws JAXBException {
        Unmarshaller unmarshaller = getUnmarshaller(clazz);
        InputStream resourceAsStream = Main.class.getResourceAsStream(resourcePath);
        return unmarshaller.unmarshal(resourceAsStream);
    }

    public static void marshallObject(String resourcePath, Class clazz, Object object)
            throws JAXBException {
        Marshaller marshaller = getMarshaller(clazz);
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

    public static Zoo initialZoo() {
        return new Zoo(initialAnimals());
    }

    public static void writeAnimalsXML(String filePath) throws JAXBException {
        marshallObject(filePath, Zoo.class, initialZoo());
    }

}
