package car.tests;

import car.tests.data.Car;

public class CarMain {
    public static void main(String[] args) {
        CarFactory factory = new CarFactory();

        Car masinaMea = factory.makeCar("BMW", "Red");
        Car masina2 = factory.makeCar("Dacia", "Blue");

        System.out.println(masinaMea);
        System.out.println(masina2);
    }
}
