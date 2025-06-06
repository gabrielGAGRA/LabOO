package LabOO.Aulas.Aula_5.src;
import polígonos.*;

public class App {
  public static void main(String[] args) {
    // Cria pentágono regular de lado 4cm
    Polígono pentágono = new Polígono(5, 4, "pentágono");
    // pentágono._tipo = "pentágono"; // Gera erro de acesso
    System.out.println(pentágono);
    System.out.println("Perímetro do pentágono: " + pentágono.calculaPerímetro());
    Retângulo retângulo = new Retângulo(3, 4);
    System.out.println(retângulo);
    System.out.println("Área do retângulo: " + retângulo.calculaÁrea());
    // se não criarmos um pacote para Polígono ou se este arquivo estiver no mesmo
    // pacote
    // a linha a seguir não gera erro de acesso pois _lados é protected (acessível a
    // todos no mesmo pacote)
    // retângulo._lados[0] = 10;
    // note que isso viola a modularidade do código
    System.out.println("Área do retângulo: " + retângulo.calculaÁrea());

    if (pentágono.éCompatívelCom(retângulo))
      System.out.println("Pentágono e retângulo são compatíveis");
    else
      System.out.println("Pentágono e retângulo não são compatíveis");

    Retângulo quadrado = new Retângulo(5);
    System.out.println(quadrado);
    System.out.println("Área do quadrado: " + quadrado.calculaÁrea());

    System.out.println("Foram criados " + Polígono.quantosPolígonos() + " polígonos");

    if (Polígono.sãoCompatíveis(quadrado, retângulo))
      System.out.println("Quadrado e retângulo são compatíveis");
    else
      System.out.println("Quadrado e retângulo não são compatíveis");

    /*
     * Crie casos de uso na classe App para classes e métodos criados.
     * 
     * Crie testes automatizados para os métodos calcularÁrea e calcularPerímetro.
     */
    try {
      Triangulo t = new Triangulo(5, 6, 7, "Vermelho");
      System.out.println("Triangulo: " + t.getCor());
      System.out.println("area: " + t.calcularÁrea(t.getLado(0), t.getLado(1), t.getLado(2)));
    } catch (Exception e) {
      System.out.println("Erro");
    }

    try {
      Triangulo_Equilatero te = new Triangulo_Equilatero(6, "Azul");
      System.out.println("Equilatero " + te.getCor());
      System.out.println("area: " + te.calcularÁrea(te.getLado(0), te.getLado(1), te.getLado(2)));
    } catch (Exception e) {
      System.out.println("Erro");
    }

    try {
      Triangulo_Isosceles ti = new Triangulo_Isosceles(7, 5, "Verde", true);
      System.out.println("Isosceles: " + ti.getCor());
      System.out.println("area: " + ti.calcularÁrea(ti.getLado(0), ti.getLado(1), ti.getLado(2)));
    } catch (Exception e) {
      System.out.println("Erro");
    }

    try {
      new Triangulo(1, 1, 10, "Preto");
    } catch (Exception e) {
      System.out.println("Erro esperado");
    }

    testar();
  }

  public static void testar() {
    try {
      System.out
          .println("Teste 1: " + (Math.abs(new Triangulo_Equilatero(10, "T").calcularÁrea(10, 10, 10) - 43.3) < 0.1));
      System.out.println(
          "Teste 2: " + (Math.abs(new Triangulo_Isosceles(8, 6, "T", true).calcularÁrea(8, 8, 6) - 23.3) < 0.1));
      System.out.println("Teste 3: " + (new Triangulo(3, 4, 5, "T").calculaPerímetro() == 12));
    } catch (Exception e) {
      System.out.println("Erro");
    }
  }
}
