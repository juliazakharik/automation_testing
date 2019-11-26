package service;

import model.Location;

public class LocationCreator {
    public static final String COUNTRY = "testdata.country";
    public static final String CITY = "testdata.city";
    public static final String PLACE_IN_CITY = "testdata.place";

    public static Location withInfoFromProperty() {
        return new Location(DataReader.getData(COUNTRY),
                DataReader.getData(CITY),
                DataReader.getData(PLACE_IN_CITY));
    }
}
