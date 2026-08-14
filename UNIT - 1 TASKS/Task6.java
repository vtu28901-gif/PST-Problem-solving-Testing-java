import java.util.*;

public class Task6 {

    static abstract class Vehicle {
        abstract int calculateFare(int distance);
    }

    static class Bike extends Vehicle {
        int calculateFare(int distance) {
            return distance * 5;
        }
    }

    static class Auto extends Vehicle {
        int calculateFare(int distance) {
            return distance * 12;
        }
    }

    static class Cab extends Vehicle {
        int calculateFare(int distance) {
            return distance * 12;
        }
    }

    static class Driver {
        String name;

        Driver(String name) {
            this.name = name;
        }
    }

    static class Rider {
        String name;

        Rider(String name) {
            this.name = name;
        }
    }

    static class Trip {
        Rider rider;
        Driver driver;
        Vehicle vehicle;
        int distance;

        Trip(Rider rider, Driver driver, Vehicle vehicle, int distance) {
            if (distance <= 0) {
                throw new IllegalArgumentException("Invalid distance");
            }

            this.rider = rider;
            this.driver = driver;
            this.vehicle = vehicle;
            this.distance = distance;
        }

        int getFare() {
            return vehicle.calculateFare(distance);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int distance = sc.nextInt();

            try {
                Vehicle vehicle;

                if (type.equalsIgnoreCase("Bike")) {
                    vehicle = new Bike();
                } else if (type.equalsIgnoreCase("Auto")) {
                    vehicle = new Auto();
                } else if (type.equalsIgnoreCase("Cab")) {
                    vehicle = new Cab();
                } else {
                    throw new IllegalArgumentException("Invalid ride type");
                }

                Rider rider = new Rider("Rider");
                Driver driver = new Driver("Driver");

                Trip trip = new Trip(rider, driver, vehicle, distance);

                System.out.println(trip.getFare());

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid booking");
            }
        }
    }
}