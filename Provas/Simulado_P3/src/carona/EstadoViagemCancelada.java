package LabOO.Provas.Simulado_P3.src.carona;

public class EstadoViagemCancelada extends EstadoViagem {
    public EstadoViagemCancelada(Viagem viagem) {
        super(viagem);
    }

    @Override
    public String relatório() {
        return "Viagem cancelada";
    }

}
