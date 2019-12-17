package model;

import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Location {
    private String country;
    private String city;
    private String locationInCity;
    private static final Logger LOGGER = LogManager.getRootLogger();

    public Location(String country, String city, String locationInCity) {
        this.country = country;
        this.city = city;
        this.locationInCity = locationInCity;
        LOGGER.info("Location initialised");
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocationInCity() {
        return locationInCity;
    }

    public void setLocationInCity(String placeInCity) {
        this.locationInCity = placeInCity;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location place = (Location) o;
        return country.equals(place.country) &&
                city.equals(place.city) &&
                locationInCity.equals(place.locationInCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, locationInCity);
    }

    @Override
    public String toString() {
        return "Place{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", placeInCity='" + locationInCity + '\'' +
                '}';
    }
}
