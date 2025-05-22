package carona;

public abstract class EstadoViagem {
    private Viagem viagem;

    public EstadoViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public Viagem qualViagem() { return viagem; } 
    public void iniciar() {}
    public void concluir() {}
    public void cancelar() {}
    public boolean aceitaPassageiro() { return false; }
    public void adicionarPassageiro(Usuario passageiro) {};
    public void removerPassageiro(Usuario passageiro) {};    
    public abstract String relatório();
    
}
