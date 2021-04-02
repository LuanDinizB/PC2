package service;

import domain.Gerente;
import repository.IRepository;
import repository.vetor.GerenteRepository;
import view.GerenteView;

public class GerenteController {
    private GerenteView view;
    private IRepository<Gerente> repository;

    public GerenteController() {
        repository = new GerenteRepository();
        view = new GerenteView();
    }

    public void cadastrar() {
        Gerente gerente = view.askForGerente();
        repository.cadastrar(gerente);
    }

    public void atualizar(){
        Gerente gerente = localizarGerente();
        if(gerente != null) {
            view.atualizar(gerente);
            repository.atualizar(gerente);
        }
    }

    public void excluir(){
        Gerente gerente = localizarGerente();
        if(gerente != null) {
            repository.remover(gerente);
        }
    }

    public Gerente localizarGerente() {
        String cpf = view.askForDocumento();
        return repository.localizar(cpf);
    }

    public void persistAll() {
        repository.persistAll();
    }

    public void loadAll() {
        repository.loadAll();
    }
}
