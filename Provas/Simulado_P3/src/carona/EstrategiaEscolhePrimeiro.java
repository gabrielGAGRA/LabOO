package LabOO.Provas.Simulado_P3.src.carona;

public class EstrategiaEscolhePrimeiro implements Estrategia {

    @Override
    public Viagem escolheViagem(Viagem[] viagens) {
        return viagens[0];
    }
    
}
