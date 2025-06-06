package LabOO.Provas.Simulado_P3.src.carona;

public class EstadoViagemEmAndamento extends EstadoViagem {

    public EstadoViagemEmAndamento(Viagem viagem) {
        super(viagem);
    }

    @Override
    public void concluir() {
        Viagem viagem = qualViagem();
        viagem.alterarEstado(new EstadoViagemConcluida(viagem));
    }

    @Override
    public String relatório() {
        return "Em andamento";
    }

}
