package animals;

import animals.model.Animal;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class UtilTest {
    @Test
    public void initialRandomTest(){
        Animal animal = Util.randomAnimalWithFriends();
        assertNotNull(animal);
        assertNotNull(animal.getName());
        assertFalse(animal.getFriends().isEmpty());
    }

    @Test
    public void marshalFileTest() {
        File zooTmpFile = null;
        try {
            zooTmpFile = File.createTempFile("zoo",".xml");
            Util.writeAnimalsXML(zooTmpFile.getAbsolutePath());
            assertTrue(zooTmpFile.length()>0);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        } finally {
            if(zooTmpFile!=null){
                zooTmpFile.delete();
            }
        }
    }
}
