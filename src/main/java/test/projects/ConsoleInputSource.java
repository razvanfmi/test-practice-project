package test.projects;

import java.util.Scanner;

public class ConsoleInputSource implements InputSource {
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
