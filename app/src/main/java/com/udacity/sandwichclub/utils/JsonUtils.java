package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        Sandwich sandwich = new Sandwich();
        try {

            JSONObject reader = new JSONObject(json);
            JSONObject name = reader.getJSONObject("name");
            sandwich.setMainName(name.getString("mainName"));
            sandwich.setAlsoKnownAs(getArrayListFromJsonArray(name.getJSONArray("alsoKnownAs")));
            sandwich.setPlaceOfOrigin(reader.getString("placeOfOrigin"));
            sandwich.setDescription(reader.getString("description"));
            sandwich.setImage(reader.getString("image"));
            sandwich.setIngredients(getArrayListFromJsonArray(reader.getJSONArray("ingredients")));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sandwich;
    }

    private static ArrayList getArrayListFromJsonArray(JSONArray jsonArray) {
        ArrayList<String> listdata = new ArrayList<String>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                listdata.add(jsonArray.getString(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return listdata;
    }
}
