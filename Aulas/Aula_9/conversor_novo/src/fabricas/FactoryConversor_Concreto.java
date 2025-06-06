package LabOO.Aulas.Aula_9.conversor_novo.src.fabricas;

import LabOO.Aulas.Aula_9.conversor_novo.src.conversor.distancias.ConversorKmParaMilhas;
import LabOO.Aulas.Aula_9.conversor_novo.src.conversor.distancias.ConversorMilhasParaKm;
import LabOO.Aulas.Aula_9.conversor_novo.src.conversor.interfaces.Conversor;
import LabOO.Aulas.Aula_9.conversor_novo.src.conversor.interfaces.ConversorDistancia;
import LabOO.Aulas.Aula_9.conversor_novo.src.prototipo.ConversorPrototipo;

public class FactoryConversor_Concreto implements FactoryConversor_Abstrato {
    private final ConversorPrototipo tempPrototypeManager;

    public FactoryConversor_Concreto() {
        this.tempPrototypeManager = new ConversorPrototipo();
    }

    @Override
    public Conversor getConversorTemperatura(char de, char para) {
        if (de == para) {
            return tempPrototypeManager.getConversor("IDENTIDADE");
        }
        return tempPrototypeManager.getConversor(de + "_" + para);
    }

    @Override
    public ConversorDistancia getConversorDistancia(String de, String para) {
        if (de.equalsIgnoreCase("KM") && para.equalsIgnoreCase("MI")) {
            return new ConversorKmParaMilhas();
        }
        else if (de.equalsIgnoreCase("MI") && para.equalsIgnoreCase("KM")) {
            return new ConversorMilhasParaKm();
        }
        throw new IllegalArgumentException("não suportado");
    }
}
