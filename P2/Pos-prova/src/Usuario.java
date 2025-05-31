import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/*
Os usuários devem possuir um número único de identificação na biblioteca, 
gerado automaticamente quando o usuário é cadastrado, 
além de um registro de identificação pessoal (CPF, RG, RNM, número de passaporte etc). 
*/
public class Usuario{
    private int numeroIdentificador;
    private int registroIdentificacaoPessoal;
    private String nome;
    private String dataNascimento;
    private String email;
    private String endereco;
    /*Os usuários podem ficar impedidos de fazer empréstimos dentro de um certo período, 
    como punição por descumprimento de regras; 
    o sistema deve armazenar tal informação na ficha de cada usuário.
    */
    private Boolean banido;
    private String dataBanido;
    private int numeroEmprestimos;

    // CRÉDITOS (nao copiei, mas pesquisei): https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java
    Random numero = new Random();

    // O sistema deve possuir ao menos as funcionalidades de cadastramento de usuário
    Usuario(Boolean banido, String dataBanido, int registroIdentificacaoPessoal, String dataNascimento, String endereco) {
        this.banido = banido;
        this.dataBanido = dataBanido;
        this.registroIdentificacaoPessoal = registroIdentificacaoPessoal;
        this.numeroIdentificador = numero.nextInt();
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    /*busca de usuários pelo início do nome (para usuários que esqueçam seus identificadores)*/
    public List<Usuario> buscaUsuario_Nome(String nome) {
        List<Usuario> resultado = new ArrayList<>();
        List<Usuario> listaUsuarios = Banco_Usuarios.getListaUsuarios();
        for (Usuario usuario_x : listaUsuarios) {
            // CRÉDITOS (nao copiei, mas pesquisei): https://www.google.com/search?client=firefox-b-e&channel=entpr&q=java+search+by+string+start
            if (usuario_x.getNome().startsWith(nome)) {
                resultado.add(usuario_x);
            }
        }
        return resultado;
    }

    /*busca de usuários pelo número de identificação.  */
    public Usuario buscaUsuario_Identificador(int numeroIdentificador) {
        for (Usuario usuario_x : Banco_Usuarios.getListaUsuarios()) {
            if (usuario_x.getnumeroIdentificador() == numeroIdentificador) {
                return usuario_x;
            }
        }
        return null;
    }

    public boolean getbanido() {
        return banido;
    }

    public String getdataBanido() {
        return dataBanido;
    }
    
    public int getnumeroIdentificador() {
        return numeroIdentificador;
    }

    public String getNome() {
        return nome;
    }

    public String getemail() {
        return email;
    }

    public void setBanimento(Boolean banido, String dataBanido) {
        this.banido = banido;
        this.dataBanido = dataBanido;
    }

    public int getNumeroEmprestimos() {
        return numeroEmprestimos;
    }

    @Override
    public String toString() {
        String res = "banido: " + banido + "\nDAta banimento: " + dataBanido + "\ndataNascimento: " + dataNascimento
                + "\nendereco: " + endereco + "\nnumeroIdentificador: " + numeroIdentificador;
        return res;
    }

}
