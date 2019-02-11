package zoo;

import zoo.model.Animal;
import zoo.model.Chicken;
import zoo.model.Zoo;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ChickenTest {

    private Zoo zoo;
    private Set<Animal> chickens;

    @Before
    public void setUp() {
        zoo = Util.initialZoo();
        chickens = zoo.getAnimals().stream().filter(Animal.isAnimalByClass(Chicken.class))
                .collect(Collectors.toSet());
    }

    @Test
    public void size() {
        assertTrue(chickens.size() > 0);
    }

    @Test
    public void properties() {
        chickens.forEach(chicken -> assertNotNull(chicken.getName()));
    }

}
