package com.bcpratt.foodfinder.model;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private Context context;

    public String getAddress() {
        return address;
    }

    public boolean isChainRestaurant() {
        return isChainRestaurant;
    }

    public LatLng getCoordinates() {
        return coordinates;
    }

    public double getLatitude(){
        return coordinates.latitude;
    }

    public double getLongitude(){
        return coordinates.longitude;
    }

    public ArrayList<MenuItem> getMenu() {
        return menu;
    }

    private String address;
    private boolean isChainRestaurant;
    private LatLng coordinates;
    ArrayList<MenuItem> menu;

    public Restaurant(Context context, String address, boolean isChainRestaurant, ArrayList<MenuItem> menu){
        this.address = address;
        this.isChainRestaurant = isChainRestaurant;
        this.menu = menu;
        this.context = context;

        this.coordinates = getLocationFromAddress(context, address);

    }
    public Restaurant(Context context, String address, boolean isChainRestaurant){
        this.address = address;
        this.isChainRestaurant = isChainRestaurant;
        this.context = context;

        this.coordinates = getLocationFromAddress(context, address);

    }

    private LatLng getLocationFromAddress(Context context, String strAddress) {

        Geocoder coder = new Geocoder(context);
        List<Address> address;
        LatLng p1 = null;

        try {
            // May throw an IOException
            address = coder.getFromLocationName(strAddress, 5);
            if (address == null) {
                return null;
            }

            Address location = address.get(0);
            p1 = new LatLng(location.getLatitude(), location.getLongitude() );

        } catch (IOException ex) {

            ex.printStackTrace();
        }

        return p1;
    }
}
