package test.projects;

import java.util.ArrayList;
import java.util.List;

public class StringInputSource implements InputSource {

    private List<String> input;

    public StringInputSource() {
        this.input = new ArrayList<String>();
    }

    public StringInputSource(List<String> input) {
        this.input = input;
    }

    public String getInput() {
        return input.remove(0);
    }

    public void setInput(List<String> input) {
        this.input = input;
    }
}
