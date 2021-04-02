package model.conta;

import domain.Pessoa;
import domain.Conta;
import domain.Extrato;

public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(double saldo, int numero) {
        super(saldo, numero);
        this.limite = 150;
    }

    @Override
    public boolean sacar(double valor) {
        if((saldo + limite) < valor)
            return false;

        if(saldo < valor) {
            limite -= valor;
        }

        super.saldo -= valor;

        Extrato extrato = new Extrato(valor, Extrato.Tipos.SAQUE);
        this.inserirExtrato(extrato);

        return true;
    }

    @Override
    public boolean transferir(Conta conta,  double valor) {
        if((saldo + limite) < valor)
            return false;

        if(saldo < valor) {
            limite -= valor;
        }

        saldo -= valor;

        double novoSaldo = conta.getSaldo() + valor;
        conta.setSaldo(novoSaldo);

        Extrato extrato = new Extrato(valor, Extrato.Tipos.TRANSFERENCIA);
        this.inserirExtrato(extrato);
        conta.inserirExtrato(extrato);

        return true;
    }
}
