package animals;

import animals.handler.JsonHandler;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class AnimalTest {

    private JsonHandler jsonHandler;

    @Before
    public void setUp() throws IOException, ParseException {
        jsonHandler = new JsonHandler("/animals.json");
    }

    @Test
    public void size() {
        assertTrue(jsonHandler.getDogs().size() > 0);
    }
}
