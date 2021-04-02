package domain;

import java.io.Serializable;
import model.enumeration.TipoPessoa;

public class Pessoa implements Serializable {
   private String nome;
   private String cpf;
   private String telefone;
   public TipoPessoa tipopessoa;
   public Pessoa(String nome, String cpf, String telefone){
       this.nome = nome;
       this.cpf = cpf;
       this.telefone = telefone;
   }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
        
}
