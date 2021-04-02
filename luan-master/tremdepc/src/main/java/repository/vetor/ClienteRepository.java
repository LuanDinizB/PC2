package repository.vetor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import domain.Pessoa;
import repository.IRepository;

public class ClienteRepository implements IRepository<Pessoa> {
    private Pessoa[] pessoas;

    public ClienteRepository() {
        this.pessoas = new Pessoa[10];
    } 

    public ClienteRepository(int tamanho) {
        this.pessoas = new Pessoa[tamanho];
    } 

    public boolean cadastrar(Pessoa cliente) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] == null) {
                pessoas[i] = cliente;
                return true;
            }
        }
        return false;
    }

    public Pessoa[] findAll() {
        return pessoas;
    }
    
     public boolean remover(Pessoa pessoa) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && pessoas[i] == pessoa) {
                pessoas[i] = null;
                return true;
            }
        }

        return false;
    }
     
    public boolean persistAll(){
       try {
           FileOutputStream arquivo = new FileOutputStream("clientesVetor.dat");
           ObjectOutputStream  out = new ObjectOutputStream(arquivo);
           out.writeObject(pessoas);
           return true;
       } catch (IOException e) {
           return false;
       }
    }
    
    public boolean loadAll(){
        try {
            FileInputStream arq = new FileInputStream("clientesVetor.dat");
            ObjectInputStream in =  new ObjectInputStream(arq);
            pessoas = (Pessoa[])in.readObject();
            
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }   
    
    public Pessoa atualizar(Pessoa clienteAtualizar) {
        Pessoa c = this.localizar(clienteAtualizar.getCpf());
        c = clienteAtualizar;
        return c;    
    }

    public Pessoa localizar(String cpf) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null) {
                if (pessoas[i].getCpf().equals(cpf)) {
                    return pessoas[i];
                }
            }
        }
        return null;
    }
}
