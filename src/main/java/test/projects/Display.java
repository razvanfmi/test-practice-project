package test.projects;

public class Display {

    private OutputDestination outputDestination;

    public void displayMessage(String message) {
        outputDestination.sendOutput(message);
    }

    public void setOutputDestination(OutputDestination outputDestination) {
        this.outputDestination = outputDestination;
    }
}
