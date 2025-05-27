package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.Livro;
import model.LivroColecao;
import model.LivroRecente;
import model.LivroReferencia;
import service.Biblioteca;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca bib = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (running) {
            System.out.println("\n--- Menu Biblioteca ---");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Cadastrar Livro");
            System.out.println("3. Realizar Empréstimo");
            System.out.println("4. Renovar Empréstimo");
            System.out.println("5. Registrar Devolução");
            System.out.println("6. Listar Usuários com Empréstimos em Atraso");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Data de Nascimento (dd/MM/yyyy): ");
                    LocalDate nascimento = LocalDate.parse(scanner.nextLine(), formatter);
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();
                    bib.adicionarUsuario(cpf, nome, nascimento, endereco);
                    System.out.println("Usuário cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Editora: ");
                    String editora = scanner.nextLine();
                    System.out.print("Ano: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Páginas: ");
                    int paginas = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha
                    System.out.print("Edição: ");
                    String edicao = scanner.nextLine();
                    System.out.print("Tipo (1-Recente, 2-Coleção, 3-Referência): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha

                    Livro livro;
                    if (tipo == 1) {
                        livro = new LivroRecente(titulo, autor, editora, ano, isbn, paginas, edicao);
                    } else if (tipo == 2) {
                        livro = new LivroColecao(titulo, autor, editora, ano, isbn, paginas, edicao);
                    } else {
                        livro = new LivroReferencia(titulo, autor, editora, ano, isbn, paginas, edicao);
                    }
                    bib.adicionarLivro(livro);
                    System.out.println("Livro cadastrado/adicionada cópia com sucesso!");
                    break;

                case 3:
                    System.out.print("ID do Usuário: ");
                    int idUsuarioEmprestimo = scanner.nextInt();
                    System.out.print("ISBN do Livro: ");
                    String isbnEmprestimoRenovacao = scanner.next();
                    System.out.print("Data do Empréstimo (dd/MM/yyyy): ");
                    LocalDate dataEmprestimo = LocalDate.parse(scanner.next(), formatter);
                    try {
                        bib.emprestar(idUsuarioEmprestimo, isbnEmprestimoRenovacao, dataEmprestimo);
                        System.out.println("Empréstimo realizado com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("ID do Usuário: ");
                    int idUsuarioRenovacao = scanner.nextInt();
                    System.out.print("ISBN do Livro: ");
                    String isbnEmprestimoDevolucao = scanner.next();
                    System.out.print("Nova Data de Devolução (dd/MM/yyyy): ");
                    scanner.next();
                    try {
                        bib.renovar(idUsuarioRenovacao, isbnEmprestimoDevolucao);
                        System.out.println("Renovação realizada com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.print("ID do Usuário: ");
                    int idUsuarioDevolucao = scanner.nextInt();
                    System.out.print("ISBN do Livro: ");
                    String isbnEmprestimo = scanner.next();
                    System.out.print("Data de Devolução (dd/MM/yyyy): ");
                    LocalDate dataDevolucao = LocalDate.parse(scanner.next(), formatter);
                    bib.devolver(idUsuarioDevolucao, isbnEmprestimo, dataDevolucao);
                    System.out.println("Devolução registrada com sucesso!");
                    break;

                case 6:
                    System.out.print("Data de Referência (dd/MM/yyyy): ");
                    LocalDate dataReferencia = LocalDate.parse(scanner.next(), formatter);
                    bib.listarAtrasados(dataReferencia).forEach(e -> {
                        System.out.println("Usuário: " + e.getUsuario().getNome() +
                                ", Dias em atraso: " + e.calcularDiasAtraso(dataReferencia) +
                                ", Embargo até: " + e.getUsuario().getEmbargoAte());
                    });
                    break;

                case 7:
                    running = false;
                    System.out.println("Encerrando o sistema...");
                    break;
            }
        }

        scanner.close();
    }
}