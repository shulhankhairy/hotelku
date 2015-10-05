package com.hotelku;

/**
 * Created by noba on 9/27/2015.
 */
public class Room {

    private String name, picture, facility;
    private int avaibility;

    public Room() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public int getAvaibility() {
        return avaibility;
    }

    public void setAvaibility(int avaibility) {
        this.avaibility = avaibility;
    }
}
