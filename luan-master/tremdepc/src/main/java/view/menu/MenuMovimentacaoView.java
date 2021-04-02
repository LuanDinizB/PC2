package view.menu;

import java.util.InputMismatchException;
import java.util.Scanner;
import model.enumeration.MenuOptions;

public class MenuMovimentacaoView {

    private Scanner in;

    public MenuMovimentacaoView() {
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
                System.out.println("--  MENU MOVIMENTACAO       --");
                System.out.println("---------------------------");
                System.out.println("1 - Saldo                  ");
                System.out.println("2 - Deposito              ");
                System.out.println("3 - Saque                ");
                System.out.println("4 - Transferencia             ");
                System.out.println("5 - Extrato             ");
                System.out.println("0 - Voltar");

                inteiro = in.nextInt();

                switch (inteiro) {
                    case 1:
                        return MenuOptions.SALDO;
                    case 2:
                        return MenuOptions.DEPOSITO;
                    case 3:
                        return MenuOptions.SAQUE;
                    case 4:
                        return MenuOptions.TRANSFERENCIA;
                    case 5:
                        return MenuOptions.EXTRATO;
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
