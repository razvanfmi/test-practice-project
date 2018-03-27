package test.projects;

import java.util.List;
import java.util.Map;

public class SnackMachine {

    private OrderPanel orderPanel;
    private Display display;
    private Storage storage;
    private PaymentSystem paymentSystem;
    private DeliveryTray deliveryTray;

    public void configureProducts(Map<Integer, String> productLabels) {
        for (Integer productId : productLabels.keySet()) {
            String label = productLabels.get(productId);
            storage.configureLane(productId, label);
        }
    }

    public void configurePrices(Map<Integer, Double> productPrices) {
        for (Integer productId : productPrices.keySet()) {
            Double price = productPrices.get(productId);
            storage.configureLane(productId, price);
        }
    }

    public void loadProducts(List<Integer> productIds) {
        for (Integer productId : productIds) {
            Product product = new Product();
            product.setId(productId);
            storage.addProduct(product);
        }
    }

    public void run() {
        while (true) {
            takeOrder();
        }
    }

    public void takeOrder() {
        display.displayMessage("Please select product:");
        OrderInformation orderInformation = orderPanel.obtainOrder();

        display.displayMessage("Checking...");
        try {
            StockInformation stockInformation = storage.calculateStock(orderInformation.getProductId());

            if (stockInformation.getAmount() > 0) {
                display.displayMessage("Please pay " + stockInformation.getPrice());
                paymentSystem.acceptPayment(stockInformation.getPrice());
                Product product = storage.removeProduct(orderInformation.getProductId());
                deliveryTray.deliverProduct(product);
            } else {
                display.displayMessage("Product not available.");
            }
        } catch (IllegalArgumentException e) {
            display.displayMessage("No such product");
        }
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void setOrderPanel(OrderPanel orderPanel) {
        this.orderPanel = orderPanel;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public void setPaymentSystem(PaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    public void setDeliveryTray(DeliveryTray deliveryTray) {
        this.deliveryTray = deliveryTray;
    }
}
