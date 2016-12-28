package com.example.assignmentfirst.pojos;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

/**
 * Created by Inspiron on 12/27/2016.
 */

public class StoreData implements ClusterItem {
    String StoreId;
    String Name;

    public double getLat() {
        return Lat;
    }

    public void setLat(double lat) {
        Lat = lat;
    }

    public double getLong() {
        return Long;
    }

    public void setLong(double aLong) {
        Long = aLong;
    }

    double Lat;
    double Long;

    public StoreData(String storeId, String name, double lat, double aLong, String streetAddress, String postalCode, String city, String type, String description, String todaysOpeningTime, String todaysClosingTime) {
        StoreId = storeId;
        Name = name;
        Lat = lat;
        Long = aLong;
        mPosition = new LatLng(lat, Long);
        mTitle = name;
        StreetAddress = streetAddress;
        PostalCode = postalCode;
        City = city;
        Type = type;
        Description = description;
        TodaysOpeningTime = todaysOpeningTime;
        TodaysClosingTime = todaysClosingTime;
    }

    public String getStoreId() {
        return StoreId;
    }

    public void setStoreId(String storeId) {
        StoreId = storeId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public String getStreetAddress() {
        return StreetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        StreetAddress = streetAddress;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTodaysOpeningTime() {
        return TodaysOpeningTime;
    }

    public void setTodaysOpeningTime(String todaysOpeningTime) {
        TodaysOpeningTime = todaysOpeningTime;
    }

    public String getTodaysClosingTime() {
        return TodaysClosingTime;
    }

    public void setTodaysClosingTime(String todaysClosingTime) {
        TodaysClosingTime = todaysClosingTime;
    }

    String StreetAddress;
    String PostalCode;
    String City;
    String Type;
    String Description;
    String TodaysOpeningTime;
    String TodaysClosingTime;
    private final LatLng mPosition;
    private final String mTitle;

    @Override
    public LatLng getPosition() {
        return mPosition;
    }
}
