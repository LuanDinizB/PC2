package repository;

public interface IRepository<T> {
    public boolean cadastrar(T elemento);

    public T[] findAll();

    public boolean remover(T elemento);

    public T localizar(String chave);

    public T atualizar(T elemento);

    public boolean persistAll();

    public boolean loadAll();
}
