
package domain;

import java.time.Instant;


public class Extrato {
    private Instant data;
    public enum Tipos{TRANSFERENCIA, DEPOSITO, SAQUE};
    private double valor;
    private Tipos tipo;
    
    public Extrato(double valor, Tipos tipo) {
        data = Instant.now();
        this.valor = valor;
        this.tipo = tipo;
    
}
    
    /**
     * @return the data
     */
    public Instant getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Instant data) {
        this.data = data;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
