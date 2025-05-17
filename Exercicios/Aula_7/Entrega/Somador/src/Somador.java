import java.io.FileReader; // Leitor de arquivos de textos
import java.io.FileWriter; // Para escrever em arquivos de textos
import java.io.PrintWriter; // Escreve saida formatada (texto)
import java.io.FileNotFoundException; // Exceção ao abrir arquivo de entrada
import java.io.IOException; // Exceção ao abrir arquivo de saida
import java.util.Scanner; // Leitor de tipos de dados

public class Somador {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Use: java Somador.java 'arquivo_entrada' (opcional: 'arquivo_saida')");
            System.exit(1);
        }

        Scanner leitor = null;
        PrintWriter saida = null;

        try {
            leitor = new Scanner(new FileReader(args[0]));
            if (args.length < 2) {
                saida = new PrintWriter(System.out);
            }
            else {
                saida = new PrintWriter(new FileWriter(args[1]));
            }

            while (leitor.hasNextInt()) {
                try {
                    int numero1 = leitor.nextInt();
                    int numero2 = leitor.nextInt();
                    saida.println(numero1 + numero2);
                }
                catch (java.util.InputMismatchException e) {
                    System.out.println("Erro fatal: Use somente inteiros");
                    System.exit(1);
                    ;
                }
                catch (java.util.NoSuchElementException e) {
                    System.out.println("Fim do arquivo");
                    break;
                }
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("Arquivo de entrada não encontrado: " + args[0]);
        }
        catch (IOException e) {
            System.out.println("Arquivo de saída não pode ser criado.");
            e.printStackTrace();
        }
        finally {
            if (leitor != null) {
                leitor.close();
            }
            if (saida != null) {
                saida.close();
            }
        }
    }
}
