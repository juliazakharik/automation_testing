package runner;

import action.PlanesCreator;
import entity.airport.Airport;

public final class Runner {
    private Runner() {
    }
    public static void main(final String[] args) {
        Airport airport = new Airport(new PlanesCreator().getPlanesList());
        Airport militaryAirport = new Airport(airport.getMilitaryPlanes());
        Airport passengerAirport = new Airport(airport.getPassengerPlanes());
        System.out.println("Military airport sorted by max distance: "
                + militaryAirport.sortByMaxDistance().toString());
        System.out.println("Passenger airport sorted by max speed: "
                + passengerAirport.sortByMaxSpeed().toString());
        System.out.println("Plane with max passenger capacity: "
                + passengerAirport.
                getPassengerPlaneWithMaxPassengersCapacity());
    }
}
