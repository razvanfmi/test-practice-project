package car.tests;

import car.tests.data.Car;

public class CarFactory {

    public Car makeCar(String modelName,String color){
        Car newCar = new Car();
      newCar.setModelName(modelName);
      newCar.setColor(color);
      newCar.setYear(2018);
        return newCar;
    }

}
