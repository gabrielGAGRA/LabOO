package LabOO.Exercicios.Simulado_P2.src;

abstract class Musica {
    private String Titulo;
    private String Nome_Album;
    private String Compositor;
    private String Intérprete;
    private int Ano;

    Musica(String Titulo, String Nome_Album, String Compositor, String Intérprete, int Ano) {
        this.Titulo = Titulo;
        this.Nome_Album = Nome_Album;
        this.Compositor = Compositor;
        this.Intérprete = Intérprete;
        this.Ano = Ano;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getNome_Album() {
        return Nome_Album;
    }

    public String getCompositor() {
        return Compositor;
    }

    public String getIntérprete() {
        return Intérprete;
    }

    public int getAno() {
        return Ano;
    }

    public String toString() {
        String res = "Titulo: " + Titulo + "\nNome do Album: " + Nome_Album + "\nCompositor: " + Compositor
                + "\nIntérprete: " + Intérprete + "\nAno: " + Ano;
        return res;
    }
}
