package animals;

import animals.model.Animal;
import animals.model.Chicken;
import animals.model.Dog;
import animals.model.Zoo;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DogTest {

    private Zoo zoo;
    private Set<Animal> dogs;

    @Before
    public void setUp() throws JAXBException {
        zoo = (Zoo) Util.getResourceUnMarshall("/zoo.xml", Zoo.class);
        dogs = zoo.getAnimals().stream().filter(Animal.isAnimalByClass(Dog.class))
                .collect(Collectors.toSet());
    }

    @Test
    public void size() {
        assertTrue(dogs.size() > 0);
    }

    @Test
    public void properties() {
        dogs.forEach(dog -> assertNotNull(((Dog) dog).getDogType()));
    }

}
