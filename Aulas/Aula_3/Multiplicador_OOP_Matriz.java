package LabOO.Aulas.Aula_3;

import java.util.Scanner;

class Matriz {
    double[][] numeros;
    int linhas;
    int colunas;

    public Matriz(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.numeros = new double[linhas][colunas];
    }

    public void LerMatriz(Scanner input) {
        int i, j;
        for (i = 0; i < linhas; i++) {
            for (j = 0; j < colunas; j++) {
                numeros[i][j] = input.nextDouble();
            }
        }
    }

    public void MostrarMatriz() {
        int i, j;
        for (i = 0; i < linhas; i++) {
            for (j = 0; j < colunas; j++) {
                System.out.print(numeros[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public Matriz MultiplicarColunas(Matriz Matriz_B) {
        Matriz Matriz_C = new Matriz(this.linhas, Matriz_B.colunas);

        for (int i = 0; i < this.linhas; i++) {
            for (int j = 0; j < Matriz_B.colunas; j++) {
                for (int k = 0; k < this.colunas; k++) {
                    Matriz_C.numeros[i][j] += this.numeros[i][k] * Matriz_B.numeros[k][j];
                }
            }
        }

        return Matriz_C;
    }
}

public class Multiplicador_OOP_Matriz {
    public static void main(String[] args) {
        // Precisa ter pelo menos 4 números para indicar a dimensão das duas matrizes
        if (args.length < 4) {
            System.out.println("Faltou numeros para a dimensao das matrizes");
            return;
        }

        int linhasA = Integer.parseInt(args[0]);
        int colunasA = Integer.parseInt(args[1]);
        int linhasB = Integer.parseInt(args[2]);
        int colunasB = Integer.parseInt(args[3]);
        /*
         * Na multiplicacao de matrizes, as matrizes devem ser da forma mxn e nxp
         * Ou seja, coluna_A deve ser de mesma dimensao que linha_B
         */
        if (colunasA != linhasB) {
            System.out.println("Erro: Coluna A deve ter mesma dimensao que linha B");
            return;
        }

        Scanner input = new Scanner(System.in);

        System.out.println("Digite os valores da matriz A: ");
        Matriz Matriz_A = new Matriz(linhasA, colunasA);
        Matriz_A.LerMatriz(input);

        System.out.println("Matriz A:");
        Matriz_A.MostrarMatriz();

        System.out.println("Digite os valores da matriz B: ");
        Matriz Matriz_B = new Matriz(linhasB, colunasB);
        Matriz_B.LerMatriz(input);

        System.out.println("Matriz B:");
        Matriz_B.MostrarMatriz();

        Matriz Matriz_C = Matriz_A.MultiplicarColunas(Matriz_B);
        System.out.println("Matriz C:");
        Matriz_C.MostrarMatriz();
    }
}