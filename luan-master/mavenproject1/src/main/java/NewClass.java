
import java.util.Scanner;


public class NewClass {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Digite a quantidade de clientes a serem cadastrados: ");
        int i = in.nextInt();
        String[] nome = new String[i];
        String[] telefone = new String[i];
        String[] endereço = new String[i];
        String[] procedimentos = new String[i];

        for (int j = 0; j < i; j++) {
            System.out.println("Digite seu nome: ");
            nome[j] = in.next();
            System.out.println("Digite seu telefone: ");
            telefone[j] = in.next();
            System.out.println("Digite seu endereço: ");
            endereço[j] = in.next();
            System.out.println("Digite seus procedimentos: ");
            procedimentos[j] = in.nextLine();
          
        }

        for (int j = 0; j < i; j++) {
            System.out.println(nome[j] + " " + telefone[j] + " " + endereço[j] + " " + procedimentos[j]);
        }

    }
}
