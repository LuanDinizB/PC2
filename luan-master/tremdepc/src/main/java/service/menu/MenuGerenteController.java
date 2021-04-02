package service.menu;

import model.enumeration.MenuOptions;
import service.GerenteController;
import view.menu.MenuGerenteView;

public class MenuGerenteController {
    private MenuGerenteView view;
    private GerenteController gerenteController;

    public MenuGerenteController(GerenteController gerenteController) {
        this.gerenteController = gerenteController;
    }

    public void start() {
        MenuOptions option;
        do {
            option = view.askOptionMenu();

            switch (option) {
                case CREATE:
                    gerenteController.cadastrar();
                    break;
                case READ:
                    //gerenteController.exibir();
                    break;
                case UPDATE:
                    gerenteController.atualizar();
                    break;
                case DELETE:
                    gerenteController.excluir();
                    break;
                case LIST:
                    //gerenteController.listar();
                    break;
                case VOLTAR:
                    break;

            }
        } while (option != MenuOptions.VOLTAR);
    }

}
