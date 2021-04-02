package domain;

import java.util.ArrayList;
import java.util.List;
import model.cliente.PessoaFisica;

public class Gerente extends PessoaFisica {
    private List<Conta> contas;

    private final int MAXCONTAS = 3;
    private final int MAXGERENTES = 10;
    private static int numeroGerentes;

    public Gerente(String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
        contas = new ArrayList<>();

    }

    public boolean addConta(Conta conta) {
        if (contas.size() < MAXCONTAS && numeroGerentes < MAXGERENTES) {
            contas.add(conta);
            numeroGerentes++;
            return true;
        }
        return false;
    }

    public boolean veriricarMaximo() {
        return contas.size() < MAXCONTAS && numeroGerentes < MAXGERENTES;
    }

    public int getNumeroContas() {
        return contas.size();
    }

    public int getNumeroGerentes() {
        return numeroGerentes;
    }

}
