package service.menu;

import service.ContaController;
import model.enumeration.MenuOptions;
import view.menu.MenuContaView;

public class MenuContaController {

    
    private MenuContaView tela;
    private ContaController contaController;

    public MenuContaController(ContaController contaController) {
        tela = new MenuContaView();
        this.contaController = contaController;

    }

    public void start() {
        MenuOptions option;
        do {
            option = tela.askOptionMenu();

            switch (option) {
                case CREATE:
                    contaController.cadastrar();
                    break;
                case READ:
                    contaController.listar();
                    break;
                case UPDATE:
                    
                    break;
                case DELETE:
                    contaController.excluir();
                    break;
                case LIST:
                    
                    break;
                case VOLTAR:
                    break;

            }
        } while (option != MenuOptions.VOLTAR);
    }
}
