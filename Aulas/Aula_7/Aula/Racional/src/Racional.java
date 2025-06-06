package LabOO.Aulas.Aula_7.Aula.Racional.src;

import java.util.ArrayList;

/*
    * 1. Execute o código a seguir e verifique o que acontece quando uma divisão
    * por zero é realizada. 2. Trate a exceção lançada pelo código acima usando um
    * bloco try-catch para gerar uma mensagem de erro mais amigável e evitar um
    * erro de execução 3. Gere uma exceção do tipo ArithmeticException se o
    * denominador for zero no construtor da classe Racional e execute novamente o
    * código. 4. Gere uma exceção verificada do tipo Exception se o denominador for
    * zero no construtor da classe Racional e execute novamente o código. 5. Crie
    * uma exceção verificada do tipo DivisorZeroException que herde de Exception e
    * gere essa exceção no construtor da classe Racional se o denominador for zero.
    * Gere tal exceção se o denominador for zero no construtor da classe Racional e
    * execute novamente o código. 6. Modifique o código para que ele compile e gere
    * mensagens de erro mais amigáveis.
*/
public class Racional {
    private int numerador;
    private int denominador;

    // Encontra maior divisor comum entre inteiros m e n
    // pelo algoritmo de Euclides
    private static int mdc(int m, int n) {
        if (n == 0)
            return m;
        else
            return mdc(n, m % n);
    }

    /* Cria racional numerador/denominador */
    Racional(int numerador, int denominador) {
        /* simplificar */
        if (numerador == 0) {
            this.numerador = numerador;
            this.denominador = 1;
        }
        else {
            int d = mdc(numerador, denominador);
            this.numerador = numerador / d;
            this.denominador = denominador / d;
        }
    }

    // Construtor para inteiro (denominador = 1)
    public Racional(int numerador) {
        this(numerador, 1);
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    /* Calcula a soma desse racional e de outro dado */
    Racional soma(Racional r) {
        return new Racional(numerador * r.denominador + r.numerador * denominador, denominador * r.denominador);
    }

    /*
     * Calcula o produto desse racional e outro dado
     */
    Racional produto(Racional r) {
        return new Racional(numerador * r.numerador, denominador * r.denominador);
    }

    /*
     * Calcula o recíproco desse número racional (isto é, q/p para um racional p/q)
     */
    Racional recíproco() {
        return new Racional(denominador, numerador);
    }

    @Override
    public String toString() {
        if (denominador == 1)
            return "" + numerador;
        else
            return numerador + "/" + denominador;
    }

    public double toDouble() {
        return numerador;
    }

    public static void main(String[] args) {
        // Casos de teste
        ArrayList<Racional> racionais = new ArrayList<>();

        racionais.add(new Racional(1, 2));
        racionais.add(new Racional(1, 3));
        racionais.add(new Racional(6, 7));
        racionais.add(new Racional(1, 7));
        racionais.add(new Racional(-2, 4));
        racionais.add(new Racional(2, 4));
        racionais.add(new Racional(2, 3));
        racionais.add(new Racional(4, 3));

        for (int i = 0; i < racionais.size(); i += 2) {
            Racional r = racionais.get(i);
            Racional s = racionais.get(i + 1);
            Racional t = r.soma(s);
            System.out.println("t = " + r + " + " + s + " = " + t);
            // Gera exceção se número t for zero:

            try {
                Racional recíproco_t = t.recíproco();
                System.out.println("1/t = " + recíproco_t + " ≈" + recíproco_t.toDouble());
            }
            catch (Exception e) {
                System.out.println("Algo deu errado");
            }
        }
    }
}