
package model.cliente;

import domain.Pessoa;
import model.enumeration.TipoPessoa;

public class PessoaFisica extends Pessoa{
    private String cpf;
    
    
    public PessoaFisica(String nome, String cpf, String telefone){
        super(nome, cpf, telefone);
              this.cpf = cpf;
              tipopessoa = TipoPessoa.FISICA;
    }
    
    @Override
    public String getCpf(){
        return this.cpf;
    }
}
