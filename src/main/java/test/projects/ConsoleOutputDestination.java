package test.projects;

import java.util.ArrayList;
import java.util.List;

public class ConsoleOutputDestination implements OutputDestination {

    public void sendOutput(String output) {
        System.out.println(output);
    }
}
