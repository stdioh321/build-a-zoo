package animals;

import animals.model.Zoo;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AnimalTest {

    private Zoo zoo;

    @Before
    public void setUp() throws JAXBException {
        zoo = (Zoo) Util.getResourceUnMarshall("/zoo.xml", Zoo.class);
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
