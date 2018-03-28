package test.projects;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class SnackMachineTest {
    @Test
public void testBuyProduct() throws UnsupportedEncodingException {
        System.out.println("------------------ TEST 1 - testBuyProduct() ------------------");
        StringInputSource inputCommands = new StringInputSource(new ArrayList<String>(Arrays.asList("3")));
        StringInputSource paymentBills = new StringInputSource(new ArrayList<String>(Arrays.asList("2.0", "5.0")));

        ConsoleOutputDestination displayOutputDestination = new ConsoleOutputDestination();
        StringOutputDestination deliveryOutputDestination = new StringOutputDestination();

        SnackMachine snackMachine = new SnackMachine();

        Storage storage = new Storage();
        snackMachine.setStorage(storage);

        OrderPanel orderPanel = new OrderPanel();
        orderPanel.setOrderInput(inputCommands);
        snackMachine.setOrderPanel(orderPanel);

        Display display = new Display();
        display.setOutputDestination(displayOutputDestination);
        snackMachine.setDisplay(display);

        BillPaymentSystem billPaymentSystem = new BillPaymentSystem();
        billPaymentSystem.setBillInput(paymentBills);
        billPaymentSystem.setDisplay(display);
        snackMachine.setPaymentSystem(billPaymentSystem);

        DeliveryTray deliveryTray = new DeliveryTray();
        deliveryTray.setOutputDoor(deliveryOutputDestination);
        snackMachine.setDeliveryTray(deliveryTray);

        Map<Integer, Double> prices = new HashMap<Integer, Double>();
        prices.put(1, 2.5);
        prices.put(2, 3.0);
        prices.put(3, 6.0);
        prices.put(8, 1.5);
        prices.put(12, 2.0);

        snackMachine.configurePrices(prices);

        Map<Integer, String> labels = new HashMap<Integer, String>();
        labels.put(1, "KitKat");
        labels.put(2, "Snickers");
        labels.put(3, "Sandwich");
        labels.put(8, "Orbit");
        labels.put(12, "Cola");

        snackMachine.configureProducts(labels);

        snackMachine.loadProducts(Arrays.asList(1, 3, 2, 3, 3, 2, 8, 12, 12, 8, 12));

        snackMachine.takeOrder();

        String deliveredProduct = deliveryOutputDestination.getOutput().get(0);

        //assert deliveredProduct.equals("Delivered product 3");
        assertEquals(deliveredProduct,"Delivered product 3" );

}
@Test
public void testBuyMultipleProducts() throws UnsupportedEncodingException {
        System.out.println("------------------ TEST 2 - testBuyMultipleProducts() ------------------");
        StringInputSource inputCommands = new StringInputSource(new ArrayList<String>(Arrays.asList("3", "2")));
        StringInputSource paymentBills = new StringInputSource(new ArrayList<String>(Arrays.asList("2.0", "5.0", "4.0")));

        ConsoleOutputDestination displayOutputDestination = new ConsoleOutputDestination();
        StringOutputDestination deliveryOutputDestination = new StringOutputDestination();

        SnackMachine snackMachine = new SnackMachine();

        Storage storage = new Storage();
        snackMachine.setStorage(storage);

        OrderPanel orderPanel = new OrderPanel();
        orderPanel.setOrderInput(inputCommands);
        snackMachine.setOrderPanel(orderPanel);

        Display display = new Display();
        display.setOutputDestination(displayOutputDestination);
        snackMachine.setDisplay(display);

        BillPaymentSystem billPaymentSystem = new BillPaymentSystem();
        billPaymentSystem.setBillInput(paymentBills);
        billPaymentSystem.setDisplay(display);
        snackMachine.setPaymentSystem(billPaymentSystem);

        DeliveryTray deliveryTray = new DeliveryTray();
        deliveryTray.setOutputDoor(deliveryOutputDestination);
        snackMachine.setDeliveryTray(deliveryTray);

        Map<Integer, Double> prices = new HashMap<Integer, Double>();
        prices.put(1, 2.5);
        prices.put(2, 3.0);
        prices.put(3, 6.0);
        prices.put(8, 1.5);
        prices.put(12, 2.0);

        snackMachine.configurePrices(prices);

        Map<Integer, String> labels = new HashMap<Integer, String>();
        labels.put(1, "KitKat");
        labels.put(2, "Snickers");
        labels.put(3, "Sandwich");
        labels.put(8, "Orbit");
        labels.put(12, "Cola");

        snackMachine.configureProducts(labels);

        snackMachine.loadProducts(Arrays.asList(1, 3, 2, 3, 3, 2, 8, 12, 12, 8, 12));

        snackMachine.takeOrder();
        snackMachine.takeOrder();

        List<String> output = deliveryOutputDestination.getOutput();

        String deliveredProduct1 = output.get(0);
        //assert deliveredProduct1.equals("Delivered product 3");
        assertEquals(deliveredProduct1,"Delivered product 3" );

        String deliveredProduct2 = output.get(1);
        //assert deliveredProduct2.equals("Delivered product 2");
        assertEquals(deliveredProduct2,"Delivered product 2");

    }
    @Test
    public void testBuyProductNotFound() throws UnsupportedEncodingException {
      System.out.println("------------------ TEST 3 - testBuyProductNotFound() ------------------");
      StringInputSource inputCommands = new StringInputSource(new ArrayList<String>(Arrays.asList("4")));
      StringInputSource paymentBills = new StringInputSource(new ArrayList<String>(Arrays.asList("0")));

      StringOutputDestination displayOutputDestination = new StringOutputDestination();
      StringOutputDestination deliveryOutputDestination = new StringOutputDestination();

      SnackMachine snackMachine = new SnackMachine();

      Storage storage = new Storage();
      snackMachine.setStorage(storage);

      OrderPanel orderPanel = new OrderPanel();
      orderPanel.setOrderInput(inputCommands);
      snackMachine.setOrderPanel(orderPanel);

      Display display = new Display();
      display.setOutputDestination(displayOutputDestination);
      snackMachine.setDisplay(display);

      BillPaymentSystem billPaymentSystem = new BillPaymentSystem();
      billPaymentSystem.setBillInput(paymentBills);
      billPaymentSystem.setDisplay(display);
      snackMachine.setPaymentSystem(billPaymentSystem);

      DeliveryTray deliveryTray = new DeliveryTray();
      deliveryTray.setOutputDoor(deliveryOutputDestination);
      snackMachine.setDeliveryTray(deliveryTray);

      Map<Integer, Double> prices = new HashMap<Integer, Double>();
      prices.put(1, 2.5);
      prices.put(2, 3.0);
      prices.put(3, 6.0);
      prices.put(8, 1.5);
      prices.put(12, 2.0);

      snackMachine.configurePrices(prices);

      Map<Integer, String> labels = new HashMap<Integer, String>();
      labels.put(1, "KitKat");
      labels.put(2, "Snickers");
      labels.put(3, "Sandwich");
      labels.put(8, "Orbit");
      labels.put(12, "Cola");

      snackMachine.configureProducts(labels);

      snackMachine.loadProducts(Arrays.asList(1, 3, 2, 3, 3, 2, 8, 12, 12, 8, 12));

      snackMachine.takeOrder();

      String deliveredProduct = displayOutputDestination.getOutput().get(2);
      //System.out.println(deliveredProduct);
     // assert deliveredProduct.equals("No such product");
      assertEquals(deliveredProduct,"No such product");

      }
    @Test
      public void testBuyProductNotAvailable() throws UnsupportedEncodingException {
        System.out.println("------------------ TEST 4 - testBuyProductNotAvailable() ------------------");
        StringInputSource inputCommands = new StringInputSource(new ArrayList<String>(Arrays.asList("1", "1")));
        StringInputSource paymentBills = new StringInputSource(new ArrayList<String>(Arrays.asList("2.5", "0")));

        StringOutputDestination displayOutputDestination = new StringOutputDestination();
        StringOutputDestination deliveryOutputDestination = new StringOutputDestination();

        SnackMachine snackMachine = new SnackMachine();

        Storage storage = new Storage();
        snackMachine.setStorage(storage);

        OrderPanel orderPanel = new OrderPanel();
        orderPanel.setOrderInput(inputCommands);
        snackMachine.setOrderPanel(orderPanel);

        Display display = new Display();
        display.setOutputDestination(displayOutputDestination);
        snackMachine.setDisplay(display);

        BillPaymentSystem billPaymentSystem = new BillPaymentSystem();
        billPaymentSystem.setBillInput(paymentBills);
        billPaymentSystem.setDisplay(display);
        snackMachine.setPaymentSystem(billPaymentSystem);

        DeliveryTray deliveryTray = new DeliveryTray();
        deliveryTray.setOutputDoor(deliveryOutputDestination);
        snackMachine.setDeliveryTray(deliveryTray);

        Map<Integer, Double> prices = new HashMap<Integer, Double>();
        prices.put(1, 2.5);
        prices.put(2, 3.0);
        prices.put(3, 6.0);
        prices.put(8, 1.5);
        prices.put(12, 2.0);

        snackMachine.configurePrices(prices);

        Map<Integer, String> labels = new HashMap<Integer, String>();
        labels.put(1, "KitKat");
        labels.put(2, "Snickers");
        labels.put(3, "Sandwich");
        labels.put(8, "Orbit");
        labels.put(12, "Cola");

        snackMachine.configureProducts(labels);

        snackMachine.loadProducts(Arrays.asList(1, 3, 2, 3, 3, 2, 8, 12, 12, 8, 12));

        snackMachine.takeOrder();
        snackMachine.takeOrder();

        String deliveredProduct1 = deliveryOutputDestination.getOutput().get(0);
       // assert deliveredProduct1.equals("Delivered product 1");
          assertEquals(deliveredProduct1,"Delivered product 1");

        String deliveredProduct2 = displayOutputDestination.getOutput().get(5);
        //assert deliveredProduct2.equals("Product not available.");
          assertEquals(deliveredProduct2, "Product not available.");
    }
    @Test
    public void testCheckPrice() throws UnsupportedEncodingException {
        System.out.println("------------------ TEST 5 - testCheckPrice() ------------------");
        StringInputSource inputCommands = new StringInputSource(new ArrayList<String>(Arrays.asList("2", "3")));
        StringInputSource paymentBills = new StringInputSource(new ArrayList<String>(Arrays.asList("4", "2","6")));

        StringOutputDestination displayOutputDestination = new StringOutputDestination();
        StringOutputDestination deliveryOutputDestination = new StringOutputDestination();

        SnackMachine snackMachine = new SnackMachine();

        Storage storage = new Storage();
        snackMachine.setStorage(storage);

        OrderPanel orderPanel = new OrderPanel();
        orderPanel.setOrderInput(inputCommands);
        snackMachine.setOrderPanel(orderPanel);

        Display display = new Display();
        display.setOutputDestination(displayOutputDestination);
        snackMachine.setDisplay(display);

        BillPaymentSystem billPaymentSystem = new BillPaymentSystem();
        billPaymentSystem.setBillInput(paymentBills);
        billPaymentSystem.setDisplay(display);
        snackMachine.setPaymentSystem(billPaymentSystem);

        DeliveryTray deliveryTray = new DeliveryTray();
        deliveryTray.setOutputDoor(deliveryOutputDestination);
        snackMachine.setDeliveryTray(deliveryTray);

        Map<Integer, Double> prices = new HashMap<Integer, Double>();
        prices.put(1, 2.5);
        prices.put(2, 3.0);
        prices.put(3, 6.0);
        prices.put(8, 1.5);
        prices.put(12, 2.0);

        snackMachine.configurePrices(prices);

        Map<Integer, String> labels = new HashMap<Integer, String>();
        labels.put(1, "KitKat");
        labels.put(2, "Snickers");
        labels.put(3, "Sandwich");
        labels.put(8, "Orbit");
        labels.put(12, "Cola");

        snackMachine.configureProducts(labels);

        snackMachine.loadProducts(Arrays.asList(1, 3, 2, 3, 3, 2, 8, 12, 12, 8, 12));

        snackMachine.takeOrder();
        String deliveredProduct = displayOutputDestination.getOutput().get(2);
        //System.out.println(deliveredProduct);
        //assert deliveredProduct.equals("Please pay 3.0");
        assertEquals(deliveredProduct,"Please pay 3.0");

        snackMachine.takeOrder();
        String deliveredProduct2 = displayOutputDestination.getOutput().get(6);
        //System.out.println(deliveredProduct2);
        //assert deliveredProduct2.equals("4.0 left");
       assertEquals(deliveredProduct2, "4.0 left");

    }
}
