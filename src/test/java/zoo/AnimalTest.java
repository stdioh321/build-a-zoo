package zoo;

import zoo.model.Zoo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AnimalTest {

    private Zoo zoo;

    @Before
    public void setUp() {
        zoo = Util.initialZoo();
    }

    @Test
    public void size() {
        assertTrue(zoo.getAnimals().size() > 0);
    }

    @Test
    public void properties() {
        zoo.getAnimals().forEach(animal -> assertNotNull(animal.getName()));
    }

}
