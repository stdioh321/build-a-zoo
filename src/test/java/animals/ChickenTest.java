package animals;

import animals.model.Animal;
import animals.model.Chicken;
import animals.model.Zoo;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ChickenTest {

    private Zoo zoo;
    private Set<Animal> chickens;

    @Before
    public void setUp() throws JAXBException {
        zoo = (Zoo) Util.getResourceUnMarshall("/zoo.xml", Zoo.class);
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
