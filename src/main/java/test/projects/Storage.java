package test.projects;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<Integer, Lane> lanes;

    public Storage() {
        lanes = new HashMap<Integer, Lane>();
    }

    public void configureLane(Integer productId, Double productPrice) {
        if (lanes.get(productId) == null) {
            Lane lane = new Lane();
            lane.setPrice(productPrice);
            lanes.put(productId, lane);
        } else {
            Lane lane = lanes.get(productId);
            lane.setPrice(productPrice);
        }
    }

    public void configureLane(Integer productId, String productLabel) {
        if (lanes.get(productId) == null) {
            Lane lane = new Lane();
            lane.setLabel(productLabel);
            lanes.put(productId, lane);
        } else {
            Lane lane = lanes.get(productId);
            lane.setLabel(productLabel);
        }
    }

    public void addProduct(Product product) {
        Lane productLane = lanes.get(product.getId());
        productLane.loadProduct(product);
    }

    public StockInformation calculateStock(Integer productId) {
        StockInformation stockInformation = new StockInformation();
        Lane lane = lanes.get(productId);

        if (lane == null) {
            throw new IllegalArgumentException("Product not found");
        }

        stockInformation.setProductId(productId);
        stockInformation.setPrice(lane.getPrice());
        stockInformation.setAmount(lane.availableAmount());

        return stockInformation;
    }

    public Product removeProduct(Integer productId) {
        Lane lane = lanes.get(productId);

        if (lane == null) {
            throw new IllegalArgumentException("Product not found");
        }

        return lane.removeProduct();
    }
}
