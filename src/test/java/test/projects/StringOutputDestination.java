package test.projects;

import java.util.ArrayList;
import java.util.List;

public class StringOutputDestination implements OutputDestination {

    private List<String> output;

    public StringOutputDestination() {
        this.output = new ArrayList<String>();
    }

    public void sendOutput(String output) {
        this.output.add(output);
    }

    public List<String> getOutput() {
        return output;
    }
}
