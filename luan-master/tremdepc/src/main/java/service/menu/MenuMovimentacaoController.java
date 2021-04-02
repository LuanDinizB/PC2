
package service.menu;

import service.ContaController;
import model.enumeration.MenuOptions;
import view.menu.MenuMovimentacaoView;

public class MenuMovimentacaoController {
    private MenuMovimentacaoView tela;
    private ContaController contaController;

    public MenuMovimentacaoController(ContaController contaController) {
        tela = new MenuMovimentacaoView();
        this.contaController = contaController;

    }

    public void start() {
        MenuOptions option;
        do {
            option = tela.askOptionMenu();

            switch (option) {
                case SALDO:
                    contaController.saldo();
                    break;
                case DEPOSITO:
                    contaController.depositar();
                    break;
                case SAQUE:
                    contaController.sacar();
                    break;
                case TRANSFERENCIA:
                    contaController.transferir();
                    break;
                case EXTRATO:
                    
                    break;
                
            }
        } while (option != MenuOptions.VOLTAR);
    }
}
