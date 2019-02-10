package animals;

import animals.Main;
import animals.model.Animal;
import animals.model.Dog;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.InputStream;

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

}
