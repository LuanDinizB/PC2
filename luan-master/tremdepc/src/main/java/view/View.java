package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
    private Scanner in;

    public View() {
        in = new Scanner(System.in);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public String lerString(String question) {
        do {
            try {
                showMessage(question);
                String str = in.next();
                return str;
            } catch (InputMismatchException ex) {
                System.out.println("Tente Denovo. ("
                        + "Input incorreto: é requerido uma string)");
                in.nextLine();
            }
        } while (true);
    }

    public double lerDouble(String question) {
        do {
            try {
                showMessage(question);
                double dbl = in.nextDouble();
                return dbl;
            } catch (InputMismatchException ex) {
                System.out.println("Tente Denovo. ("
                        + "Input incorreto: é requerido uma string)");
                in.nextLine();
            }
        } while (true);

    }

    public int lerInteiro(String question) {
        do {
            try {
                showMessage(question);
                int inteiro = in.nextInt();
                return inteiro;
            } catch (InputMismatchException ex) {
                System.out.println("Tente Denovo. ("
                        + "Input incorreto: é requerido um inteiro)");
                in.nextLine();
            }
        } while (true);
    }
}
