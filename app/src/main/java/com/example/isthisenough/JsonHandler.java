/**
package com.example.isthisenough;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonHandler extends JSONObject {

    public JSONObject createObject(int h, int min, String jtitle) {

        JSONObject obj = new JSONObject();

        try {
            obj.put("hours", h);
            obj.put("minutes", min);
            obj.put("jobtitle", jtitle);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
*/