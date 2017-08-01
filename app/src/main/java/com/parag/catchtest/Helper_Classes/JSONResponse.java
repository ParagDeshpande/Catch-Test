package com.parag.catchtest.Helper_Classes;

import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by parag on 1/08/2017.
 */

public class JSONResponse {
    public static ArrayList results;
    String jsonStr;
    DataObject obj;

    public ArrayList parseJSON(String jsonStr) {


        if (jsonStr != null) {
            try {
                JSONArray json = new JSONArray(jsonStr);
                results = new ArrayList<DataObject>();

                for (int i = 0; i < json.length(); i++) {

                    JSONObject jsonobj = json.getJSONObject(i);

                        int id = jsonobj.getInt("id");
                        String title = jsonobj.getString("title");
                        String subtitle = jsonobj.getString("subtitle");
                        String content = jsonobj.getString("content");
                        obj = new DataObject(title, subtitle,id,content);
                        results.add(i, obj);
                }

            } catch (final JSONException e) {
                Log.e("TAG", "Json parsing error: " + e.getMessage());
            }
        }
        return results;
    }
}