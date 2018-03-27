package test.projects;

public class DeliveryTray {

    private OutputDestination outputDoor;

    public void deliverProduct(Product product) {
        outputDoor.sendOutput("Delivered product " + product.getId());
    }

    public void setOutputDoor(OutputDestination outputDoor) {
        this.outputDoor = outputDoor;
    }
}
