package CalculadoraView;

import static java.lang.System.in;
import java.util.InputMismatchException;
import java.util.Scanner;
import CalculadoraEnumeration.ContasEnum;
import CalculadoraEnumeration.TiposEnum;

public class View {

    Scanner in = new Scanner(System.in);

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void menuCalculadora() {
        System.out.println("Calculadora");
    }

    public TiposEnum perguntarTipo() {
        while (true) {
            System.out.println("Digite o tipo de dado a ser inserido: ");
            System.out.println("i -- inteiro\n"
                    + "d -- double\n"
                    + "s -- string\n"
                    + "x -- sair");
            char caractere = in.next().charAt(0);

            switch (caractere) {
                case 'i':
                    return TiposEnum.INTEIRO;
                case 'd':
                    return TiposEnum.DOUBLE;
                case 's':
                    return TiposEnum.STRING;
                case 'x':
                    return TiposEnum.SAIR;

            }
        }
    }

    public ContasEnum perguntarOperação() {
        while (true) {
            System.out.println("Digite a operação a ser aplicada: ");
            System.out.println("*  -- Multiplicação\n"
                    + "-  -- Subtração\n"
                    + "/  -- Divisão\n"
                    + "+  -- Adição\n"
                    + "^  -- Potenciação");
            char caractere = in.next().charAt(0);

            switch (caractere) {
                case '*':
                    return ContasEnum.MULTIPLICACAO;
                case '-':
                    return ContasEnum.SUBTRACAO;
                case '/':
                    return ContasEnum.DIVISAO;
                case '+':
                    return ContasEnum.ADICAO;
                case '^':
                    return ContasEnum.POTENCIACAO;
            }
        }
    }

    public String lerString(String question) {
        do {
            try {
                showMessage(question);
                String str = in.next();
                return str;
            } catch (InputMismatchException ex) {
                System.out.println("Digite outra vez /n("
                        + "Foi pedido uma String)");
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
                System.out.println("Digite outra vez /n("
                        + "Foi pedido um Double)");
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
                System.out.println("Digite outra vez /n("
                        + "Foi pedido um Inteiro)");
                in.nextLine();
            }
        } while (true);
    }

}
