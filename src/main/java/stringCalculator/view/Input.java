package stringCalculator.view;

import java.util.Scanner;

public class Input {

    private final String input;

    private static Scanner scanner = new Scanner(System.in);

    public Input(String input) {
        this.input = input;
    }

    public String inputNumericFormula(){
        return scanner.nextLine();
    }
}
