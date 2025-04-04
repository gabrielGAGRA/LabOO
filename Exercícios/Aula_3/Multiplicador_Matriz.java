package JAVA.LabOO.Exercícios.Aula_3;

import java.util.Scanner;

public class Multiplicador_Matriz {
    public static double[][] Ler_Matriz(int linha, int coluna, Scanner input) {
        int i, j;
        double[][] Matriz = new double[linha][coluna];
        for (i = 0; i < linha; i++) {
            for (j = 0; j < coluna; j++) {
                Matriz[i][j] = input.nextDouble();
            }
        }
        return Matriz;
    }

    public static void Mostrar_Matriz(double[][] Matriz, int linha, int coluna) {
        int i, j;
        for (i = 0; i < linha; i++) {
            for (j = 0; j < coluna; j++) {
                System.out.print(Matriz[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

    public static void Multiplicar_Colunas(double[][] Matriz_A, double[][] Matriz_B, int linha_A, int coluna_A,
            int linha_B, int coluna_B) {
        int i, j, k;
        for (i = 0; i < linha_A; i++) {
            for (j = 0; j < coluna_B; i++) {
                for (k = 0; k < coluna_A; k++) {
                    double c = Matriz_A[i][k] * Matriz_B[k][j];
                    System.out.println(c);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Precisa ter pelo menos 4 numeros pra indicar a dimensao das duas matrizes no
        // terminal
        if (args.length < 4) {
            System.out.println("Faltou numeros para a dimensao das matrizes");
            return;
        }

        int linha_A = Integer.parseInt(args[0]);
        int coluna_A = Integer.parseInt(args[1]);
        int linha_B = Integer.parseInt(args[2]);
        int coluna_B = Integer.parseInt(args[3]);

        Scanner input = new Scanner(System.in);

        /*
         * Na multiplicacao de matrizes, as matrizes devem ser da forma mxn e nxp
         * Ou seja, coluna_A deve ser de mesma dimensao que linha_B
         */
        if (coluna_A == linha_B) {
            double[][] Matriz_A = Ler_Matriz(linha_A, coluna_A, input);
            Mostrar_Matriz(Matriz_A, linha_A, coluna_A);
            double[][] Matriz_B = Ler_Matriz(linha_B, coluna_B, input);
            Mostrar_Matriz(Matriz_B, linha_B, coluna_B);
            Multiplicar_Colunas(Matriz_A, Matriz_B, linha_A, coluna_A, linha_B, coluna_B);
        }
    }
}