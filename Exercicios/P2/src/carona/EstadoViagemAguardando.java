package carona;

public class EstadoViagemAguardando extends EstadoViagem {

    public EstadoViagemAguardando(Viagem viagem) {
        super(viagem);
    }

    @Override
    public void iniciar() {
        Viagem viagem = qualViagem();
        viagem.alterarEstado(new EstadoViagemEmAndamento(viagem));
    }

    @Override
    public void cancelar() {
        Viagem viagem = qualViagem();
        viagem.alterarEstado(new EstadoViagemCancelada(viagem));
    }    

    @Override
    public void removerPassageiro(Usuario passageiro) {
        Viagem viagem = qualViagem();
        if (viagem.removerPassageiro(passageiro)) {
            int vagas = viagem.quantasVagasDisponíveis();
            viagem.alterarVagasDisponíveis(vagas+1);
            if (vagas == 0) viagem.alterarEstado(new EstadoViagemAceitando(viagem));
        }
    }

    @Override
    public String relatório() {
        return "Aguardando início da viagem";
    }      
    
}
