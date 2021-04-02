package repository.vetor;

import domain.Conta;
import repository.IRepository;

import java.io.*;

public class ContaRepository implements IRepository<Conta> {
    private Conta[] contas;

    public ContaRepository() {
        this.contas = new Conta[10];
    }

    public ContaRepository(int tamanho) {
        this.contas = new Conta[tamanho];
    }

    public boolean cadastrar(Conta cliente) {
        for (int i = 0; i < contas.length; i++) {
            if (contas[i] == null) {
                contas[i] = cliente;
                return true;
            }
        }
        return false;
    }

    public Conta[] findAll() {
        return contas;
    }

    public boolean remover(Conta conta) {
        for (int i = 0; i < contas.length; i++) {
            if (contas[i] != null && contas[i] == conta) {
                contas[i] = null;
                return true;
            }
        }

        return false;
    }

    public boolean persistAll(){
        try {
            FileOutputStream arquivo = new FileOutputStream("clientesVetor.dat");
            ObjectOutputStream out = new ObjectOutputStream(arquivo);
            out.writeObject(contas);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean loadAll(){
        try {
            FileInputStream arq = new FileInputStream("contasVetor.dat");
            ObjectInputStream in =  new ObjectInputStream(arq);
            contas = (Conta[]) in.readObject();
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }

    public Conta atualizar(Conta clienteAtualizar) {
        Conta c = this.localizar(clienteAtualizar.getCpf());
        c = clienteAtualizar;
        return c;
    }

    public Conta localizar(String cpf) {
        for (int i = 0; i < contas.length; i++) {
            if (contas[i] != null) {
                if (contas[i].getCpf().equals(cpf)) {
                    return contas[i];
                }
            }
        }
        return null;
    }
}
