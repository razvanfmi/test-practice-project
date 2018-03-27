package test.projects;

import java.util.Stack;

public class Lane {
    private String label;
    private Double price;
    private Stack<Product> products;

    public Product removeProduct() {
        return products.pop();
    }

    public Integer availableAmount() {
        return products.size();
    }

    public Lane() {
        products = new Stack<Product>();
    }

    public void loadProduct(Product product) {
        products.push(product);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
