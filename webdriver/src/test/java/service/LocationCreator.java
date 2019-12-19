package service;

import model.Location;

public class LocationCreator {
    public static final String COUNTRY = "testdata.country";
    public static final String CITY = "testdata.city";
    public static final String LOCATION_IN_CITY = "testdata.location";

    public static Location infoLocation() {
        return new Location(TestDataReader.getTestData(COUNTRY),
                TestDataReader.getTestData(CITY),
                TestDataReader.getTestData(LOCATION_IN_CITY));
    }
}
