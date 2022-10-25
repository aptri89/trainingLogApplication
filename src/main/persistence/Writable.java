package persistence;

// Method was taken from Writable in:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

import org.json.JSONObject;

// add citation for JsonSerializationDemo
public interface Writable {
    //EFFECTS: returns this as JSON object

    JSONObject toJson();

}
