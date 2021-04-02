package view;

import domain.Pessoa;
import domain.Conta;
import model.conta.ContaCorrente;
import model.conta.ContaPoupança;
import model.enumeration.TipoConta;

public class ContaView extends View {
    public double askValor() {
        while(true) {
            double valor = lerDouble("Digite o valor a ser movimentado:");
            if(valor > 0)
                return valor;
        }
    }

    public String askForCPF() {
        String cpf = lerString("Qual cpf da conta para exclusão?");
        return cpf;
    }

    public Conta askForConta(){
        while(true) {
            TipoConta tipo = askForTipoConta();

            int numero = lerInteiro("Digite numero da conta: ");
            double saldo = lerDouble("Digite seu saldo: ");
            

            switch (tipo) {
                case POUPANÇA:
                    return new ContaPoupança(saldo, numero);
                case CORRENTE:
                    return new ContaCorrente(saldo, numero);
            }
        }
    }

    public void exibirSaldo(double saldo) {
        System.out.println("O saldo é: " + saldo);
    }

    public TipoConta askForTipoConta() {
        while(true) {
            showMessage("----------- TIPOS DE CONTA -----------");
            showMessage("1 - Poupança");
            showMessage("2 - Corrente");
            showMessage("--------------------------------------");

            int numero = lerInteiro("Digite uma opcão válida!");

            switch (numero) {
                case 1: return TipoConta.POUPANÇA;
                case 2: return TipoConta.CORRENTE;
            }
        }
    }

    public void listar(Conta[] contas) {
        if(contas.length  == 0){
            showMessage("Não existem contas cadastradas!");
        }

        for (int i = 0; i < contas.length; i++) {
            Conta conta = contas[i];
            if(conta != null){
                showMessage("CPF: " + conta.getCpf() +
                            "-" +
                            "Número: " + conta.getNumero());
            }
        }
    }
}
