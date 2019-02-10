package animals;

import animals.model.Animal;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilTest {
    @Test
    public void initialRandomTest(){
        Animal animal = Util.randomAnimalWithFriends();
        assertNotNull(animal);
        assertNotNull(animal.getName());
        assertFalse(animal.getFriends().isEmpty());
    }
}
