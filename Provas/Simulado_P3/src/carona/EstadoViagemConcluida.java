package LabOO.Provas.Simulado_P3.src.carona;

public class EstadoViagemConcluida extends EstadoViagem {

    public EstadoViagemConcluida(Viagem viagem) {
        super(viagem);
    }

    @Override
    public String relatório() {
        return "Viagem concluída";
    }

}
