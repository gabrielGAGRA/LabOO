
package LabOO.Provas.P2.Copilot.src.model;

public class LivroRecente extends Livro {
    public LivroRecente(String t, String a, String p, int y, String i, int pg, String e) {
        super(t, a, p, y, i, pg, e);
    }

    @Override
    public int getDiasEmprestimo() {
        return 30;
    }

    @Override
    public int getMaxRenovacoes() {
        return 1;
    }

    @Override
    public boolean isEmprestavel() {
        return true;
    }
}