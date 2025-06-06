package LabOO.Provas.Simulado_P3.src.carona;

public class EstadoViagemLotada extends EstadoViagemAguardando {

    public EstadoViagemLotada(Viagem viagem) {
        super(viagem);
    }

    @Override
    public String relatório() {
        return "Lotado; aguardando início";
    }

}
