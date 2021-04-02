
package view;

import domain.Gerente;

public class GerenteView extends View {
    public String askForDocumento() {
        return lerString("Digite o documento do gerente:");
    }

    public void atualizar(Gerente gerente) {
        String nome = lerString("Digite seu nome:");
        String cpf = lerString("Digite seu cpf: ");
        String telefone = lerString("Digite seu telefone: ");

        gerente.setNome(nome);
        gerente.setCpf(cpf);
        gerente.setTelefone(telefone);
    }

    public Gerente askForGerente(){
        String nome = lerString("Digite seu nome: ");
        String cpf = lerString("Digite seu cpf: ");
        String telefone = lerString("Digite seu telefone: ");
        return new Gerente(nome, cpf, telefone);
    }
}
