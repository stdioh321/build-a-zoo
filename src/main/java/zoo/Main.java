package zoo;

import zoo.model.Zoo;

import javax.xml.bind.JAXBException;

public class Main {

    public static void main(String... args) throws JAXBException {

        Zoo zoo = (Zoo) Util.getResourceUnMarshall("/zoo.json", Zoo.class);

        Menu menu = new Menu(zoo);
        menu.start();
    }

}