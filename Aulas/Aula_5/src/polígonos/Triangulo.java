package LabOO.Aulas.Aula_5.src.polígonos;

public class Triangulo extends Polígono {

    /* Adicione também um atributo cor privado. */
    private String cor;

    /*
     * Adicione uma nova classe Triângulo que especializa a classe Polígono. Defina
     * o construtor da classe Triângulo recebendo três argumentos especificando os
     * tamanhos de cada lado
     */
    public Triangulo(int lado1, int lado2, int lado3, String cor) {
        super(new int[3], "Triangulo");
        _lados[0] = lado1;
        _lados[1] = lado2;
        _lados[2] = lado3;
        this.cor = cor;

        /*
         * Use esse método para gerar uma mensagem de aviso caso um triângulo inválido
         * seja instanciado (ou seja, no construtor).
         */
        if (!ehTriangulo(lado1, lado2, lado2)) {
            throw new IllegalArgumentException("ERRO: Triangulo nao eh valido");
        }
    }

    /*
     * Crie um método privado que verifica se um triângulo é válido (isto, é, se o
     * tamanho de cada lado é positivo e se os lados satisfazem desigualdade
     * triangular).
     */
    protected boolean ehTriangulo(int lado1, int lado2, int lado3) {
        if (lado1 > 0 && lado2 > 0 && lado3 > 0) {
            if (lado1 + lado2 > lado3 || lado1 + lado3 > lado2 || lado2 + lado3 > lado1) {
                return true;
            }
        }
        return false;
    }

    /* Implemente o método calcularÁrea para os triângulos. */
    public double calcularÁrea(int lado1, int lado2, int lado3) {
        double semi_perimetro = (lado1 + lado2 + lado3) / 2.0;
        return (Math.pow(
                (semi_perimetro * (semi_perimetro - lado1) * (semi_perimetro - lado2) * (semi_perimetro - lado3)),
                0.5));
    }

    /*
     * Crie métodos para acessar e modificar os atributos de triângulos (getters e
     * setters).
     */
    // Funciona para qualquer tipo de triangulo, na classe triangulo
    public int getLado(int index_lado) {
        return this._lados[index_lado];
    }

    // Checamos se a mudanca vai continuar valida. setLado exige index de qual lado
    // mudar porque eh generico, usuario escolhe um dos tres lados
    public void setLado(int index_lado, int tamanho) {
        int[] novosLados = _lados.clone();
        novosLados[index_lado] = tamanho;
        if (ehTriangulo(novosLados[0], novosLados[1], novosLados[2]))
            _lados[index_lado] = tamanho;
        else
            throw new IllegalArgumentException("ERRO: Mudanca torna triangulo invalido");

    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
