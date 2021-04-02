package service.menu;

import service.PessoaController;
import model.enumeration.MenuOptions;
import view.menu.MenuClienteView;

public class MenuClienteController {
    private MenuClienteView tela;
    private PessoaController pessoaController;

    public MenuClienteController(PessoaController pessoaController) {
        tela = new MenuClienteView();
        this.pessoaController = pessoaController;
    }

    public void start() {
        MenuOptions option;
        do {
            option = tela.askOptionMenu();

            switch (option) {
                case CREATE:
                    pessoaController.cadastrar();
                    break;
                case READ:
                    pessoaController.exibir();
                    break;
                case UPDATE:
                    pessoaController.atualizar();
                    break;
                case DELETE:
                    pessoaController.excluir();
                    break;
                case LIST:
                    pessoaController.listar();
                    break;
                case VOLTAR:
                    break;

            }
        } while (option != MenuOptions.VOLTAR);
    }

    
}
