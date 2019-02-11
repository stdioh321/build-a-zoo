package zoo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ AnimalTest.class, ChickenTest.class, DogTest.class, ParrotTest.class })
public class AllTests {
}