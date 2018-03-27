package test.projects;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main (String[] args) {
        SnackMachine snackMachine = new SnackMachine();

        Storage storage = new Storage();
        snackMachine.setStorage(storage);

        InputSource consoleInputSource = new ConsoleInputSource();
        OutputDestination consoleOutputDestination = new ConsoleOutputDestination();

        OrderPanel orderPanel = new OrderPanel();
        orderPanel.setOrderInput(consoleInputSource);
        snackMachine.setOrderPanel(orderPanel);

        Display display = new Display();
        display.setOutputDestination(consoleOutputDestination);
        snackMachine.setDisplay(display);

        BillPaymentSystem billPaymentSystem = new BillPaymentSystem();
        billPaymentSystem.setBillInput(consoleInputSource);
        billPaymentSystem.setDisplay(display);
        snackMachine.setPaymentSystem(billPaymentSystem);

        DeliveryTray deliveryTray = new DeliveryTray();
        deliveryTray.setOutputDoor(consoleOutputDestination);
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

        snackMachine.run();
    }
}
