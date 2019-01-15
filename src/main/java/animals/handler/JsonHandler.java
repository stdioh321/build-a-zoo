package animals.handler;

import animals.model.Animal;
import animals.model.Chicken;
import animals.model.Dog;
import animals.model.Parrot;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JsonHandler {
    private JSONObject jsonObject;

    public JsonHandler(String jsonResourcePath) throws IOException, ParseException {
        InputStream resourceAsStream = JsonHandler.class.getResourceAsStream(jsonResourcePath);
        // Read the file that contains the animals's info
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new InputStreamReader(resourceAsStream));
        this.jsonObject = (JSONObject) obj;
    }

    /**
     * Reads the dogs on the handler file, and return a list of them
     * 
     * @return
     */
    public List<Dog> getDogs() {
        List<Dog> dogs = new ArrayList<>();

        List<JSONObject> jsonObjectList = toJSONObject((JSONArray) this.jsonObject.get("dog"));
        jsonObjectList.forEach(jsonObject -> dogs.add(toDog(jsonObject)));

        return dogs;
    }

    /**
     * Reads the parrots on the handler file, and return a list of them
     * 
     * @return
     */
    public List<Parrot> getParrots() {
        List<Parrot> parrots = new ArrayList<>();

        List<JSONObject> jsonObjectList = toJSONObject((JSONArray) this.jsonObject.get("parrot"));
        jsonObjectList.forEach(jsonObject -> parrots.add(toParrot(jsonObject)));

        return parrots;
    }

    /**
     * Reads the chickens on the handler file, and return a list of them
     * 
     * @return
     */
    public List<Chicken> getChicken() {
        List<Chicken> chickens = new ArrayList<>();

        List<JSONObject> jsonObjectList = toJSONObject((JSONArray) this.jsonObject.get("chicken"));
        jsonObjectList.forEach(jsonObject -> chickens.add(toChicken(jsonObject)));

        return chickens;
    }

    public List<Animal> getAnimals() {
        List<Animal> animals = new ArrayList<>();
        animals.addAll(getDogs());
        animals.addAll(getParrots());
        animals.addAll(getChicken());
        return animals;
    }

    public List<JSONObject> toJSONObject(JSONArray jsonArray) {
        List<JSONObject> jsonObjectList = new ArrayList<>();
        jsonArray.forEach(s -> jsonObjectList.add((JSONObject) s));
        return jsonObjectList;
    }

    public static Dog toDog(JSONObject json) {
        return new Dog((String) json.get("name"), (String) json.get("favoriteFood"),
                (String) json.get("dogType"));
    }

    public static Parrot toParrot(JSONObject json) {
        return new Parrot((String) json.get("name"), (String) json.get("favoriteFood"),
                (boolean) json.get("speak"), Float.parseFloat(((String) json.get("wingLength"))));
    }

    public static Chicken toChicken(JSONObject json) {
        return new Chicken((String) json.get("name"), (String) json.get("favoriteFood"),
                (boolean) json.get("broiler"), Float.parseFloat(((String) json.get("wingLength"))));
    }

}
