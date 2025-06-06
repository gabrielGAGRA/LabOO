package LabOO.Aulas.Aula_7.Entrega.Servidor_Calculadora.src;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            System.err.println("Use: java Cliente.java <host> <porta>");
            System.exit(1);
        }

        // O cliente recebe como argumento o endereço de internet (IP) e porta do
        // servidor.
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try (Socket echoSocket = new Socket(hostName, portNumber);
                PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
                Scanner stdIn = new Scanner(new InputStreamReader(System.in))) {
            System.out.println("Conectado.");

            int numero1;
            int numero2;
            while (true) {
                // O cliente pede ao usuário dois números inteiros e os envia para o servidor.
                System.out.println("Digite dois inteiros seguidos e tecle <ENTER>.");
                try {
                    numero1 = stdIn.nextInt();
                    numero2 = stdIn.nextInt();
                    out.println(numero1 + " " + numero2);
                    // O cliente exibe na tela a resposta do servidor.
                    System.out.println("O servidor disse: " + in.readLine());
                }
                catch (Exception NoSuchElementException) {
                    // Esse processo se repete até que o usuário indique que não há mais números.
                    System.out.println("Fim do programa");
                    break;
                }
            }
        }
        catch (UnknownHostException e) {
            System.err.println("Host sumiu" + hostName);
            System.exit(1);
        }
        catch (IOException e) {
            System.err.println("Erro em conexao IO" + hostName);
            System.exit(1);
        }
    }
}