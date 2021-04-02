package service.menu;

import service.GerenteController;
import service.PessoaController;
import service.ContaController;
import model.enumeration.MenuOptions;
import view.menu.MenuView;

public class MenuController {
    private MenuView tela;

    private ContaController contaController;
    private PessoaController clienteController;
    private GerenteController gerenteController;

    private MenuGerenteController menuGerente;
    private MenuClienteController menuCliente;
    private MenuContaController menuConta;
    private MenuMovimentacaoController menuMovimentacao;

    public MenuController() {
        tela = new MenuView();
        gerenteController = new GerenteController();
        clienteController = new PessoaController();
        contaController = new ContaController(clienteController, gerenteController);

        menuGerente = new MenuGerenteController(gerenteController);
        menuCliente = new MenuClienteController(clienteController);
        menuMovimentacao = new MenuMovimentacaoController(contaController);
        menuConta = new MenuContaController(contaController);
    }

    public void start() {
        MenuOptions option;
        do {
            option = tela.askOptionMenuPrincipal();
            System.out.println(option);
            switch (option) {
                case CLIENTE:
                    menuCliente.start();
                    break;
                case CONTA:
                    menuConta.start();
                    break;
                case GERENTE:
                    menuGerente.start();
                    break;
                case MOVIMENTACAO:
                    menuMovimentacao.start();
                    break;
                case CARREGAR:
                    clienteController.loadAll();
                    break;
                case SALVAR:
                    clienteController.persistAll();
                    break;
                case SAIR:
                    break;

            }
        } while (option != MenuOptions.SAIR);

    }
}
