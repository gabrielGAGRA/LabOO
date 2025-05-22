// talvez abstract cause problemas?
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

    /*
     * poder fazer buscas por
     * título da música, compositor, intérprete, período (ano de início, ano de
     * fim).
     */
    public static ArrayList buscaMusicas(String Titulo, String Compositor, String Intérprete, int Ano_Inicio,
            int Ano_Fim) {

    }

    public String toString() {
        String res = "Titulo: " + Titulo + "\nNome do Album: " + Nome_Album + "\nCompositor: " + Compositor
                + "\nIntérprete: " + Intérprete + "\nAno: " + Ano;
        return res;
    }
}
