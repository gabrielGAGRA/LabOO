package LabOO.Provas.P2.Prova.src;

/*
Um empréstimo é um associação entre um usuário e um livro (item), 
com informação sobre a data de empréstimo, a data de retorno (devida) e a data de devolução (efetiva).
*/
public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private String dataEmprestimo;
    private String dataDevolucao;
    private String dataRetorno;
    private int tempoEmprestado;

    /*
     * O sistema deve permitir criar novos empréstimos, renovar empréstimos (o que
     * altera a data de retorno) e listar empréstimos atrasados.
     */
    /*
     * Um usuário pode tomar no máximo 3 empréstimos simultaneamente. O sistema só
     * deve permitir um novo empréstimo ou a renovação de um empréstimo se o usuário
     * não estiver em período de impedimento e abaixo do limite de empréstimos.
     */
    Emprestimo(Livro livro, Usuario usuario, String dataEmprestimo) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.tempoEmprestado = Livro.diasRetornoLivro;
    }

    public int calcularDiasAtraso(String dataDevolucao, String dataRetorno) {
        String[] dataDevolucaoSplit = dataDevolucao.split("/");
        String[] dataRetornoSplit = dataRetorno.split("/");

        int diaDevolucao = Integer.parseInt(dataDevolucaoSplit[0]);
        int mesDevolucao = Integer.parseInt(dataDevolucaoSplit[1]);

        int diaRetorno = Integer.parseInt(dataRetornoSplit[0]);
        int mesRetorno = Integer.parseInt(dataRetornoSplit[1]);

        return (mesDevolucao - mesRetorno) * 30 + (diaDevolucao - diaRetorno);
    }

    /*
     * Cada empréstimo de um livro de coleção pode ser renovado no máximo 2 vezes,
     * totalizando um período total de empréstimo de 180 dias. O empréstimo de um
     * livro recente só pode ser renovado uma vez, totalizando 60 dias.
     */
    /*
     * O sistema só deve permitir um novo empréstimo ou a renovação de um empréstimo
     * se o usuário não estiver em período de impedimento e abaixo do limite de
     * empréstimos.
     */
    public void criarEmprestimo(Livro livro, Usuario usuario, String dataEmprestimo) {
        if (usuario.getNumeroEmprestimos() < 3 && !usuario.getBanido()) {
            this.livro = livro;
            this.usuario = usuario;
            this.dataEmprestimo = dataEmprestimo;
            this.tempoEmprestado = Livro.diasRetornoLivro;
        }
        else {
            System.out.println("Usuario nao pode pegar emprestado");
        }
    }

    public void renovarEmprestimo(Usuario usuario, Livro livro, String novaDataRetorno) {
        if (usuario.getNumeroEmprestimos() < 3 && !usuario.getBanido()) {
            this.tempoEmprestado += Livro.diasRetornoLivro;
        }
        else {
            System.out.println("Usuario nao pode renovar emprestimo");
        }
        this.dataRetorno = novaDataRetorno;
    }

    /*
     * Caso o usuário devolva o livro após a data de retorno, o sistema deve
     * registrar um impedimento de 3 dias para cada dia atrasado.
     */
    public void registrarDevolucao(Usuario usuario, String dataDevolucao, String dataRetorno) {
        this.dataDevolucao = dataDevolucao;
        this.dataRetorno = dataRetorno;
        if (this.dataDevolucao.compareTo(this.dataRetorno) > 0) {
            int diasAtraso = calcularDiasAtraso(this.dataDevolucao, this.dataRetorno);
            usuario.setBanido(true);
            usuario.setImpedimento(diasAtraso * 3);
        }

    }

    public void listarEmprestimosAtrasados(int numeroIdentificador) {
        if (this.dataDevolucao.compareTo(this.dataRetorno) > 0) {
            System.out.println("Emprestimo atrasado: " + this.toString());
        }
        else {
            System.out.println("Nenhum emprestimo atrasado.");
        }
    }

    public void listarEmprestimosUsuario(int numeroIdentificador) {
        Usuario usuario = buscaUsuario_Identificador(numeroIdentificador);
        System.out.println("Emprestimos do usuario: " + usuario.toString());
    }

    public String toString() {
        return "Livro: " + livro + ", Usuario: " + usuario + ", Data de Emprestimo: " + dataEmprestimo
                + ", Data de Devolucao: " + dataDevolucao + ", Data de Retorno: " + dataRetorno;
    }

}
