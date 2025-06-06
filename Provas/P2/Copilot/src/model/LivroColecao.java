
package LabOO.Provas.P2.Copilot.src.model;

public class LivroColecao extends Livro {
    public LivroColecao(String t, String a, String p, int y, String i, int pg, String e) {
        super(t, a, p, y, i, pg, e);
    }

    @Override
    public int getDiasEmprestimo() {
        return 60;
    }

    @Override
    public int getMaxRenovacoes() {
        return 2;
    }

    @Override
    public boolean isEmprestavel() {
        return true;
    }
}