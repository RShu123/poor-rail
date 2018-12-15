package hu.frameworkpattern.poorrail.Persistence;

import com.google.gson.Gson;
import hu.frameworkpattern.poorrail.Domain.Locomotief;
import hu.frameworkpattern.poorrail.Domain.Wagon;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

public class JsonConvert {


    public ArrayList<String> createJsonTrainArray(ArrayList<Locomotief> locomotieven) throws JSONException, ParseException {
        Gson json = new Gson();
        JSONParser parser = new JSONParser();
        JSONObject jsonTrainObj = new JSONObject();
        JSONArray jTrainArray = new JSONArray();

        for (Locomotief loco : locomotieven) {
            System.out.println(loco);
            String treinObject = json.toJson(loco);
            System.out.println(treinObject);
            jsonTrainObj = (JSONObject) parser.parse(treinObject);
            jTrainArray.add(jsonTrainObj);
        }
        return jTrainArray;

    }

    public ArrayList<String> createJsonWagonArray(ArrayList<Wagon> Wagons) throws JSONException, ParseException {
        Gson json = new Gson();
        JSONParser parser = new JSONParser();
        JSONObject jsonWagonObj = new JSONObject();
        JSONArray jWagonArray = new JSONArray();

        for (Wagon wagon : Wagons) {
            String wagonObject = json.toJson(wagon);
            jsonWagonObj = (JSONObject) parser.parse(wagonObject);
            jWagonArray.add(jsonWagonObj);
        }
        return jWagonArray;
    }

}

