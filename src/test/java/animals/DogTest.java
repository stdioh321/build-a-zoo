package animals;

import animals.model.Zoo;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBException;

public class DogTest {

    private Zoo zoo;

    @Before
    public void setUp() throws JAXBException {
        zoo = (Zoo) Util.getResourceUnMarshall("/zoo.xml", Zoo.class);
    }

    @Test
    public void size() {

        // assertTrue(zoo.getDogs().size() > 0);
    }

    @Test
    public void properties() {

        // jsonHandler.getDogs().forEach(dog -> assertNotNull(dog.getDogType()));
    }

}
