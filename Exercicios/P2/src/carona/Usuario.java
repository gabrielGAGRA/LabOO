package carona;

public class Usuario {
    private String cpf;
    private String nome;
    Estrategia estrategia;

    public Usuario(String cpf, String nome, Estrategia estrategia) {
        this.cpf = cpf;
        this.nome = nome;
        this.estrategia = estrategia;
    }

    public String qualCPF() {
        return cpf;
    }

    public void alteraCPF(String cpf) {
        this.cpf = cpf;
    }    

    public String getNome() {
        return nome;
    }

    public void escolheViagem(Viagem[] viagens) {
        if (viagens != null && viagens.length > 0) {
         Viagem viagem = estrategia.escolheViagem(viagens);
         viagem.pedirCarona(this);
        }
    }

    @Override
    public String toString() {
        return nome + "[cpf=" + cpf + "]";
    }

}
