package test.car;

import car.tests.CarFactory;
import car.tests.data.Car;
import org.junit.Test;
import java.io.UnsupportedEncodingException;
//import java.util.*;
import static org.junit.Assert.assertEquals;

public class CarFactoryTest {
    @Test
    public void carTest1()throws UnsupportedEncodingException{
        System.out.println("------------------ TEST 1 - carTest1() ------------------");

        CarFactory factory = new CarFactory();

        Car masinaMea = factory.makeCar("Golf 7", "Blue");
       // Car masina2 = factory.makeCar("Dacia", "Blue");

        //System.out.println(masinaMea);
       // System.out.println(masina2);
       assertEquals(masinaMea.toString(), "Marca: Golf 7, An fabricatie: 2018, Culoare: Blue");
    }
    @Test
    public void carTest2()throws UnsupportedEncodingException {
        System.out.println("------------------ TEST 2 - carTest1() ------------------");

        CarFactory factory = new CarFactory();

        Car masinaMea = factory.makeCar("BMW", "Blue");
        // Car masina2 = factory.makeCar("Dacia", "Blue");

       // System.out.println(masinaMea);

        assertEquals(masinaMea.getModelName(), "BMW");
    }
    @Test
    public void carTest3()throws UnsupportedEncodingException {
        System.out.println("------------------ TEST 3 - carTest1() ------------------");

        CarFactory factory = new CarFactory();

        Car masinaMea = factory.makeCar("BMW", "Black");
        // Car masina2 = factory.makeCar("Dacia", "Blue");

        // System.out.println(masinaMea);

        assertEquals(masinaMea.getColor(), "Black");
    }
    @Test
    public void carTest4()throws UnsupportedEncodingException {
        System.out.println("------------------ TEST 4 - carTest1() ------------------");

        CarFactory factory = new CarFactory();

        Car masinaMea = factory.makeCar("BMW", "Black");
        // Car masina2 = factory.makeCar("Dacia", "Blue");

        // System.out.println(masinaMea);

        assertEquals(masinaMea.getYear(), 2018);
    }
}

