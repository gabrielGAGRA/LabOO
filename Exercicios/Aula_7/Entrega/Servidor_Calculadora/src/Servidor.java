import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        // O servidor recebe como argumento uma porta para "escutar".

        if (args.length != 1) {
            System.err.println("Use: java Servidor.java <porta>");
            System.exit(1);
        }

        System.out.println("Servidor de calculadora");

        int portNumber = Integer.parseInt(args[0]);

        try (ServerSocket serverSocket = new ServerSocket(portNumber);
                // O servidor permite no máximo uma conexão ao cliente e encerra o programa após
                // a desconexão.
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
            System.out.println("Cliente conectado.");

            // Ao receber dois números inteiros do cliente, ele calcula sua soma e envia o
            // resultado ao cliente.
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                try {
                    String[] partes = inputLine.split(" ");
                    int numero1 = Integer.parseInt(partes[0]);
                    int numero2 = Integer.parseInt(partes[1]);
                    out.println(numero1 + numero2);
                }
                catch (java.util.InputMismatchException e) {
                    System.out.println("Erro fatal: Use somente inteiros");
                    System.exit(1);
                }
                catch (java.util.NoSuchElementException e) {
                    System.out.println("Fim do arquivo");
                    System.exit(1);
                }
            }
        }
        catch (IOException e) {
            System.out.println(
                    "Exception caught when trying to listen on port " + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
