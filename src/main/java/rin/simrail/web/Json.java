package rin.simrail.web;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


public class Json {
    public static String[] json(String json, String server, String trainNumber) {
        Gson gson = new Gson();
        var data = gson.fromJson(json, JsonObject.class);
        /*for (var i : data){
            var trainNoLocal = gson.fromJson(data, String.class);
            if (trainNoLocal.equals(trainNumber)){
                System.out.println(data);
                break;
            }
        }*/
        System.out.println(data);
        return null;
    }
}