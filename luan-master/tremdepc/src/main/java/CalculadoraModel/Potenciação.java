package CalculadoraModel;

import CalculadoraEnumeration.TiposEnum;

public class Potenciação<T> extends Operação {

    public void operar(T elemento1, T elemento2, TiposEnum options) {
        if (options.equals(TiposEnum.INTEIRO)) {
            System.out.println("Não é possivel fazer essa operação");

        } else if (options.equals(TiposEnum.DOUBLE)) {
            double resultado = Math.pow((double) elemento1, (double) elemento2);
            System.out.println(resultado);
        } else if (options.equals(TiposEnum.STRING)) {
            System.out.println("Não é possivel fazer essa operação");

        }

    }
}
