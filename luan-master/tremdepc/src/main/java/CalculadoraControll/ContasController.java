package CalculadoraControll;

import CalculadoraEnumeration.ContasEnum;
import CalculadoraEnumeration.TiposEnum;
import CalculadoraModel.Adição;
import CalculadoraModel.Divisão;
import CalculadoraModel.Multiplicação;
import CalculadoraModel.Potenciação;
import CalculadoraModel.Subtração;
import CalculadoraView.View;

public class ContasController {

    public ContasEnum contas;
    View view;

    public void start(TiposEnum option) {

        view = new View();

        if (option.equals(TiposEnum.INTEIRO)) {
            int int1 = view.lerInteiro("");
            ContasEnum operacao = view.perguntarOperação();
            int int2 = view.lerInteiro("");

            switch (operacao) {
                case ADICAO:
                    Adição<Integer> soma = new Adição<>();
                    soma.operar(int1, int2, option);
                    break;
                case SUBTRACAO:
                    Subtração<Integer> diminuir = new Subtração<>();
                    diminuir.operar(int1, int2, option);
                    break;
                case MULTIPLICACAO:
                    Multiplicação<Integer> multiplicar = new Multiplicação<>();
                    multiplicar.operar(int1, int2, option);
                    break;
                case DIVISAO:
                    Divisão<Integer> dividir = new Divisão<>();
                    dividir.operar(int1, int2, option);
                    break;
                case POTENCIACAO:
                    Potenciação<Integer> potenciar = new Potenciação<>();
                    potenciar.operar(int1, int2, option);
                    break;

            }
        } else if (option.equals(TiposEnum.DOUBLE)) {
            double dbl1 = view.lerDouble("");
            ContasEnum operacao = view.perguntarOperação();
            double dbl2 = view.lerDouble("");
            switch (operacao) {
                case ADICAO:
                    Adição<Double> soma = new Adição<>();
                    soma.operar(dbl1, dbl2, option);
                    break;
                case SUBTRACAO:
                    Subtração<Double> diminuir = new Subtração<>();
                    diminuir.operar(dbl1, dbl2, option);
                    break;
                case MULTIPLICACAO:
                    Multiplicação<Double> multiplicar = new Multiplicação<>();
                    multiplicar.operar(dbl1, dbl2, option);
                    break;
                case DIVISAO:
                    Divisão<Double> dividir = new Divisão<>();
                    dividir.operar(dbl1, dbl2, option);
                    break;
                case POTENCIACAO:
                    Potenciação<Double> potenciar = new Potenciação<>();
                    potenciar.operar(dbl1, dbl2, option);
                    break;

            }
        } else if (option.equals(TiposEnum.STRING)) {
            String str1 = view.lerString("");
            ContasEnum operacao = view.perguntarOperação();
            String str2 = view.lerString("");
            switch (operacao){
                case ADICAO:
                    Adição<String> soma = new Adição<>();
                    soma.operar(str1, str2, option);
                    break;
            }    
        }
    }

}
