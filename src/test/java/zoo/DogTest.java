package zoo;

import zoo.model.Animal;
import zoo.model.Dog;
import zoo.model.Zoo;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DogTest {

    private Zoo zoo;
    private Set<Animal> dogs;

    @Before
    public void setUp() {
        zoo = Util.initialZoo();
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
