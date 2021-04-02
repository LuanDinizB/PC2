package model.conta;

import domain.Pessoa;
import domain.Conta;
import domain.Extrato;

 public class ContaPoupança extends Conta {

    public ContaPoupança(Double saldo, int numero) {
        super(saldo, numero);
    }

    @Override
    public boolean sacar(double valor) {
        if ((saldo) < valor) {
            return false;
        }

        super.saldo -= valor;

        Extrato extrato = new Extrato(valor, Extrato.Tipos.SAQUE);
        this.inserirExtrato(extrato);

        return true;
    }

    @Override
    public boolean transferir(Conta conta, double valor) {
        if ((saldo) < valor) {
            return false;
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
