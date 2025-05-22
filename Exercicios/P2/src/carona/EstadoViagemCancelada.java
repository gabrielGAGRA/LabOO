package carona;

public class EstadoViagemCancelada extends EstadoViagem {   
    public EstadoViagemCancelada(Viagem viagem) {
        super(viagem);
    }

    @Override
    public String relatório() {
        return "Viagem cancelada";
    }
    
}
