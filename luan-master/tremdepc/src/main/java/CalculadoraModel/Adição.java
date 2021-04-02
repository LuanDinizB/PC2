package CalculadoraModel;

import java.util.Scanner;
import CalculadoraEnumeration.TiposEnum;

public class Adição<T> extends Operação {

    public void operar(T elemento1, T elemento2, TiposEnum options) {
        if (options.equals(TiposEnum.INTEIRO)) {
            int resultado = (int) elemento1 + (int) elemento2;
            System.out.println(resultado);
        } else if (options.equals(TiposEnum.DOUBLE)) {
            double resultado = (double) elemento1 + (double) elemento2;
            System.out.println(resultado);
        } else if (options.equals(TiposEnum.STRING)) {
            String resultado = (String) elemento1 + (String) elemento2;
            System.out.println(resultado);

        }
    }

}
