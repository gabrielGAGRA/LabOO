package LabOO.Provas.Simulado_P2.src;

// Um arquivo MP3 possui título da música, nome do álbum, compositor, intérprete, ano, tamanho em bytes.
public class Musica_MP3 extends Musica {
    private int tamanho;

    Musica_MP3(String Titulo, String Nome_Album, String Compositor, String Intérprete, int Ano, int tamanho) {
        super(Titulo, Nome_Album, Compositor, Intérprete, Ano);
        this.tamanho = tamanho;
    }

    public int getTamanho() { // Getter para tamanho
        return tamanho;
    }

    public String toString() {
        String res = "tamanho: " + tamanho;
        return res + super.toString();
    }
}
