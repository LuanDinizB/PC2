package service;

import domain.Gerente;
import domain.Pessoa;
import domain.Conta;
import repository.IRepository;
import repository.vetor.ContaRepository;
import view.ContaView;

public class ContaController {
    private ContaView view;
    private IRepository<Conta> repository;
    private PessoaController pessoaController;
    private GerenteController gerenteController;

    public ContaController(PessoaController pessoaController, GerenteController gerenteController) {
        view = new ContaView();
        repository = new ContaRepository();
        this.pessoaController = pessoaController;
        this.gerenteController = gerenteController;
    }

    public void cadastrar() {
        Gerente gerente = gerenteController.localizarGerente();
        Pessoa pessoa = pessoaController.localizarPessoa();

        if(gerente != null) {
            if(gerente.veriricarMaximo()) {
                if (pessoa != null) {
                    Conta conta = view.askForConta();
                    conta.setGerente(gerente);
                    conta.setCliente(pessoa);
                    repository.cadastrar(conta);
                }
            }
        }
    }

    public void listar() {
        Conta[] lista = repository.findAll();
        view.listar(lista);
    }

    public void excluir() {
        Conta conta = localizarConta();
        if(conta != null) {
            repository.remover(conta);
        }
    }

    public void transferir() {
        Conta contaOrigem = localizarConta();
        if (contaOrigem != null) {
            Conta contaDestino = localizarConta();
            if (contaDestino != null) {
                double valor = view.askValor();
                contaOrigem.transferir(contaDestino, valor);
            }
        }
    }

    public void depositar() {
        Conta conta = localizarConta();
        if (conta != null) {
            double valor = view.askValor();
            conta.depositar(valor);
        }
    }

    public void saldo() {
        Conta conta = localizarConta();
        view.exibirSaldo(conta.getSaldo());
    }

    public void sacar() {
        Conta conta = localizarConta();
        if (conta != null) {
            double valor = view.askValor();
            conta.sacar(valor);
        }
    }

    public Conta localizarConta() {
        String cpf = view.askForCPF();
        return repository.localizar(cpf);
    }
}
