package com.biblioteca;

import com.biblioteca.service.EmprestimoService;
import com.biblioteca.service.LivroService;
import com.biblioteca.service.UsuarioService;

import java.util.Scanner;

public class App {
    private static final UsuarioService usuarioService = new UsuarioService();
    private static final LivroService livroService = new LivroService();
    private static final EmprestimoService emprestimoService = new EmprestimoService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        do {
            displayMenu();
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
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
                    listarUsuariosAtrasados();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 0);
    }

    private static void displayMenu() {
        System.out.println("=== Sistema de Biblioteca ===");
        System.out.println("1. Cadastrar Usuário");
        System.out.println("2. Cadastrar Livro");
        System.out.println("3. Cadastrar Empréstimo");
        System.out.println("4. Renovar Empréstimo");
        System.out.println("5. Registrar Devolução");
        System.out.println("6. Listar Usuários com Empréstimos Atrasados");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarUsuario() {
        // Implementar lógica para cadastrar usuário
    }

    private static void cadastrarLivro() {
        // Implementar lógica para cadastrar livro
    }

    private static void cadastrarEmprestimo() {
        // Implementar lógica para cadastrar empréstimo
    }

    private static void renovarEmprestimo() {
        // Implementar lógica para renovar empréstimo
    }

    private static void registrarDevolucao() {
        // Implementar lógica para registrar devolução
    }

    private static void listarUsuariosAtrasados() {
        // Implementar lógica para listar usuários com empréstimos atrasados
    }
}