package persistence;

import org.json.JSONObject;

// add citation for JsonSerializationDemo
public interface Writable {
    //EFFECTS: returns this as JSON object

    JSONObject toJson();

}
