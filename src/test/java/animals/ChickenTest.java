package animals;

import animals.handler.JsonHandler;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ChickenTest {

    private JsonHandler jsonHandler;

    @Before
    public void setUp() throws IOException, ParseException {
        jsonHandler = new JsonHandler("/animals.json");
    }

    @Test
    public void size() {
        assertTrue(jsonHandler.getChicken().size() > 0);
    }

    @Test
    public void properties() {
        jsonHandler.getChicken().forEach( chicken -> assertNotNull(chicken.getName()));
    }

}
