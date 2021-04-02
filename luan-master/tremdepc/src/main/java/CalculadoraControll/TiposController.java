package CalculadoraControll;

import CalculadoraEnumeration.ContasEnum;
import CalculadoraEnumeration.TiposEnum;
import CalculadoraModel.Adição;
import CalculadoraView.View;

public class TiposController {

    public TiposEnum tipos;

    ContasController conta;
    View view;

    public void start() {
        conta = new ContasController();
        view = new View();

        TiposEnum option;
        do {
            option = view.perguntarTipo();

            switch (option) {
                case INTEIRO:
                    conta.start(option);
                    break;

                case DOUBLE:
                    conta.start(option);
                    break;
                    
                case STRING:
                    conta.start(option);
                    break;

            }

        } while (option != TiposEnum.SAIR);

    }
}
