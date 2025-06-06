package LabOO.Aulas.Aula_7.Aula.Maiuscula;

import java.io.FileReader; // Leitor de arquivos de textos
import java.io.FileWriter; // Para escrever em arquivos de textos
import java.io.PrintWriter; // Escreve saída formatada (texto)
import java.io.FileNotFoundException; // Exceção ao abrir arquivo de entrada
import java.io.IOException; // Exceção ao abrir arquivo de saída
import java.util.Scanner; // Leitor de tipos de dados

public class ConverteParaMaiuscula {
    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Use: java programa nome_do_arquivo_de_entrada [nome_do_arquivo_de_saída]");
            System.exit(1);
        }
        Scanner leitor = null;
        PrintWriter saída = null;
        try {
            leitor = new Scanner(new FileReader(args[0]));
            // Para ler do teclado: Scanner leitor = new Scanner(System.in);
            if (args.length < 2) {
                saída = new PrintWriter(System.out);
            }
            else {
                saída = new PrintWriter(new FileWriter(args[1]));
            }
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                saída.println(linha.toUpperCase());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Arquivo de entrada não encontrado.");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("Arquivo de saída não pode ser criado.");
            e.printStackTrace();
        }
        finally {
            if (leitor != null)
                leitor.close();
            if (saída != null)
                saída.close();

        }
    }
}
