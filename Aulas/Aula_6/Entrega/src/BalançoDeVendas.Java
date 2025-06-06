import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class BalançoDeVendas {
    private static List<Vendas> listaDeVendas = new ArrayList<>();

    // Imprimir todas as vendas realizadas até o momento.
    public static void imprimeVendas() {
        System.out.println("\nLista completa de vendas");
        System.out.printf("%-10s | %-25s | %-13s | %-25s | %-8s | %-8s | %-13s\n",
                "Código", "Nome do item", "Valor total", "Tipo de venda", "Frete", "Imposto", "Receita líquida");
        for (Vendas venda : listaDeVendas) {
            System.out.printf("%-10d | %-25s | r$%-13.2f | %-25s | r$%-8.2f | r$%-8.2f | r$%-13.2f\n",
                    venda.getCodigoItem(),
                    venda.getNomeItem(),
                    venda.getValorTotalVenda(),
                    venda.getTipoVenda(),
                    venda.getFrete(),
                    venda.getImposto(),
                    venda.getReceitaLiquida());
        }
    }

    // Calcular o valor total do imposto pago até o momento.
    public static float calculaImpostoTotal() {
        float totalImposto = 0;
        for (Vendas venda : listaDeVendas) {
            totalImposto += venda.getImposto();
        }
        return totalImposto;
    }

    // Calcular a receita líquida total até o momento. Receita líquida = preço da venda - imposto - frete.
    public static float calculaReceitaLiquidaTotal() {
        float totalReceita = 0;
        for (Vendas venda : listaDeVendas) {
            totalReceita += venda.getReceitaLiquida();
        }
        return totalReceita;
    }

    /*
     * Implemente uma função main() que leia do teclado um conjunto de n vendas e, ao final,
     * imprima um relatório com a lista completa das vendas e o valor total de imposto pago e da receita líquida obtida.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        System.out.print("Quantas vendas deseja registrar? ");
        n = scanner.nextInt();
        scanner.nextLine();

        if (n < 0) {
            System.out.println("Número de vendas não pode ser negativo.");
            scanner.close();
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\nRegistrando venda #" + (i + 1) + " ---");

            System.out.print("Código do item (numérico): ");
            int codigoDoItem = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nome do item: ");
            String nomeDoItem = scanner.nextLine();

            System.out.print("Valor total da venda (ex: 100.50): r$");
            float valorDaVenda = scanner.nextFloat();
            scanner.nextLine();

            System.out.println("\nTipo de venda:");
            System.out.println("1: Dentro de SP");
            System.out.println("2: Fora de SP");
            System.out.println("3: Exterior");
            System.out.print("Escolha o tipo (1-3): ");
            int tipoVendaOpcao = scanner.nextInt();
            scanner.nextLine();

            Vendas novaVenda = null;

            switch (tipoVendaOpcao) {
                case 1:
                    listaDeVendas.add(new VendasDentroDeSaoPaulo(codigoDoItem, nomeDoItem, valorDaVenda));
                    break;
                case 2:
                    listaDeVendas.add(new VendasForaDeSaoPaulo(codigoDoItem, nomeDoItem, valorDaVenda));
                    break;
                case 3:
                    listaDeVendas.add(new VendasExterior(codigoDoItem, nomeDoItem, valorDaVenda));
                    break;
            }
            System.out.println("Venda registrada com sucesso!");
        }
        // Imprimir o relatório final
        System.out.println("\nRelatório final de vendas");
        imprimeVendas();

        float totalImposto = calculaImpostoTotal();
        System.out.printf("Valor total de imposto pago: r$ %.2f\n", totalImposto);

        float totalReceitaLiquida = calculaReceitaLiquidaTotal();
        System.out.printf("Receita líquida total obtida: r$ %.2f\n", totalReceitaLiquida);
        scanner.close();
    }
}