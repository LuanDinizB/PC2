package view;

import domain.Pessoa;
import model.cliente.PessoaFisica;
import model.cliente.PessoaJuridica;
import model.enumeration.TipoPessoa;

public class ClienteView extends View {

    public TipoPessoa askForTipoPessoa() {
        while(true) {
            showMessage("----- TIPOS DE PESSOA -----");
            showMessage("1 - Fisica.");
            showMessage("2 - Juridica.");
            showMessage("---------------------------");

            int valor = lerInteiro("Digite uma opção válida!");

            switch (valor) {
                case 1: return TipoPessoa.FISICA;
                case 2: return TipoPessoa.JURIDICA;
                default: showMessage("Opção invalida!");
            }
        }
    }

    public Pessoa askForPessoa() {
        while(true) {
            TipoPessoa tipo = askForTipoPessoa();

            String nome = lerString("Digite seu nome: ");
            String telefone = lerString("Digite seu telefone: ");

            switch (tipo) {
                case FISICA:
                    String cpf = lerString("Digite seu cpf: ");
                    return new PessoaFisica(nome, cpf, telefone);

                case JURIDICA:
                    String cnpj = lerString("Digite seu cnpj: ");
                    return new PessoaJuridica(nome, cnpj, telefone);

                default: showMessage("Ocorreu um problema!");
            }
        }
    }

    public void listarClientes(Pessoa[] clientes) {
        for (int i = 0; i < clientes.length; i++) {
            Pessoa cliente = clientes[i];
            if (cliente != null) {

                showMessage("Nome : " + cliente.getNome());
                showMessage("CPF : " + cliente.getCpf());
                showMessage("Telefone : " + cliente.getTelefone());
            }
        }
    }

    public String askForDocumento() {
        return lerString("Digite o documento da pessoa:");
    }

    public void exibirCliente(Pessoa cliente) {
        if (cliente != null) {
            showMessage("Nome : " + cliente.getNome());
            showMessage("CPF : " + cliente.getCpf());
            showMessage("Telefone : " + cliente.getTelefone());
        }
    }
}
