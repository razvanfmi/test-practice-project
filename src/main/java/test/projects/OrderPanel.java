package test.projects;

public class OrderPanel {

    private InputSource orderInput;

    public OrderInformation obtainOrder() {
        OrderInformation orderInformation = new OrderInformation();
        orderInformation.setProductId(new Integer(orderInput.getInput()));
        return orderInformation;
    }

    public void setOrderInput(InputSource orderInput) {
        this.orderInput = orderInput;
    }
}
