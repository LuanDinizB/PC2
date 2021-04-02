package service;

import domain.Pessoa;
import view.ClienteView;
import repository.IRepository;
import repository.vetor.ClienteRepository;

public class PessoaController {
    private Pessoa[] clientes;

    private ClienteView view;
    private IRepository<Pessoa> repository;

    public PessoaController() {
        view = new ClienteView();
        this.repository = new ClienteRepository();
    }

    public void cadastrar() {
        Pessoa pessoa = view.askForPessoa();
        repository.cadastrar(pessoa);
    }

    public void exibir() {
        Pessoa pessoa = localizarPessoa();
        if (pessoa != null) {
            view.exibirCliente(pessoa);
        }
    }

    public void listar() {
        Pessoa[] cliente = repository.findAll();
        view.listarClientes(cliente);
    }

    public void excluir() {
        Pessoa pessoa = localizarPessoa();
        repository.remover(pessoa);
    }

    public void atualizar() {
        Pessoa atualizar = view.askForPessoa();
        repository.atualizar(atualizar);
    }

    public Pessoa localizarPessoa() {
        String cpf = view.askForDocumento();
        return repository.localizar(cpf);
    }

    public void persistAll() {
        repository.persistAll();
    }

    public void loadAll() {
        repository.loadAll();
    }
}
