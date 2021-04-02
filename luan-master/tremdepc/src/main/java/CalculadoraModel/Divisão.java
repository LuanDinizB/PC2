package CalculadoraModel;

import CalculadoraEnumeration.TiposEnum;

public class Divisão<T> extends Operação {

    public void operar(T elemento1, T elemento2, TiposEnum options) {
        if (options.equals(TiposEnum.INTEIRO)) {
            int resultado = (int) elemento1 / (int) elemento2;
            System.out.println(resultado);
        } else if (options.equals(TiposEnum.DOUBLE)) {
            double resultado = (double) elemento1 / (double) elemento2;
            System.out.println(resultado);
        } else if (options.equals(TiposEnum.STRING)) {
           System.out.println("Não é possivel fazer essa operação");

        }
    }
}


