package LabOO.Provas.P2.Prova.src;

import java.util.Scanner;

public class Interface {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    cadastrarLivro();
                    break;
                case 3:
                    cadastrarEmprestimo();
                    break;
                case 4:
                    renovarEmprestimo();
                    break;
                case 5:
                    registrarDevolucao();
                    break;
                case 6:
                    listarUsuariosComAtraso();
                    break;
    }

    private static void cadastrarUsuario() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Data de Nascimento (dd/MM/yyyy): ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Usuario novoUsuario = new Usuario(true, nome, 0, dataNascimento, email);

        Banco_Usuarios.getListaUsuarios().add(novoUsuario);
    }

    private static void cadastrarLivro() {
        System.out.println("Tipo de Livro (1-Recente, 2-Coleção, 3-Consulta): ");
        int tipoLivro = Integer.parseInt(scanner.nextLine());

        System.out.print("Título: ");
    }
}

String titulo = scanner.nextLine();System.out.print("Autor: ");
String autor = scanner.nextLine();System.out.print("Editora: ");
String editora = scanner.nextLine();System.out.print("Ano de Publicação: ");
int ano = Integer.parseInt(scanner.nextLine());
