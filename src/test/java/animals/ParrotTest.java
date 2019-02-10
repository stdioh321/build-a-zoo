package animals;

import animals.model.Zoo;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class ParrotTest {

    private Zoo zoo;

    @Before
    public void setUp() throws IOException, JAXBException {
        zoo = (Zoo) Util.getResourceUnMarshall("/zoo.xml", Zoo.class);
    }

    @Test
    public void size() {
        // assertTrue(zoo.getAnimals().getParrots().size() > 0);
    }

    @Test
    public void properties() {

        // zoo.getParrots().forEach(parrot -> assertNotNull(parrot.getName()));
    }

}
