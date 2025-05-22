// Uma música num LP possui título, nome do álbum, compositor, intérprete, ano e velocidade (33, 45 ou 78 rotações por minuto).
class Musica_LP extends Musica {
    private int velocidade;

    Musica_LP(String Titulo, String Nome_Album, String Compositor, String Intérprete, int Ano, int velocidade) {
        super(Titulo, Nome_Album, Compositor, Intérprete, Ano);
        this.velocidade = velocidade;
    }

    public String toString() {
        String res = "Velocidade: " + velocidade;
        return res + super.toString();
    }
}
