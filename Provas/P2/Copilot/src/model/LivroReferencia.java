
package LabOO.Provas.P2.Copilot.src.model;

public class LivroReferencia extends Livro {
    public LivroReferencia(String t, String a, String p, int y, String i, int pg, String e) {
        super(t, a, p, y, i, pg, e);
    }

    @Override
    public int getDiasEmprestimo() {
        return 0;
    }

    @Override
    public int getMaxRenovacoes() {
        return 0;
    }

    @Override
    public boolean isEmprestavel() {
        return false;
    }
}