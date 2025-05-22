// Uma música em CD possui título, nome do álbum, compositor, intérprete e ano.
public class Musica_CD extends Musica {
    Musica_CD(String Titulo, String Nome_Album, String Compositor, String Intérprete, int Ano, int tamanho) {
        super(Titulo, Nome_Album, Compositor, Intérprete, Ano);
    }

    public String toString() {
        return super.toString();
    }
}