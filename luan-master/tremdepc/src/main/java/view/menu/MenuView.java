package view.menu;

import view.View;
import model.enumeration.MenuOptions;
import java.util.InputMismatchException;

public class MenuView extends View {
    public MenuOptions askOptionMenuPrincipal() {
        int inteiro = 1;

        do {
            try {
                showMessage("---------------------------");
                showMessage("--     MENU PRINCIPAL    --");
                showMessage("---------------------------");
                showMessage("1 - Cadastro de Clientes");
                showMessage("2 - Cadastro de Contas");
                showMessage("3 - Movimentação");
                showMessage("---------------------------");
                showMessage("8 - Carregar Dados");
                showMessage("9 - Salvar Dados");
                showMessage("0 - Sair");
                inteiro = lerInteiro("Digite uma opção válida!");

                switch (inteiro) {
                    case 1:
                        return MenuOptions.CLIENTE;
                    case 2:
                        return MenuOptions.CONTA;
                    case 3:
                        return MenuOptions.MOVIMENTACAO;
                    case 8:
                        return MenuOptions.CARREGAR;
                    case 9:
                        return MenuOptions.SALVAR;
                    case 0:
                        return MenuOptions.SAIR;
                }
            } catch (InputMismatchException ex) {
                showMessage("Tente Denovo. ("
                        + "Incorrect input: an integer is required)");
            }
        } while (true);
    }
}
