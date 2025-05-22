package carona;

public class EstadoViagemAceitando extends EstadoViagemAguardando {
    public EstadoViagemAceitando(Viagem viagem) {
        super(viagem);
    }

    @Override
    public boolean aceitaPassageiro() {
        return true;
    }

    @Override
    public void adicionarPassageiro(Usuario passageiro) {
        Viagem viagem = qualViagem();
        int vagas = viagem.quantasVagasDisponíveis();
        if (vagas > 0) {
            viagem.adicionarPassageiro(passageiro);
            vagas--;
            viagem.alterarVagasDisponíveis(vagas);
            if (vagas == 0)
                viagem.alterarEstado(new EstadoViagemLotada(viagem));
        }
    };

    @Override
    public String relatório() {
        return "Aceitando novos passageiros";
    }

}
