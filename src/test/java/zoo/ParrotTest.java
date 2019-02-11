package zoo;

import zoo.model.Animal;
import zoo.model.Parrot;
import zoo.model.Zoo;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ParrotTest {

    private Zoo zoo;
    private Set<Animal> perrots;

    @Before
    public void setUp() {
        zoo = Util.initialZoo();
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
