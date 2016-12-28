package com.example.assignmentfirst.api;

import com.example.assignmentfirst.extras.Keys;
import com.example.assignmentfirst.pojos.StoreData;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Inspiron on 12/27/2016.
 */

public class Parser {


    public static ArrayList<StoreData> parseData(String string){
        ArrayList<StoreData> dealsPojoArrayList =  new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(string);
            JSONObject jsonObject6 = jsonObject.getJSONObject(Keys.GetAllStoresResult);
            JSONArray jsonArray = jsonObject6.getJSONArray(Keys.StoreList);
            if(jsonArray.length() != 0){
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    dealsPojoArrayList.add(new StoreData(jsonObject1.getString(Keys.StoreId),
                            jsonObject1.getString(Keys.Name),
                            jsonObject1.getDouble(Keys.Lat),
                            jsonObject1.getDouble(Keys.Long),
                            jsonObject1.getString(Keys.StreetAddress),
                            jsonObject1.getString(Keys.PostalCode),
                            jsonObject1.getString(Keys.City),
                            jsonObject1.getString(Keys.Type),
                            jsonObject1.getString(Keys.Description),
                            jsonObject1.getString(Keys.TodaysOpeningTime),
                            jsonObject1.getString(Keys.TodaysClosingTime)));
//                    if(jsonObject1.has(Keys.StoreId))
//                        pojo.setStoreId(jsonObject1.getString(Keys.StoreId));
//                    if(jsonObject1.has(Keys.Name))
//                        pojo.setName(jsonObject1.getString(Keys.Name));
//                    if(jsonObject1.has(Keys.Lat) && jsonObject1.getString(Keys.Lat)!=  null)
//                        pojo.setLat(jsonObject1.getDouble(Keys.Lat));
//                    if(jsonObject1.has(Keys.Long) && jsonObject1.getString(Keys.Long)!=  null)
//                        pojo.setLong(jsonObject1.getDouble(Keys.Long));
//                    if(jsonObject1.has(Keys.StreetAddress))
//                        pojo.setStreetAddress(jsonObject1.getString(Keys.StreetAddress));
//                    if(jsonObject1.has(Keys.PostalCode))
//                        pojo.setPostalCode(jsonObject1.getString(Keys.PostalCode));
//                    if(jsonObject1.has(Keys.City))
//                        pojo.setCity(jsonObject1.getString(Keys.City));
//                    if(jsonObject1.has(Keys.Type))
//                        pojo.setType(jsonObject1.getString(Keys.Type));
//                    if(jsonObject1.has(Keys.Description))
//                        pojo.setDescription(jsonObject1.getString(Keys.Description));
//                    if(jsonObject1.has(Keys.TodaysOpeningTime))
//                        pojo.setTodaysOpeningTime(jsonObject1.getString(Keys.TodaysOpeningTime));
//                    if(jsonObject1.has(Keys.TodaysClosingTime))
//                        pojo.setTodaysClosingTime(jsonObject1.getString(Keys.TodaysClosingTime));
                }
            }
            return dealsPojoArrayList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dealsPojoArrayList;
    }
}

