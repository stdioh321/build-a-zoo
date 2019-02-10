package animals;

import animals.model.Animal;
import animals.model.Parrot;
import animals.model.Zoo;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ParrotTest {

    private Zoo zoo;
    private Set<Animal> perrots;

    @Before
    public void setUp() throws JAXBException {
        zoo = (Zoo) Util.getResourceUnMarshall("/zoo.xml", Zoo.class);
        perrots = zoo.getAnimals().stream().filter(Animal.isAnimalByClass(Parrot.class))
                .collect(Collectors.toSet());
    }

    @Test
    public void size() {
        assertTrue(perrots.size() > 0);
    }

    @Test
    public void properties() {
        perrots.forEach(parrot -> assertNotNull(parrot.getName()));
    }

}
