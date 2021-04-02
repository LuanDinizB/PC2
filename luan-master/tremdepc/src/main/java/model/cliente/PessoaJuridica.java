
package model.cliente;

import domain.Pessoa;
import model.enumeration.TipoPessoa;

public class PessoaJuridica extends Pessoa {
    private String cpf;
    
    
    public PessoaJuridica(String nome, String cpf, String telefone){
        super(nome, cpf, telefone);
              this.cpf = cpf;
              tipopessoa = TipoPessoa.JURIDICA;
    }
    
    @Override
    public String getCpf(){
        return this.cpf;
}
}