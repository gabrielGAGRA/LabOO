package polígonos;

/*
 * Especialize a classe Triângulo para criar subclasses representando um
 * Triângulo Equilátero (todos os lados de mesmo tamanho) e um Triângulo
 * Isósceles (dois lados iguais e um diferente).
*/
public class Triangulo_Equilatero extends Triangulo {
    /* Crie construtores com argumentos de acordo com cada subclasse. */
    public Triangulo_Equilatero(int lado, String cor) {
        super(lado, lado, lado, cor);
    }

    /*
     * A classe para triângulo equilátero deve ter métodos para recuperar ou
     * modificar o lado.
     */
    public int getLadoEquilatero() {
        return getLado(0);
    }

    @Override
    public void setLado(int index_lado, int valor) {
        super.setLado(0, valor);
        super.setLado(1, valor);
        super.setLado(2, valor);
    }

    public void setLadoEquilatero(int valor) {
        setLado(0, valor);
    }

}
