package animals.handler;

import animals.model.Chicken;
import animals.model.Dog;
import animals.model.Parrot;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonHandler {
    private JSONObject mainJsonObject;

    public JsonHandler(String jsonFile) throws ParseException, IOException {
        JSONParser parser = new JSONParser();
        // Read the file that contains the animals's info
        Object obj = parser.parse(new FileReader(jsonFile));
        this.mainJsonObject = (JSONObject) obj;

    }

    // Reads the dogs on the handler file, and return a list of them
    public List<Dog> getDogs() {
        List<Dog> dogs = new ArrayList<>();
        JSONArray jDogs = (JSONArray) this.mainJsonObject.get("dog");
        Iterator itDog = jDogs.iterator();

        while (itDog.hasNext()) {
            JSONObject tmpDog = (JSONObject) itDog.next();
            dogs.add(new Dog((String) tmpDog.get("name"), (String) tmpDog.get("favoriteFood"),
                    (String) tmpDog.get("dogType")));
        }
        return dogs;
    }

    // Reads the parrots on the handler file, and return a list of them
    public List<Parrot> getParrots() {
        List<Parrot> parrots = new ArrayList<>();
        JSONArray jParrots = (JSONArray) this.mainJsonObject.get("parrot");
        Iterator itParrot = jParrots.iterator();
        while (itParrot.hasNext()) {
            JSONObject tmpParrot = (JSONObject) itParrot.next();
            parrots.add(new Parrot((String) tmpParrot.get("name"),
                    (String) tmpParrot.get("favoriteFood"), (boolean) tmpParrot.get("speak"),
                    Float.parseFloat(((String) tmpParrot.get("wingLength")))));
        }

        return parrots;
    }

    // Reads the chickens on the handler file, and return a list of them
    public List<Chicken> getChicken() {
        List<Chicken> chickens = new ArrayList<>();
        JSONArray jChickens = (JSONArray) this.mainJsonObject.get("chicken");
        Iterator itChicken = jChickens.iterator();
        while (itChicken.hasNext()) {
            JSONObject tmpChicken = (JSONObject) itChicken.next();
            chickens.add(new Chicken((String) tmpChicken.get("name"),
                    (String) tmpChicken.get("favoriteFood"), (boolean) tmpChicken.get("broiler"),
                    Float.parseFloat(((String) tmpChicken.get("wingLength")))));
        }

        return chickens;
    }
}
