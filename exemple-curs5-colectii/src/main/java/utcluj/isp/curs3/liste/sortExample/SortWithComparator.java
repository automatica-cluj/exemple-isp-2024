package utcluj.isp.curs3.liste.sortExample;

public class SortWithComparator {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[4];
        vehicles[0] = new Vehicle("Ford", "Focus", 2010, 10000);
        vehicles[1] = new Vehicle("Audi", "A4", 2015, 20000);
        vehicles[2] = new Vehicle("BMW", "X5", 2018, 30000);
        vehicles[3] = new Vehicle("Mercedes", "E200", 2019, 40000);

        System.out.println("Before sorting:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }

        /**
         * Comparing using a comparator.
         */
        java.util.Arrays.sort(vehicles, new VehicleComparator());
        System.out.println("After sorting:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }

        /**
         * Comparing using the Comparable interface.
         */
        java.util.Arrays.sort(vehicles);
        System.out.println("After sorting by make:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }

    }
}

class VehicleComparator implements java.util.Comparator<Vehicle> {
    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        return (int) (o1.getPrice() - o2.getPrice());
    }
}

class Vehicle implements Comparable<Vehicle>{
    private String make;
    private String model;
    private int year;
    private double price;

    public Vehicle(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }

    /**
     * Compares this object with the specified object for order. Returns a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     * We compare the make of the vehicle. This will allow us to sort alphabetically the vehicles by make.
     *
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Vehicle o) {
        return this.make.compareTo(o.getMake());
    }
}


