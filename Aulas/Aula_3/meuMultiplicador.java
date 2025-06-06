package LabOO.Aulas.Aula_3;

import java.util.Scanner;

public class meuMultiplicador {
    public static void Multiplicador_Colunas(int linha_A, int coluna_A, int linha_B, int coluna_B) {
        Scanner input = new Scanner(System.in);

        int i, j, k;

        System.out.println("Digite o conteudo de A:");
        int[][] matrizA = new int[linha_A][coluna_A];
        for (i = 0; i < linha_A; i++) {
            for (j = 0; j < coluna_A; j++) {
                matrizA[i][j] = input.nextInt();
            }
        }

        System.out.println("Digite o conteudo de B:");
        int[][] matrizB = new int[linha_B][coluna_B];
        for (i = 0; i < linha_B; i++) {
            for (j = 0; j < coluna_B; j++) {
                matrizB[i][j] = input.nextInt();
            }
        }

        for (i = 0; i < linha_A; i++) {
            for (j = 0; j < coluna_B; j++) {
                for (k = 0; k < coluna_A; k++) {
                    int c = matrizA[i][k] * matrizB[k][j];
                    System.out.println(c);
                }
            }
        }
    }

    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Faltou numeros");
            return;
        }

        int linha_A = Integer.parseInt(args[0]);
        int coluna_A = Integer.parseInt(args[1]);
        int linha_B = Integer.parseInt(args[2]);
        int coluna_B = Integer.parseInt(args[3]);
        if (coluna_A == linha_B) {
            Multiplicador_Colunas(linha_A, coluna_A, linha_B, coluna_B);
        }
    }
}
