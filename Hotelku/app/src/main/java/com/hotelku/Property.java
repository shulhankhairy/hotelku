package com.hotelku;

import java.util.ArrayList;

/**
 * Created by noba on 9/27/2015.
 */
public class Property {

    private String name, address, city, country, latitude, longitude, phoneNumber, email, password, description, policy, facility;
    private double distanceAirport, distanceTrain, distanceTerminal;
    private ArrayList<String>interestingPoint, picture;
    private Owner ownerData;
    private ArrayList<Room> roomData;

    public Property() {
    }


}
