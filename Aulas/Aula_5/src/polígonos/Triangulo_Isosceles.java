package LabOO.Aulas.Aula_5.src.polígonos;

/*
 * Especialize a classe Triângulo para criar subclasses representando um
 * Triângulo Equilátero (todos os lados de mesmo tamanho) e um Triângulo
 * Isósceles (dois lados iguais e um diferente).
*/
public class Triangulo_Isosceles extends Triangulo {
    /* Crie construtores com argumentos de acordo com cada subclasse. */
    public Triangulo_Isosceles(int lado_duplo, int lado_diff, String cor, Boolean lado_duplicado) {
        super(lado_duplo, lado_duplo, lado_diff, cor);
    }

    /*
     * A classe para triângulo isósceles deve ter métodos para modificar o lado
     * duplicado e o lado distinto.
     */
    public int getLadoIsosceles(boolean lado_duplicado) {
        if (lado_duplicado)
            return this._lados[0];
        else {
            return this._lados[2];
        }
    }

    @Override
    public void setLado(int index_lado, int valor) {
        if (index_lado == 0 || index_lado == 1) {
            super.setLado(0, valor);
            super.setLado(1, valor);
        } else if (index_lado == 2) {
            super.setLado(2, valor);
        }
    }

}
