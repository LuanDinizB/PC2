package view.menu;

import model.enumeration.MenuOptions;
import view.View;

import java.util.InputMismatchException;

public class MenuGerenteView extends View {
    public MenuOptions askOptionMenu() {
        int inteiro = 0;

        do {
            try {
                System.out.println("---------------------------");
                System.out.println("------ MENU GERENTE  ------");
                System.out.println("---------------------------");
                System.out.println("1 - Cadastrar");
                System.out.println("2 - Listar");
                System.out.println("3 - Excluir");
                System.out.println("4 - Atualizar");
                System.out.println("9 - Visualizar");
                System.out.println("0 - Voltar");

                inteiro = lerInteiro("Digite uma opção válida!");

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
            }
        } while (true);
    }
}
