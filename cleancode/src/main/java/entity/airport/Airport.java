package entity.airport;

import entity.plane.ExperimentalPlane;
import entity.plane.MilitaryPlane;
import entity.plane.PassengerPlane;
import entity.plane.Plane;
import entity.type.MilitaryType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Airport{

    private List<? extends Plane> planes;

    public Airport(final List<? extends Plane> newPlanes) {
            this.planes = newPlanes;
            }

    public void setPlanes(final List<? extends Plane> newPlanes) {
            this.planes = newPlanes;
            }

    public List<? extends Plane> getPlanes() {
            return planes;
            }

    public List<PassengerPlane> getPassengerPlanes() {
            List<PassengerPlane> passengerPlanes = new ArrayList<>();

            for (Plane plane : this.planes) {
            if (plane instanceof PassengerPlane) {
            passengerPlanes.add((PassengerPlane) plane);
            }
            }

            return passengerPlanes;
            }

    public List<MilitaryPlane> getMilitaryPlanes() {
            List<MilitaryPlane> militaryPlanes = new ArrayList<>();

            for (Plane plane : this.planes) {
            if (plane instanceof MilitaryPlane) {
            militaryPlanes.add((MilitaryPlane) plane);
            }
            }

            return militaryPlanes;
            }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
            PassengerPlane planeWithMaxCapacity = getPassengerPlanes().get(0);

            for (PassengerPlane passengerPlane : getPassengerPlanes()) {
            if (passengerPlane.getPassengersCapacity()
            > planeWithMaxCapacity.getPassengersCapacity()) {
            planeWithMaxCapacity = passengerPlane;
            }
            }

            return planeWithMaxCapacity;
            }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
            List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();

            for (MilitaryPlane militaryPlane : getMilitaryPlanes()) {
            if (militaryPlane.getType() == MilitaryType.TRANSPORT) {
            transportMilitaryPlanes.add(militaryPlane);
            }
            }

            return transportMilitaryPlanes;
            }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
            List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();

            for (MilitaryPlane militaryPlane : getMilitaryPlanes()) {
            if (militaryPlane.getType() == MilitaryType.BOMBER) {
            bomberMilitaryPlanes.add(militaryPlane);
            }
            }

            return bomberMilitaryPlanes;
            }

    public List<ExperimentalPlane> getExperimentalPlanes() {
            List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();

            for (Plane plane : this.planes) {
            if (plane instanceof ExperimentalPlane) {
            experimentalPlanes.add((ExperimentalPlane) plane);
            }
            }

            return experimentalPlanes;
            }

    @Override
    public String toString() {
            return "by.epam.aircompany.entity.Airport{"
            + "Planes=" + planes.toString()
            + '}';
            }

    public Airport sortByMaxDistance() {
            planes.sort(new Comparator<Plane>() {
    public int compare(final Plane o1, final Plane o2) {
            return o1.getMaxFlightDistance() - o2.getMaxFlightDistance();
            }
            });

            return this;
            }

    /**
     * Sorts by max speed.
     * @return by.epam.aircompany.entity.Airport
     */
    public Airport sortByMaxSpeed() {
            planes.sort(new Comparator<Plane>() {
    public int compare(final Plane o1, final Plane o2) {
            return o1.getMaxSpeed() - o2.getMaxSpeed();
            }
            });

            return this;
            }

    public Airport sortByMaxLoadCapacity() {
            planes.sort(new Comparator<Plane>() {
    public int compare(final Plane o1, final Plane o2) {
            return o1.getMaxLoadCapacity() - o2.getMaxLoadCapacity();
            }
            });

            return this;
            }
        }