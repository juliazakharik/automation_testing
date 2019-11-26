package service;

import model.Location;

public class LocationCreator {
    public static final String COUNTRY = "testdata.country";
    public static final String CITY = "testdata.city";
    public static final String PLACE_IN_CITY = "testdata.place";

    public static Location withInfoFromProperty() {
        return new Location(TestDataReader.getTestData(COUNTRY),
                TestDataReader.getTestData(CITY),
                TestDataReader.getTestData(PLACE_IN_CITY));
    }
}
