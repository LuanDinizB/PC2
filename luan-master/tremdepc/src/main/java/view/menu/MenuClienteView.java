package view.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.enumeration.MenuOptions;

public class MenuClienteView {

    private Scanner in;

    public MenuClienteView() {
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

    public MenuOptions askOptionMenu() {
        int inteiro = 1;

        do {
            try {
                System.out.println("---------------------------");
                System.out.println("--  MENU CLIENTE       --");
                System.out.println("---------------------------");
                System.out.println("1 - Cadastrar");
                System.out.println("2 - Listar");
                System.out.println("3 - Excluir");
                System.out.println("4 - Atualizar");
                System.out.println("9 - Visualizar");
                System.out.println("0 - Voltar");
                inteiro = in.nextInt();

                switch (inteiro) {
                    case 1:
                        return MenuOptions.CREATE;
                    case 2:
                        return MenuOptions.READ;
                    case 3:
                        return MenuOptions.DELETE;
                    case 4:
                        return MenuOptions.UPDATE;
                    case 9:
                        return MenuOptions.LIST;
                    case 0:
                        return MenuOptions.VOLTAR;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Tente Denovo. ("
                        + "Incorrect input: an integer is required)");
                in.nextLine();
            }
        } while (true);
    }

    
}
