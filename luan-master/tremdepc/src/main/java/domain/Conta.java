package domain;

public class Conta {
    protected Double saldo;
    protected int numero;
    protected Extrato[] extratos;
    private Pessoa cliente;
    private Gerente gerente;

    public Conta(Double saldo, int numero) {
        this.saldo = saldo;
        this.numero = numero;
        extratos = new Extrato[100];
    }

    /**
     * @return the saldo
     */
    public Double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

   

    public String getCpf() {
        return getCliente().getCpf();
    }

    public void inserirExtrato(Extrato extrato) {
        for (int i = 0; i < extratos.length; i++) {
            if (extratos[i] == null) {
                extratos[i] = extrato;
                break;
            }

        }
    }
    public void imprimirExtrato(Extrato extrato){
            getExtratos();
        for (int i = 0; i < extratos.length; i++) {
            System.out.println(this.extratos[i]);
        }
}

    public Extrato[] getExtratos() {
        return extratos;
    }

    public boolean sacar(double valor) {
        if(saldo >= valor) {
            saldo -= valor;

            Extrato extrato = new Extrato(valor, Extrato.Tipos.SAQUE);
            this.inserirExtrato(extrato);

            return true;
        }

        return false;
    }

    public boolean depositar(double valor) {
        if(valor > 0) {
            saldo += valor;

            Extrato extrato = new Extrato(valor, Extrato.Tipos.DEPOSITO);
            this.inserirExtrato(extrato);

            return true;
        }

        return false;
    }

    public boolean transferir(Conta conta, double valor) {
        if(saldo < valor)
            return false;

        saldo -= valor;

        double novoSaldo = conta.getSaldo() + valor;
        conta.setSaldo(novoSaldo);

        Extrato extrato = new Extrato(valor, Extrato.Tipos.TRANSFERENCIA);
        this.inserirExtrato(extrato);
        conta.inserirExtrato(extrato);

        return true;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }
}
