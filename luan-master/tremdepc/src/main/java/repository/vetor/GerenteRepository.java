package repository.vetor;

import domain.Gerente;
import repository.IRepository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GerenteRepository implements IRepository<Gerente> {

    private Gerente[] gerentes;

    public GerenteRepository() {
        this.gerentes = new Gerente[10];
    }

    public GerenteRepository(int tamanho) {
        this.gerentes = new Gerente[tamanho];
    }

    public boolean cadastrar(Gerente cliente) {
        for (int i = 0; i < gerentes.length; i++) {
            if (gerentes[i] == null) {
                gerentes[i] = cliente;
                return true;
            }
        }
        return false;
    }

    public Gerente[] findAll() {
        return gerentes;
    }

    public boolean remover(Gerente gerente) {
        for (int i = 0; i < gerentes.length; i++) {
            if (gerentes[i] != null && gerentes[i] == gerente) {
                gerentes[i] = null;
                return true;
            }
        }

        return false;
    }

    public boolean persistAll() {
        try {
            FileOutputStream arquivo = new FileOutputStream("gerenteVetor.dat");
            ObjectOutputStream out = new ObjectOutputStream(arquivo);
            out.writeObject(gerentes);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean loadAll() {
        try {
            FileInputStream arq = new FileInputStream("gerenteVetor.dat");
            ObjectInputStream in = new ObjectInputStream(arq);
            gerentes = (Gerente[]) in.readObject();

            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public Gerente atualizar(Gerente gerenteAtualizar) {
        Gerente c = this.localizar(gerenteAtualizar.getCpf());
        c = gerenteAtualizar;
        return c;
    }

    public Gerente localizar(String cpf) {
        for (int i = 0; i < gerentes.length; i++) {
            if (gerentes[i] != null) {
                if (gerentes[i].getCpf().equals(cpf)) {
                    return gerentes[i];
                }
            }
        }
        return null;
    }
}
